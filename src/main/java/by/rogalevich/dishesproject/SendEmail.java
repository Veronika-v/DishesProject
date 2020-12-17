package by.rogalevich.dishesproject;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Objects;
import java.util.Properties;

public class SendEmail {
    public JavaMailSenderImpl JavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("student.it.rvs@gmail.com");
        mailSender.setPassword("studentitrvs2020");

        Properties properties= mailSender.getJavaMailProperties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.ssl.trust", "smtp.gmail.com");

        return mailSender;
    }

    public void SendSimpleEmail(String subject, String text, String email) {
        JavaMailSenderImpl javaMailSender = JavaMailSender();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setSubject(subject); //The subject of the mail
        mailMessage.setText(text);
        mailMessage.setTo(email); //Who to send to
        mailMessage.setFrom(Objects.requireNonNull(javaMailSender.getUsername())); //Who sent it
        javaMailSender.send(mailMessage);
    }

}