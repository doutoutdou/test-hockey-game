package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.mapper.PlayerMapper;
import com.maplr.testhockeygame.mapper.TeamMapper;
import com.maplr.testhockeygame.service.PlayerService;
import com.maplr.testhockeygame.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "teams", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TeamController implements TeamEndpoint {

    private final TeamMapper teamMapper;
    private final PlayerMapper playerMapper;
    private final TeamService teamService;
    private final PlayerService playerService;

    @GetMapping("{year}")
    public TeamDto getTeam(@PathVariable(value = "year") long year) throws TeamNotFoundException {
        return teamMapper.toDto(teamService.searchByYear(year));
    }

    @PostMapping(value = "{year}/players", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerDto addPlayer(@PathVariable("year") long year, @Valid @RequestBody PlayerDto playerDto) throws TeamNotFoundException {
        return playerMapper.toDto(playerService.addPlayer(year, playerMapper.fromDto(playerDto)));
    }

    @PutMapping(value = "{year}/players/{number}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PlayerDto updatePlayer(@PathVariable("year") long year, @PathVariable("number") long number, @Valid @RequestBody PlayerDto playerDto) throws TeamNotFoundException {
        return playerMapper.toDto(playerService.updatePlayer(year, number, playerMapper.fromDto(playerDto)));
    }
}
