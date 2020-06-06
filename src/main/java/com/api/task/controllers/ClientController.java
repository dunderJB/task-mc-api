package com.api.task.controllers;

import com.api.task.entities.Client;
import com.api.task.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Client>> findAllClients(){
        List<Client> listClient = clientService.findAllClient();
        return ResponseEntity.ok().body(listClient);
    }

    @RequestMapping(value = "/new-client", method = RequestMethod.POST)
    public ResponseEntity<Void> insertClient(@RequestBody Client obj){
        clientService.insertClient(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(obj.getName()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
