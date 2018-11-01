package com.hundun.mahjong;

import static org.mahjong4j.tile.Tile.TON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import org.mahjong4j.GeneralSituation;
import org.mahjong4j.PersonalSituation;
import org.mahjong4j.Player;
import org.mahjong4j.exceptions.Mahjong4jException;
import org.mahjong4j.hands.Hands;
import org.mahjong4j.tile.Tile;


/**
 * 
 * @author hundun 2018年10月23日
 */
public class GamingMahjongBoard {
	public GeneralSituation generalSituation;
    public Player[] players;
    public TileWall tileWall;
    public TileKing tileKing;
    public final int PLAYERS_SIZE = 4;
    
    
    public GamingMahjongBoard() throws Mahjong4jException {
    	EnumSet<Tile> tileKinds = EnumSet.allOf(Tile.class);
    	// 將所有種類的Tile各放4張進牌堆
    	List<Tile> tiles = new ArrayList<>();
    	for (Tile tile : tileKinds) {
    		for (int i = 0; i < Tile.NUM_EACH_KIND ; i++) {
    			tiles.add(tile);
    		}
    	}
    	// 洗牌
    	Collections.shuffle(tiles);
    	// 開山
    	tileWall = new TileWall(tiles.subList(0, TileWall.TILE_WALL_SIZE));
    	tileKing = new TileKing(tiles.subList(TileWall.TILE_WALL_SIZE, tiles.size()));
    	// 摸牌
    	List<Tile> drawingTilesA = new ArrayList<>();
    	List<Tile> drawingTilesB = new ArrayList<>();
    	List<Tile> drawingTilesC = new ArrayList<>();
    	List<Tile> drawingTilesD = new ArrayList<>();
    	for (int i = 0; i < 13; i++) {
    		drawingTilesA.add(tileWall.beDrawn());
    		drawingTilesB.add(tileWall.beDrawn());
    		drawingTilesC.add(tileWall.beDrawn());
    		drawingTilesD.add(tileWall.beDrawn());
    	}
    	
    	Hands hands;
    	PersonalSituation personalSituation;
    	players = new Player[PLAYERS_SIZE];
    	for (int i = 0; i < PLAYERS_SIZE; i++) {
    		hands = HandsFactory.getHands(drawingTilesA);
    		personalSituation = new PersonalSituation();
        	players[i] = new Player(hands, generalSituation, personalSituation);
        	players[i].calculate();
    	}
    	
    }
    

    
    
    
    
    

	
}
