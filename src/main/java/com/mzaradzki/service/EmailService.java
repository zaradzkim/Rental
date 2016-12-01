package com.mzaradzki.service;

/**
 * Created by Marcel on 2016-12-01.
 */
public interface EmailService {
    void sendEmail(String fromAddress, String toAddress, String subject, String body);
}
