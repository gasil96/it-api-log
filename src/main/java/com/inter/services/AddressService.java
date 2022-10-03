package com.inter.services;

import com.inter.dtos.AddressDTO;

public interface AddressService {

	AddressDTO getAddressByZipCode(String zipCode);

}
