package com.example.orderswift.service.auth;

import com.example.orderswift.model.UserRole;
import com.example.orderswift.repository.UserRepository;
import com.example.orderswift.security.AuthenticationRequest;
import com.example.orderswift.security.AuthenticationResponse;
import com.example.orderswift.security.JwtService;
import com.example.orderswift.security.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUserEmail())
                .password(passwordEncoder.encode(request.getUserPassword()))
                .roles(String.valueOf(UserRole.USER))
                .build();
        repository.findByUserEmail(String.valueOf(user));
        var jwtToken= jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUserEmail(),
                        request.getUserPassword()
                )
        );
        var user = repository.findByUserEmail(request.getUserPassword())
                .orElseThrow();
        var jwtToken= jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
