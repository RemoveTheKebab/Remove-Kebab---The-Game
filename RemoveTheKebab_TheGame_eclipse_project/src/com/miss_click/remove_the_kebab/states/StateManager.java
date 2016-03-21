package com.miss_click.remove_the_kebab.states;

import java.awt.Graphics;

public class StateManager {

	private State currentState;
	
	public void setState(State state){
		currentState = state;
	}
	
	public void update(){
		if(currentState != null)
			currentState.update();
	}
	
	public void render(Graphics g){
		if(currentState != null)
			currentState.render(g);
	}
	
}
