package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {

    @Override
    public void sendMessage(User user, String message) {
        System.out.println("Sending an e-mail to " + user.getName() + ". Message: ");
        System.out.println(message);
    }
}
