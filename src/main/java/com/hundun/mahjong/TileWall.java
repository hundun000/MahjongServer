package com.hundun.mahjong;


import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.mahjong4j.exceptions.Mahjong4jException;
import org.mahjong4j.tile.Tile;

import net.bytebuddy.dynamic.scaffold.MethodGraph.Linked;

/**
 * 壁牌
 * @author hundun 2018年10月18日
 */
public class TileWall {
	public static final int TILE_WALL_SIZE = 122;
	// 約束其只能被從前端摸取
	private Stack<Tile> tiles = new Stack<>();
	// 每次開杠少摸一張
	private int numUnDraw = 0;
	
	
	public TileWall(List<Tile> tiles) throws Mahjong4jException {
		if (tiles.size() != TILE_WALL_SIZE) {
			throw new Mahjong4jException("壁牌構造時大小錯誤");
		}
		this.tiles.addAll(tiles);
	}
	
	public boolean isNotEmpty() {
		return tiles.size() > numUnDraw;
	}
	
	public Tile beDrawn() {
		if(isNotEmpty()) {
			return tiles.pop();
		} else {
			return null;
		}
	}
	
	public void kangHappen() {
		numUnDraw++;
	}

}
