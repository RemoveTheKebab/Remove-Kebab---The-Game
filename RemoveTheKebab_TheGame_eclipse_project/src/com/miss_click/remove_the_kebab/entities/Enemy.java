package com.miss_click.remove_the_kebab.entities;

import java.awt.Graphics;
import java.awt.Graphics2D;

public abstract class Enemy extends Entity{
	
	public void update() {
		updateEnemy();
	}

	public void render(Graphics2D g) {	
		renderEnemy(g);
	}

	public abstract void renderEnemy(Graphics2D g);
	public abstract void updateEnemy();
	
}
