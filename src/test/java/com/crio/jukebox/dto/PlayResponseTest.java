package com.crio.jukebox.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class dtoTest {

    @Test
    void testToString() {
        PlayListUpdateResponse playListUpdateResponse=new PlayListUpdateResponse("1","P1", Arrays.asList("1,2,3"));
        PlayResponse playResponse=new PlayResponse("song","xyz",Arrays.asList("a","b","c"));

        System.out.println(playListUpdateResponse);
        System.out.println(playResponse);
    }
}