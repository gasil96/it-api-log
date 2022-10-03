package com.inter.controllers;

import com.inter.contants.TypeLog;
import com.inter.dtos.LogDTO;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@MicronautTest
@TestInstance(PER_CLASS)
class LogControllerTest {

	private final static String MESSAGE_LOG = "A message log";
	private final static String TRACE_LOG = "A trace log";
	private final static String SYSTEM_ID_ONE = "1SYS";
	private final static String LOG_ID = "1S33asd!@2dsa";

	@Inject
	@Client("/")
	HttpClient client;

	@Test
	void createLogDTOisCreated() {
		HttpResponse<Void> response = client.toBlocking().exchange(HttpRequest.POST("/v1/logs/create", LogDTO.builder()
				.messageLog(MESSAGE_LOG)
				.traceLog(TRACE_LOG)
				.systemReference(Collections.singletonList(SYSTEM_ID_ONE))
				.type(TypeLog.HARD)
				.build()));

		assertEquals(HttpStatus.CREATED, response.getStatus());

	}


}
