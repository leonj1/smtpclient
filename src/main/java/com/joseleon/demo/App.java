package com.joseleon.demo;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "localhost");
        props.setProperty("mail.smtp.port", "8025");
        // props.setProperty("mail.smtp.auth", "true"); // not necessary for my server, I'm not sure if you'll need it
        Session session = Session.getInstance(props, null);
        Transport transport = session.getTransport("smtp");
        transport.connect("user", "password");

        Message message = new MimeMessage(session);
        message.setSubject("Test");
        message.setText("Hello :)");
        message.setFrom(new InternetAddress("you@example.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("your-friend@example.com"));
        transport.sendMessage(message, message.getAllRecipients());
    }
}
