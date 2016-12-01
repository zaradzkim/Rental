package com.mzaradzki.service.impl;

import com.mzaradzki.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by Marcel on 2016-12-01.
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String fromAddress, String toAddress, String subject, String body) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setFrom(fromAddress);
        simpleMailMessage.setSubject("Rental" + subject);
        simpleMailMessage.setText(body);

        javaMailSender.send(simpleMailMessage);

    }
}
