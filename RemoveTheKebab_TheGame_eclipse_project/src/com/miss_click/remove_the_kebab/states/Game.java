package com.miss_click.remove_the_kebab.states;

import java.awt.Graphics;

import com.miss_click.remove_the_kebab.entities.Player;
import com.miss_click.remove_the_kebab.util.EntityManager;

public class Game extends State{

	private EntityManager entityManager;
	
	public Game(){
		entityManager = new EntityManager();
		entityManager.addEntity(new Player());
	}
	
	public void update(){
		entityManager.update();
	}
	
	public void render(Graphics g){
		entityManager.render(g);
	}
	
}
