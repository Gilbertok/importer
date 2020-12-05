package com.funsoft.importer.facade;

import com.funsoft.importer.model.Vendedor;

public class VendedorFacade {

	public Vendedor parse(String[] objeto) {
		Vendedor vendedor = new Vendedor();
		vendedor.setCpf(objeto[1]);
		vendedor.setNome(objeto[2]);
		vendedor.setSalario(objeto[3]);
		return vendedor;
	}

}
