package com.miss_click.remove_the_kebab.entities;

import java.awt.Graphics2D;

import com.miss_click.remove_the_kebab.Main;
import com.miss_click.remove_the_kebab.graphics.FontsColors;
import com.miss_click.remove_the_kebab.states.Game;
import com.miss_click.remove_the_kebab.util.Vector2i;

public abstract class Enemy extends Entity{
	
	protected Vector2i healthBar;
	private float halthBarDiff;
	
	protected void initEnemy(){
		pos.x = Main.WIDTH + (int)(Math.random() * 100);
		pos.y = (int)(Math.random() * (Main.HEIGHT - size.y));
		
		healthBar = new Vector2i(150, 15);
		halthBarDiff = 150.0f / life;
	}
	
	public void update() {
		checkLife();
		
		// health bar
		healthBar.x = (int)(halthBarDiff*life);
		
		// movement
		if(pos.x > Game.BORDER_X)
			pos.x += speed;
		else 
			pos.x = Game.BORDER_X;
		
		updateEnemy();
	}

	public void render(Graphics2D g) {	
		renderEnemy(g);
	}
	
	protected void renderHealthBar(Graphics2D g){
		g.setColor(FontsColors.BOSS_HEALTH_BAR);
		g.fillRoundRect((int)((pos.x + size.x / 2) - healthBar.x / 2), (int)(pos.y - healthBar.y - 8), healthBar.x, healthBar.y, 3, 3);
	}
	
	public abstract void renderEnemy(Graphics2D g);
	public abstract void updateEnemy();
	
}
