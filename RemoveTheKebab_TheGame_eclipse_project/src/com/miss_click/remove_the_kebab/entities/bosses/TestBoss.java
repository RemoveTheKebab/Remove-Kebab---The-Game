package com.miss_click.remove_the_kebab.entities.bosses;

import java.awt.Graphics2D;

import com.miss_click.remove_the_kebab.entities.Enemy;
import com.miss_click.remove_the_kebab.entities.Entity;
import com.miss_click.remove_the_kebab.entities.EntityType;
import com.miss_click.remove_the_kebab.states.Game;

public class TestBoss extends Enemy{

	public TestBoss(){
		type = EntityType.BOSS;
	}
	
	public void renderEnemy(Graphics2D g) {
		
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
