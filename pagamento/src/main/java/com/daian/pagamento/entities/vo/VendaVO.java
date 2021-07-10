package com.daian.pagamento.entities.vo;

import com.daian.pagamento.entities.Venda;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonPropertyOrder({"id","data","produtos","valorTotal"})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VendaVO extends RepresentationModel<VendaVO> implements Serializable {

    private static final long serialVersionUID = -7334701345685781346L;

    @JsonProperty("id")
    private Long id;

    @JsonProperty("data")
    private Date data;

    @JsonProperty("produtos")
    private List<ProdutoVendaVO> produtos;

    @JsonProperty("valorTotal")
    private Double valorTotal;

    public static VendaVO create(Venda venda) {
        return new ModelMapper().map(venda, VendaVO.class);
    }
}
