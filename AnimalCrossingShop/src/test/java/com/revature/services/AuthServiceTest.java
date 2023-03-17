package com.revature.services;
import com.revature.exceptions.InvalidUserException;
import com.revature.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {
    @Mock
    private UserService userService;
    @Mock
    private AuthService authService;

    @Test
    void findByCredentialsSuccess() throws InvalidUserException {
        User mockUser = new User(1,"testfirst","testlast","testusername","testpassword","test@email.com");
        when(authService.findByCredentials("testusername", "testpassword")).thenReturn(Optional.of(mockUser));

        Optional<User> resultUser = authService.findByCredentials("testusername", "testpassword");

        assertEquals(resultUser.get().getEmail(), mockUser.getEmail());
        assertEquals(resultUser.get().getPassword(), mockUser.getPassword());
    }

    @Test
    void findByCredentialsFail() throws InvalidUserException {
        User mockUser = new User(1,"testfirst","testlast","testusername","testpassword","test@email.com");

        when(authService.findByCredentials(mockUser.getUsername(), mockUser.getPassword())).thenReturn(Optional.of(mockUser));

        Optional<User> resultUser = authService.findByCredentials("testusername", "testpassword");

        assertNotEquals("blorpnorp", mockUser.getEmail());
        assertNotEquals("chicaca", mockUser.getPassword());

        assertNotEquals(resultUser.get().getEmail(), "blorpnorp");
        assertNotEquals(resultUser.get().getPassword(), "chicaca");

    }
}
