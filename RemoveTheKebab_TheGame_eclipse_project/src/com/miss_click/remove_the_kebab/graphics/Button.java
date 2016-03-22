package com.miss_click.remove_the_kebab.graphics;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import com.miss_click.remove_the_kebab.util.ButtonEvent;
import com.miss_click.remove_the_kebab.util.Input;
import com.miss_click.remove_the_kebab.util.Vector2i;

public class Button {

	private Vector2i pos;
	private Sprite buttonSprite_n;
	private Sprite buttonSprite_h;
	private ButtonEvent be;
	
	public Button(int x, int y, Sprite normalSprite, Sprite hoveredSprite, ButtonEvent be){
		buttonSprite_n = normalSprite;
		buttonSprite_h = hoveredSprite;
		pos = new Vector2i(x, y);
		this.be = be;
	}
	
	public void update(){
		if(isClicked()){
			be.clicked();
		}
	}
	
	public boolean isClicked(){
		return Input.isMouseButtonPressed(MouseEvent.BUTTON1) && isHovered();
	}
	
	public boolean isHovered(){
		return (Input.mouseX >= pos.x && Input.mouseX <= pos.x + buttonSprite_n.size.x) &&
				(Input.mouseY >= pos.y && Input.mouseY <= pos.y + buttonSprite_n.size.y);
	}
		
	public void render(Graphics2D g){
		if(isHovered())
			buttonSprite_h.render(g, pos);
		else
			buttonSprite_n.render(g, pos);
	}
	
}
