// src/main/java/com/example/demo/controller/RunController.java
package com.esercitazione.demo.controller;

import com.esercitazione.demo.run.Run;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final List<Run> runs = new ArrayList<>();

    public RunController() {
    }

    @GetMapping
    public ResponseEntity<List<Run>> findAll() {
        return ResponseEntity.ok(runs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Run> findById(@PathVariable Integer id) {
        if (id < 0 || id >= runs.size()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(runs.get(id));
    }

    @PostMapping
    public ResponseEntity<Run> create(@RequestBody Run newRun) {
        runs.add(newRun);
        return ResponseEntity.status(HttpStatus.CREATED).body(newRun);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Run> update(@PathVariable Integer id, @RequestBody Run updatedRun) {
        for (int i = 0; i < runs.size(); i++) {
            if (runs.get(i).id().equals(id)) {
                runs.set(i, updatedRun);
                return ResponseEntity.ok(updatedRun);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Optional<Run> existing = runs.stream()
                .filter(run -> run.id().equals(id))
                .findFirst();

        if (existing.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        runs.remove(existing.get());
        return ResponseEntity.noContent().build();
    }

}