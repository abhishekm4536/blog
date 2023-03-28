package com.myblog.Security;
import com.myblog.entity.Role;
import com.myblog.entity.User;
import com.myblog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private  UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String userNameOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByUserNameOrEmail(userNameOrEmail, userNameOrEmail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("user not found with username or email:" + userNameOrEmail));
    return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Set<Role> roles) {
    return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
