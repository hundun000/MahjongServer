package com.hundun.mahjong;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mahjong4j.Player;
import org.mahjong4j.exceptions.Mahjong4jException;

import com.hundun.mahjong.core.game.board.MahjongBoard;

public class GamingMahjongBoardTest {
	
	MahjongBoard mahjongBoard;

	@Test
	public void test() throws Mahjong4jException {
		boolean isDoubleReach = false;
		int tryTimes = 0;
//		while(!isDoubleReach) {
//			tryTimes++;
//			mahjongBoard = new GamingMahjongBoard();
//		}
		System.out.println(tryTimes);
	}

}
