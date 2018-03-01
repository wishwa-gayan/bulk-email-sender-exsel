/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.GUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.mail.MessagingException;
import javax.mail.Session;

import mailer.EmailSender;
import mailer.sessionsob;

/**
 *
 * @author wishwa
 */
public class EmailSenderModel {
    
    private HashMap<String,String> confData = new HashMap<>();
    private ArrayList<String> emailList;
    private  String fileUrl ;
    private Session session;
    private sessionsob em;
    
  
    
    
    
   
    
   

    public void setConfData(HashMap<String, String> confData) {
        this.confData = confData;
    }

  

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }
    
    
    
}
