package com.funsoft.importer.scheduled;

import java.io.IOException;
import java.util.List;

import com.funsoft.importer.model.DadosVendas;
import com.funsoft.importer.utils.GeracaoDeArquivo;
import com.funsoft.importer.utils.LeituraArquivos;

public class ExecutaImportacao {
	
	public void executa() {
		LeituraArquivos leitura = new LeituraArquivos();
		try {
			List<DadosVendas> dados = leitura.lerArquivosEntrada();
			GeracaoDeArquivo geracao = new GeracaoDeArquivo(dados);
			geracao.gerarArquivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		new ExecutaImportacao().executa();
	}

}
