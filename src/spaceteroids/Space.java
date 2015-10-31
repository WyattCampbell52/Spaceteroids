/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spaceteroids;

import environment.Environment;
import images.ResourceTools;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

/**
 *
 * @author kevinlawrence
 */
class Space extends Environment {

    Image ship;
    int angle = 0;
    int shipX = 400;
    int shipY = 300;
    
    private double getAngleInRadians(){
        return Math.toRadians(angle);
    }
    
    public Space() {
        setBackground(ResourceTools.loadImageFromResource("spaceteroids/color_space_cloud.jpg"));
        ship = ResourceTools.loadImageFromResource("spaceteroids/ship.png").getScaledInstance(100, 200, Image.SCALE_SMOOTH);
    }

    @Override
    public void initializeEnvironment() {
    
    }

    @Override
    public void timerTaskHandler() {
    
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            angle = (++angle % 360);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            angle = (--angle % 360);
        }
//        System.out.println("Angle " + angle);
    }
    

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    
    }

    @Override
    public void paintEnvironment(Graphics graphics) {

        Graphics2D g2d = (Graphics2D) graphics;
        AffineTransform olde = g2d.getTransform();
        
        if (ship != null) {
            AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(angle));
            at.setToRotation(getAngleInRadians(), shipX + (ship.getWidth(this)/ 2), shipY + (ship.getHeight(this) / 2));
            g2d.setTransform(at);
            g2d.drawImage(ship, shipX, shipY, this);
        }
        
        g2d.setTransform(olde);
        g2d.dispose();
    }
    
}
