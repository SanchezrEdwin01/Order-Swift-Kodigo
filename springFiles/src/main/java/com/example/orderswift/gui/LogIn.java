/*
 * Created by JFormDesigner on Sun May 14 17:17:15 ART 2023
 */

package com.example.orderswift.gui;

import java.awt.event.*;

import com.example.orderswift.service.user.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Lucas M
 */
@SpringBootApplication
@Component
public class LogIn {
    private UserService userService;
    public LogIn(UserService userService) {
        this.userService = userService;
        initComponents();
    }

    private void signUp(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register(userService);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        signFrame = new JFrame();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextPane();
        textArea2 = new JTextPane();
        textField1 = new JTextField();
        textArea3 = new JTextPane();
        textField2 = new JPasswordField();
        signInButton = new JButton();
        textArea4 = new JTextPane();
        signUpButton = new JButton();

        //======== signFrame ========
        {
            signFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            signFrame.setResizable(false);
            Container signFrameContentPane = signFrame.getContentPane();
            signFrameContentPane.setLayout(new BorderLayout());

            //======== dialogPane ========
            {
                dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
                dialogPane.setLayout(new BorderLayout());

                //======== contentPanel ========
                {

                    //======== scrollPane1 ========
                    {
                        scrollPane1.setBorder(null);

                        //---- textArea1 ----
                        textArea1.setText("Sign In");
                        textArea1.setFont(textArea1.getFont().deriveFont(16f));
                        textArea1.setEditable(false);
                        textArea1.setFocusable(false);
                        textArea1.setBorder(null);
                        textArea1.setCaretColor(SystemColor.desktop);
                        textArea1.setRequestFocusEnabled(false);
                        textArea1.setVerifyInputWhenFocusTarget(false);
                        textArea1.setBackground(UIManager.getColor("Label.selectedForeground"));
                        scrollPane1.setViewportView(textArea1);
                    }

                    //---- textArea2 ----
                    textArea2.setText("Username:");
                    textArea2.setFont(textArea2.getFont().deriveFont(14f));
                    textArea2.setEditable(false);
                    textArea2.setFocusable(false);
                    textArea2.setBorder(null);
                    textArea2.setCaretColor(SystemColor.desktop);
                    textArea2.setRequestFocusEnabled(false);
                    textArea2.setVerifyInputWhenFocusTarget(false);
                    textArea2.setBackground(UIManager.getColor("Label.selectedForeground"));

                    //---- textArea3 ----
                    textArea3.setText("Password:");
                    textArea3.setFont(textArea3.getFont().deriveFont(14f));
                    textArea3.setEditable(false);
                    textArea3.setFocusable(false);
                    textArea3.setBorder(null);
                    textArea3.setCaretColor(SystemColor.desktop);
                    textArea3.setRequestFocusEnabled(false);
                    textArea3.setVerifyInputWhenFocusTarget(false);
                    textArea3.setBackground(UIManager.getColor("Label.selectedForeground"));

                    //---- signInButton ----
                    signInButton.setText("Sign In");
                    signInButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));

                    //---- textArea4 ----
                    textArea4.setText("Don't have an account yet?");
                    textArea4.setFont(textArea4.getFont().deriveFont(12f));
                    textArea4.setEditable(false);
                    textArea4.setFocusable(false);
                    textArea4.setBorder(null);
                    textArea4.setCaretColor(SystemColor.desktop);
                    textArea4.setRequestFocusEnabled(false);
                    textArea4.setVerifyInputWhenFocusTarget(false);
                    textArea4.setBackground(UIManager.getColor("Label.selectedForeground"));

                    //---- signUpButton ----
                    signUpButton.setText("Sign Up");
                    signUpButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                    signUpButton.addActionListener(e -> signUp(e));

                    GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                    contentPanel.setLayout(contentPanelLayout);
                    contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addComponent(textField1)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(signInButton, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addComponent(signInButton)
                                .addGap(24, 24, 24)
                                .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(signUpButton))
                    );
                }
                dialogPane.add(contentPanel, BorderLayout.CENTER);
            }
            signFrameContentPane.add(dialogPane, BorderLayout.CENTER);
            signFrame.pack();
            signFrame.setLocationRelativeTo(signFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        signFrame.setVisible(true); //This is the line that makes the GUI visible.
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame signFrame;
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JScrollPane scrollPane1;
    private JTextPane textArea1;
    private JTextPane textArea2;
    private JTextField textField1;
    private JTextPane textArea3;
    private JPasswordField textField2;
    private JButton signInButton;
    private JTextPane textArea4;
    private JButton signUpButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
