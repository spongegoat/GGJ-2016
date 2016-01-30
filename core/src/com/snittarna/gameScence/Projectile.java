package com.snittarna.gameScence;

import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Animation;
import com.snittarna.framework.GameObject;

public class Projectile extends GameObject {
	private int damage;
	
	private float angle;
	private float speeed;
	
	public boolean explosive;
	public boolean enemy;
	
	public Projectile(Vector2 position, Animation sprite) {
		super(position, sprite);
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
	}
	
	public int getDamage() {
		return this.damage;
	}
}
