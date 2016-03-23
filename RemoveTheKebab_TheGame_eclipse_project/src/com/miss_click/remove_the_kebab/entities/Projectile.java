package com.miss_click.remove_the_kebab.entities;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.miss_click.remove_the_kebab.Main;
import com.miss_click.remove_the_kebab.graphics.Sprite;
import com.miss_click.remove_the_kebab.states.Game;
import com.miss_click.remove_the_kebab.util.Vector2i;

public class Projectile {

	private Sprite sprite;
	private int speed;
	private Vector2i pos;
	private int damage;
	
	public boolean dead = false;
	
	private int ownerID;
	
	public Projectile(int damage, int x, int y, boolean dir, int ownerID){
		sprite = Main.spriteManager.getSprite("bullet");
		pos = new Vector2i(x, y);
		this.damage = damage;
		this.ownerID = ownerID;
		
		if(dir){
			speed = 10;
		}else{
			sprite.flipX();
			speed = -10;
		}
	}
	
	public void render(Graphics2D g){
		sprite.render(g, pos);
	}
	
	public void update(){
		if(!dead){
			// move
			pos.x += speed;
			
			// check  if out of bounds
			if(pos.x >= Main.WIDTH || pos.x <= -sprite.size.x || pos.y >= Main.HEIGHT || pos.y <= -sprite.size.y)
				dead = true;
			
			// checking if hit anyone
			ArrayList<Entity> entities = Game.entityManager.getEntities();
			for(int i=0; i < entities.size(); i++){
				if(i == ownerID) continue;
				
				Entity e = entities.get(i);
				if(pos.x + sprite.size.x >= e.getPos().x && pos.x <= e.getPos().x + e.getSize().x){
					if(pos.y + sprite.size.y >= e.getPos().y && pos.y <= e.getPos().y + e.getSize().y){
						e.hit(damage);
						dead = true;
						break;
					}
				}
			}
		}
	}
	
}
