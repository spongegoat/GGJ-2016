package com.snittarna.gameScence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Animation;
import com.snittarna.framework.Killable;
import com.snittarna.pizza.AssetManager;

public class Player extends Killable {
	
	enum ShootDirection { 
		LEFT ((float)Math.PI), RIGHT (0), UP ((float)Math.PI/2);
		
		float value;
		
		ShootDirection(float value) {
			this.value = value;
		}
	}
	
	public float currentFireDelay;
	public float maxFireDelay;
	
	public ShootDirection shootDirection;
	
	public Player(Vector2 position) {
		super(position, new Animation(AssetManager.getTexture("projectile")));
		
		getSprite().setSize(2, 2);
		
		setHealth(3);  
		
		this.setType(Type.PLAYER);
		
		this.shootDirection = ShootDirection.LEFT; 
		
		maxFireDelay = 64;
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
		System.out.println("ayy");
		if(Gdx.input.isKeyJustPressed(Keys.SPACE) && currentFireDelay <= 0) {
			getScene().addObject(new Projectile(getPosition().cpy(), shootDirection.value, 8, 1, this.getType(), new Animation(AssetManager.getTexture("projectile"))));
			currentFireDelay += 10 * deltaTime;
		}
		
		if(currentFireDelay > 0) {
			currentFireDelay += 10 * deltaTime;
			if(currentFireDelay >= maxFireDelay) {
				currentFireDelay = 0;
			}
		}
	}
}
