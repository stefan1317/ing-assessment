package com.example.ing.service;

import com.example.ing.domain.AppUser;
import com.example.ing.exceptions.RecordNotFoundException;
import com.example.ing.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.example.ing.utils.StringUtils.ROLE;

@RequiredArgsConstructor
@Service
public class AppUserService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    //TODO: Implement a more complex authentification functionality based on JWT.

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        AppUser user = appUserRepository
                .findByEmail(email)
                .orElseThrow(() -> new RecordNotFoundException("User with email " + email + " cannot be found."));

        return User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(ROLE + user.getRole())
                .build();
    }

}
