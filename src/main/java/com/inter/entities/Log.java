package com.inter.entities;

import com.inter.contants.TypeLog;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
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
@NoArgsConstructor
@AllArgsConstructor
@Introspected
@MappedEntity
public class Log implements Serializable {

	private static final long serialVersionUID = 6953719407166668936L;

	@Id
	@GeneratedValue(GeneratedValue.Type.SEQUENCE)
	private String id;

	private TypeLog type;

	private String traceLog;

	@NotNull
	private String messageLog;

	private ZonedDateTime created;

	private List<String> systemReference;

}
