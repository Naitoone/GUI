package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AboutWindow extends JDialog {

    private JButton button;
    Icon logo;

    public AboutWindow() {

        this.setTitle("Informacja o Autorze");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());

        button = new JButton("OK");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AboutWindow.this.dispose();
            }
        });

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                setVisible(false);
            }
        });

        this.add(button);
        this.setVisible(true);



    }


}
