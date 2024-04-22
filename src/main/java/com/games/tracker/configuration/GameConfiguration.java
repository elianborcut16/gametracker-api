package com.games.tracker.configuration;

import com.games.tracker.model.Game;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class GameConfiguration {
    @Bean
    public List<Game> games() {
        List<Game> games = new ArrayList<>();
        games.add(new Game(1, "The Legend of Zelda", "Action-adventure"));
        games.add(new Game(2, "Super Mario Bros.", "Platform"));
        return games;
    }
}