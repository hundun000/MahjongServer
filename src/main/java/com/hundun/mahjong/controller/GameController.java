package com.hundun.mahjong.controller;

import java.util.Map;

import org.mahjong4j.exceptions.Mahjong4jException;
import org.mahjong4j.tile.Tile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hundun.mahjong.core.exception.GameException;
import com.hundun.mahjong.core.exception.PlayerStateTransitionExceprion;
import com.hundun.mahjong.core.game.board.MahjongBoard;
import com.hundun.mahjong.core.game.board.MahjongBoardFactory;
import com.hundun.mahjong.core.game.board.MahjongBoard.MeiPaiType;
import com.hundun.mahjong.core.dto.MahjongApiRequest;
import com.hundun.mahjong.core.utls.CharImageTool;
import com.hundun.mahjong.core.utls.JsonFormatTool;

@RestController
@RequestMapping("/mahjong")
public class GameController {
	
	MahjongBoard board;
	
	static final String JSON_FORMAT = "json";
	static final String IMAGE_FORMAT = "image";
	static final String defaultFormat = IMAGE_FORMAT;
	
	public GameController() throws Mahjong4jException {
		
	}
	
	private Object mahjongBoardToView(MahjongBoard board, String mode) {
	    if (mode.equals(JSON_FORMAT)) {
            return JsonFormatTool.mahjongBoardToJson(board);
        }
        return CharImageTool.mahjongBoardToCharImage(board);
    }
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String bot(
			@RequestParam(value = "message", required = false) String message) {
		System.out.println("from GMS:" + message);
		return "Hello GameMaker!";
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	public Object resetBoard(
			@RequestBody MahjongApiRequest request
			) throws Exception {
	    if (request.mode == null) {
	        request.mode = defaultFormat;
	    }
		board = MahjongBoardFactory.getMahjongBoardById(Integer.valueOf(request.board_id));
		return mahjongBoardToView(board, request.mode);
	}

	@RequestMapping(value="/draw", method=RequestMethod.POST)
	public Object playerNormalDraw(
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode) throws Exception {
		board.playerNormalDraw();
		return mahjongBoardToView(board, mode);
	}
	
	@RequestMapping(value="/an-kan-draw", method=RequestMethod.POST)
    public Object playerAnKanDraw(
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode) throws Exception {
        board.playerAnKanDraw();
        return mahjongBoardToView(board, mode);
    }
	
	@RequestMapping(value="/reach-pass", method=RequestMethod.POST)
    public Object playerReachPass(
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode) throws Exception {
        board.playerReachPass();
        return mahjongBoardToView(board, mode);
    }
	
	@RequestMapping(value="/discard", method=RequestMethod.POST)
	public Object playerDiscardTile(
			@RequestParam(value = "tile_name") String tileName,
			@RequestParam(value = "want_reach", required = false, defaultValue = "false") boolean wantReach,
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode
			) throws Exception {
		board.playerDiscardTile(Tile.valueOf(tileName), wantReach);
		return mahjongBoardToView(board, mode);
	}
	
	@RequestMapping(value="/turn-end", method=RequestMethod.POST)
	public Object playerTurnEnd(
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode) throws Exception {
		board.playerTurnEnd();
		return mahjongBoardToView(board, mode);
	}
	
	@RequestMapping(value="/an-kan", method=RequestMethod.POST)
    public Object playerAnKan(
            @RequestParam(value = "player_index") int anKanPlayerIndex,
            @RequestParam(value = "candidate_index") int anKanCandidateIndex,
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode) throws Exception {
        board.playerAnKan(anKanPlayerIndex, anKanCandidateIndex);
        return mahjongBoardToView(board, mode);
    }
	
	@RequestMapping(value="/mei-pai", method=RequestMethod.POST)
	public Object playerMeipai(
			@RequestParam(value = "player_index") int meiPaiPlayerIndex,
			@RequestParam(value = "candidate_index") int meiPaiCandidateIndex,
			@RequestParam(value = "mei_pai_type") MeiPaiType mei_pai_type,
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode
			) throws Exception {
		board.playerMeipai(meiPaiPlayerIndex, meiPaiCandidateIndex, mei_pai_type);
		return mahjongBoardToView(board, mode);
	}

	
	@RequestMapping(value="/tsumo", method=RequestMethod.POST)
	public Object playerTsumo(
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode) throws Mahjong4jException, GameException {
		board.playerTsumo();
		return mahjongBoardToView(board, mode);
	}
	
	@RequestMapping(value="/ron", method=RequestMethod.POST)
    public Object playerRon(
            @RequestParam(value = "player_index") int playerIndex,
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode
            ) throws Mahjong4jException, GameException {
        board.playerRon(playerIndex);
        return mahjongBoardToView(board, mode);
    }
	
	@RequestMapping(value="/command-line", method=RequestMethod.POST)
	public Object commandLineControl(
			@RequestParam(value = "line") String line,
            @RequestParam(value = "mode", required = false, defaultValue = defaultFormat) String mode
			) throws Mahjong4jException, GameException {
		board.commandLineControl(line);
		return mahjongBoardToView(board, mode);
	}
	
}
