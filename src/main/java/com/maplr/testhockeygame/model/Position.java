package com.maplr.testhockeygame.model;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

@Getter
public enum Position {
    DEFENSE_MAN("defenseman"),
    GOAL_TENDER("goaltender"),
    FORWARD("forward");

    @JsonValue
    public final String value;

    Position(String value) {
       this.value = value;
    }
}
