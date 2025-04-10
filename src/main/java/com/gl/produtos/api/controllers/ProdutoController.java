package com.gl.produtos.api.controllers;


import com.gl.produtos.api.models.Produto;
import com.gl.produtos.api.repository.ProdutoRepository;
import com.gl.produtos.api.services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/salvar-produto")
    public String SalvarProduto(@RequestBody Produto produto) {
        try {
            produtoService.salvarProduto(produto);
            return "Produto salvo com sucesso!";
        } catch (Exception e) {
            return "Erro ao salvar o produto: " + e.getMessage();
        }
    }

    @GetMapping("/buscar-produto/")
    public List<Produto> BuscarProdutos() {
        try {
            return produtoService.buscarTodosProdutos();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar produtos: " + e.getMessage());
        }
    }

    @GetMapping("/buscar-produto/{id}")
    public Produto BuscarProduto(@PathVariable Integer id) {
        try {
            return produtoService.buscarProdutoPorId(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto: " + e.getMessage());
        }
    }

    @DeleteMapping("/deletar-produto/{id}")
    public String DeletarProduto(@PathVariable Integer id) {
        try {
            produtoService.deletarProduto(id);
            return "Produto deletado com sucesso!";
        } catch (Exception e) {
            return "Erro ao deletar o produto: " + e.getMessage();
        }
    }

    @PutMapping("/atualizar-produto")
    public Produto AtualizarProduto(@RequestBody Produto produto) {
        try {
            return produtoService.atualizarProduto(produto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar produto: " + e.getMessage());
        }
    }






}
