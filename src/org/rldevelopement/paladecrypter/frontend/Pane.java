package org.rldevelopement.paladecrypter.frontend;

import org.rldevelopement.paladecrypter.Decrypter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Pane extends JPanel {

    JLabel d = new JLabel("D3crYpT");

    public JTextField input = new JTextField();
    private static JTextField output = new JTextField();

    JLabel i = new JLabel("INPUT");
    JLabel o = new JLabel("OUTPUT");

    private Button loginButton = new Button("Decrypt");

    public Pane() {
        setLayout(null);
        setBackground(new Color(44, 47, 51));


        d.setBounds(560, 100, 300, 50);
        d.setFont(d.getFont().deriveFont(34f));
        d.setBorder(null);
        d.setOpaque(false);
        d.setBackground(null);
        d.setForeground(Color.white);
        add(d);

        i.setBounds(435, 235, 400, 12);
        i.setBackground(null);
        i.setOpaque(false);
        i.setForeground(Color.white);
        add(i);
        input.setFont(input.getFont().deriveFont(15F));
        input.setForeground(Color.WHITE);
        input.setCaretColor(Color.white);
        input.setOpaque(false);
        input.setBounds(432,250, 400, 40);
        input.setOpaque(false);
        input.setColumns(10);
        add(input);

        o.setBounds(435, 325, 400, 10);
        o.setBackground(null);
        o.setOpaque(false);
        //password.setFont(LauncherFrame.DefaultFont);
        o.setForeground(Color.white);
        add(o);
        output.setFont(output.getFont().deriveFont(15F));
        output.setForeground(Color.WHITE);
        output.setOpaque(false);
        output.setBounds(432, 340, 400, 40);
        output.setCaretColor(Color.white);
        add(output);

        loginButton.setBounds(410, 450, 450, 50);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (input.getText() != null && output.getText() != null) {
                    String inputfilename = String.valueOf(System.getProperty("user.dir").replace("\\", "\\\\")) + "\\\\" + input.getText();
                    File filetodecrypt = new File(inputfilename);
                    if(!filetodecrypt.exists()) {
                        System.out.println("File not found !");
                        return;
                    }
                    FileOutputStream outputfile = null;
                    try {
                        outputfile = new FileOutputStream(String.valueOf(System.getProperty("user.dir").replace("\\", "\\\\")) + "\\\\" + output.getText());
                        try {
                            outputfile.write(Decrypter.decrypt(filetodecrypt));
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                        outputfile.close();
                    } catch (IOException fileNotFoundException) {
                        fileNotFoundException.printStackTrace();
                    }
                }
            }
        });
        add(loginButton);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(39, 42, 46));
        g.fillRoundRect(((getWidth() / 2) - (500 / 2)), (getHeight() / 2) - (580 / 2), 500, 580, 10, 10);

        g.setColor(new Color(90, 94, 107));
        g.fillRoundRect(((getWidth() / 2) - (500 / 2)) + 20, ((getHeight() / 2) - (580 / 2)) + 120, 460, 2, 2, 2);

        g.setColor(new Color(94,97,101, 50));
        g.fillRoundRect((getWidth() / 2) - (500 / 2) + 50, (getHeight() / 2) - (580 / 2) + 200, 400, 40, 5, 5);
        g.fillRoundRect((getWidth() / 2) - (500 / 2) + 50, (getHeight() / 2) - (580 / 2) + 290, 400, 40, 5, 5);
    }
}
