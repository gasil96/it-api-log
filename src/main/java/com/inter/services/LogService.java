package com.inter.services;

import com.inter.dtos.LogDTO;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

public interface LogService {

	Page<LogDTO> getAllByFilters(Pageable pageable);

	Optional<LogDTO> getById(String id);

	void create(LogDTO logDTO);

}
