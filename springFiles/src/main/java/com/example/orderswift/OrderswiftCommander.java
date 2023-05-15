package com.example.orderswift;

import com.example.orderswift.gui.LogIn.LogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * This CommandLineRunner fires off at runtime and boots up our GUI.
 */
@Component
public class OrderswiftCommander implements CommandLineRunner {
    private final LogIn login;

    @Autowired
    public OrderswiftCommander(LogIn login) {
        this.login = login;
    }


    @Override
    public void run(String... args) {
        //This boots up the GUI.
//        EventQueue.invokeLater(() -> menu.setVisible(true));
    }
}


