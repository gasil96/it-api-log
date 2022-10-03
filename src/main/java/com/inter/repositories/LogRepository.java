package com.inter.repositories;

import com.inter.entities.Log;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.repository.PageableRepository;

@MongoRepository
public interface LogRepository extends PageableRepository<Log, String> {

}
