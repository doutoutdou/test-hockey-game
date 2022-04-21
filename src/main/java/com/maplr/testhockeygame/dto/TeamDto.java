package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class TeamDto {

    private Long id;

    private Long year;

    private String coach;

    private Set<PlayerDto> players;

    @JsonIgnore
    private PlayerDto captain;
}
