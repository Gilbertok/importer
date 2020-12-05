package com.funsoft.importer.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.funsoft.importer.bussines.VendasBussines;
import com.funsoft.importer.model.DadosVendas;

public class GeracaoDeArquivo {

	private List<DadosVendas> dados;
	
	public GeracaoDeArquivo(List<DadosVendas> dados) {
		this.dados = dados;
	}

	public void gerarArquivo() throws IOException {
		File diretorio = new File("/data/out");
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		}
		
		dados.forEach((dadoArquivo) -> {
			VendasBussines venda = new VendasBussines();
			File arquivo = new File("/data/out/"+dadoArquivo.getNomeArquivo()+".done.dat");
			Integer qtdeClientes = venda.getQuantidadeDeClientes(dadoArquivo);
			Integer qtdeVendedor = venda.getQuantidadeDeVendedores(dadoArquivo);
			String idMaiorvenda = venda.getIdMaiorVendaValor(dadoArquivo);
			String nomePiorVendedor = venda.getNomeVendedorMenorVendaValor(dadoArquivo);
			try {
				arquivo.createNewFile();
				FileWriter file = new FileWriter(arquivo);
				BufferedWriter buf = new BufferedWriter(file);
				buf.write(qtdeClientes+"ç"+qtdeVendedor+"ç"+idMaiorvenda+"ç"+nomePiorVendedor);
				buf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		
	}

}
