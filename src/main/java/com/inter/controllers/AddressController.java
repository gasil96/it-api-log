package com.inter.controllers;

import com.inter.dtos.AddressDTO;
import com.inter.services.AddressService;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Status;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@AllArgsConstructor
@Tag(name = "Address Management")
public class AddressController {

	private final AddressService addressService;

	@Operation(summary = "Get address by zipCode")
	@Get("/v1/addresses/{zipCode}")
	@Status(HttpStatus.OK)
	AddressDTO getAddressByZipCode(@PathVariable("zipCode") String zipCode) {
		AddressDTO addressDTO = addressService.getAddressByZipCode(zipCode);

		log.info("AddressController.getAddressByZipCode - success - {}", zipCode);
		return addressDTO;
	}

}
