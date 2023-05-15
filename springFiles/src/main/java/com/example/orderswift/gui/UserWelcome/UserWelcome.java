/*
 * Created by JFormDesigner on Mon May 15 01:00:35 ART 2023
 */

package com.example.orderswift.gui.UserWelcome;

import com.example.orderswift.model.User;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Lucas M
 */
public class UserWelcome extends JFrame {
    private User user;
    public UserWelcome(User user) {
        this.user = user;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        welcomeText = new JTextPane();
        textArea2 = new JTextPane();
        button1 = new JButton();
        button4 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            //---- welcomeText ----
            welcomeText.setText("Welcome User");
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

            //---- button1 ----
            button1.setText("New order");

            //---- button4 ----
            button4.setText("Search companies");

            //---- button2 ----
            button2.setText("Show orders");

            //---- button3 ----
            button3.setText("Search products");

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
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button4, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(button1, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(button2, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(button3, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addContainerGap())
            );
            dialogPaneLayout.setVerticalGroup(
                dialogPaneLayout.createParallelGroup()
                    .addGroup(dialogPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(welcomeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textArea2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button1)
                            .addComponent(button2))
                        .addGap(18, 18, 18)
                        .addGroup(dialogPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button4)
                            .addComponent(button3))
                        .addContainerGap(30, Short.MAX_VALUE))
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
    private JButton button1;
    private JButton button4;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
