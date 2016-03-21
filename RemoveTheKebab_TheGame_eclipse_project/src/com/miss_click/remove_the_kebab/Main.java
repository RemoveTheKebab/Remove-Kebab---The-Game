package com.miss_click.remove_the_kebab;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Main {

	public static final String TITLE = "Remove The Kebab - The Game";
	public static final byte VERSION = 0x01;
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	private JFrame frame;
	private Canvas canvas;
	
	private Thread mainThread;
	
	public Main(){
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		canvas.requestFocus();
		
		frame = new JFrame(TITLE + "  v."+ VERSION);
		frame.setResizable(false);
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		mainThread = new Thread();
	}
	
	
	
	public static void main(String[] args){
		new Main();
	}
	
}
