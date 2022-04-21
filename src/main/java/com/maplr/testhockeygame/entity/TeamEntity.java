package com.maplr.testhockeygame.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "team")
@Getter
@Setter
public class TeamEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private long year;

    @Column(nullable = false)
    private String coach;

    @ManyToMany
    @JoinTable(name = "teams_players",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id"))
    private Set<PlayerEntity> players = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "captain")
    private PlayerEntity captain;
}
