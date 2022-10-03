package com.inter.controllers;

import com.inter.dtos.LogDTO;
import com.inter.services.LogService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@Controller
@AllArgsConstructor
@Tag(name = "Log Management")
public class LogController {

	private final LogService logService;

	@Operation(summary = "Get log by idd")
	@Get("/v1/logs/{idLog}")
	@Status(HttpStatus.OK)
	Optional<LogDTO> getById(@PathVariable("idLog") String id) {
		Optional<LogDTO> optionalLogDTO = logService.getById(id);

		log.info("LogController.getById - success - {}", id);
		return optionalLogDTO;
	}

	@Operation(summary = "Get all logs by filters")
	@Get("/v1/logs")
	@Status(HttpStatus.OK)
	Page<LogDTO> getAllByFilter(Pageable pageable) {
		Page<LogDTO> logDTOPage = logService.getAllByFilters(pageable);

		log.info("LogController.getAll - success - {} ", pageable);
		return logDTOPage;
	}

	@Operation(summary = "Create new Log")
	@Post("/v1/logs/create")
	@Status(HttpStatus.CREATED)
	void create(@Body LogDTO logDTO) {
		log.info("LogController.save - success - {}", logDTO);
		logService.create(logDTO);
	}

}
