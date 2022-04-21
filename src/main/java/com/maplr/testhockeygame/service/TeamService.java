package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.TeamEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;

public interface TeamService extends CommonService {

    /**
     * Search a team for a year
     *
     * @param year the year
     * @return the team, if found
     */
    TeamEntity searchByYear(long year) throws TeamNotFoundException;


}
