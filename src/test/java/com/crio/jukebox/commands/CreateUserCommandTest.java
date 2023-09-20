package com.crio.jukebox.commands;

import com.crio.jukebox.entites.User;
import com.crio.jukebox.services.IUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@DisplayName("CreateUserCommandTest")
@ExtendWith(MockitoExtension.class)
class CreateUserCommandTest {

    private final PrintStream sOut=System.out;
    private final ByteArrayOutputStream outputStreamCaptor=new ByteArrayOutputStream();

    @Mock
    IUserService userServiceMock;

    @InjectMocks
     CreateUserCommand createUserCommandMock;

    @BeforeEach
    void setUp(){
       System.setOut(new PrintStream(outputStreamCaptor)); }

    @Test
    @DisplayName("execute method of CreateUser command ,print newly created user to console ")
    void execute_PrintPlaylistId() {
        String expectedOutput="1 Ronan";
        User user=new User("1","Ronan");
        when(userServiceMock.createUser(anyString())).thenReturn(user);

        createUserCommandMock.execute(Arrays.asList("CREATE-USER",""));
        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString());

        verify(userServiceMock,times(1)).createUser(anyString());
    }

    }

