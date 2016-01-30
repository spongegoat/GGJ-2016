package com.snittarna.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.snittarna.framework.Point;

public class Tile {
	
	TileType type;
	Vector2 position;
	Point index;
	
	public Tile(Point index, Vector2 position, TileType type) {
		this.type = type;
		this.position = position;
		this.index = index;
	}

	public void draw(SpriteBatch batch) {
		batch.draw(type.getTexture(), position.x, position.y, 1, 1);
	}
}
