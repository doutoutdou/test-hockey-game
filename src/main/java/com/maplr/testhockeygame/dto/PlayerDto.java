package com.maplr.testhockeygame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maplr.testhockeygame.model.Position;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDto {

    @NotNull
    private long number;
    @NotBlank
    private String name;
    @NotBlank
    @JsonProperty(value = "lastname")
    private String lastName;
    @NotNull
    @JsonProperty(value = "isCaptain")
    private boolean captain;

    // FIXME indiqué de ne pas s'en occuper dans l'énoncé mais sinon il faudrait vérifier l'input
    private Position position;

}
