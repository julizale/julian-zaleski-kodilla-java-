package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User seba = new Millenials("Sebastian");
        User antos = new YGeneration("Antoni");
        User denis = new ZGeneration("Denis");

        //When
        String millenialsSocial = seba.sharePost();
        String yGenerationSocial = antos.sharePost();
        String zGenerationSocial = denis.sharePost();

        //Then
        assertEquals("Facebook", millenialsSocial);
        assertEquals("Twitter", zGenerationSocial);
        assertEquals("Snapchat", yGenerationSocial);
    }

    @Test
    void testIndividualSharingStrategies() {
        //Given
        User seba = new Millenials("Sebastian");

        //When
        String sebaDefaultSocial = seba.sharePost();
        seba.setSocialMedia(new TwitterPublisher());
        String sebaNewSocial = seba.sharePost();

        //Then
        assertEquals("Facebook", sebaDefaultSocial);
        assertEquals("Twitter", sebaNewSocial);
    }
}
