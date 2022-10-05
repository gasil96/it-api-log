package com.inter.mappers;

import com.inter.contants.TypeLog;
import com.inter.dtos.LogDTO;
import com.inter.entities.Log;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class LogMapperTest {

	private static final String SYSTEM_REFERENCE = "123";
	private static final String ID_LOG = "1996";
	private static final String TRACE = "Trace Message";
	private static final String MESSAGE_LOG = "A Message Log";
	private static final ZonedDateTime CREATED = ZonedDateTime.of(1996, 11, 11, 17, 5, 0, 0, ZoneId.of("Asia/Tokyo"));
	private final Log LOG = builderLog();
	private final LogDTO LOG_DTO = builderLogDTO();

	@Inject
	LogMapper mapper;

	@Test
	void logMapperEntityToDTOIsOK() {
		LogDTO result = mapper.toDTO(LOG);

		assertEquals(ID_LOG, result.getId());
		assertEquals(TypeLog.HARD, result.getType());
		assertEquals(TRACE, result.getTraceLog());
		assertEquals(MESSAGE_LOG, result.getMessageLog());
		assertEquals(CREATED, result.getCreated());
		assertEquals(SYSTEM_REFERENCE, result.getSystemReference().get(0));
	}

	@Test
	void logMapperDTOToEntityIsOK() {
		Log result = mapper.toEntity(LOG_DTO);

		assertEquals(ID_LOG, result.getId());
		assertEquals(TypeLog.BASIC, result.getType());
		assertEquals(TRACE, result.getTraceLog());
		assertEquals(MESSAGE_LOG, result.getMessageLog());
		assertEquals(CREATED, result.getCreated());
		assertEquals(SYSTEM_REFERENCE, result.getSystemReference().get(0));
	}

	private Log builderLog() {
		return Log.builder()
				.id(ID_LOG)
				.type(TypeLog.HARD)
				.traceLog(TRACE)
				.messageLog(MESSAGE_LOG)
				.created(CREATED)
				.systemReference(List.of(SYSTEM_REFERENCE))
				.build();
	}

	private LogDTO builderLogDTO() {
		return LogDTO.builder()
				.id(ID_LOG)
				.type(TypeLog.BASIC)
				.traceLog(TRACE)
				.messageLog(MESSAGE_LOG)
				.created(CREATED)
				.systemReference(List.of(SYSTEM_REFERENCE))
				.build();
	}

}
