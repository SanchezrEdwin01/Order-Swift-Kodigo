/*
 * Created by JFormDesigner on Mon May 15 00:14:18 ART 2023
 */

package com.example.orderswift.gui.AdminWelcome;

import com.example.orderswift.model.User;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Lucas M
 */
public class AdminWelcome extends JFrame {
    private User user;
    public AdminWelcome(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        welcomeText = new JTextPane();
        textArea2 = new JTextPane();
        productsButton = new JButton();
        companiesButton = new JButton();
        usersButton = new JButton();
        orderDetailsButton = new JButton();
        categoriesButton = new JButton();
        ordersButton = new JButton();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            //---- welcomeText ----
            welcomeText.setText("Welcome Admin");
            welcomeText.setFont(welcomeText.getFont().deriveFont(16f));
            welcomeText.setEditable(false);
            welcomeText.setFocusable(false);
            welcomeText.setBorder(null);
            welcomeText.setCaretColor(SystemColor.desktop);
            welcomeText.setRequestFocusEnabled(false);
            welcomeText.setVerifyInputWhenFocusTarget(false);
            welcomeText.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- textArea2 ----
            textArea2.setText("Select an option:");
            textArea2.setFont(textArea2.getFont().deriveFont(14f));
            textArea2.setEditable(false);
            textArea2.setFocusable(false);
            textArea2.setBorder(null);
            textArea2.setCaretColor(SystemColor.desktop);
            textArea2.setRequestFocusEnabled(false);
            textArea2.setVerifyInputWhenFocusTarget(false);
            textArea2.setBackground(UIManager.getColor("Label.selectedForeground"));

            //---- productsButton ----
            productsButton.setText("Products");

            //---- companiesButton ----
            companiesButton.setText("Companies");

            //---- usersButton ----
            usersButton.setText("Users");

            //---- orderDetailsButton ----
            orderDetailsButton.setText("Order Details");

            //---- categoriesButton ----
            categoriesButton.setText("Categories");

            //---- ordersButton ----
            ordersButton.setText("Orders");

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addComponent(welcomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 228, Short.MAX_VALUE))
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addComponent(productsButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(companiesButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(usersButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE))
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                .addComponent(orderDetailsButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(categoriesButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ordersButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addComponent(welcomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(productsButton)
                            .addComponent(companiesButton)
                            .addComponent(usersButton))
                        .addGap(18, 18, 18)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(orderDetailsButton)
                            .addComponent(categoriesButton)
                            .addComponent(ordersButton))
                        .addGap(0, 29, Short.MAX_VALUE))
            );
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        welcomeText.setText("Welcome " + user.getFirstName() + " " + user.getLastName());
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JTextPane welcomeText;
    private JTextPane textArea2;
    private JButton productsButton;
    private JButton companiesButton;
    private JButton usersButton;
    private JButton orderDetailsButton;
    private JButton categoriesButton;
    private JButton ordersButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
