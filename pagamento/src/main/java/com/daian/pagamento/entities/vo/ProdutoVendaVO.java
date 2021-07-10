package com.daian.pagamento.entities.vo;

import com.daian.pagamento.entities.ProdutoVenda;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({ "id", "idProduto", "quantidade" })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoVendaVO extends RepresentationModel<ProdutoVendaVO> implements Serializable {

    private static final long serialVersionUID = 3277044024726131411L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("idProduto")
    private Long idProduto;

    @JsonProperty("quantidade")
    private Integer quantidade;

    public static ProdutoVendaVO create(ProdutoVenda produtoVenda) {
        return new ModelMapper().map(produtoVenda, ProdutoVendaVO.class);
    }

}

