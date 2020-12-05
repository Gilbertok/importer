package com.funsoft.importer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Cliente {
	
//	formato - 002çCNPJçNameçBusiness Area 
	
	private String cnpj;
	private String nome;
	private String areaNegocios;

}
