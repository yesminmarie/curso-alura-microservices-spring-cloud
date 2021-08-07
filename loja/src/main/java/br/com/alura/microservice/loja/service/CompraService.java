package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.controller.dto.InfoFornecedorDTO;

@Service
public class CompraService {
	
	@Autowired
	private RestTemplate client;

	public void realizaCompra(CompraDTO compra) {
		
		//método exchange retorna ResponseEntity do tipo InfoFornecedorDTO 
		//retorna as informações do fornecedor
		ResponseEntity<InfoFornecedorDTO> exchange =
		client.exchange("http://fornecedor/info/"+compra.getEndereco().getEstado(), 
				HttpMethod.GET, null, InfoFornecedorDTO.class); //pega o estado de destino da compra que é o estado do fornecedor
		
		//getBody() pega InfoFornecedorDTO
		System.out.println(exchange.getBody().getEndereco());
	}

}
