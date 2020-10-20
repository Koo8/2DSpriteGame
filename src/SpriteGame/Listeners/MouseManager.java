package SpriteGame.Listeners;

import SpriteGame.UI_Menu.StartButton;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseManager extends MouseAdapter {
    private boolean leftPressed, rightPressed;
    private int mouseX, mouseY;
    public boolean isHovering;
    public Rectangle bounds;

    public MouseManager() {
        super();
        leftPressed = false;
        rightPressed = false;
        isHovering = false;
        bounds = StartButton.bounds;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getButton()==MouseEvent.BUTTON1) {

            leftPressed = true;
        }
        if (e.getButton() == MouseEvent.BUTTON3){
            rightPressed = true;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton()==MouseEvent.BUTTON1) {

            leftPressed = false;
        }
        if (e.getButton() == MouseEvent.BUTTON3){
            rightPressed = false;
        }
    }



    public void checkMouseOverButton() {
       // System.out.println("is check mouse over button method");
        if (bounds.contains(mouseX, mouseY)) {
            isHovering = true;
           //  System.out.println("is hovering over button");

        } else {
            // System.out.println("is NOT hovering over button");
            isHovering = false;
        }
    }

    public boolean isLeftPressed() {

        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }
}
