package com.miss_click.remove_the_kebab.util;

import java.awt.Graphics;
import java.util.ArrayList;

import com.miss_click.remove_the_kebab.entities.Entity;

public class EntityManager {

	private ArrayList<Entity> entities;
	private int count = 0;
	
	public EntityManager(){
		entities = new ArrayList<Entity>();
	}
	
	public void addEntity(Entity entity){
		entities.add(entity);
		entity.setID(count);
		count++;
	}
	
	public void update(){
		for(int i=0; i < entities.size(); i++){
			Entity entity = entities.get(i);
			entity.update();
			
			if(entity.isDead()){
				entities.remove(i);
				for(int j=i; j < entities.size(); j++){
					entities.get(j).setID(entities.get(j).getID() -1);
				}
			}
		}
	}
	
	public void render(Graphics g){
		for(int i=0; i < entities.size(); i++){
			entities.get(i).render(g);
		}
	}
	
}
