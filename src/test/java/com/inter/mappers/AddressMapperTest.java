package com.inter.mappers;

import com.inter.clients.dtos.AddressDTOClient;
import com.inter.dtos.AddressDTO;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
class AddressMapperTest {

	private final static String ZIP_CODE = "66820000";
	private final static String STREET = "Djalma 33";
	private final static String COMPLEMENT = "West Size";
	private final static String DISTRICT = "B13";
	private static final String CITY = "BELEM";
	private static final String STATE = "PA";
	private final AddressDTOClient ADDRESS_CLIENT = builderAddressDTOClient();

	@Inject
	AddressMapper mapper;

	@Test
	void mapperClientToDTOIsOk() {
		AddressDTO result = mapper.toDTO(ADDRESS_CLIENT);

		assertEquals(ZIP_CODE, result.getZipCode());
		assertEquals(STREET, result.getStreet());
		assertEquals(COMPLEMENT, result.getComplement());
		assertEquals(DISTRICT, result.getDistrict());
		assertEquals(CITY, result.getCity());
		assertEquals(STATE, result.getState());
	}

	private AddressDTOClient builderAddressDTOClient() {
		return AddressDTOClient.builder()
				.cep(ZIP_CODE)
				.logradouro(STREET)
				.complemento(COMPLEMENT)
				.uf(STATE)
				.bairro(DISTRICT)
				.localidade(CITY)
				.build();
	}

}
