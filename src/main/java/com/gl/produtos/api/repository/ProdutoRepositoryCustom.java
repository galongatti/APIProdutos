package com.gl.produtos.api.repository;
import com.gl.produtos.api.models.Produto;
import java.util.List;

public interface ProdutoRepositoryCustom {

    List<Produto> buscarProdutosPorIntervaloPreco(Double precoMinimo, Double precoMaximo);
}
