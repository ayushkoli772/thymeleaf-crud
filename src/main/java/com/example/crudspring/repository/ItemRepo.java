package com.example.crudspring.repository;

import com.example.crudspring.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends MongoRepository<Item, String> {
}
