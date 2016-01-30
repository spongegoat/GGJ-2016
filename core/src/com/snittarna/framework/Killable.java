package com.snittarna.framework;

import com.badlogic.gdx.math.Vector2;
import com.snittarna.gameScence.Projectile;

public class Killable extends GameObject {
	public enum Type { PLAYER, ENEMY };
	
	private int health;
	
	private Type type;
	
	public Killable(Vector2 position, Animation sprite) {
		super(position, sprite);
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		for(GameObject g : getScene().getObjects()) {
			if(g instanceof Projectile) {
				if(g.getHitbox().collision(getHitbox()) && ((Projectile)g).getOwner() != type) {
					System.out.println(((Projectile) g).getOwner() + " - " + type);
					onHit((Projectile) g);
					((Projectile) g).onHit();
				}
			}
		}
		
		if(health <= 0) { 
			onDeath();
		}
	}
	
	public void onDeath() {
		getScene().removeObject(this);
	}
	
	public void onHit(Projectile p) {
		health -= p.getDamage();
	}
	
	public Type getType() {
		return this.type;
	}
	
	public void setType(Type type) {
		this.type = type;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
}
