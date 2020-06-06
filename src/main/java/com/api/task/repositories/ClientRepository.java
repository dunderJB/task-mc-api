package com.api.task.repositories;

import com.api.task.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "select * from client", nativeQuery = true)
    public List<Client> findAllCLient();

}
