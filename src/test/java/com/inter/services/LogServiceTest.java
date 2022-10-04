package com.inter.services;

import com.inter.dtos.LogDTO;
import com.inter.entities.Log;
import com.inter.mappers.LogMapper;
import com.inter.repositories.LogRepository;
import io.micronaut.context.annotation.Import;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.*;

@MicronautTest
public class LogServiceTest {
//
//	private final static String MESSAGE_LOG = "A message log";
//	private final static String TRACE_LOG = "A trace log";
//	private final static String SYSTEM_ID_ONE = "1SYS";
//	private final static String LOG_ID = "1S33asd!@2dsa";
//
//	@MockBean
//	LogRepository logRepository;
//
//	@InjectMocks
//	LogServiceImpl logService;
//
//	@Mock
//	LogMapper logMapper;
//
//	@Test
//	void logIsCreatedWithSuccess() {
//		Log log = Log.builder().id(LOG_ID).traceLog(TRACE_LOG).messageLog(MESSAGE_LOG).systemReference(List.of(SYSTEM_ID_ONE)).build();
//		LogDTO logDTO = LogDTO.builder().id(LOG_ID).traceLog(TRACE_LOG).messageLog(MESSAGE_LOG).systemReference(List.of(SYSTEM_ID_ONE)).build();
//
// 		when(logMapper.toEntity(logDTO)).thenReturn(log);
//
//		doNothing().when(logRepository).save(log);
//
//		logService.create(logDTO);
//
//		verify(logRepository).save(log);
//	}
//	private final static String MESSAGE_LOG = "A message log";
//	private final static String TRACE_LOG = "A trace log";
//	private final static String SYSTEM_ID_ONE = "1SYS";
//	private final static String LOG_ID = "1S33asd!@2dsa";
//
//	@MockBean
//	LogRepository logRepository;
//
//	@InjectMocks
//	LogServiceImpl logService;
//
//	@Mock
//	LogMapper logMapper;
//
//	@Test
//	void logIsCreatedWithSuccess() {
//		Log log = Log.builder().id(LOG_ID).traceLog(TRACE_LOG).messageLog(MESSAGE_LOG).systemReference(List.of(SYSTEM_ID_ONE)).build();
//		LogDTO logDTO = LogDTO.builder().id(LOG_ID).traceLog(TRACE_LOG).messageLog(MESSAGE_LOG).systemReference(List.of(SYSTEM_ID_ONE)).build();
//
// 		when(logMapper.toEntity(logDTO)).thenReturn(log);
//
//		doNothing().when(logRepository).save(log);
//
//		logService.create(logDTO);
//
//		verify(logRepository).save(log);
//	}

}
