/*
 * Created by JFormDesigner on Mon May 15 11:49:39 ART 2023
 */

package com.example.orderswift.gui.OrdersTable.CreateOrder;

import java.awt.event.*;

import com.example.orderswift.model.Order;
import com.example.orderswift.model.User;
import com.example.orderswift.service.order.OrderServiceImpl;
import com.example.orderswift.service.user.UserService;

import java.awt.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.text.NumberFormatter;

/**
 * @author Lucas M
 */
public class CreateOrder extends JFrame {
    private OrderServiceImpl orderService;
    private UserService userService;
    public CreateOrder(OrderServiceImpl orderService, UserService userService) {
        this.orderService = orderService;
        this.userService = userService;
        initComponents();
    }

    private void create(ActionEvent e) {
        Order order = new Order(orderService.getOrders().size()+1, new Date(dateField.getText()), statusField.getSelectedItem().toString(), Double.parseDouble(totalAmountField.getText()));
        orderService.saveOrder(order);
    }

    private void initComponents() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = today.format(dateTimeFormatter);
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
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        JLabel label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        createButton = new JButton();
        idField = new JFormattedTextField(numberFormatter);
        dateField = new JFormattedTextField(dateTimeFormatter);
        statusField = new JComboBox();
        totalAmountField = new JFormattedTextField(numberFormatter);
        userIdField = new JFormattedTextField(numberFormatter);

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("Create Order");
                label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

                //---- label2 ----
                label2.setText("ID:");

                //---- label3 ----
                label3.setText("Date:");

                //---- label4 ----
                label4.setText("Status:");

                //---- label5 ----
                label5.setText("Total Amount:");

                //---- label6 ----
                label6.setText("User ID:");

                //---- createButton ----
                createButton.setText("Create");
                createButton.addActionListener(e -> create(e));

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(idField, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label6, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                    .addComponent(userIdField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label3, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                    .addComponent(dateField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                    .addComponent(statusField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addComponent(label5, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                    .addComponent(totalAmountField, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
                            .addContainerGap())
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(141, 141, 141)
                            .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(153, Short.MAX_VALUE))
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(18, 18, 18)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2)
                                .addComponent(idField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label3)
                                .addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label4)
                                .addComponent(statusField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5)
                                .addComponent(totalAmountField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label6)
                                .addComponent(userIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                            .addComponent(createButton))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
        dateField.setText(formattedDate);
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JButton createButton;
    private JFormattedTextField idField;
    private JFormattedTextField dateField;
    private JComboBox statusField;
    private JFormattedTextField totalAmountField;
    private JFormattedTextField userIdField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
