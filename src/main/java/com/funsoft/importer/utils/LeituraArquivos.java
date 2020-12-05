package com.funsoft.importer.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.funsoft.importer.facade.ClienteFacade;
import com.funsoft.importer.facade.VendasFacade;
import com.funsoft.importer.facade.VendedorFacade;
import com.funsoft.importer.model.DadosVendas;

public class LeituraArquivos {
	
	public List<DadosVendas> lerArquivosEntrada() throws IOException {
		List<DadosVendas> dados = new ArrayList<>();
		File diretorio = new File("/data/in");
		if (!diretorio.exists()) {
			diretorio.mkdirs();
		} else {
			File[] arquivos = getArquivosDat(diretorio);
			for (File file : arquivos) {
				DadosVendas dadosArquivo = new DadosVendas(file.getName());
				VendedorFacade vendedorFacade = new VendedorFacade();
				ClienteFacade clienteFacade = new ClienteFacade();
				VendasFacade vendasFacade = new VendasFacade();
				FileReader arq = new FileReader(file.getAbsolutePath());
			    BufferedReader lerArq = new BufferedReader(arq);
			    String linha = lerArq.readLine();
			    while (linha != null){
			        String[] objeto = linha.split("ç");
					if (CommonUtils.isNotEmpty(objeto)) {
						switch (objeto[0]) {
						case "001":
							dadosArquivo.getVendedores().add(vendedorFacade.parse(objeto));
							break;
						case "002":
							dadosArquivo.getClientes().add(clienteFacade.parse(objeto));
							break;
						case "003":
							dadosArquivo.getVendas().add(vendasFacade.parse(objeto));
							break;
						default:
							break;
						}
					};
					linha = lerArq.readLine();
			    }
			    arq.close();
			    dados.add(dadosArquivo);
			}
		}
		return dados;
	}
	
	private File[] getArquivosDat(File diretorio) {
		return diretorio.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".dat");
		    }
		});
	}
	
}
