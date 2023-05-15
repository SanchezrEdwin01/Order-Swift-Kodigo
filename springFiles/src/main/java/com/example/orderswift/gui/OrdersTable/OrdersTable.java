package com.example.orderswift.gui.OrdersTable;

import com.example.orderswift.gui.OrdersTable.CreateOrder.CreateOrder;
import com.example.orderswift.model.Order;
import com.example.orderswift.service.order.OrderService;
import com.example.orderswift.service.order.OrderServiceImpl;
import com.example.orderswift.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.text.ParseException;

@SpringBootApplication
@Component
public class OrdersTable extends JFrame{
    private OrderServiceImpl orderService;
    private UserService userService;

    @Autowired
    public OrdersTable(OrderServiceImpl orderService, UserService userService) {
        this.orderService = orderService;
        initComponents();
        completeOrders();
    }

    private void refresh(ActionEvent e) {
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
        ordersTable = new JTable(model);

        for(Order order : orderService.getOrders()){
            // if order.getUser().getUserId() == user.getUserId() then add to table
            Object[] row = {order.getOrderId(), order.getOrderDate(), order.getOrderStatus(), order.getTotalAmount(), order.getUser().getUserId()};
            model.addRow(row);
        }

        panel.setViewportView(ordersTable);
    }

    private void delete(ActionEvent e) {
        orderService.deleteOrder(Integer.valueOf(ordersTable.getModel().getValueAt(ordersTable.getSelectedRow(), 0).toString()));
    }

    private void create(ActionEvent e) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateOrder createOrder = new CreateOrder(orderService, userService);
                    createOrder.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void search(ActionEvent e) {
        Order order = orderService.getOrderById(Integer.valueOf(searchField.getText()));
        if(order != null){
            DefaultTableModel model = new DefaultTableModel();
            String[] columnNames = {"ID", "Date", "Status", "Total Amount", "User ID"};

            model.setColumnIdentifiers(columnNames);
            ordersTable = new JTable(model);

            Object[] row = {order.getOrderId(), order.getOrderDate(), order.getOrderStatus(), order.getTotalAmount(), order.getUser().getUserId()};
            model.addRow(row);

            panel.setViewportView(ordersTable);
        }
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
        JLabel label1 = new JLabel();
        refreshButton = new JButton();
        panel = new JScrollPane();
        ordersTable = new JTable();
        createButton = new JButton();
        deleteButton = new JButton();
        updateButton = new JButton();
        searchButton = new JButton();
        searchField = new JFormattedTextField();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Orders Table");
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        //---- refreshButton ----
        refreshButton.setText("Refresh");
        refreshButton.addActionListener(e -> refresh(e));

        //======== panel ========
        {

            //---- ordersTable ----
            ordersTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            panel.setViewportView(ordersTable);
        }

        //---- createButton ----
        createButton.setText("Create Order");
        createButton.addActionListener(e -> create(e));

        //---- deleteButton ----
        deleteButton.setText("Delete Order");
        deleteButton.addActionListener(e -> delete(e));

        //---- updateButton ----
        updateButton.setText("Update Order");

        //---- searchButton ----
        searchButton.setText("Search Order");
        searchButton.addActionListener(e -> search(e));

        //---- searchField ----
        searchField.setText("Search Order by Id");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(274, 274, 274)
                            .addComponent(refreshButton))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(59, 59, 59)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(panel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addComponent(createButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(updateButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(searchButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))))))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(searchField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(createButton)
                        .addComponent(updateButton)
                        .addComponent(deleteButton))
                    .addGap(30, 30, 30)
                    .addComponent(refreshButton)
                    .addGap(18, 18, 18))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
//        welcomeFrame.setVisible(true);


    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton refreshButton;
    private JScrollPane panel;
    private JTable ordersTable;
    private JButton createButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton searchButton;
    private JFormattedTextField searchField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
