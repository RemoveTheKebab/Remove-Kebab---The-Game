package com.miss_click.remove_the_kebab.util;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.miss_click.remove_the_kebab.graphics.Sprite;

public class SpriteManager {

	private HashMap<String, Sprite> sprites;
	
	public SpriteManager(){
		sprites = new HashMap<String, Sprite>();
	}
	
	public void loadSpriteSheet(String path){
		try{
			// reading the sprite sheet image
			BufferedImage sheetImage = ImageIO.read(getClass().getResourceAsStream("/textures" + "/" + path + "/" + path + ".png"));		// only supports .png file format
			
			// reading the sprite sheet data from .tex file with BufferedReader
			InputStreamReader isr = new InputStreamReader(getClass().getResourceAsStream("/textures" + "/" + path + "/" + path + ".tex"));
			BufferedReader br = new BufferedReader(isr);
			
			// reading each line for each sprite and loading the sprite
			String line;
			while((line = br.readLine()) != null){
				String[] lineArray = line.split(",");
				int x = Integer.valueOf(lineArray[1]);
				int y = Integer.valueOf(lineArray[2]);
				int w = Integer.valueOf(lineArray[3]);
				int h = Integer.valueOf(lineArray[4]);
				
				// extracting the sprite image from the sprite sheet image
				BufferedImage spriteImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
				for(int yi=0; yi < h; yi++){
					for(int xi=0; xi < w; xi++){
						spriteImage.setRGB(xi, yi, sheetImage.getRGB(xi + x, yi + y));
					}
				}
				
				sprites.put(lineArray[0], new Sprite(spriteImage));
			}
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public Sprite getSprite(String key){
		return sprites.get(key);
	}
	
	public void clear(){
		sprites.clear();
	}
}
  