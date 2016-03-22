package com.miss_click.remove_the_kebab.util;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseMotionListener, MouseListener{
	
	public static int mouseX = 0, mouseY = 0;
	private static boolean[] buttons = new boolean[256];
	private static boolean mousePressed = false;
	
	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
	}

	public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
		mousePressed = false;
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	public static boolean isMouseButtonPressed(int button){
        boolean result =  buttons[button] && !mousePressed;

        if(result)
         mousePressed = true;

        return result;
    }
	
	
	private static boolean[] keys = new boolean[512];
	private static boolean[] keysP = new boolean[512];
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		keysP[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public static boolean keyDown(int key){
		return keys[key];
	}
	
	public static boolean keyPressed(int key){
		boolean result = keys[key] && !keysP[key];
		
		if(result)
			keysP[key] = true;
		
		return result;
	}
	
}
