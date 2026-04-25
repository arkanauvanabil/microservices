package com.arkan.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = "orderQueue")
    public void receiveMessage(String message) {

        System.out.println("Received: " + message);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("raemon@pnp.ac.id");
        mail.setSubject("Order Baru Masuk");
        mail.setText(
    "ORDER BARU MASUK\n\n" +
    "Detail Order:\n" +
    "------------------------\n" +
    message + "\n" +
    "------------------------\n\n" +
    "Silakan segera diproses.\n\n" +
    "Terima kasih."
    );

        mailSender.send(mail);
    }
}