package com.hundun.mahjong;

import java.util.List;

import org.mahjong4j.exceptions.HandsOverFlowException;
import org.mahjong4j.exceptions.IllegalMentsuSizeException;
import org.mahjong4j.exceptions.MahjongTileOverFlowException;
import org.mahjong4j.hands.Hands;
import org.mahjong4j.tile.Tile;

public class HandsFactory {
	
	public static Hands getHands(List<Tile> tiles) throws HandsOverFlowException, MahjongTileOverFlowException, IllegalMentsuSizeException {
    	int size = tiles.size();
		int[] allTiles = new int[Tile.NUM_KINDS];
    	for (int i = 0; i < size; i++) {
    		allTiles[tiles.get(i).getCode()]++;
		}
    	Tile last = tiles.get(size - 1);
    	return new Hands(allTiles, last);
	}

}
