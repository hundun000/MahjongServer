package com.hundun.mahjong;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

import org.mahjong4j.exceptions.Mahjong4jException;
import org.mahjong4j.hands.Kantsu;
import org.mahjong4j.tile.Tile;

/**
 * 王牌
 * @author hundun 2018年10月19日
 */
public class TileKing {
	public static final int TILE_KING_SIZE = 14;
	// 嶺上牌
	private Stack<Tile> tileHill = new Stack<>();
	private List<Tile> tiles = new ArrayList<>();
	public static final int TILE_HILL_SIZE = 4;
	
	private List<Tile> dora = new ArrayList<>();
	private List<Tile> uradora = new ArrayList<>();
	
	public TileKing(List<Tile> tiles) throws Mahjong4jException {
		if (tiles.size() != TILE_KING_SIZE) {
			throw new Mahjong4jException("王牌構造時大小錯誤");
		}
		this.tiles = tiles;
		tileHill.addAll(tiles.subList(0
				, TILE_HILL_SIZE - 1));
	}
	
	public boolean isKangFull() {
		return tileHill.isEmpty();
	}
	
	public Tile kanDraw() {
		return tileHill.pop();
	}
	
	public void newDoraAndUradora() {
		dora.add(getNextDoraOrUradora());
		uradora.add(getNextDoraOrUradora());
	}
	
	private Tile getNextDoraOrUradora() {
		int nextIndex = TILE_HILL_SIZE + dora.size() + uradora.size();
		return tiles.get(nextIndex);
	}
		
		
}
