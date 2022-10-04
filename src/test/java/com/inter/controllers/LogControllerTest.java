package com.inter.controllers;

import com.inter.contants.TypeLog;
import com.inter.dtos.LogDTO;
import com.inter.services.LogService;
import com.inter.services.LogServiceImpl;
import io.micronaut.core.type.Argument;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@MicronautTest
@TestInstance(PER_CLASS)
class LogControllerTest {

	private final static String MESSAGE_LOG = "A message log";
	private final static String TRACE_LOG = "A trace log";
	private final static String SYSTEM_ID_ONE = "1SYS";
	private final static String LOG_ID = "1S33asd!@2dsa";
	private final static Pageable PAGE_EXAMPLE = Pageable.from(0, 2);

	@Inject
	@Client("/")
	HttpClient client;

	@Inject
	LogService logService;

	@Test
	void getAllByFilterdWithReturnEmpty() {
		when(logService.getAllByFilters(PAGE_EXAMPLE)).thenReturn(Page.of(Collections.emptyList(), PAGE_EXAMPLE, 0));

		Page<LogDTO> response = client.toBlocking().retrieve(HttpRequest.GET("/v1/logs?page=0&size=2"), pageOf(LogDTO.class));

		assertEquals(Collections.emptyList(), response.getContent());
	}

	@Test
	void getAllByFilterdWithReturnTwoElements() {
		when(logService.getAllByFilters(PAGE_EXAMPLE)).thenReturn(Page.of(Arrays.asList(
				LogDTO.builder().id(LOG_ID).build(),
				LogDTO.builder().id(LOG_ID.toUpperCase()).build()
		), PAGE_EXAMPLE, 2));

		Page<LogDTO> response = client.toBlocking().retrieve(HttpRequest.GET("/v1/logs?page=0&size=2"), pageOf(LogDTO.class));

		assertEquals(2, response.getTotalSize());
		assertEquals(LOG_ID, response.getContent().get(0).getId());
	}

	@Test
	void getByIdWithReturnEmpty() {
		when(logService.getById(LOG_ID)).thenReturn(Optional.empty());

		try {
			client.toBlocking().exchange(HttpRequest.GET("/v1/logs/".concat(LOG_ID)));
		} catch (HttpClientResponseException exception) {
			assertEquals(HttpStatus.NOT_FOUND, exception.getResponse().getStatus());
		}
	}

	@Test
	void getByIdWithReturnPresentLog() {
		when(logService.getById(LOG_ID)).thenReturn(Optional.of(LogDTO.builder().id(LOG_ID).messageLog(MESSAGE_LOG).build()));

		HttpRequest<Object> request = HttpRequest.GET("/v1/logs/".concat(LOG_ID));
		LogDTO response = client.toBlocking().retrieve(request, LogDTO.class);

		assertEquals(LOG_ID, response.getId());
		assertEquals(MESSAGE_LOG, response.getMessageLog());
	}

	@Test
	void createLogDTOisCreated() {
		HttpResponse<Void> response = client.toBlocking().exchange(HttpRequest.POST("/v1/logs/create", LogDTO.builder()
				.messageLog(MESSAGE_LOG)
				.traceLog(TRACE_LOG)
				.systemReference(Collections.singletonList(SYSTEM_ID_ONE))
				.type(TypeLog.HARD)
				.build()));

		assertEquals(HttpStatus.CREATED, response.getStatus());

		verify(logService).create(any());
	}

	@Test
	void createLogDTOwithBadRequestForPayloadValidation() {
		try {
			client.toBlocking().exchange(HttpRequest.POST("/v1/logs/create", LogDTO.builder()
					.traceLog(TRACE_LOG)
					.systemReference(Collections.singletonList(SYSTEM_ID_ONE))
					.type(TypeLog.HARD)
					.build()));
		} catch (HttpClientResponseException exception) {
			assertEquals(HttpStatus.BAD_REQUEST, exception.getResponse().getStatus());
		}

		verify(logService, times(0)).create(any());
	}

	@MockBean(LogServiceImpl.class)
	LogService logService() {
		return mock(LogService.class);
	}

	private static <T> Argument<Page<T>> pageOf(Class<T> type) {
		return Argument.of((Class<Page<T>>) ((Class) Page.class), type);
	}
}
