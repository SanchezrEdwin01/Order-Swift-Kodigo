package com.example.orderswift.gui;
import java.awt.*;
import java.awt.event.*;

import com.example.orderswift.model.Order;

import com.example.orderswift.service.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SpringBootApplication
@Component
public class manager extends JFrame{
    private OrderService orderService;

    @Autowired
    public manager(OrderService orderService) {
        this.orderService = orderService;
        initComponents();
        completeOrders();
    }

    private void show(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    completeOrders();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void completeOrders(){
        DefaultTableModel model = new DefaultTableModel();
        String[] columnNames = {"ID", "Date", "Status", "Total Amount", "User ID"};

        model.setColumnIdentifiers(columnNames);
        elements = new JTable(model);

        for(Order order : orderService.getOrders()){
            Object[] row = {order.getOrderId(), order.getOrderDate(), order.getOrderStatus(), order.getTotalAmount(), order.getUser().getUserId()};
            model.addRow(row);
        }

        panel.setViewportView(elements);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        welcomeFrame = new JFrame();
        JLabel label1 = new JLabel();
        showButton = new JButton();
        panel = new JScrollPane();
        elements = new JTable();

        //======== welcomeFrame ========
        {
            welcomeFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Container welcomeFrameContentPane = welcomeFrame.getContentPane();

            //---- label1 ----
            label1.setText("Welcome");

            //---- showButton ----
            showButton.setText("Show");
            showButton.addActionListener(e -> show(e));

            //======== panel ========
            {

                //---- elements ----
                elements.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                panel.setViewportView(elements);
            }

            GroupLayout welcomeFrameContentPaneLayout = new GroupLayout(welcomeFrameContentPane);
            welcomeFrameContentPane.setLayout(welcomeFrameContentPaneLayout);
            welcomeFrameContentPaneLayout.setHorizontalGroup(
                welcomeFrameContentPaneLayout.createParallelGroup()
                    .addGroup(welcomeFrameContentPaneLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(291, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, welcomeFrameContentPaneLayout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(welcomeFrameContentPaneLayout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(showButton)
                        .addContainerGap(231, Short.MAX_VALUE))
            );
            welcomeFrameContentPaneLayout.setVerticalGroup(
                welcomeFrameContentPaneLayout.createParallelGroup()
                    .addGroup(welcomeFrameContentPaneLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(label1)
                        .addGap(18, 18, 18)
                        .addComponent(panel, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showButton)
                        .addGap(17, 17, 17))
            );
            welcomeFrame.pack();
            welcomeFrame.setLocationRelativeTo(welcomeFrame.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
//        welcomeFrame.setVisible(true);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JFrame welcomeFrame;
    private JButton showButton;
    private JScrollPane panel;
    private JTable elements;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
