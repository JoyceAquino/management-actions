package com.produtize.managementactions.repository;

import com.produtize.managementactions.model.Action;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends MongoRepository<Action, String> {
}
