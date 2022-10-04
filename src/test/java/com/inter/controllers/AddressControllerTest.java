package com.inter.controllers;

import com.inter.dtos.AddressDTO;
import com.inter.services.AddressService;
import com.inter.services.AddressServiceImpl;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
@TestInstance(PER_CLASS)
class AddressControllerTest {

	private final static String ZIP_CODE = "66820000";
	private static final String STATE = "PA";
	private static final String CITY = "BELEM";

	@Inject
	@Client("/")
	HttpClient client;

	@Inject
	AddressService addressService;

	@Test
	void getAddressByZipCodeWithReturnCorrect() {
		when(addressService.getAddressByZipCode(ZIP_CODE)).thenReturn(AddressDTO.builder()
				.city(CITY)
				.zipCode(ZIP_CODE)
				.state(STATE)
				.build());

		HttpRequest<Object> request = HttpRequest.GET("/v1/addresses/".concat(ZIP_CODE));
		AddressDTO response = client.toBlocking().retrieve(request, AddressDTO.class);

		assertEquals(STATE, response.getState());
		assertEquals(ZIP_CODE, response.getZipCode());
		assertEquals(CITY, response.getCity());
	}

	@MockBean(AddressServiceImpl.class)
	AddressService addressService() {
		return mock(AddressService.class);
	}
}
