package com.snittarna.map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.snittarna.framework.ResourceReader;
import com.snittarna.pizza.AssetManager;

public class TileType {
	
	private TextureRegion texture;
	
	public TileType(ResourceReader r) {
		this.texture = AssetManager.getTexture("");
	}
}
