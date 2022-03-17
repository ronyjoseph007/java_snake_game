/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.snakegame;

/**
 *
 * @author Administrator
 */
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {
    
    public Image apple_image;
    GameOver panel;
    JButton button = new JButton();
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
    static final int DELAY = 75;
    final int x[] = new int[GAME_UNITS];
    final int y[] = new int[GAME_UNITS];
    
    int bodyParts = 6;
    int applesEaten;
    int appleX;
    int appleY;
    
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    
    GamePanel() {
        random = new Random();
        panel = new GameOver();
        panel.setVisible(false);
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        this.add(panel);
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(new Color(97, 232, 212));
        this.setFocusable(true);
        this.addKeyListener(new myKeyAdapter());
        this.add(button);
        
        button.setFont(new Font("Aharoni", Font.BOLD, 30));
        button.setForeground(new Color(44, 195, 212));
        button.setBackground(new Color(97, 237, 207));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMargin(new Insets(10,2,7,30));
        button.setFocusable(false);
        button.setBorder(null);
        button.setText("Exit the game");
        button.setSize(50, 50);
        button.addActionListener((ActionListener) this);
        button.setVisible(false);
        startGame();
        
    }
    
    public final void startGame() {
        
        newApple();
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
        
    }
    
    @Override
    public void paintComponent(Graphics e) {
        super.paintComponent(e);
        draw(e);
        
    }
    
    public void draw(Graphics e) {

        // e.drawImage(apple_image, appleX, appleY, 25, 25, this);
        e.setColor(Color.red);
        e.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
        
        for (int i = 0; i < bodyParts; i++) {
            
            if (i == 0) {
                e.setColor(new Color(251, 255, 168));
                e.fillOval(x[i], y[i], UNIT_SIZE + 5, UNIT_SIZE + 5);
                
                e.setColor(Color.RED);
                e.fillOval(x[i] + 25, y[i] + 10, 30, 8);
            } else {
                e.setColor(new Color(251, 10, 168));
                e.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE - 5);
                
            }
            
        }
        
    }
    
    public void newApple() {
        appleX = random.nextInt((int) SCREEN_WIDTH / UNIT_SIZE) * UNIT_SIZE;
        appleY = random.nextInt((int) SCREEN_HEIGHT / UNIT_SIZE) * UNIT_SIZE;
        
    }
    
    public void move() {
        
        for (int i = bodyParts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
            
        }
        
        switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
            
        }
        
    }
    
    public void checkApple() {
        
        if (x[0] == appleX && y[0] == appleY) {
            bodyParts++;
            applesEaten++;
            newApple();
        }
        
    }
    
    public void checkCollision() {

        //head touhes body
        for (int i = bodyParts; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                running = false;
            }
        }

        //head touhes left border
        if (x[0] < 0) {
            running = false;
        }

        //head touches right border
        if (x[0] > SCREEN_WIDTH) {
            running = false;
        }

        //head touhes top border
        if (y[0] < 0) {
            running = false;
        }

        // head touhes bottom border
        if (y[0] > SCREEN_HEIGHT) {
            running = false;
            
        }
        
        if (!running) {
            
            timer.stop();
            panel.setVisible(true);
            button.setVisible(true);
            
        }
        
    }
    
    public void gameOver(Graphics e) {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand() != null) {
            
            panel.setVisible(false);
            button.setVisible(false);
          
            System.exit(0);
           
            
        } else {
            if (running) {
                
                move();
                checkApple();
                checkCollision();
            }
            
        }
        
        repaint();
        
    }
    
    public class myKeyAdapter extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    
                    break;
                
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
            }
            
        }
    }
    
}
