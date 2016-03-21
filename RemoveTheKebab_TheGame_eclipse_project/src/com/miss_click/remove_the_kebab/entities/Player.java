package com.miss_click.remove_the_kebab.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.miss_click.remove_the_kebab.Main;
import com.miss_click.remove_the_kebab.util.Input;
import com.miss_click.remove_the_kebab.util.Vector2i;
import com.sun.glass.events.KeyEvent;

public class Player extends Entity{

	private BufferedImage img;
	
	public Player(){
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/textures/bird1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		size = new Vector2i(48, 48);
		pos = new Vector2i(200, Main.HEIGHT / 2 - size.y / 2);
		fireRate = 1000000000 / 5;
		speed = 5;
	}
	
	private void move(){
		if(Input.keyDown(KeyEvent.VK_UP)){
			pos.y -= speed;
		}else if(Input.keyDown(KeyEvent.VK_DOWN)){
			pos.y += speed;
		}
	}
	
	private void shoot(){
		if(System.nanoTime() - attackTimer >= fireRate){
			attackTimer = System.nanoTime();
			if(Input.keyDown(KeyEvent.VK_SPACE))
				projectiles.add(new Projectile());
		}
	}
	
	public void update() {
		updateProjectiles();
		move();
		shoot();
	}
	
	public void render(Graphics g) {
		renderProjectiles(g);
		g.drawImage(img, pos.x, pos.y, null);
	}

}
