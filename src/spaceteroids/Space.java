/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceteroids;

import environment.Environment;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author kevinlawrence
 */
class Space extends Environment {

    Image ship;
    int angle = 0;
    
    public Space() {
        setBackground(ResourceTools.loadImageFromResource("spaceteroids/color_space_cloud.jpg"));
        ship = ResourceTools.loadImageFromResource("spaceteroids/ship.png");
    }

    @Override
    public void initializeEnvironment() {
    
    }

    @Override
    public void timerTaskHandler() {
    
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            angle = (++angle % 360);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            angle = (--angle % 360);
        }
        System.out.println("Angle " + angle);
    }
    

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (ship != null) {
            graphics.drawImage(ship, 400, 400, 100, 100, this);
        }
    }
    
}
