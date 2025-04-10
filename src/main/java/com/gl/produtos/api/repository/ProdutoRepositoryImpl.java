package com.gl.produtos.api.repository;

import com.gl.produtos.api.models.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class ProdutoRepositoryImpl implements ProdutoRepositoryCustom {


    @PersistenceContext()
    private EntityManager entityManager;

    public ProdutoRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public List<Produto> buscarProdutosPorIntervaloPreco(Double precoMinimo, Double precoMaximo) {
        String sql = "SELECT p FROM Produto p WHERE p.preco BETWEEN :precoMinimo AND :precoMaximo";

        TypedQuery<Produto> query = entityManager.createQuery(sql, Produto.class);
        query.setParameter("precoMinimo", precoMinimo);
        query.setParameter("precoMaximo", precoMaximo);
        return query.getResultList();
    }
}
