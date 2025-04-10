package com.gl.produtos.api.repository;

import com.gl.produtos.api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>, ProdutoRepositoryCustom {}
