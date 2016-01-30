package com.snittarna.gameScence;

import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Animation;
import com.snittarna.framework.GameObject;

public class PowerUp extends GameObject {
	public enum Pattern { NORMAL, SPREAD };
	
	private Pattern pattern;
	
	private int damage;
	
	private float speed;
	
	private float maxFireDelay;
	
	public PowerUp(Vector2 position, Animation sprite) {
		super(position, sprite);
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
	}
	
	public Pattern getPattern() {
		return this.pattern;
	}
	
	public float getMaxFireDelay() {
		return this.maxFireDelay;
	}
	
	public float getSpeed() {
		return this.speed;
	}
	
	public int getDamage() {
		return this.damage;
	}
}
