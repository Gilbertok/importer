package com.funsoft.importer.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Vendedor {
	
//	formato - 001çCPFçNameçSalary 
	
	private String cpf;
	private String nome;
	private String salario;

}
