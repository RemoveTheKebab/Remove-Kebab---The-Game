package com.miss_click.remove_the_kebab.graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.miss_click.remove_the_kebab.util.Vector2i;

public class Sprite {

	private BufferedImage img;
	public Vector2i size;
	
	public Sprite(BufferedImage img){
		this.img = img;
		size = new Vector2i(img.getWidth(), img.getHeight());
	}
	
	public void render(Graphics g, Vector2i pos){
		g.drawImage(img, pos.x, pos.y, null);
	}
	
	public void render(Graphics2D g, int x, int y){
		g.drawImage(img, x, y, null);
	}
	
	public void flipX(){
		
	}
	
	public void flipY(){
		
	}
	
}
