package com.ganeshsiripuram.springsecurity.springsecurity.services;

import com.ganeshsiripuram.springsecurity.springsecurity.dto.LoginDto;
import com.ganeshsiripuram.springsecurity.springsecurity.entities.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
 public class AuthService {




    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;


    public String login(LoginDto loginDto) {
        Authentication authentication=authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        User user=(User) authentication.getPrincipal();
        return jwtService.generateToken(user);

    }

}
