package br.com.fiap.controller;


import br.com.fiap.model.Person;
import br.com.fiap.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "Person Endpoint", tags = {"PersonEndpoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices services;

    @ApiOperation(value = "Find All People Recorded.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Person> findAll() {
        return services.findAll();
    }

    @ApiOperation(value = "Find People By your Id.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Long id ) {
        return services.findById(id);
    }

    @ApiOperation(value = "Create a People.")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public Person create(@RequestBody Person person) {
        return services.create(person);
    }

    @ApiOperation(value = "Update People By your Id.")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public Person update(@RequestBody Person person) {
        return services.update(person);
    }

    @ApiOperation(value = "Delete People by your Id.")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id ) {
        services.delete(id);
        return ResponseEntity.ok().build();
    }


}























