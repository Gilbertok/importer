package com.funsoft.importer.model;

import java.util.ArrayList;
import java.util.List;

import com.funsoft.importer.utils.CommonUtils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DadosVendas {
	
	private String nomeArquivo;
	private List<Vendedor> vendedores;
	private List<Cliente> clientes;
	private List<Venda> vendas;
	
	public DadosVendas() {
		this.vendedores = new ArrayList<Vendedor>();
		this.clientes = new ArrayList<Cliente>();
		this.vendas = new ArrayList<Venda>();
	}

	public DadosVendas(String nomeArquivo) {
		this();
		this.nomeArquivo = nomeArquivo;
	}
	
	public String getNomeArquivo() {
		if (CommonUtils.isNotNull(nomeArquivo)) {
			nomeArquivo = nomeArquivo.replace(".dat", "");
		}
		return nomeArquivo;
	}
	
}
