package com.hundun.mahjong.exception;

import com.hundun.mahjong.game.PlayerAction;
import com.hundun.mahjong.game.PlayerState;

/**
 * @author hundun
 * Created on 2019/08/06
 */
public class PlayerStateTransitionExceprion extends GameException {

	public PlayerStateTransitionExceprion(PlayerState state, PlayerAction action) {
		super("不能在["+state+"]执行["+action+"]。");
	}

}
