package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;

public interface PlayerService extends CommonService{

    /**
     * @param teamYear     the year of the team in which the player is to be added
     * @param playerEntity the player to add
     * @return the player added
     * @throws TeamNotFoundException if the team isn't found
     */
    PlayerEntity addPlayer(long teamYear, PlayerEntity playerEntity) throws TeamNotFoundException;

    /**
     * @param teamYear     the year of the team for which the player should be updated
     * @param playerNumber the player's number
     * @param player       the player's content
     * @return the player updated
     * @throws TeamNotFoundException if the team isn't found
     */
    PlayerEntity updatePlayer(long teamYear, long playerNumber, PlayerEntity player) throws TeamNotFoundException;

}
