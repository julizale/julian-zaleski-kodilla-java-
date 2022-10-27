package com.kodilla.patterns.strategy.social;

public sealed class User permits Millenials, YGeneration, ZGeneration {

    private final String name;
    protected SocialPublisher socialPublisher;

    public User(final String name) {
        this.name = name;
    }

    public void setSocialMedia(SocialPublisher socialPublisher) {
        this.socialPublisher = socialPublisher;
    }

    public String sharePost() {
        return socialPublisher.share();
    }
}
