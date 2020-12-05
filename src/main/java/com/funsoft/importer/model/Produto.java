package com.funsoft.importer.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class Produto {
	
//	formato - Item ID-Item Quantity-Item Price
	
	private String idProduto;
	private Integer quantidade;
	private BigDecimal valor;

}
