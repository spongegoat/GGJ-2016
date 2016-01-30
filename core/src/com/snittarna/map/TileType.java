package com.snittarna.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.snittarna.framework.ResourceReader;
import com.snittarna.pizza.AssetManager;

public class TileType {
	
	private TextureRegion texture;
	private Color dataColor;
	
	public TileType(ResourceReader r) {
		this.texture = AssetManager.getTexture(r.getString("texture"));
		this.dataColor = new Color(r.getInt("dataColor"));
	}
	
	public TextureRegion getTexture() {
		return texture;
	}
	
	public Color getDataColor() {
		return dataColor;
	}
	
	
	
	
	private static TileType[] types;
	
	public static TileType[] getAll() {
		if (types == null) {
			ResourceReader[] readers = ResourceReader.readObjectList(Gdx.files.internal("tileTypes.gd"));
			types = new TileType[readers.length];
			int i = 0;
			for (ResourceReader r : readers) {
				types[i++] = new TileType(r);
			}
		}
		
		return types;
	}
}
