package com.aut.pdc.mike.gui;

import javax.swing.JOptionPane;
import com.aut.pdc.mike.gamemodel.Player;

/**
 * Login Frame
 * @author Minghao Yang
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login(Player player) {
        this.player = player;
        initComponents();
        this.loginMess.setVisible(false);
    }

    private Login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usernameTxt = new javax.swing.JTextField();
        passwordTxt = new javax.swing.JTextField();
        returnBtn = new javax.swing.JButton();
        loginBtn = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();
        loginMess = new javax.swing.JOptionPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 600));
        setSize(new java.awt.Dimension(600, 600));
        getContentPane().setLayout(null);

        usernameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTxtActionPerformed(evt);
            }
        });
        getContentPane().add(usernameTxt);
        usernameTxt.setBounds(250, 230, 190, 30);

        passwordTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTxtActionPerformed(evt);
            }
        });
        getContentPane().add(passwordTxt);
        passwordTxt.setBounds(250, 310, 190, 30);

        returnBtn.setBackground(new java.awt.Color(177, 222, 121));
        returnBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        returnBtn.setText("RETURN");
        returnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnBtnActionPerformed(evt);
            }
        });
        getContentPane().add(returnBtn);
        returnBtn.setBounds(250, 430, 110, 40);

        loginBtn.setBackground(new java.awt.Color(177, 222, 121));
        loginBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        loginBtn.setText("LOGIN");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginBtn);
        loginBtn.setBounds(250, 380, 110, 40);

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/aut/pdc/mike/gui/img/login.jpg"))); // NOI18N
        backgroundLabel.setSize(new java.awt.Dimension(600, 600));
        getContentPane().add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 600, 600);
        getContentPane().add(loginMess);
        loginMess.setBounds(210, 210, 262, 90);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTxtActionPerformed

    private void usernameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTxtActionPerformed
    /**
     * Login button action performed
     * @param evt 
     */
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        String userName = usernameTxt.getText();
        String passWord = passwordTxt.getText();
        String messageTxt = player.login(userName, passWord);
        loginMess.showMessageDialog(this, messageTxt, "LOGIN", JOptionPane.INFORMATION_MESSAGE);
        usernameTxt.setText("");
        passwordTxt.setText("");
        if (messageTxt.startsWith("Successfully", 0)) {
            if (this.player.getPet().getName() == null || !(this.player.getPet().isAlive())) {
                int temp = loginMess.showConfirmDialog(this, "You haven't got a pet yet, do you want to adopt one?", "ADOPT", JOptionPane.YES_NO_OPTION);
                if (temp == 0) {
                    player.adopt();
                    this.dispose();
                    VirtualPetFrame petGame = new VirtualPetFrame(player);
                    petGame.setVisible(true);
                } else {
                    loginMess.showMessageDialog(this, "Maybe you still nedd sometime to consider about this.", "ADOPT", JOptionPane.INFORMATION_MESSAGE);
                    this.returnBtnActionPerformed(evt);
                }
            } else {
                this.dispose();
                VirtualPetFrame petGame = new VirtualPetFrame(player);
                petGame.setVisible(true);
            }
        }
    }//GEN-LAST:event_loginBtnActionPerformed
    /**
     * Return button action performed
     * @param evt 
     */
    private void returnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnBtnActionPerformed
        // TODO add your handling code here:
        this.dispose();
        MainMenu mm = new MainMenu(player);
        mm.setVisible(true);
    }//GEN-LAST:event_returnBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton loginBtn;
    private javax.swing.JOptionPane loginMess;
    private javax.swing.JTextField passwordTxt;
    private javax.swing.JButton returnBtn;
    private javax.swing.JTextField usernameTxt;
    // End of variables declaration//GEN-END:variables
    public Player player;
}
