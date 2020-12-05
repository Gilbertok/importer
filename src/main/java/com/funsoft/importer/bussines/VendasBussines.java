package com.funsoft.importer.bussines;

import java.math.BigDecimal;

import com.funsoft.importer.model.DadosVendas;
import com.funsoft.importer.model.Produto;
import com.funsoft.importer.model.Venda;

public class VendasBussines {
	
	public Integer getQuantidadeDeClientes(DadosVendas dadoArquivo) {
		return Math.toIntExact(dadoArquivo.getClientes().stream().count());
	}
	
	public Integer getQuantidadeDeVendedores(DadosVendas dadoArquivo) {
		return Math.toIntExact(dadoArquivo.getVendedores().stream().count());
	}
	
	public String getIdMaiorVendaValor(DadosVendas dadoArquivo) {
		String idMaiorvenda = null;
		BigDecimal valorMaiorVenda = BigDecimal.ZERO;
		for (Venda venda : dadoArquivo.getVendas()) {
			BigDecimal valorTotalVenda = calculaValorVenda(venda);
			if (valorMaiorVenda.compareTo(valorTotalVenda) <= 0) {
				idMaiorvenda = venda.getIdPedido();
				valorMaiorVenda = valorTotalVenda;
			}
		}
		return idMaiorvenda;
	}
	
	public String getNomeVendedorMenorVendaValor(DadosVendas dadoArquivo) {
		String nomeVendedor = null;
		BigDecimal valorMenorVenda = BigDecimal.ZERO;
		for (Venda venda : dadoArquivo.getVendas()) {
			BigDecimal valorTotalVenda = calculaValorVenda(venda);
			if (valorMenorVenda.compareTo(BigDecimal.ZERO) <=0 || valorMenorVenda.compareTo(valorTotalVenda) >= 0) {
				nomeVendedor = venda.getNomeVendedor();
				valorMenorVenda = valorTotalVenda;
			}
		}
		return nomeVendedor;
	}
	
	private BigDecimal calculaValorVenda(Venda venda) {
		BigDecimal valorTotalVenda = BigDecimal.ZERO;
		for (Produto produto : venda.getProdutos()) {
			BigDecimal valorProduto = BigDecimal.valueOf(produto.getQuantidade()).multiply(produto.getValor());
			valorTotalVenda = valorTotalVenda.add(valorProduto);
		}
		return valorTotalVenda;
	}

}
