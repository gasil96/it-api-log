package com.inter.services;

import com.inter.clients.ViaCEPClient;
import com.inter.dtos.AddressDTO;
import com.inter.mappers.AddressMapper;
import jakarta.inject.Singleton;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

	private final ViaCEPClient viaCEPClient;
	private final AddressMapper addressMapper;

	@Override
	public AddressDTO getAddressByZipCode(String zipCode) {
		AddressDTO addressDTO = addressMapper.toDTO(viaCEPClient.getAddressByCEP(zipCode));

		log.info("AddressServiceImpl.getAddressByZipCode - success - {}", zipCode);
		return addressDTO;
	}

}
