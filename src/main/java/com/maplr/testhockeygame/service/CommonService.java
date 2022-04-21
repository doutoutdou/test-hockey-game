package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.TeamEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.repository.TeamRepository;

public interface CommonService {

     /**
     * Search a team for a year
     *
     * @param teamRepository the team repository
     * @param year           the year
     * @return the team if found
     * @throws TeamNotFoundException if the team isn't found
     */
    default TeamEntity findByYear(TeamRepository teamRepository, long year) throws TeamNotFoundException {
        return teamRepository.findByYear(year).
                orElseThrow(() -> new TeamNotFoundException("Team not found for year " + year));
    }
}
