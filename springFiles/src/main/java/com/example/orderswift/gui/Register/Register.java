/*
 * Created by JFormDesigner on Sun May 14 20:54:30 ART 2023
 */

package com.example.orderswift.gui.Register;

import com.example.orderswift.gui.CompanyRegister.CompanyRegister;
import com.example.orderswift.gui.UserRegister.UserRegister;
import com.example.orderswift.service.company.CompanyService;
import com.example.orderswift.service.company.CompanyServiceImpl;
import com.example.orderswift.service.user.UserService;
import com.example.orderswift.service.usercompanyrole.UserCompanyRoleService;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Lucas M
 */
public class Register extends JFrame {
    private UserService userService;
    private CompanyServiceImpl companyService;
    private UserCompanyRoleService userCompanyRoleService;
    public Register(UserService userService, CompanyServiceImpl companyService, UserCompanyRoleService userCompanyRolService) {
        this.userService = userService;
        this.companyService = companyService;
        this.userCompanyRoleService = userCompanyRolService;
        initComponents();
    }

    private void userCreate(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegister frame = new UserRegister(userService, userCompanyRoleService);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void companyCreate(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CompanyRegister frame = new CompanyRegister(companyService, userService, userCompanyRoleService);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        userCreate = new JButton();
        textArea1 = new JTextPane();
        companyCreate = new JButton();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();

        //---- userCreate ----
        userCreate.setText("User profile");
        userCreate.addActionListener(e -> userCreate(e));

        //---- textArea1 ----
        textArea1.setText("What kind of profile do you want to create? ");
        textArea1.setFont(textArea1.getFont().deriveFont(16f));
        textArea1.setEditable(false);
        textArea1.setFocusable(false);
        textArea1.setBorder(null);
        textArea1.setCaretColor(SystemColor.desktop);
        textArea1.setRequestFocusEnabled(false);
        textArea1.setVerifyInputWhenFocusTarget(false);
        textArea1.setBackground(UIManager.getColor("Label.selectedForeground"));

        //---- companyCreate ----
        companyCreate.setText("Company profile");
        companyCreate.addActionListener(e -> companyCreate(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(userCreate, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                    .addComponent(companyCreate, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
                    .addGap(44, 44, 44))
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap(85, Short.MAX_VALUE)
                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(84, 84, 84))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(userCreate)
                        .addComponent(companyCreate))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton userCreate;
    private JTextPane textArea1;
    private JButton companyCreate;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
