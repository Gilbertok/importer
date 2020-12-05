package com.funsoft.importer.facade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.funsoft.importer.model.Produto;
import com.funsoft.importer.utils.CommonUtils;

public class ProdutoFacade {

	
	public Produto parse(String[] objeto) {
		Produto produto = new Produto();
		produto.setIdProduto(objeto[0]);
		
		if (CommonUtils.isNotNull(objeto[1])) {
			Integer qtde = Integer.parseInt(objeto[1]);
			produto.setQuantidade(qtde);
		}
		if (CommonUtils.isNotNull(objeto[2])) {
			Double valorDouble = Double.parseDouble(objeto[2]);
			produto.setValor(BigDecimal.valueOf(valorDouble));
		}
		return produto;
	}
	
	
	public List<Produto> parseArray(String[] objetos) {
		List<Produto> produtos = new ArrayList<Produto>();
		for (String objeto : objetos) {
			String[] produto = objeto.split("-");
			produtos.add(parse(produto));
		}
		return produtos;
		
	}
}
