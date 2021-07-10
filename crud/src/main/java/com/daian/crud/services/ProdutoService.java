package com.daian.crud.services;

import java.util.Optional;

import com.daian.crud.messages.ProdutoSendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.daian.crud.entities.vo.ProdutoVO;
import com.daian.crud.entities.Produto;
import com.daian.crud.exceptions.ResourceNotFoundException;
import com.daian.crud.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	private final ProdutoSendMessage produtoSendMessage;

	@Autowired
	public ProdutoService(ProdutoRepository produtoRepository, ProdutoSendMessage produtoSendMessage) {

		this.produtoRepository = produtoRepository;
		this.produtoSendMessage = produtoSendMessage;
	}

	public ProdutoVO create(ProdutoVO produtoVO) {

		ProdutoVO result = ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));

		produtoSendMessage.sendMessage(result);//adiciona o evento no rabbitmq

		return result;
	}

	public Page<ProdutoVO> findAll(Pageable pageable) {
		var page = produtoRepository.findAll(pageable);

		return page.map(this::convertToProdutoVO);
	}

	public ProdutoVO findById(Long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));

		return ProdutoVO.create(entity);
	}

	public ProdutoVO update(ProdutoVO produtoVO) {
		
		final Optional<Produto> optionalProduto = produtoRepository.findById(produtoVO.getId());

		if (!optionalProduto.isPresent()) {
			throw new ResourceNotFoundException("No Records found for this ID");
		}

		return ProdutoVO.create(produtoRepository.save(Produto.create(produtoVO)));
	}
	
	public void delete(Long id) {
		var entity = produtoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Records found for this ID"));

		produtoRepository.delete(entity);
	}

	private ProdutoVO convertToProdutoVO(Produto produto) {
		return ProdutoVO.create(produto);
	}

}
