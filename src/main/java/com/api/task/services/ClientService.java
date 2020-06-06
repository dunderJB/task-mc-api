package com.api.task.services;

import com.api.task.entities.Client;
import com.api.task.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAllClient(){
        List<Client> listCLient = clientRepository.findAll();
        return listCLient;
    }

    public Client insertClient(Client obj){
        Client client = clientRepository.save(obj);
        return client;
    }

}
