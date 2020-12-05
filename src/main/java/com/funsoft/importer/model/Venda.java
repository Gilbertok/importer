package com.funsoft.importer.model;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Venda {

//	formato - 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name 
	
	private String idPedido;
	private List<Produto> produtos;
	private String nomeVendedor;
	
}
