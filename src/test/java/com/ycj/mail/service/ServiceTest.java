package com.ycj.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.MessagingException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Resource
    MailService mailService;

    @Test
    public void sendTextTest() {
        mailService.text("AAAAAAAAAAAAAAAAAAAAAAAAA");
    }

    @Test
    public void sendSimpleMailTest() {
        mailService.sendMail("18919026771@163.com", "test", "第一封邮件");
    }

    @Test
    public void sendHtmlMailTest() throws MessagingException {
        String content = "<html>\n" +
                "\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.css\" integrity=\"sha384-wITovz90syo1dJWVh32uuETPVEtGigN07tkttEqPv+uR2SE/mbQcG7ATL28aI9H0\" crossorigin=\"anonymous\">\n" +
                "   \n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<h2>发你维护金融服务号发我if和我i   html邮件内容</h2>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>";
        mailService.sendHtmlMail("18919026771@163.com", "html 邮件", content);
    }
}
