package com.funsoft.importer.facade;

import com.funsoft.importer.model.Cliente;

public class ClienteFacade {
	
	public Cliente parse(String[] objeto) {
		Cliente cliente = new Cliente();
		cliente.setCnpj(objeto[1]);
		cliente.setNome(objeto[2]);
		cliente.setAreaNegocios(objeto[3]);
		return cliente;
	}

}
