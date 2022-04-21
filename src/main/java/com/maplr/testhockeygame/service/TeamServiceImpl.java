package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.TeamEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Override
    public TeamEntity searchByYear(long year) throws TeamNotFoundException {
        return findByYear(teamRepository, year);
    }


}
