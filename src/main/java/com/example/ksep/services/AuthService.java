package com.example.ksep.services;

import com.example.ksep.dto.AuthResponseDto;
import com.example.ksep.dto.LoginRequestDto;
import com.example.ksep.dto.RegisterRequestDto;
import com.example.ksep.models.*;
import com.example.ksep.repository.CampusProfileRepository;
import com.example.ksep.repository.CorporateProfileRepository;
import com.example.ksep.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final CampusProfileRepository campusProfileRepository;
    private final CorporateProfileRepository corporateProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @Transactional
    public AuthResponseDto register(RegisterRequestDto request) {
        // 1. Verify user doesn't already exist
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // 2. Create and save the User
        Role userRole = Role.valueOf(request.role().toUpperCase());
        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(userRole)
                .build();
        User savedUser = userRepository.save(user);

        // 3. Prevent Orphaned Dashboards: Initialize the specific profile
        if (userRole == Role.CAMPUS) {
            CampusProfile profile = CampusProfile.builder()
                    .user(savedUser)
                    .campusName(request.name()) // From the registration form
                    .build();
            campusProfileRepository.save(profile);
        } else if (userRole == Role.CORPORATE) {
            CorporateProfile profile = CorporateProfile.builder()
                    .user(savedUser)
                    .companyName(request.name())
                    // Setting a default type to avoid null constraints, can be updated in dashboard
                    .type(CorporateType.STARTUP)
                    .build();
            corporateProfileRepository.save(profile);
        }

        // 4. Generate Token and Return
        String jwtToken = jwtService.generateToken(savedUser);
        emailService.sendWelcomeEmail(savedUser.getEmail(), request.name(), savedUser.getRole().name());

        return new AuthResponseDto(jwtToken, savedUser.getId(), savedUser.getRole().name());
    }

    public AuthResponseDto login(LoginRequestDto request) {
        // 1. Authenticate credentials via Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password())
        );

        // 2. Fetch user and generate token
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String jwtToken = jwtService.generateToken(user);
        return new AuthResponseDto(jwtToken, user.getId(), user.getRole().name());
    }
}
