package com.snittarna.gameScence;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Animation;
import com.snittarna.framework.Killable;
import com.snittarna.framework.Scene;
import com.snittarna.map.Map;
import com.snittarna.pizza.AssetManager;

public class GameScene extends Scene {
	public GameScene() {
		super();
		Map.load();
		
		addObject(new Projectile(new Vector2(0, 0), (float)Math.PI/2, (float)Math.PI/2, 1, new Killable(new Vector2(0, 0), new Animation(AssetManager.getTexture("projectile"))), new Animation(AssetManager.getTexture("projectile"))));
	}
	
	public void update(float deltaTime) {
		super.update(deltaTime);
	}
	
	public void draw(SpriteBatch batch) {
		Map.draw(batch);
	}
}
