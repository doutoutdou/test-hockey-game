package com.maplr.testhockeygame.entity;

import com.maplr.testhockeygame.model.Position;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "player")
@Getter
@Setter
public class PlayerEntity {

    // Pas de contrainte d'unicité pour l'exercice
    // mais il serait pertinent de ne pas pouvoir ajouter 2 joueurs avec les mêmes caractéristiques

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long number;

    private String name;

    @Column(name = "lastname")
    private String lastName;

    private Position position;

    @ManyToMany(mappedBy = "players")
    private Set<TeamEntity> teams;

    @Transient
    private boolean captain;

}
