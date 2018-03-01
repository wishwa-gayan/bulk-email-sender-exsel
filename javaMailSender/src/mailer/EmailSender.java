/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
import javafx.scene.chart.PieChart.Data;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
import javax.swing.SpringLayout;
import org.apache.log4j.helpers.AbsoluteTimeDateFormat;

/**
 *
 * @author wishwa
 */
public class EmailSender {

    private String password;
    private String username;
    private String SMTP_HOST_NAME;
    private String SMTP_PORT;
    private String emailMsgTxt;
    private String emailSubjectTxt;
    private String emailFromAddress;
    private int  delay;
//    private String SSL_FACTORY
//            = "javax.net.ssl.SSLSocketFactory";

    private ArrayList<String> recipients;
    private ArrayList<String> emailssendtime;

    public static int counter = 0;

    public void EmailSender (ArrayList<String> emailLisst,HashMap<String,String> confData) throws IOException, MessagingException{
        
        
        this.password = confData.get("password");
        this.username=confData.get("username");
        this.SMTP_HOST_NAME=confData.get("host");
        this.SMTP_PORT=confData.get("port");
        this.emailMsgTxt=confData.get("Msg");
        this.emailSubjectTxt=confData.get("Subject");
        this.recipients= emailLisst;
        this.delay= Integer.parseInt(confData.get("delay"));
        Set keys = confData.keySet();
       
        
        
    }
//    public Session setSesion(){
//      boolean debug = true;
//        Properties props = new Properties();
//        props.put("mail.smtp.host", SMTP_HOST_NAME);
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.debug", "true");
//        props.put("mail.smtp.port", SMTP_PORT);
//        props.put("mail.smtp.socketFactory.port", SMTP_PORT);
//        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
//        props.put("mail.smtp.socketFactory.fallback", "false");
//        Session session = Session.getDefaultInstance(props,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(emailFromAddress, password);
//            }
//        });
//    
//        return session;
//    }
    ///
    public ArrayList<String> sendEmail(Session session) throws MessagingException, InterruptedException {
        emailssendtime = new ArrayList<>();
      

        if (session != null) {
            MimeMessage message1
                    = new MimeMessage(session);
            message1.setFrom(
                    new InternetAddress(username));

            for (String line : recipients) {
                System.out.println(line + " emails id to >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                message1.addRecipient(
                        Message.RecipientType.TO,
                        new InternetAddress(line));
                message1.setSubject(emailSubjectTxt);

// create the message part
                MimeBodyPart messageBodyPart
                        = new MimeBodyPart();
//fill message
                messageBodyPart.setText(emailMsgTxt);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
// Part two is attachment
//        messageBodyPart = new MimeBodyPart();
//        DataSource source
//                = new FileDataSource(fileAttachment);
//        messageBodyPart.setDataHandler(
//                new DataHandler(source));
//        messageBodyPart.setFileName(fileAttachment);
//        multipart.addBodyPart(messageBodyPart);
// Put parts in message
                message1.setContent(multipart);
// Send the message

                Transport.send(message1);
                
                DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                Date today = Calendar.getInstance().getTime();
                String reportDate = df.format(today);
                
                System.out.println(reportDate);
                emailssendtime.add(reportDate);
                System.out.println("waiting...........................................................");
              
                Thread.sleep(delay);
                

            }

        }
        return emailssendtime;
    }
}
