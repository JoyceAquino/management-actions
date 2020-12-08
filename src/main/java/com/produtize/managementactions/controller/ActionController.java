package com.produtize.managementactions.controller;

import com.produtize.managementactions.converter.ActionInConverter;
import com.produtize.managementactions.converter.ActionsOutConverter;
import com.produtize.managementactions.dto.ActionIn;
import com.produtize.managementactions.dto.ActionOut;
import com.produtize.managementactions.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/actions")
@RequiredArgsConstructor
@Slf4j
public class ActionController {

    //TODO Id location no created.

    private final ActionRepository repository;
    private final ActionInConverter inConverter;
    private final ActionsOutConverter outConverter;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ActionIn in) {
        log.info(in.toString());
        repository.save(inConverter.apply(in));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ArrayList<ActionOut> findAll() {
        return outConverter.apply(repository.findAll());
    }
}
