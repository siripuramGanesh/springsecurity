package com.ganeshsiripuram.springsecurity.springsecurity.services;

import com.ganeshsiripuram.springsecurity.springsecurity.dto.LoginDto;
import com.ganeshsiripuram.springsecurity.springsecurity.dto.SignUpDto;
import com.ganeshsiripuram.springsecurity.springsecurity.dto.UserDto;
import com.ganeshsiripuram.springsecurity.springsecurity.entities.User;
import com.ganeshsiripuram.springsecurity.springsecurity.exceptions.ResourceNotFoundException;
import com.ganeshsiripuram.springsecurity.springsecurity.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder  passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new BadCredentialsException("user with email"+ username+"not found"));
    }

    public User getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with userid"+ userId+"not found"));
    }

    public UserDto signUp(SignUpDto signUpDto) {
        Optional<User> user=userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User with email already exists"+signUpDto.getEmail());
        }

        User toCreate=modelMapper.map(signUpDto,User.class);
        toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
        User savedUser=userRepository.save(toCreate);
        return modelMapper.map(savedUser,UserDto.class);
    }


}
