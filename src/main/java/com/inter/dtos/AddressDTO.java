package com.inter.dtos;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Introspected
public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 412461865937312815L;

	private String zipCode;
	private String street;
	private String complement;
	private String district;
	private String city;
	private String state;

}
