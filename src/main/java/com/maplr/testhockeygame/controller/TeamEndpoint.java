package com.maplr.testhockeygame.controller;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

public interface TeamEndpoint {

    @Operation(summary = "Get a team by its year")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Team found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = TeamDto.class))}),
            @ApiResponse(responseCode = "404", description = "Team not found",
                    content = {@Content()})})
    TeamDto getTeam(@Parameter(description = "the year of the team") long year) throws TeamNotFoundException;

    @Operation(summary = "Add a player to a team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Player added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlayerDto.class))}),
            @ApiResponse(responseCode = "404", description = "Team not found",
                    content = {@Content()})})
    PlayerDto addPlayer(@Parameter(description = "the year of the team") long year,
                        @Parameter(description = "the player to add", content = {@Content(schema = @Schema(implementation = PlayerDto.class))}) PlayerDto playerDto) throws TeamNotFoundException;

    @Operation(summary = "Update a player for a team")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = PlayerDto.class))}),
            @ApiResponse(responseCode = "404", description = "Team not found",
                    content = {@Content()})})
    PlayerDto updatePlayer(@Parameter(description = "the year of the team") long year,
                           @Parameter(description = "the number of the player to update") long number,
                           @Parameter(description = "the player's content ", content = {@Content(schema = @Schema(implementation = PlayerDto.class))}) PlayerDto playerDto) throws TeamNotFoundException;
}
