package com.inter.dtos;

import com.inter.contants.TypeLog;
import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Introspected
public class LogDTO implements Serializable {

	private static final long serialVersionUID = 4471242389206947822L;

	private String id;
	private TypeLog type;
	private String traceLog;
	@NotNull
	private String messageLog;
	private ZonedDateTime created;
	private List<String> systemReference;

}
