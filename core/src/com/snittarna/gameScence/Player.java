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
	
	private float currentFireDelay;
	private float maxFireDelay;
	
	private ShootDirection shootDirection;
	
	private PowerUp.Pattern currentShootPattern;
	
	private Projectile projectilePrototype;
	
	public Player(Vector2 position) {
		super(position, new Animation(AssetManager.getTexture("projectile")));
		
		getSprite().setSize(1, 1);
		
		setHealth(3);  
		
		this.setType(Type.PLAYER);
		
		this.shootDirection = ShootDirection.LEFT; 
		
		this.projectilePrototype = new Projectile(new Vector2(0, 0), 0, 8, 1, Killable.Type.PLAYER, new Animation(AssetManager.getTexture("projectile")));
		
		maxFireDelay = 8;
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
		
		updateInput(deltaTime);
		
		if(currentFireDelay > 0) {
			currentFireDelay += 10 * deltaTime;
			if(currentFireDelay >= maxFireDelay) {
				currentFireDelay = 0;
			}
		}
	}
	
	public void updateInput(float deltaTime) {
		if(Gdx.input.isKeyJustPressed(Keys.SPACE) && currentFireDelay <= 0) {
			getScene().addObject(new Projectile(getPosition().cpy(), shootDirection.value, projectilePrototype.getSpeed(), projectilePrototype.getDamage(), this.getType(), new Animation(AssetManager.getTexture("projectile"))));
			currentFireDelay += 10 * deltaTime;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			this.shootDirection = ShootDirection.LEFT;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			this.shootDirection = ShootDirection.RIGHT;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.UP)) {
			this.shootDirection = ShootDirection.UP;
		}
	}
	
	public void onPowerUp(PowerUp p) {
		this.currentShootPattern = p.getPattern();
		this.maxFireDelay = p.getMaxFireDelay();
		this.projectilePrototype = new Projectile(new Vector2(0, 0), 0, p.getSpeed(), p.getDamage(), Killable.Type.PLAYER, new Animation(AssetManager.getTexture("projectile")));
	}
}
