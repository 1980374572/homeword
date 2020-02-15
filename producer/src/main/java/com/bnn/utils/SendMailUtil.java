package com.bnn.utils;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class SendMailUtil {


    public static void sendSimpleMail(String users, String name, Date date) throws Exception {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();//直接生产一个实例
        mailSender.setHost("smtp.qq.com");
        mailSender.setUsername("1550402521@qq.com");
        mailSender.setPassword("kofvzaryxngyhagd");
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1550402521@qq.com");
        message.setTo(users); // 群发
        message.setSubject("亲爱的同学！");
        String text = "亲爱的"+name+"，今天的作业特别简单，附件为已经发至邮箱, 请于"+date+"日前完成并提交";
        message.setText(text);
        mailSender.send(message);
    }
}
