/*
 * Created by JFormDesigner on Mon May 15 00:14:18 ART 2023
 */

package com.example.orderswift.gui.AdminWelcome;

import java.awt.event.*;

import com.example.orderswift.gui.OrdersTable.OrdersTable;
import com.example.orderswift.model.User;
import com.example.orderswift.service.order.OrderServiceImpl;
import com.example.orderswift.service.user.UserService;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Lucas M
 */
public class AdminWelcome extends JFrame {
    private User user;
    private OrderServiceImpl orderService;
    private UserService userService;
    public AdminWelcome(User user, OrderServiceImpl orderService, UserService userService) {
        this.user = user;
        this.orderService = orderService;
        initComponents();
    }

    private void orders(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OrdersTable ordersTable = new OrdersTable(orderService, userService);
                    ordersTable.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
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
            ordersButton.addActionListener(e -> orders(e));

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addGroup(dialogPaneLayout.createParallelGroup()
                            .addComponent(welcomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(companiesButton, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(orderDetailsButton, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(productsButton, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(usersButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(ordersButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(categoriesButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addContainerGap())
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addComponent(welcomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(usersButton)
                            .addComponent(productsButton))
                        .addGap(18, 18, 18)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(ordersButton)
                            .addComponent(orderDetailsButton))
                        .addGap(18, 18, 18)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(categoriesButton)
                            .addComponent(companiesButton))
                        .addGap(0, 21, Short.MAX_VALUE))
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
