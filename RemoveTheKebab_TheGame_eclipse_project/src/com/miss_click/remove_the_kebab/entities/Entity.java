package com.miss_click.remove_the_kebab.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import com.miss_click.remove_the_kebab.util.Vector2i;

public abstract class Entity {

	protected int id;
	protected boolean dead = false;
	protected Vector2i pos;
	protected int speed;
	protected Vector2i size;
	
	protected long fireRate;
	protected long attackTimer = System.nanoTime();
	protected ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	
	public void setID(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
	public boolean isDead(){
		return dead;
	}
	
	protected void updateProjectiles(){
		for(int i=0; i < projectiles.size(); i++){
			projectiles.get(i).update();
		}
	}
	
	protected void renderProjectiles(Graphics g){
		for(int i=0; i < projectiles.size(); i++){
			projectiles.get(i).render(g);
		}
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
