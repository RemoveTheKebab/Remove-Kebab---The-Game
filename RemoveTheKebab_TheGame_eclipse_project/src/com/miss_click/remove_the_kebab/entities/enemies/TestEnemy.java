package com.miss_click.remove_the_kebab.entities.enemies;

import java.awt.Graphics2D;

import com.miss_click.remove_the_kebab.Main;
import com.miss_click.remove_the_kebab.entities.Enemy;
import com.miss_click.remove_the_kebab.entities.Entity;
import com.miss_click.remove_the_kebab.entities.EntityType;
import com.miss_click.remove_the_kebab.states.Game;
import com.miss_click.remove_the_kebab.util.Vector2i;

public class TestEnemy extends Enemy{

	public TestEnemy(){
		type = EntityType.ENEMY;
		
		// graphics
		sprite = Main.spriteManager.getSprite("bird");
		
		// properties
		size = new Vector2i(sprite.size.x, sprite.size.y);
		pos = new Vector2i(0,0);
		fireRate = 1000000000 / 5;
		speed = -1;
		life = 100;
		damage = 100;
		projectileDir = PR_LEFT;
		
		initEnemy();
	}
	
	public void renderEnemy(Graphics2D g) {
		sprite.render(g, pos);
	}

	public void updateEnemy() {
		
	}

	public void die() {
		Entity player = Game.entityManager.getFirtsByType(EntityType.PLAYER);
		player.kill(type);
	}

	public void kill(EntityType type) {
		
	}

}
