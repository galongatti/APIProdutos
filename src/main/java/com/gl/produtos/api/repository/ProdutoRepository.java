package com.gl.produtos.api.repository;

import com.gl.produtos.api.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> { }
