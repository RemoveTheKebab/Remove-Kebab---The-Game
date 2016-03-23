package com.miss_click.remove_the_kebab.entities.bosses;

import java.awt.Graphics2D;

import com.miss_click.remove_the_kebab.Main;
import com.miss_click.remove_the_kebab.entities.Enemy;
import com.miss_click.remove_the_kebab.entities.Entity;
import com.miss_click.remove_the_kebab.entities.EntityType;
import com.miss_click.remove_the_kebab.states.Game;
import com.miss_click.remove_the_kebab.util.Vector2f;
import com.miss_click.remove_the_kebab.util.Vector2i;

public class TestBoss extends Enemy{

	public TestBoss(){
		super();
		type = EntityType.BOSS;
		
		// graphics
		sprite = Main.spriteManager.getSprite("isis");
		
		// properties
		size = new Vector2i(sprite.size.x, sprite.size.y);
		pos = new Vector2f(Main.WIDTH, Main.HEIGHT / 2 - size.y / 2);
		fireRate = 1000000000 / 5;
		speed = - 0.5f;
		life = 2000;
		damage = 100;
		projectileDir = PR_LEFT;
		
		initEnemy();
	}
	
	public void renderEnemy(Graphics2D g) {
		sprite.render(g, (int)pos.x, (int)pos.y);
		renderHealthBar(g);
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
