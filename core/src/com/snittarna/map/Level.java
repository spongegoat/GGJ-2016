package com.snittarna.map;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Level {
	private ArrayList<Tile> tiles;
	
	public Level(ArrayList<Tile> tiles) {
		this.tiles = tiles;
		System.out.println(tiles.size() + " tiles in level");
	}
	
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	
	public void draw(SpriteBatch batch) {
		for (Tile t : tiles) t.draw(batch);
	}
}
