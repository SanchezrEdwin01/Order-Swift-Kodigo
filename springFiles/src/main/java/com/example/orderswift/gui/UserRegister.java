/*
 * Created by JFormDesigner on Sun May 14 21:12:44 ART 2023
 */

package com.example.orderswift.gui;

import com.example.orderswift.model.User;
import com.example.orderswift.service.user.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.text.NumberFormatter;

/**
 * @author Lucas M
 */
@SpringBootApplication
@Component
public class UserRegister extends JFrame {
    private UserService userService;
    public UserRegister(UserService userService) {
        this.userService = userService;
        initComponents();
    }

    private void register(ActionEvent e) {
    // Insert a new user into the database
        User user = new User(userService.getUsers().size()+1,usernameField.getText(), firstNameField.getText(), lastNameField.getText(), passwordField.getText(), emailField.getText(), phoneField.getText());
        userService.saveOrUpdate(user);
    }

    private void initComponents() {
        NumberFormat longFormat = NumberFormat.getIntegerInstance();
        longFormat.setGroupingUsed(false);
        NumberFormatter numberFormatter = new NumberFormatter(longFormat) {
            @Override
            public Object stringToValue(String text) throws ParseException {
                if (text.length() == 0)
                    return null;
                return super.stringToValue(text);
            }
        };
        numberFormatter.setValueClass(Long.class);
        numberFormatter.setAllowsInvalid(false);
        numberFormatter.setMinimum(0l);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane2 = new JPanel();
        textArea1 = new JTextPane();
        textArea2 = new JTextPane();
        usernameField = new JTextField();
        textArea3 = new JTextPane();
        passwordField = new JTextField();
        textArea4 = new JTextPane();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        textArea5 = new JTextPane();
        phoneField = new JFormattedTextField();
        textArea6 = new JTextPane();
        textArea7 = new JTextPane();
        emailField = new JTextField();
        registerButton = new JButton();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();

        //======== dialogPane2 ========
        {
            dialogPane2.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane2.setAutoscrolls(true);

            //---- textArea1 ----
            textArea1.setText("Create an user profile");
            textArea1.setFont(textArea1.getFont().deriveFont(16f));
            textArea1.setEditable(false);
            textArea1.setFocusable(false);
            textArea1.setBorder(null);
            textArea1.setCaretColor(SystemColor.desktop);
            textArea1.setRequestFocusEnabled(false);
            textArea1.setVerifyInputWhenFocusTarget(false);
            textArea1.setBackground(UIManager.getColor("Label.selectedForeground"));

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

            //---- textArea4 ----
            textArea4.setText("First name:");
            textArea4.setFont(textArea4.getFont().deriveFont(14f));
            textArea4.setEditable(false);
            textArea4.setFocusable(false);
            textArea4.setBorder(null);
            textArea4.setCaretColor(SystemColor.desktop);
            textArea4.setRequestFocusEnabled(false);
            textArea4.setVerifyInputWhenFocusTarget(false);
            textArea4.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea5 ----
            textArea5.setText("Last name:");
            textArea5.setFont(textArea5.getFont().deriveFont(14f));
            textArea5.setEditable(false);
            textArea5.setFocusable(false);
            textArea5.setBorder(null);
            textArea5.setCaretColor(SystemColor.desktop);
            textArea5.setRequestFocusEnabled(false);
            textArea5.setVerifyInputWhenFocusTarget(false);
            textArea5.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea6 ----
            textArea6.setText("Phone:");
            textArea6.setFont(textArea6.getFont().deriveFont(14f));
            textArea6.setEditable(false);
            textArea6.setFocusable(false);
            textArea6.setBorder(null);
            textArea6.setCaretColor(SystemColor.desktop);
            textArea6.setRequestFocusEnabled(false);
            textArea6.setVerifyInputWhenFocusTarget(false);
            textArea6.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea7 ----
            textArea7.setText("Email:");
            textArea7.setFont(textArea7.getFont().deriveFont(14f));
            textArea7.setEditable(false);
            textArea7.setFocusable(false);
            textArea7.setBorder(null);
            textArea7.setCaretColor(SystemColor.desktop);
            textArea7.setRequestFocusEnabled(false);
            textArea7.setVerifyInputWhenFocusTarget(false);
            textArea7.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.addActionListener(e -> register(e));

            GroupLayout dialogPane2Layout = new GroupLayout(dialogPane2);
            dialogPane2.setLayout(dialogPane2Layout);
            dialogPane2Layout.setHorizontalGroup(
                dialogPane2Layout.createParallelGroup()
                    .addGroup(dialogPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogPane2Layout.createParallelGroup()
                            .addGroup(dialogPane2Layout.createSequentialGroup()
                                .addGroup(dialogPane2Layout.createParallelGroup()
                                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dialogPane2Layout.createSequentialGroup()
                                .addGroup(dialogPane2Layout.createParallelGroup()
                                    .addComponent(lastNameField)
                                    .addComponent(firstNameField)
                                    .addComponent(passwordField)
                                    .addComponent(usernameField)
                                    .addGroup(GroupLayout.Alignment.TRAILING, dialogPane2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(dialogPane2Layout.createParallelGroup()
                                            .addComponent(textArea6, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(dialogPane2Layout.createSequentialGroup()
                                        .addGroup(dialogPane2Layout.createParallelGroup()
                                            .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textArea5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textArea7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
                                            .addGroup(dialogPane2Layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())))
            );
            dialogPane2Layout.setVerticalGroup(
                dialogPane2Layout.createParallelGroup()
                    .addGroup(dialogPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(firstNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textArea5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textArea6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(textArea7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addComponent(registerButton))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(dialogPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(dialogPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 4, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane2;
    private JTextPane textArea1;
    private JTextPane textArea2;
    private JTextField usernameField;
    private JTextPane textArea3;
    private JTextField passwordField;
    private JTextPane textArea4;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextPane textArea5;
    private JFormattedTextField phoneField;
    private JTextPane textArea6;
    private JTextPane textArea7;
    private JTextField emailField;
    private JButton registerButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
