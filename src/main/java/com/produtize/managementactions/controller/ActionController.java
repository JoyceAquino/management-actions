package com.produtize.managementactions.controller;

import com.produtize.managementactions.converter.ActionInConverter;
import com.produtize.managementactions.dto.ActionIn;
import com.produtize.managementactions.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;

@RestController
@RequestMapping("/actions")
@RequiredArgsConstructor
@Slf4j
public class ActionController {

    //TODO Adicionar MDC e campos do contexto de request no log
    //TODO Id location no created.

    private final ActionRepository repository;
    private final ActionInConverter converter;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody ActionIn in) {
        log.info(in.toString());
        repository.save(converter.apply(in));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
