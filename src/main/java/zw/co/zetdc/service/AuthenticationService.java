package zw.co.zetdc.service;

import zw.co.zetdc.payload.request.AuthenticationRequest;
import zw.co.zetdc.payload.request.RegisterRequest;
import zw.co.zetdc.payload.response.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
