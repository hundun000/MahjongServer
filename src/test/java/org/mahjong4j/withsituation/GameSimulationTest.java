package org.mahjong4j.withsituation;

import static org.mahjong4j.tile.Tile.CHN;
import static org.mahjong4j.tile.Tile.HAK;
import static org.mahjong4j.tile.Tile.HAT;
import static org.mahjong4j.tile.Tile.M2;
import static org.mahjong4j.tile.Tile.M8;
import static org.mahjong4j.tile.Tile.P2;
import static org.mahjong4j.tile.Tile.PEI;
import static org.mahjong4j.tile.Tile.S2;
import static org.mahjong4j.tile.Tile.TON;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.GeneralSituation;
import org.mahjong4j.PersonalSituation;
import org.mahjong4j.Player;
import org.mahjong4j.hands.Hands;
import org.mahjong4j.hands.Kantsu;
import org.mahjong4j.hands.Kotsu;
import org.mahjong4j.hands.Mentsu;
import org.mahjong4j.hands.MentsuComp;
import org.mahjong4j.hands.Shuntsu;
import org.mahjong4j.hands.Toitsu;
import org.mahjong4j.tile.Tile;
import org.mahjong4j.yaku.normals.ShosangenResolver;

/**
 * 模拟一局
 * @author hundun 2018年10月18日
 */
public class GameSimulationTest {
	
	Hands hands;
    Player player;

    @Before
    public void setUp() throws Exception {
        int[] tiles = {
            2, 0, 0, 0, 2, 0, 0, 2, 0,
            0, 0, 0, 0, 2, 0, 0, 0, 0,
            0, 0, 2, 0, 0, 0, 0, 2, 0,
            0, 2, 0, 0,
            0, 0, 0
        };
        Tile last = M8;
        List<Tile> dora = new ArrayList<>(1);
        dora.add(CHN);

        List<Tile> uradora = new ArrayList<>(1);
        uradora.add(M2);
        GeneralSituation general;
        general = new GeneralSituation(true, false, TON, dora, uradora);
        PersonalSituation personal;
        personal = new PersonalSituation(false, false, false, false, false, false, TON);
        hands = new Hands(tiles, last);
        player = new Player(hands, general, personal);
        player.calculate();
    }
    
    
    @Test
    public void gameStart() {
    	// 发牌
    	
    }
}
