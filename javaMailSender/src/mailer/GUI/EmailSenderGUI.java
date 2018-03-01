/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer.GUI;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

/**
 *
 * @author wishwa
 */
public class EmailSenderGUI extends javax.swing.JFrame {

    /**
     * Creates new form EmailSenderGUI
     */
    public EmailSenderGUI() {
        initComponents();
        intialze();
    }

    public void intialze() {
        emailList.setText("");
        unametxt.setText("");
        pwdtxt.setText("");
        portTtx.setText("");
        hosttxt.setText("");
        msgbody.setText("");
        emailMagPathtxt.setText("");
    }

    public static int getEXIT_ON_CLOSE() {
        return EXIT_ON_CLOSE;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    String getEmailList() {
        String temp = emailList.getText();
        if (temp.isEmpty()) {

            displayError("Email List excel file field must be non empthy !");
        }

        return temp;

    }

    public String getHosttxt() {
        String temp = hosttxt.getText();
        if (temp.isEmpty()) {

            displayError(" Host name  field must be non empthy !");
        }

        return temp;
    }

    public String getDelaytxt() {
        String temp = delaytxt.getText();
        if (temp.isEmpty()) {

            displayError(" Host name  field must be non empthy !");
        }

        return temp;
    }

    public String getMsgbody() {
        String temp = msgbody.getText();
        if (temp.isEmpty()) {

            displayError("Massenge  field must be non empthy !");
        }

        return temp;
    }

    public String getPortTtx() {
        String temp = null;
        try {
        temp = portTtx.getText().toString();
        } catch (Exception e) {
            displayError("must be numn");
        }
        if (temp.isEmpty()) {

            displayError("Port field must be non empthy");
        }
        return temp;
    }

    public String getPwdtxt() {
        String temp = this.pwdtxt.getText();

        if (temp.isEmpty()) {

            displayError("Password field must be non empthy! ");
        }

        return temp;
    }

    public String getSubjectTxt() {
        String temp = subjectTxt.getText();
        if (temp.isEmpty()) {

            displayError("Subject field must be non empthy !");
        }

        return temp;
    }

    public String getUnametxt() {
        String temp = unametxt.getText();
        if (temp.isEmpty()) {

            displayError("User Name  field must be non empthy !");
        }

        return temp;
    }

    public String getEmailMagPathtxt() {
        String temp = emailMagPathtxt.getText();
        if (temp.isEmpty()) {

            displayError("Subject field must be non empthy !");
        }

        return temp;
    }

    public JPanel getNextPanel() {
        return nextPanel;
    }

    public void setEmailMagPathtxt(String emailMagPathtxt) {
        this.emailMagPathtxt.setText(emailMagPathtxt);
    }

    public void setMsgbody(String msgbody) {
        this.msgbody.setText(msgbody);
    }

    public void setMsgbody(JTextArea msgbody) {
        this.msgbody = msgbody;
    }

    public void setEmailList(String emailist) {
        this.emailList.setText(emailist);
    }

    public void displayError(String errorMsg) {
        JOptionPane.showMessageDialog(this, errorMsg);
    }

    void addSendButtonListner(ActionListener listnerForSendBtn) {

        sendBtn.addActionListener(listnerForSendBtn);
    }

    void addloginButtonListner(ActionListener listnerForSendBtn) {

        loginbnt.addActionListener(listnerForSendBtn);
    }

    void addsetPathButtonListner(ActionListener listnerForSendBtn) {

        setPathBtn.addActionListener(listnerForSendBtn);
    }

    void addemailMsgButtonListner(ActionListener listnerForSendBtn) {

        EmailPathbtn.addActionListener(listnerForSendBtn);
    }

    void addSetButtonListner(ActionListener listnerForSendBtn) {

        setbtn.addActionListener(listnerForSendBtn);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        unametxt = new javax.swing.JTextField();
        pwdtxt = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        loginbnt = new javax.swing.JButton();
        nextPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msgbody = new javax.swing.JTextArea();
        sendBtn = new javax.swing.JButton();
        subjectTxt = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        emailList = new javax.swing.JTextField();
        setPathBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        delaytxt = new javax.swing.JTextField();
        emailMagPathtxt = new javax.swing.JTextField();
        EmailPathbtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        portTtx = new javax.swing.JTextField();
        hosttxt = new javax.swing.JTextField();
        setbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Email Sender ");
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setBackground(new java.awt.Color(204, 255, 255));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("User Name");

        jLabel2.setText("Password");

        unametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unametxtActionPerformed(evt);
            }
        });

        pwdtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwdtxtActionPerformed(evt);
            }
        });

        loginbnt.setBackground(new java.awt.Color(204, 204, 204));
        loginbnt.setText("Login");
        loginbnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbntActionPerformed(evt);
            }
        });

        nextPanel.setBackground(new java.awt.Color(204, 204, 255));

        msgbody.setColumns(20);
        msgbody.setRows(5);
        jScrollPane1.setViewportView(msgbody);

        sendBtn.setBackground(new java.awt.Color(204, 204, 204));
        sendBtn.setText("Send");
        sendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendBtnActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 255));
        jRadioButton1.setText("Import Email Body File");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Message ");

        jLabel5.setText("Emails List (Exel)");

        emailList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailListActionPerformed(evt);
            }
        });

        setPathBtn.setBackground(new java.awt.Color(204, 204, 204));
        setPathBtn.setText("Set Path");
        setPathBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setPathBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Subject");

        jLabel9.setText("Delay");

        delaytxt.setText("0");

        EmailPathbtn.setBackground(new java.awt.Color(204, 204, 204));
        EmailPathbtn.setText("Set Email");
        EmailPathbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailPathbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nextPanelLayout = new javax.swing.GroupLayout(nextPanel);
        nextPanel.setLayout(nextPanelLayout);
        nextPanelLayout.setHorizontalGroup(
            nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delaytxt, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137)
                .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(332, 332, 332))
            .addGroup(nextPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(nextPanelLayout.createSequentialGroup()
                        .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(nextPanelLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jRadioButton1)
                                .addGap(29, 29, 29)
                                .addComponent(emailMagPathtxt))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nextPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(subjectTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
                                    .addComponent(emailList))))
                        .addGap(18, 18, 18)
                        .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(setPathBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EmailPathbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))))
                .addContainerGap())
        );
        nextPanelLayout.setVerticalGroup(
            nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nextPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(setPathBtn))
                .addGap(25, 25, 25)
                .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jLabel8)
                        .addComponent(emailMagPathtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(EmailPathbtn))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(nextPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(delaytxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pwdtxt, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                            .addComponent(unametxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 28, Short.MAX_VALUE)
                        .addComponent(loginbnt, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel6)))
                .addGap(22, 22, 22))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(nextPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(0, 3, Short.MAX_VALUE)
                                .addComponent(loginbnt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(unametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(pwdtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(nextPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 560));

        jTabbedPane1.addTab("Email Send", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Port");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 76, -1, -1));

        jLabel4.setText("Host");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 138, -1, -1));
        jPanel3.add(portTtx, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 73, 700, -1));
        jPanel3.add(hosttxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 135, 700, -1));

        setbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        setbtn.setText("set");
        setbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setbtnActionPerformed(evt);
            }
        });
        jPanel3.add(setbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 230, 140, 60));

        jTabbedPane1.addTab("Setting", jPanel3);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 990, 590));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginbntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbntActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginbntActionPerformed

    private void setPathBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setPathBtnActionPerformed
        //       FileNameExtensionFilter fl = new FileNameExtensionFilter("excel files above 2007", "xlsx");
        //        JFileChooser jf = new JFileChooser();
        //        jf.addChoosableFileFilter(fl);
        //        int returnval = jf.showOpenDialog(null);
        //        if (returnval == JFileChooser.APPROVE_OPTION) {
        //            File myfile = jf.getSelectedFile();
        //            emailList.setText(myfile.getPath());
        //
        //        }
    }//GEN-LAST:event_setPathBtnActionPerformed

    private void pwdtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwdtxtActionPerformed

    }//GEN-LAST:event_pwdtxtActionPerformed

    private void unametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unametxtActionPerformed

    }//GEN-LAST:event_unametxtActionPerformed

    private void sendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendBtnActionPerformed

    private void setbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setbtnActionPerformed

    }//GEN-LAST:event_setbtnActionPerformed

    private void emailListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailListActionPerformed

    private void EmailPathbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailPathbtnActionPerformed
        FileNameExtensionFilter fl = new FileNameExtensionFilter("excel file _", "xls");
        JFileChooser jf = new JFileChooser();
        jf.addChoosableFileFilter(fl);
        int returnval = jf.showOpenDialog(null);
        if (returnval == JFileChooser.APPROVE_OPTION) {
            jf.getFileView();

            File file = null;

            try {

                file = jf.getSelectedFile();
                String name = file.getPath();
                setEmailMagPathtxt(name);

//                BufferedReader in = new BufferedReader(new FileReader(name));
//                String str;
//
//                List<String> list1 = new ArrayList<String>();
//                while ((str = in.readLine()) != null) {
//                    list1.add(str);
//                }
//
//                String[] stringArr = list1.toArray(new String[0]);
//
//              
                FileInputStream fis = new FileInputStream(file);
                XWPFDocument document = new XWPFDocument(fis);
                XWPFWordExtractor extracto = new XWPFWordExtractor(document);
                String fileData = extracto.getText();

                msgbody.setText(fileData);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(EmailSenderControll.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_EmailPathbtnActionPerformed
    }
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton EmailPathbtn;
    private javax.swing.JTextField delaytxt;
    private javax.swing.JTextField emailList;
    private javax.swing.JTextField emailMagPathtxt;
    private javax.swing.JTextField hosttxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton loginbnt;
    private javax.swing.JTextArea msgbody;
    private javax.swing.JPanel nextPanel;
    private javax.swing.JTextField portTtx;
    private javax.swing.JPasswordField pwdtxt;
    private javax.swing.JButton sendBtn;
    private javax.swing.JButton setPathBtn;
    private javax.swing.JButton setbtn;
    private javax.swing.JTextField subjectTxt;
    private javax.swing.JTextField unametxt;
    // End of variables declaration//GEN-END:variables
}
