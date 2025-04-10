package com.gl.produtos.api.services;


import com.gl.produtos.api.models.Produto;
import com.gl.produtos.api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto buscarProdutoPorId(Integer id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public void deletarProduto(Integer id) throws Exception {

        Produto produtoExistente = produtoRepository.findById(id).orElse(null);

        if(produtoExistente == null) {
            throw new Exception("Produto não encontrado");
        }
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Produto produto) throws Exception {

        Produto produtoExistente = produtoRepository.findById(produto.getId()).orElse(null);

        if(produtoExistente == null) {
            throw new Exception("Produto não encontrado");
        }
        return produtoRepository.save(produto);
    }

    public List<Produto> buscarProdutosPorIntervaloPreco(Double precoMinimo, Double precoMaximo) {
        return produtoRepository.buscarProdutosPorIntervaloPreco(precoMinimo, precoMaximo);
    }

}
