/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snakegame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Administrator
 */
public class GameOver extends JPanel implements ActionListener {

    static final int SCREEN_WIDTH = 300;
    static final int SCREEN_HEIGHT = 300;
    JLabel textfield = new JLabel();
    JButton button = new JButton();
    

    GameOver() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(150, 240, 250));
        this.setFocusable(true);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(120, 120, 120, 120));
       

        textfield.setForeground(new Color(44, 195, 212));
        textfield.setFont(new Font("Aharoni", Font.BOLD, 50));
        textfield.setText("Game Over");
        textfield.setAlignmentX(Component.CENTER_ALIGNMENT);

        button.setFont(new Font("Aharoni", Font.BOLD, 30));
        button.setForeground(new Color(44, 195, 212));
        button.setBackground(new Color(97, 237, 207));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFocusable(false);
        button.setBorder(null);
        button.setText("Play Again");
        button.setSize(50, 50);
        button.addActionListener((ActionListener)this);

        this.add(textfield);
        this.add(button);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
       
        
        new GameFrame();
        
        
    }
    
    

}
