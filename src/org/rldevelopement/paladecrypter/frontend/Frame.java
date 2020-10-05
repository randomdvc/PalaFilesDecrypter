package org.rldevelopement.paladecrypter.frontend;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {

        setTitle("Paladium Decrypter");
        setSize(1280, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setContentPane(new Pane());

        setVisible(true);

    }



}
