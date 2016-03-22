package com.miss_click.remove_the_kebab.entities;

import com.miss_click.remove_the_kebab.entities.bosses.TestBoss;
import com.miss_click.remove_the_kebab.entities.enemies.TestEnemy;
import com.miss_click.remove_the_kebab.states.Game;

public class EnemySpawner {

	public static final int ENEMY_COUNT = 1;
	public static final int BOSS_COUNT = 1;
	public static final long MIN_BOSS_PERIOID = 2500000000L; 	// 2.5 seconds
	public static final long MIN_SPAW_PERIOD = 250000000L; 		// 1/4 second
	public static final long MAX_SPAW_PERIOD = 3000000000L; 	// 3 seconds
	public static final int START_SCORE_REQ = 2000;
	public static int ADD_SCORE_REQ = 4000;
	
	private long spawnTimer = System.nanoTime();
	private long spawnPeriod = MAX_SPAW_PERIOD;
	
	// bosses
	private boolean bossTime = false;
	private boolean bossSpawned = false;
	private int bossLevel = 1;
	private int bossSpawnCounter = 0;
	private int bossCounter = 0;
	private int requiredScore = START_SCORE_REQ;
	private long bossTimer = System.nanoTime();
	
	public void spawnEnemy(){
		// checking if boss time
		if(Game.getScore() > requiredScore){
			requiredScore +=  ADD_SCORE_REQ; 
			ADD_SCORE_REQ += 2000 * bossLevel;
			bossTime = true;
			
			if(bossSpawnCounter >= bossLevel){
				bossLevel++;
				bossSpawnCounter = 0;
			}
		}
		
		if(bossTime){
			if(!bossSpawned){
				if(System.nanoTime() - bossTimer >= MIN_BOSS_PERIOID){
					bossTimer = System.nanoTime();
					
					spawnRandomBoss();
					
					bossCounter++;
					if(bossCounter > bossLevel){
						bossSpawned = true;
						bossSpawnCounter++;
					}
				}
			}else{
				if(bossCounter == 0)
					bossTime = false;
			}
		}else{
			if(spawnPeriod > MIN_SPAW_PERIOD)
				spawnPeriod -= 200;
			else
				spawnPeriod = MIN_SPAW_PERIOD;
			
			if(System.nanoTime() - spawnTimer >= spawnPeriod){
				spawnTimer = System.nanoTime();
				spawnRandomEnemy();
			}
		}
	}
	
	private void spawnRandomBoss(){
		Enemy enemy = null;
		int randomGen = (int)(Math.random() * BOSS_COUNT - 1);
		switch(randomGen){
		case 0:
			enemy = new TestBoss();
			break;
		}
		
		Game.entityManager.addEntity(enemy);
	}
	
	private void spawnRandomEnemy(){
		Enemy enemy = null;
		int randomGen = (int)(Math.random() * ENEMY_COUNT - 1);
		switch(randomGen){
		case 0:
			enemy = new TestEnemy();
			break;
		}
		Game.entityManager.addEntity(enemy);
	}
	
}
