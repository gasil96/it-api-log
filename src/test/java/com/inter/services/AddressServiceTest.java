package com.inter.services;

import com.inter.clients.ViaCEPClient;
import com.inter.clients.dtos.AddressDTOClient;
import com.inter.dtos.AddressDTO;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
class AddressServiceTest {

	private final static String ZIP_CODE = "66820000";
	private static final String STATE = "PA";
	private static final String CITY = "BELEM";
	private final AddressDTOClient ADDRESS_CLIENT = builderAddressDTOClient();

	@Inject
	ViaCEPClient viaCEPClient;

	@Inject
	AddressService addressService;

	@Test
	void AddressGetAddressByZipCodeIsOk() {
		when(viaCEPClient.getAddressByCEP(ZIP_CODE)).thenReturn(ADDRESS_CLIENT);

		AddressDTO result = addressService.getAddressByZipCode(ZIP_CODE);

		assertEquals(ZIP_CODE, result.getZipCode());
		assertEquals(STATE, result.getState());
		assertEquals(CITY, result.getCity());
	}

	@MockBean(ViaCEPClient.class)
	ViaCEPClient viaCEPClient() {
		return mock(ViaCEPClient.class);
	}

	private AddressDTOClient builderAddressDTOClient() {
		return AddressDTOClient.builder().uf(STATE).localidade(CITY).cep(ZIP_CODE).build();
	}

}
