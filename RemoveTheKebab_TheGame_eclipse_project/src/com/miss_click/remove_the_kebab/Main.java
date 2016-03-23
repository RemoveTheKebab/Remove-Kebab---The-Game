package com.miss_click.remove_the_kebab;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.miss_click.remove_the_kebab.graphics.FontsColors;
import com.miss_click.remove_the_kebab.states.MainMenu;
import com.miss_click.remove_the_kebab.states.StateManager;
import com.miss_click.remove_the_kebab.util.Input;
import com.miss_click.remove_the_kebab.util.SpriteManager;

public class Main implements Runnable{

	// AUTHORS
	public static final String JAN_ALES = "Jan Ale� Mlinar"; 						// this game was his idea
	public static final String ANDRAZ_CEPIC = "Andra� Cepi�, Main programmer";
	public static final String MATEVZ_VRES = "Matev� Vre�, Main designer";
	public static final String GASPER_BOZIC = "Ga�per Bo�i�, Lead artist";
	public static final String DAVID_BLENKUS = "David Blenku�, co-artist";
	
	// CONSTANTS
	public static final String TITLE = "Remove The Kebab - The Game";
	public static final String VERSION = "0.1";
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	// Graphics2D
	private JFrame frame;
	private Canvas canvas;
	
	// GAME LOOP
	private Thread mainThread;
	public boolean running = true;
	
	// MANAGERS
	public static StateManager stateManager;
	public static SpriteManager spriteManager;
	
	public Main(){
		// Graphics2D initial
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame = new JFrame(TITLE + "   - " + VERSION);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.add(canvas);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		// managers initial
		spriteManager = new SpriteManager();
		stateManager = new StateManager();
		Input input = new Input();
		canvas.addKeyListener(input);
		canvas.addMouseListener(input);
		canvas.addMouseMotionListener(input);
		
		mainThread = new Thread(this, "Main Thread");
		mainThread.start();
	}
	
	/**
	 * The game loop
	 */
	public void run(){
		init();
		
		int updatePerSec = 60;
	    long updateTimer = System.nanoTime();
	    int loops;
	    int maxFrameSkip = 10;
	    int skipTicks = 1000000000 / updatePerSec;
	    long timerSec = System.nanoTime();
	    int updates = 0;
	    int frames = 0;
	
	    while(running){
	        loops = 0;
	        while(System.nanoTime() > updateTimer && loops < maxFrameSkip){
	            updateTimer += skipTicks;
	            loops++;
	            update();
	            updates++;
	        }
	
	        render();
	        frames++;
	
	        if(System.nanoTime() - timerSec >= 1000000000){
	            timerSec = System.nanoTime();
	            System.out.println("FPS: " + frames + "\t" + "UPS: " + updates);
	            frames = 0;
	            updates = 0;
	        }
	    }
	}
	
	private void init(){
		loadTextures();
		
		canvas.requestFocus();
		stateManager.setState(new MainMenu());
	}
	
	private void update(){
		stateManager.update();
	}
	
	private void render(){
		BufferStrategy bs = canvas.getBufferStrategy();
		if(bs == null){
			canvas.createBufferStrategy(3);
			return;
		}
		
		Graphics2D g = (Graphics2D) bs.getDrawGraphics();
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON); // Text antialias
		
		// clearing the screen
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		stateManager.render(g);
		
		g.setFont(FontsColors.VERSION_FONT);
		g.setColor(Color.DARK_GRAY);
		g.drawString("version: " + VERSION, 1100, 700);
		
		g.dispose();
		bs.show();
	}
	
	private void loadTextures(){
		try {
			InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream("/textures/textures.list"));
			BufferedReader br = new BufferedReader(isr);
			String line = br.readLine();
			while(line != null){
				spriteManager.loadSpriteSheet(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public static void main(String[] args){
		new Main();
	}
	
}
