package com.inter.services;

import com.inter.dtos.LogDTO;
import com.inter.entities.Log;
import com.inter.mappers.LogMapper;
import com.inter.repositories.LogRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Singleton
@AllArgsConstructor
public class LogServiceImpl implements LogService {

	private final LogRepository logRepository;
	private final LogMapper logMapper;

	@Override
	public Page<LogDTO> getAllByFilters(Pageable pageable) {
		Page<LogDTO> logDTOPage = logRepository.findAll(pageable).map(logMapper::toDTO);

		log.info("LogServiceImpl.getAllByFilters - success - {}", pageable);
		return logDTOPage;
	}

	@Override
	public Optional<LogDTO> getById(String id) {
		Optional<LogDTO> optionalLogDTO = logRepository.findById(id).map(logMapper::toDTO);

		log.info("LogServiceImpl.getAllByFilters - success - {}", id);
		return optionalLogDTO;
	}

	@Override
	public void create(LogDTO logDTO) {
		Log entity = logMapper.toEntity(logDTO);

		logRepository.save(entity);
		log.info("LogServiceImpl.create - success - {}", logDTO);
	}


}
