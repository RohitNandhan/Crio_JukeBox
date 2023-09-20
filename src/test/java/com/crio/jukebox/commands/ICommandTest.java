package com.crio.jukebox.commands;

import com.crio.jukebox.exceptions.NoSuchSongException;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.exceptions.SongNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@ExtendWith(MockitoExtension.class)
public abstract class ICommandTest<C,S> {
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    C commandmock;
    S serviceMock;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    @Test
    @DisplayName("execute Command to print the command response")
    void execute() throws NoSuchSongException, PlaylistNotFoundException, SongNotExistException {
        System.out.println("testinggggggggggggggggggggggggg");
    }
}
