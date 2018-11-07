package com.hundun.mahjong;

import org.junit.Test;
import org.mahjong4j.exceptions.Mahjong4jException;

import com.hundun.mahjong.game.board.MahjongBoard;
import com.hundun.mahjong.game.board.MahjongBoardFactory;
import com.hundun.mahjong.utls.CharImageTool;

/**
 *
 * @author hundun
 * Created on 2019/03/04
 */
public class GameRunTest {
	
	MahjongBoard mahjongBoard;
	
	@Test
	public void test() throws Exception {
		mahjongBoard = MahjongBoardFactory.getMahjongBoardById(0);
		System.out.println(CharImageTool.mahjongBoardToCharImage(mahjongBoard));
		mahjongBoard.playerNormalDraw();
		System.out.println(CharImageTool.mahjongBoardToCharImage(mahjongBoard));
	}

}
