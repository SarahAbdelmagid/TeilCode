import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

public class MyEmail {

    public static void main(String[] args) throws Exception{

        Properties properties = new  Properties();
        properties.put("mail.smtp.auth", true);
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.starttls.enable", true);
        properties.setProperty("mail.transport.protocol", "smtp");



        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("s.abdelmagid3003@gmail.com", "Qatar@2022");

            }
        });

        Message message = new MimeMessage(session);
        message.setSubject("Email from my java program");


        Address addressTo = new InternetAddress("m.abdelmagid2002@gmail.com");
        message.setRecipient(Message.RecipientType.TO, addressTo);

        MimeMultipart multipart = new MimeMultipart();

        MimeBodyPart attachment = new MimeBodyPart();
        attachment.attachFile(new File("static/bytecode.pdf"));

        MimeBodyPart attachment2 = new MimeBodyPart();
        attachment2.attachFile(new File("static/Untitled.docx"));

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        message.setContent("<h1>Email from my program!</h1>", "text/html");

        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachment);
        multipart.addBodyPart(attachment2);

        message.setContent(multipart);

        Transport.send(message);


    }
}
