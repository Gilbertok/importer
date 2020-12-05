package com.funsoft.importer.facade;

import java.util.List;

import com.funsoft.importer.model.Produto;
import com.funsoft.importer.model.Venda;

public class VendasFacade {
	
	public Venda parse(String[] objeto) {
		Venda vendas = new Venda();
		vendas.setIdPedido(objeto[1]);
		String[] objetoProdutos = objeto[2].replaceAll("[\\[\\](){}]", "").split(",");
		List<Produto> produtos = new ProdutoFacade().parseArray(objetoProdutos);
		vendas.setProdutos(produtos);
		vendas.setNomeVendedor(objeto[3]);
		return vendas;
	}

}
