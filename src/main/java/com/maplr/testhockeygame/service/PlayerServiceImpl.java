package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.entity.PlayerEntity;
import com.maplr.testhockeygame.exception.TeamNotFoundException;
import com.maplr.testhockeygame.repository.PlayerRepository;
import com.maplr.testhockeygame.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    @Override
    public PlayerEntity addPlayer(long teamYear, PlayerEntity playerToAdd) throws TeamNotFoundException {
        var team = findByYear(teamRepository, teamYear);
        var playerEntity = playerRepository.save(playerToAdd);
        team.getPlayers().add(playerEntity);
        if (playerEntity.isCaptain()) {
            team.setCaptain(playerEntity);
        }
        teamRepository.save(team);
        return playerEntity;
    }

    @Override
    public PlayerEntity updatePlayer(long teamYear, long playerNumber, PlayerEntity playerToUpdate) throws TeamNotFoundException {
        var team = findByYear(teamRepository, teamYear);

        // Pour respecter les preco REST, si utilisateur non trouvé alors on le crée
        PlayerEntity player = playerRepository.findByNumber(playerNumber).orElse(playerToUpdate);

        // Si le joueur n'a pas d'id alors on est en création
        if (player.getId() == 0L) {
            // On associe l'équipe
            team.getPlayers().add(player);
        } else {
            // Sinon on met à jour le joueur
            // On suppose dans le cadre de l'exercice que si le joueur existe, alors il existe pour l'équipe de l'année choisie
            player.setLastName(playerToUpdate.getLastName());
            player.setName(playerToUpdate.getName());
            player.setNumber(playerToUpdate.getNumber());
            player.setPosition(playerToUpdate.getPosition());
            // On indique la notion de captain pour que celle ci remonte au niveau du DTO
            player.setCaptain(playerToUpdate.isCaptain());
        }

        player = playerRepository.save(player);

        // On met à jour le capitaine
        // On suppose dans le cadre de l'exercice que l'appel à ce endpoint est pour mettre à jour le capitaine
        // Sinon il faudrait detecter si le capitaine change
        team.setCaptain(player);
        teamRepository.save(team);

        return player;
    }
}
