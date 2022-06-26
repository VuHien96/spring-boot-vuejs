package com.hienvv.service;

import com.hienvv.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
