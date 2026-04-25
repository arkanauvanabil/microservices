package com.arkan.authservic.service;

import com.arkan.authservic.entity.User;
import com.arkan.authservic.repository.UserRepository;
import com.arkan.authservic.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // REGISTER (sudah ada)
    public String register(String username, String password) {

        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User sudah ada");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepository.save(user);

        return "Register berhasil";
    }

    //  TAMBAHKAN DI SINI
    public String login(String username, String password) {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Password salah");
        }

        return jwtUtil.generateToken(username);
    }
}