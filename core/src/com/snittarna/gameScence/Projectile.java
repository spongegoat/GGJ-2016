package com.snittarna.gameScence;

import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Animation;
import com.snittarna.framework.GameObject;
import com.snittarna.framework.Killable;

public class Projectile extends GameObject {
	private int damage;
	
	private float angle;
	private float speed;
	
	private Killable owner;
	
	public Projectile(Vector2 position, float angle, float speed, int damage, Killable owner, Animation sprite) {
		super(position, sprite);
		
		this.damage = damage;
		this.angle = angle;
		this.speed = speed;
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		this.setPosition(getPosition().cpy().add(new Vector2(velocity().x * deltaTime, velocity().y * deltaTime)));
	}
	
	public void onHit() {
		this.onRemove();
	}
	
	private Vector2 velocity() {
		return new Vector2((float)Math.cos(angle) * speed, (float)Math.sin(angle) * speed);
	}
	
	public Killable getOwner() {
		return this.owner;
	}
	
	public int getDamage() {
		return this.damage;
	}
}
