package com.daian.crud.entities.vo;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.daian.crud.entities.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonPropertyOrder({ "ìd", "nome", "estoque", "preco" })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoVO extends RepresentationModel<ProdutoVO>  implements Serializable {

	private static final long serialVersionUID = -5989121854545214474L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("estoque")
	private Integer estoque;

	@JsonProperty("preco")
	private Double preco;

	public static ProdutoVO create(Produto produto) {
		return new ModelMapper().map(produto, ProdutoVO.class);
	}
}
