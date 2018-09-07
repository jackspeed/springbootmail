package com.ycj.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    public void text(String msg) {
        System.out.println(msg);
    }

    public void sendMail(String to, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        simpleMailMessage.setFrom(from);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendHtmlMail(String to, String subject, String content) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText(content, true);
        javaMailSender.send(mimeMessage);
    }

    public void sendAttachmentMail(String to, String subject, String content, String filePath) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setFrom(from);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource fileSystemResource = new FileSystemResource(new File(filePath));
        String fileName = fileSystemResource.getFilename();
        helper.addAttachment(fileName, fileSystemResource);
        javaMailSender.send(mimeMessage);
    }
}
