package zw.co.zetdc.service.impl;

import zw.co.zetdc.enums.Region;
import zw.co.zetdc.enums.TokenType;
import zw.co.zetdc.payload.request.AuthenticationRequest;
import zw.co.zetdc.payload.request.RegisterRequest;
import zw.co.zetdc.payload.response.AuthenticationResponse;
import zw.co.zetdc.service.AuthenticationService;
import zw.co.zetdc.service.JwtService;
import zw.co.zetdc.entities.User;
import zw.co.zetdc.repository.UserRepository;
import zw.co.zetdc.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service @Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final RefreshTokenService refreshTokenService;

    // private final EmailService emailService;
    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .district(request.getDistrict())
                .region(request.getDistrict().getRegion())
                .build();
        user = userRepository.save(user);
//        String subject = "ZETDC Customer Supplied Material Scheme";
//        String body = "Your User Account Created Successfully With Email Address: " + user.getEmail();
//        emailService.sendEmail(user.getEmail(), subject, body);
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());

        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();

        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .email(user.getEmail())
                .id(user.getId())
                .refreshToken(refreshToken.getToken())
                .roles(roles)
                .district(user.getDistrict())
                .region(user.getRegion())
                .tokenType( TokenType.BEARER.name())
                .build();
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        var user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var roles = user.getRole().getAuthorities()
                .stream()
                .map(SimpleGrantedAuthority::getAuthority)
                .toList();
        var jwt = jwtService.generateToken(user);
        var refreshToken = refreshTokenService.createRefreshToken(user.getId());
        return AuthenticationResponse.builder()
                .accessToken(jwt)
                .roles(roles)
                .email(user.getEmail())
                .id(user.getId())
                .district(user.getDistrict())
                .region(user.getRegion())
                .refreshToken(refreshToken.getToken())
                .tokenType( TokenType.BEARER.name())
                .build();
    }
}
