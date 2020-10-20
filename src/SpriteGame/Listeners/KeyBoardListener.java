package SpriteGame.Listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BrokenBarrierException;

/**
 * use keyListener to switch up down left right (or w a s d )
 * key pressed(true) or released(false) boolean state
 */

public class KeyBoardListener implements KeyListener {
    boolean[] keys = new boolean[256];
    boolean up, down, left, right, exit, attack, inventoryOn;
    boolean lastInvetory;

    public KeyBoardListener() {
        lastInvetory = false;
    }

    public void whichKeyIsMoving() {
        // two keys might be moving symutaniously
        // the boolean status should be judged continuously, not just once
        up = keys[KeyEvent.VK_UP];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        exit = keys[KeyEvent.VK_E];
        attack = keys[KeyEvent.VK_A];
        inventoryOn = keys[KeyEvent.VK_ENTER];   // open and close inventory image
    }

    // todo: add listener to the game
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // this is to set keycode to true - get to the keycode
        keys[e.getKeyCode()] = true;
        if (e.getKeyCode() == KeyEvent.VK_ENTER ) {
            lastInvetory =!lastInvetory;
            System.out.println(lastInvetory + " lastInventory");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) return;
        else keys[e.getKeyCode()] = false;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean isAttack() {
        return attack;
    }

    public boolean isInventoryOn() {
        return inventoryOn;
    }

    public boolean isLastInvetory() {
        return lastInvetory;
    }
}
