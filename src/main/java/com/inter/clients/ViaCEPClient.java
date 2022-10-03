package com.inter.clients;

import com.inter.clients.dtos.AddressDTOClient;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.client.annotation.Client;

@Client("${integration.viacep.url}")
public interface ViaCEPClient {

	@Get("/ws/{cep}/json")
	AddressDTOClient getAddressByCEP(@PathVariable("cep") String cep);

}
