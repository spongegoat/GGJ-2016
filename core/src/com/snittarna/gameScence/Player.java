package com.snittarna.gameScence;

import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Animation;
import com.snittarna.framework.Killable;
import com.snittarna.pizza.AssetManager;

public class Player extends Killable {
	public float currentFireDelay;
	public float maxFireDelay;
	
	public Player(Vector2 position) {
		super(position, new Animation(AssetManager.getTexture("error")));
		
		this.setType(Type.PLAYER);
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
	}
}
