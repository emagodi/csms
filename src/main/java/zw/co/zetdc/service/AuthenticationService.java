package zw.co.zetdc.service;

import zw.co.zetdc.entities.User;
import zw.co.zetdc.payload.request.AuthenticationRequest;
import zw.co.zetdc.payload.request.RegisterRequest;
import zw.co.zetdc.payload.request.UserUpdateRequest;
import zw.co.zetdc.payload.response.AuthenticationResponse;


public interface AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);

    public User getUserById(Long id);


    public User updateUser(Long userId, UserUpdateRequest userUpdateRequest);

    public void changePassword(String email, String currentPassword, String newPassword);

    public String generateOtp();
}
