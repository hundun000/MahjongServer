package org.mahjong4j.hands;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mahjong4j.exceptions.MahjongTileOverFlowException;
import org.mahjong4j.tile.Tile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yu1ro
 */
public class ToitsuTest {
    Toitsu toitsu1;
    Toitsu toitsu2;
    Toitsu toitsuF;

    @Before
    public void setUp() throws Exception {
        toitsu1 = new Toitsu(Tile.M1);
        toitsu2 = new Toitsu(Tile.M1, Tile.M1);
        toitsuF = new Toitsu(Tile.M1, Tile.M2);
    }

    @Test
    public void testCheck() throws Exception {
        assertTrue(Toitsu.check(Tile.P1, Tile.P1));
        assertFalse(Toitsu.check(Tile.P1, Tile.P4));
    }

    @Test
    public void testGetTile() throws Exception {
        assertEquals(Tile.M1, toitsu1.getTile());
        assertEquals(Tile.M1, toitsu2.getTile());
        assertEquals(null, toitsuF.getTile());
    }

    @Test
    public void testGetIsMentsu() throws Exception {
        assertTrue(toitsu1.isMentsu());
        assertTrue(toitsu2.isMentsu());
        assertFalse(toitsuF.isMentsu());
    }

    @Test
    public void testGetIsOpen() throws Exception {
        assertFalse(toitsu1.isOpen());
        assertFalse(toitsu2.isOpen());
        assertFalse(toitsuF.isOpen());
    }

    @Test
    public void testFindJantoCandidate() throws Exception {
        int[] tiles = {
            1, 1, 1, 1, 1, 1, 1, 1, 1,
            0, 1, 1, 1, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0,
            0, 2, 0
        };
        List<Toitsu> expected, actual = Toitsu.findJantoCandidate(tiles);

        assertEquals(1, actual.size());

        expected = new ArrayList<>(7);
        expected.add(new Toitsu(Tile.HAK));
        assertEquals(Tile.HAK, expected.get(0).getTile());
    }


    @Test(expected = MahjongTileOverFlowException.class)
    public void testThrow() throws Exception {
        int[] tiles = {
            0, 2, 3, 4, 5, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0,
            0, 0, 0
        };
        Toitsu.findJantoCandidate(tiles);
    }

    @Test
    public void testEquals() throws Exception {
        assertTrue(toitsu1.equals(toitsu2));
        assertFalse(toitsu1.equals(toitsuF));
    }

    @After
    public void tearDown() throws Exception {
        assertEquals(toitsu1.hashCode(), toitsu2.hashCode());
        assertNotEquals(toitsu1.hashCode(), toitsuF.hashCode());

    }
}