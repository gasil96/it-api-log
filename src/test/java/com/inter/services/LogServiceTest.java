package com.inter.services;

import com.inter.dtos.LogDTO;
import com.inter.entities.Log;
import com.inter.repositories.LogRepository;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@MicronautTest
class LogServiceTest {

	private final static String MESSAGE_LOG = "A message log";
	private final static String TRACE_LOG = "A trace log";
	private final static String SYSTEM_ID_ONE = "1SYS";
	private final static String LOG_ID = "1S33asd!@2dsa";
	private final static Pageable PAGE_EXAMPLE = Pageable.from(0, 2);
	private final Log LOG = builderLog();
	private final LogDTO LOG_DTO = builderLogDTO();

	@Inject
	LogRepository logRepository;

	@Inject
	LogServiceImpl logService;

	@Test
	void logGetAllFiltersPageableIsEmpty() {
		when(logRepository.findAll(PAGE_EXAMPLE)).thenReturn(Page.of(List.of(), PAGE_EXAMPLE, 0));

		Page<LogDTO> result = logService.getAllByFilters(PAGE_EXAMPLE);

		assertTrue(result.getContent().isEmpty());
	}

	@Test
	void logGetAllFiltersPageableIsOk() {
		when(logRepository.findAll(PAGE_EXAMPLE)).thenReturn(Page.of(List.of(LOG), PAGE_EXAMPLE, 1));

		Page<LogDTO> result = logService.getAllByFilters(PAGE_EXAMPLE);

		assertEquals(1, result.getTotalSize());
		assertEquals(MESSAGE_LOG, result.getContent().get(0).getMessageLog());
	}

	@Test
	void logGetByIdIsEmpty() {
		when(logRepository.findById(LOG_ID)).thenReturn(Optional.empty());

		Optional<LogDTO> result = logService.getById(LOG_ID);

		assertTrue(result.isEmpty());
	}

	@Test
	void logGetByIdIsPresent() {
		when(logRepository.findById(LOG_ID)).thenReturn(Optional.of(LOG));

		LogDTO result = logService.getById(LOG_ID).get();

		assertEquals(MESSAGE_LOG, result.getMessageLog());
		assertEquals(1, result.getSystemReference().size());
	}

	@Test
	void logIsCreatedWithSuccess() {
		logService.create(LOG_DTO);

		verify(logRepository).save(LOG);
	}

	@MockBean(LogRepository.class)
	LogRepository logRepository() {
		return mock(LogRepository.class);
	}

	private Log builderLog() {
		return Log.builder().id(LOG_ID).traceLog(TRACE_LOG).messageLog(MESSAGE_LOG).systemReference(List.of(SYSTEM_ID_ONE)).build();
	}

	private LogDTO builderLogDTO() {
		return LogDTO.builder().id(LOG_ID).traceLog(TRACE_LOG).messageLog(MESSAGE_LOG).systemReference(List.of(SYSTEM_ID_ONE)).build();
	}

}
