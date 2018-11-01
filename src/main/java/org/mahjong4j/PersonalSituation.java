package org.mahjong4j;

import org.mahjong4j.tile.Tile;

import static org.mahjong4j.tile.Tile.TON;

/**
 * @author yu1ro
 */
public class PersonalSituation {
	
    /**
     * 親家
     */
    private boolean isParent;
    
    /**
     * 自摸
     */
    private boolean isTsumo;
    
    /**
     * 一發
     */
    private boolean isIppatsu;
    
    /**
     * 立直
     */
    private boolean isReach;
    
    /**
     * 兩立直
     */
    private boolean isDoubleReach;
    
    /**
     * 搶槓
     */
    private boolean isChankan;
    
    /**
     * 嶺上開花
     */
    private boolean isRinshankaihoh;
    
    /**
     * 自風
     */
    private Tile jikaze;

    public PersonalSituation() {
    }
    
    /**
     * normal init
     * @param jikaze
     */
    public PersonalSituation(Tile jikaze) {
    	this(false, false, false, false, false, false, jikaze);
    }

    public PersonalSituation(boolean isTsumo, boolean isIppatsu, boolean isReach, boolean isDoubleReach, boolean isChankan, boolean isRinshankaihoh, Tile jikaze) {
        this.isTsumo = isTsumo;
        this.isIppatsu = isIppatsu;
        this.isReach = isReach;
        this.isDoubleReach = isDoubleReach;
        this.isChankan = isChankan;
        this.isRinshankaihoh = isRinshankaihoh;
        this.jikaze = jikaze;
        isParent = (jikaze == TON);
    }

    public boolean isParent() {
        return isParent;
    }

    public boolean isTsumo() {
        return isTsumo;
    }

    public void setTsumo(boolean tsumo) {
        isTsumo = tsumo;
    }

    public boolean isIppatsu() {
        return isIppatsu;
    }

    public void setIppatsu(boolean ippatsu) {
        isIppatsu = ippatsu;
    }

    public boolean isReach() {
        return isReach;
    }

    public void setReach(boolean reach) {
        this.isReach = reach;
    }

    public boolean isDoubleReach() {
        return isDoubleReach;
    }

    public void setDoubleReach(boolean doubleReach) {
        isDoubleReach = doubleReach;
    }

    public boolean isChankan() {
        return isChankan;
    }

    public void setChankan(boolean chankan) {
        isChankan = chankan;
    }

    public boolean isRinshankaihoh() {
        return isRinshankaihoh;
    }

    public void setRinshankaihoh(boolean rinshankaihoh) {
        isRinshankaihoh = rinshankaihoh;
    }

    public Tile getJikaze() {
        return jikaze;
    }

    public void setJikaze(Tile jikaze) {
        this.jikaze = jikaze;
        isParent = (jikaze == TON);
    }
}
