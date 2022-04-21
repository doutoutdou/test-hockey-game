package com.maplr.testhockeygame.mapper;

import com.maplr.testhockeygame.dto.PlayerDto;
import com.maplr.testhockeygame.entity.PlayerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {
    PlayerEntity fromDto(PlayerDto playerDto);
    PlayerDto toDto(PlayerEntity playerEntity);
}
