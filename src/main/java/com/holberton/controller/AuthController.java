package com.holberton.controller;

import com.holberton.domain.Talent;
import com.holberton.dto.*;
import com.holberton.service.CompanyService;
import com.holberton.service.TalentService;
import com.holberton.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final TalentService talentService;
    private final CompanyService companyService;

    @PostMapping("/sign-in")
    public JwtResponse signIn(@RequestBody SignInDTO signInDTO) {
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInDTO.getUsername(),
                        signInDTO.getPassword()
                )
        );
        String refreshToken = jwtUtil.generateRefreshTokenFromUsername(signInDTO.getUsername());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtUtil.generateToken(authentication);
        return new JwtResponse(token, refreshToken);
    }

    @PostMapping("/refresh-token")
    public JwtResponse refreshToken(@RequestBody TokenRefreshRequest request) {
        String requestRefreshToken = request.getRefreshToken();
        jwtUtil.validateToken(requestRefreshToken);

        String username = jwtUtil.extractClaims(request.getRefreshToken()).getSubject();
        String token = jwtUtil.generateTokenFromUsername(username);
        requestRefreshToken = jwtUtil.generateRefreshTokenFromUsername(username);
        return new JwtResponse(token, requestRefreshToken);
    }

    @PostMapping("/talent/sign-up")
    public TalentDTO signUpTalent(@RequestBody TalentDTO talentDTO) {
        return talentService.add(talentDTO);
    }

    @PostMapping("/company/sign-up")
    public CompanyDTO signUpCompany(@RequestBody CompanyDTO companyDTO) {
        return companyService.add(companyDTO);
    }
}
