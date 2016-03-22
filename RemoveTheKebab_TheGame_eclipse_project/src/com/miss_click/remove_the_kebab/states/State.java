package com.miss_click.remove_the_kebab.states;

import java.awt.Graphics2D;

public abstract class State {
	public abstract void update();
	public abstract void render(Graphics2D g);
}
