package com.inter.mappers;

import com.inter.dtos.LogDTO;
import com.inter.entities.Log;
import org.mapstruct.Mapper;

@Mapper(componentModel = "jsr330")
public interface LogMapper {

	LogDTO toDTO(Log log);

	Log toEntity(LogDTO logDTO);

}
