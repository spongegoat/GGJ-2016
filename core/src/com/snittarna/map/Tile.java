package com.snittarna.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Point;
import com.snittarna.framework.Rectangle;

public class Tile {
	
	final static int W = 1, H = 1;
	private Rectangle hitbox;
	
	private TileType type;
	private Vector2 position;
	private Point index;
	
	public Tile(Point index, Vector2 position, TileType type) {
		this.type = type;
		this.position = position;
		this.index = index;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(type.getTexture(), position.x, position.y, 1, 1);
	}

	public Rectangle getHitBox() {
		if (hitbox == null) {
			hitbox = new Rectangle(position, new Vector2(W, H));
		}
		return hitbox;
	}

	public Vector2 getPosition() {
		return position;
	}
}
