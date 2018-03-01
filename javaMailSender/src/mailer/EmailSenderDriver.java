/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer;

import java.security.Security;
import mailer.GUI.EmailSenderControll;
import mailer.GUI.EmailSenderGUI;
import mailer.GUI.EmailSenderModel;

/**
 *
 * @author wishwa
 */
public class EmailSenderDriver {
    public static void main(String[] args) {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        EmailSenderGUI theView = new EmailSenderGUI();
        EmailSenderModel theModel = new EmailSenderModel();
        
        EmailSenderControll emObj = new EmailSenderControll(theView, theModel);
        theView.setVisible(true);
        
    }
 
}
