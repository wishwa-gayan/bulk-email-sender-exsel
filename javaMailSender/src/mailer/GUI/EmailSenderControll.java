/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import mailer.EmailSender;
import mailer.sessionsob;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import temp.DataReadi;

/**
 *
 * @author wishwa
 */
public class EmailSenderControll {

    private String password;
    private String username;
    private String SMTP_HOST_NAME;
    private String SMTP_PORT;
    private String emailMsgTxt;
    private String emailSubjectTxt;
    private String emailFromAddress;
    private long delay = 0;
//    private String SSL_FACTORY
//            = "javax.net.ssl.SSLSocketFactory";

    private String sheetname;
    private ArrayList<String> emailssendtime;
    private final EmailSenderGUI theView;
    private final EmailSenderModel theModel;
    private EmailSender emObj;
    private Session sesion;

    DataReadi dr;
    CopyOnWriteArrayList<String> data = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<String> emailsSendTime = new CopyOnWriteArrayList<>();
    CopyOnWriteArrayList<String> emailsLists = new CopyOnWriteArrayList<>();
    int count = 0;
    int count1 = 0;

    public EmailSenderControll(EmailSenderGUI theView, EmailSenderModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.getNextPanel().setVisible(false);
        this.theView.addloginButtonListner(new LoginListner());
        this.theView.addSendButtonListner(new SendListner());
        this.theView.addsetPathButtonListner(new PathListner());
        
        this.theView.addSetButtonListner(new SetListner());

//        SetConfData(theView.getUnametxt(), theView.getPwdtxt(), theView.getMsgbody(),
//                theView.getPortTtx(), theView.getSubjectTxt(), theView.getHosttxt());
    }

    private static class EditBtnLisner implements ActionListener {

        public EditBtnLisner() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            System.exit(0);
        }
    }

    private class SetListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            SMTP_PORT = theView.getPortTtx();
            SMTP_HOST_NAME = theView.getHosttxt();
        }
    }

   

    private class PathListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter fl = new FileNameExtensionFilter("excel file _", "xlsx");
            JFileChooser jf = new JFileChooser();
            jf.addChoosableFileFilter(fl);
            int returnval = jf.showOpenDialog(null);
            if (returnval == JFileChooser.APPROVE_OPTION) {
                try {
                    File myfile = jf.getSelectedFile();
                    String path = myfile.getPath();
                    theView.setEmailList(path);
                    dr = new DataReadi();
                    emailsLists = dr.getEmails(path);

                    //
                    for (String data : emailsLists) {
                        System.out.println("emails : " + data);
                    }
                    //

                } catch (IOException ex) {
                    Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class SendListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            theView.setVisible(false);
            emailSubjectTxt = theView.getSubjectTxt();
            emailMsgTxt = theView.getMsgbody();
            delay = Integer.parseInt(theView.getDelaytxt()) * 60000;
            boolean running = true;

            Thread th1 = new Thread(new Runnable() {
                public void run() {
                    while (running) {
                        MyThread my = new MyThread();
                        my.paths = theView.getEmailList();
                        my.start();
                        try {
                            my.join();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        data = my.getData();
                        for (Iterator<String> iterator = data.iterator(); iterator.hasNext();) {
                            String next = iterator.next();
                            if (!emailsLists.contains(next)) {
                                emailsLists.add(next);
                            }
                        }
                        try {
                            Thread.sleep(10000);
                           
                        } catch (InterruptedException ex) {

                        }

                    }
                }
            });

            Thread th2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (Thread.currentThread().isAlive()) {
                        if (!emailsLists.isEmpty()) {

                            count = emailsLists.size();

                            if (count > count1) {

                                for (int i = count1; i < count; i++) {
                                    System.out.println(">>>>>>>>>>>>>>>>>>>>>>>"+count+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
///-----------------------------------------------------------------------------------------------------------

                                    if (sesion != null) {
                                        MimeMessage message1
                                                = new MimeMessage(sesion);
                                        try {
                                            message1.setFrom(
                                                    new InternetAddress(username));
                                        } catch (MessagingException ex) {
                                            Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
                                        }

                                        try {
                                            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>" + emailsLists.get(i) + " emails id to >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
                                            message1.addRecipient(
                                                    Message.RecipientType.TO,
                                                    new InternetAddress(emailsLists.get(i)));
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

                                            emailsSendTime.add(reportDate);
                                            try {
                                                Thread.sleep( delay);
                                            } catch (InterruptedException ex) {
                                                Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
                                            }

                                        } catch (MessagingException ex) {
                                            Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);

                                        }

                                    }

                                    count1++;
                                    ///--------------------------------------------------------------------------------------------------------------------------
                                }

                            } else {
                                try {
                                    dr = new DataReadi();
                                    dr.setUrlfile(theView.getEmailList());
                                    dr.dateWritie(emailsLists, emailsSendTime, theView.getEmailList());
                                   Thread.currentThread().wait(200000);

                                } catch (IOException ex) {
                                    Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
                                }

                               
                            }
                        }
                    }
                }
            }
            );

            th1.start();
            th2.start();

            try {
                th1.join();
                th2.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    private class LoginListner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            password = theView.getPwdtxt();
            username = theView.getUnametxt();
            sessionsob sObj = new sessionsob();
            sesion = sObj.setSesion(SMTP_HOST_NAME, SMTP_PORT,
                    username, password);

            //
            System.out.println("passowrd " + password);
            System.out.println("username " + username);
            //
            if (sesion != null) {
                theView.getNextPanel().setVisible(true);
            } else {
                theView.displayError("WronG UserName Or Password");
            }

        }
    }

}

class MyThread extends Thread {

    CopyOnWriteArrayList<String> data = new CopyOnWriteArrayList<>();
    boolean running = true;
    String paths;

    public void run() {

        try {

            DataReadi dt = new DataReadi();

            data = dt.getEmails(paths);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public CopyOnWriteArrayList<String> getData() {
        return data;
    }

}
