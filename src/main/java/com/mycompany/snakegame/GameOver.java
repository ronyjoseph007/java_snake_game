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

    static final int SCREEN_WIDTH_NEW = 800;
    static final int SCREEN_HEIGHT_NEW = 300;
    JLabel textfield = new JLabel();
   

    GameOver() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH_NEW, SCREEN_HEIGHT_NEW));
        this.setBackground(new Color(150, 240, 250));
        this.setFocusable(true);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(120, 120, 120, 120));

        textfield.setForeground(new Color(44, 195, 212));
        textfield.setFont(new Font("Aharoni", Font.BOLD, 50));
        textfield.setText("Game Over");
        textfield.setAlignmentX(Component.CENTER_ALIGNMENT);

       

        this.add(textfield);
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
       

    }

}
