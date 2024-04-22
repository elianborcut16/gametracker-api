package com.games.tracker.controller;
import com.games.tracker.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private final List<Game> games;
    @Autowired
    public GameController(List<Game> games) {
        this.games = games;
    }
    @GetMapping
    public List<Game> getAllGames() {
        return games;
    }

    @PostMapping
    public void addGame(@RequestBody Game game) {
        games.add(game);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateGame(@PathVariable Integer id, @RequestBody Game updatedGame) {
        for (int i = 0; i < games.size(); i++) {
            Game game = games.get(i);
            if (game.getId().equals(id)) {
                games.set(i, updatedGame);
                return ResponseEntity.ok("Game updated successfully");
            }
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable Integer id) {
        for (Iterator<Game> iterator = games.iterator(); iterator.hasNext();) {
            Game game = iterator.next();
            if (game.getId().equals(id)) {
                iterator.remove();
                return ResponseEntity.ok("Game deleted successfully");
            }
        }
        return ResponseEntity.notFound().build();
    }

}
