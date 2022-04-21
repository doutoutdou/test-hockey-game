package com.maplr.testhockeygame.configuration;

import com.maplr.testhockeygame.model.Position;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Permet de manipuler un enum (afin de respecter la convention de nommage) dans le code
 * mais de stocker en BDD la valeur d'entrée
 */
@Converter(autoApply = true)
public class JpaPositionConverter implements AttributeConverter<Position, String> {

        @Override
    public String convertToDatabaseColumn(Position position) {
        if (position == null) {
            return null;
        }
        return position.getValue();
    }

    @Override
    public Position convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }

        return Stream.of(Position.values())
                .filter(c -> c.getValue().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
