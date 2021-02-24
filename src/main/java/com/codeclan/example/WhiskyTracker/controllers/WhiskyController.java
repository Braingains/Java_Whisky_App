package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskiesFilteredByYear(
            @RequestParam(name = "year", required = false) Integer year) {
        if (year != null) {
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        //this is not running
    }

    @GetMapping(value = "/whiskies/distillery")
    public ResponseEntity<List<Whisky>> findWhiskiesFilteredByDistilleryAndYear(
            @RequestParam(name = "distillery", required = false) Distillery distillery,
            @RequestParam(name = "age", required = false) Integer age) {
        return new ResponseEntity<>(whiskyRepository.findByDistilleryAndAge(distillery, age), HttpStatus.OK);
    }

}
