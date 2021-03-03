package pers.pao.mail.simple;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Mail {
    public static void main(String[] args) {
        //config
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "david.wang@kyperdata.com";
        String password = "123qweas";

        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port",port);
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(username,password);
            }
        });

        //send mail service
        try{
            String objMail = "david840422@gmail.com";
            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(objMail));

            message.setSubject("測試標題"+new Date());
            message.setContent("<h1>測試內容<h1> <p>測試內容</p>","text/html; charset = UTF-8");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
