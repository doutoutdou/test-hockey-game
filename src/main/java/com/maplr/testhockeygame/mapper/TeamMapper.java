package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.dto.TeamDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.entity.TeamEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamDto toDto(TeamEntity team);
    Set<PlayerDto> toPlayersDto(Set<PlayerEntity> players);

    PlayerDto toPlayerDto(PlayerEntity player);

    @AfterMapping
    default void map(@MappingTarget TeamDto teamDto) {
        PlayerDto captain = teamDto.getCaptain();

        for (PlayerDto playerDto : teamDto.getPlayers()) {
            if (playerDto.getNumber() == captain.getNumber()) {
                playerDto.setCaptain(true);
                break;
            }
        }
    }
}
