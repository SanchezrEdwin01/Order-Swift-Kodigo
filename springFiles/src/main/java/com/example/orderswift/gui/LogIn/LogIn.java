/*
 * Created by JFormDesigner on Sun May 14 17:17:15 ART 2023
 */

package com.example.orderswift.gui.LogIn;

import java.awt.event.*;
import javax.swing.event.*;

import com.example.orderswift.gui.AdminWelcome.AdminWelcome;
import com.example.orderswift.gui.Register.Register;
import com.example.orderswift.gui.UserWelcome.UserWelcome;
import com.example.orderswift.model.UserCompanyRol;
import com.example.orderswift.service.company.CompanyServiceImpl;
import com.example.orderswift.service.order.OrderServiceImpl;
import com.example.orderswift.service.user.UserService;
import com.example.orderswift.service.usercompanyrole.UserCompanyRoleServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
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
    private CompanyServiceImpl companyService;
    private UserCompanyRoleServiceImpl userCompanyRoleService;
    private OrderServiceImpl orderService;
    public LogIn(UserService userService, CompanyServiceImpl companyService, UserCompanyRoleServiceImpl userCompanyRoleService, OrderServiceImpl orderService) {
        this.userService = userService;
        this.companyService = companyService;
        this.userCompanyRoleService = userCompanyRoleService;
        this.orderService = orderService;
        initComponents();
    }

    private void signUp(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register(userService, companyService, userCompanyRoleService);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void signIn(ActionEvent e) {
        AtomicBoolean logged = new AtomicBoolean(false);
        userService.getUsers().forEach(user -> {
            if (user.getUserName().equals(usernameField.getText()) && user.getUserPassword().equals(passwordField.getText())) {
                JOptionPane.showMessageDialog(null, "Login successfully");
                logged.set(true);
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            AdminWelcome adminFrame = null;
                            if(user.getUserName().equals("admin")){
                                adminFrame = new AdminWelcome(user, orderService, userService);
                                adminFrame.setVisible(true);
                            }else {
                                for (UserCompanyRol role : userCompanyRoleService.readRoles()) {
                                    if (role.getUser().getUserId() == user.getUserId()) {
                                        if (role.getRole().equals("ADMIN")) {
                                            adminFrame = new AdminWelcome(user, orderService, userService);
                                            adminFrame.setVisible(true);
                                        }
                                    }
                                }
                                if(adminFrame == null || !adminFrame.isVisible()){
                                    UserWelcome frame = new UserWelcome(user);
                                    frame.setVisible(true);
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
        if(!logged.get())
            JOptionPane.showMessageDialog(null, "Doesn't exist a user with that username and password");
    }

    private void showPasswordCheckBoxStateChanged(ChangeEvent e) {
        if(showPasswordCheckBox.isSelected())
            passwordField.setEchoChar((char)0);
        else
            passwordField.setEchoChar('*');
    }

    private void usernameFieldKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            signInButton.doClick();
        }
    }

    private void passwordFieldKeyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            signInButton.doClick();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        signFrame = new JFrame();
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        textArea1 = new JTextPane();
        textArea2 = new JTextPane();
        usernameField = new JTextField();
        textArea3 = new JTextPane();
        passwordField = new JPasswordField();
        signInButton = new JButton();
        textArea4 = new JTextPane();
        signUpButton = new JButton();
        showPasswordCheckBox = new JCheckBox();

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

                    //---- usernameField ----
                    usernameField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            usernameFieldKeyPressed(e);
                        }
                    });

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

                    //---- passwordField ----
                    passwordField.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            passwordFieldKeyPressed(e);
                        }
                    });

                    //---- signInButton ----
                    signInButton.setText("Sign In");
                    signInButton.setFont(new Font("Segoe UI", Font.PLAIN, 11));
                    signInButton.addActionListener(e -> signIn(e));

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

                    //---- showPasswordCheckBox ----
                    showPasswordCheckBox.setText("Show Password");
                    showPasswordCheckBox.setFont(new Font("Segoe UI", Font.PLAIN, 10));
                    showPasswordCheckBox.addChangeListener(e -> showPasswordCheckBoxStateChanged(e));

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
                                    .addComponent(usernameField)
                                    .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 473, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(signUpButton, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(signInButton, GroupLayout.PREFERRED_SIZE, 395, GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41))
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPanelLayout.createParallelGroup()
                                    .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(showPasswordCheckBox))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                            .addGroup(contentPanelLayout.createSequentialGroup()
                                .addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(showPasswordCheckBox)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(signInButton)
                                .addGap(18, 18, 18)
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
    private JTextField usernameField;
    private JTextPane textArea3;
    private JPasswordField passwordField;
    private JButton signInButton;
    private JTextPane textArea4;
    private JButton signUpButton;
    private JCheckBox showPasswordCheckBox;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
