package com.daian.pagamento.entities.vo;

import com.daian.pagamento.entities.Produto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

@JsonPropertyOrder({"id","estoque"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoVO extends RepresentationModel<ProdutoVO> implements Serializable {

    private static final long serialVersionUID = 2381588818700865098L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("estoque")
    private Integer estoque;

    public static ProdutoVO create(Produto produto) {
        return new ModelMapper().map(produto, ProdutoVO.class);
    }
}
