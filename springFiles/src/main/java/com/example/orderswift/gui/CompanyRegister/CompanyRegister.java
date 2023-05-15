/*
 * Created by JFormDesigner on Sun May 14 22:03:15 ART 2023
 */

package com.example.orderswift.gui.CompanyRegister;

import com.example.orderswift.gui.UserRegister.UserRegister;
import com.example.orderswift.model.Company;
import com.example.orderswift.service.company.CompanyServiceImpl;
import com.example.orderswift.service.user.UserService;
import com.example.orderswift.service.usercompanyrole.UserCompanyRoleService;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Lucas M
 */
public class CompanyRegister extends JFrame {
    private CompanyServiceImpl companyService;
    private UserService userService;
    private UserCompanyRoleService userCompanyRoleService;
    public CompanyRegister(CompanyServiceImpl companyService, UserService userService, UserCompanyRoleService userCompanyRoleService) {
        this.companyService = companyService;
        this.userService = userService;
        this.userCompanyRoleService = userCompanyRoleService;
        initComponents();
    }

    private void register(ActionEvent e) {
    // Insert a new company into the database
        Company company = new Company(companyService.getAllCompanies().size()+1, companyNameField.getText(), contactField.getText(), sectorField.getText(), descriptionField.getText(), LocalDate.now());
        companyService.createCompany(company);
        JOptionPane.showMessageDialog(null, "Company created successfully");
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        textArea1 = new JTextPane();
        textArea2 = new JTextPane();
        companyNameField = new JTextField();
        textArea3 = new JTextPane();
        addressField = new JTextField();
        textArea4 = new JTextPane();
        contactField = new JTextField();
        sectorField = new JTextField();
        textArea5 = new JTextPane();
        textArea6 = new JTextPane();
        textArea7 = new JTextPane();
        registerDateField = new JTextField();
        registerButton = new JButton();
        descriptionField = new JTextField();
        textArea8 = new JTextPane();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            //---- textArea1 ----
            textArea1.setText("Create a company profile");
            textArea1.setFont(textArea1.getFont().deriveFont(16f));
            textArea1.setEditable(false);
            textArea1.setFocusable(false);
            textArea1.setBorder(null);
            textArea1.setCaretColor(SystemColor.desktop);
            textArea1.setRequestFocusEnabled(false);
            textArea1.setVerifyInputWhenFocusTarget(false);
            textArea1.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea2 ----
            textArea2.setText("Company name:");
            textArea2.setFont(textArea2.getFont().deriveFont(14f));
            textArea2.setEditable(false);
            textArea2.setFocusable(false);
            textArea2.setBorder(null);
            textArea2.setCaretColor(SystemColor.desktop);
            textArea2.setRequestFocusEnabled(false);
            textArea2.setVerifyInputWhenFocusTarget(false);
            textArea2.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea3 ----
            textArea3.setText("Address:");
            textArea3.setFont(textArea3.getFont().deriveFont(14f));
            textArea3.setEditable(false);
            textArea3.setFocusable(false);
            textArea3.setBorder(null);
            textArea3.setCaretColor(SystemColor.desktop);
            textArea3.setRequestFocusEnabled(false);
            textArea3.setVerifyInputWhenFocusTarget(false);
            textArea3.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea4 ----
            textArea4.setText("Contact:");
            textArea4.setFont(textArea4.getFont().deriveFont(14f));
            textArea4.setEditable(false);
            textArea4.setFocusable(false);
            textArea4.setBorder(null);
            textArea4.setCaretColor(SystemColor.desktop);
            textArea4.setRequestFocusEnabled(false);
            textArea4.setVerifyInputWhenFocusTarget(false);
            textArea4.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea5 ----
            textArea5.setText("Sector:");
            textArea5.setFont(textArea5.getFont().deriveFont(14f));
            textArea5.setEditable(false);
            textArea5.setFocusable(false);
            textArea5.setBorder(null);
            textArea5.setCaretColor(SystemColor.desktop);
            textArea5.setRequestFocusEnabled(false);
            textArea5.setVerifyInputWhenFocusTarget(false);
            textArea5.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea6 ----
            textArea6.setText("Description:");
            textArea6.setFont(textArea6.getFont().deriveFont(14f));
            textArea6.setEditable(false);
            textArea6.setFocusable(false);
            textArea6.setBorder(null);
            textArea6.setCaretColor(SystemColor.desktop);
            textArea6.setRequestFocusEnabled(false);
            textArea6.setVerifyInputWhenFocusTarget(false);
            textArea6.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea7 ----
            textArea7.setText("Register Date");
            textArea7.setFont(textArea7.getFont().deriveFont(14f));
            textArea7.setEditable(false);
            textArea7.setFocusable(false);
            textArea7.setBorder(null);
            textArea7.setCaretColor(SystemColor.desktop);
            textArea7.setRequestFocusEnabled(false);
            textArea7.setVerifyInputWhenFocusTarget(false);
            textArea7.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- registerDateField ----
            registerDateField.setEditable(false);
            registerDateField.setFocusable(false);

            //---- registerButton ----
            registerButton.setText("Register");
            registerButton.addActionListener(e -> register(e));

            //---- textArea8 ----
            textArea8.setText("You will need to create an admin user for your company when you register it");
            textArea8.setFont(textArea8.getFont().deriveFont(12f));
            textArea8.setEditable(false);
            textArea8.setFocusable(false);
            textArea8.setBorder(null);
            textArea8.setCaretColor(SystemColor.desktop);
            textArea8.setRequestFocusEnabled(false);
            textArea8.setVerifyInputWhenFocusTarget(false);
            textArea8.setBackground(UIManager.getColor("Label.selectedForeground"));

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(companyNameField, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                    .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addressField, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                    .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(contactField, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                    .addComponent(textArea5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sectorField, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                    .addComponent(textArea6, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(registerDateField, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                                    .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textArea7, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(descriptionField, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addComponent(textArea8, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(GroupLayout.Alignment.TRAILING, dialogPaneLayout.createSequentialGroup()
                        .addContainerGap(173, Short.MAX_VALUE)
                        .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, dialogPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(companyNameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textArea3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(addressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textArea4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(contactField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textArea5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(sectorField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textArea6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descriptionField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textArea7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(registerDateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(textArea8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton)
                        .addGap(12, 12, 12))
            );
        }
        contentPane.add(dialogPane, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(dateTimeFormatter);
        registerDateField.setText(formattedDate);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JTextPane textArea1;
    private JTextPane textArea2;
    private JTextField companyNameField;
    private JTextPane textArea3;
    private JTextField addressField;
    private JTextPane textArea4;
    private JTextField contactField;
    private JTextField sectorField;
    private JTextPane textArea5;
    private JTextPane textArea6;
    private JTextPane textArea7;
    private JTextField registerDateField;
    private JButton registerButton;
    private JTextField descriptionField;
    private JTextPane textArea8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
