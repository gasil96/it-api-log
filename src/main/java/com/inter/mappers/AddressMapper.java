package com.inter.mappers;

import com.inter.clients.dtos.AddressDTOClient;
import com.inter.dtos.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "jsr330")
public interface AddressMapper {

	@Mapping(source = "cep", target = "zipCode")
	@Mapping(source = "logradouro", target = "street")
	@Mapping(source = "complemento", target = "complement")
	@Mapping(source = "bairro", target = "district")
	@Mapping(source = "localidade", target = "city")
	@Mapping(source = "uf", target = "state")
	AddressDTO toDTO(AddressDTOClient addressDTOClient);

}
