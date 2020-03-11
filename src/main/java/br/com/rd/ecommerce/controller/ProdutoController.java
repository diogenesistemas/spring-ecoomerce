package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Produto;
import br.com.rd.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping("/produto")
    public Produto salvar(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @GetMapping("/produto/{id}")
    public Produto buscarPorId(@PathVariable("id") Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/produto/{descricao}")
    public List<Produto> buscarPorDescricao(@PathVariable("descricao") String descricao){
        return repository.findByDescricao(descricao);
    }

    @DeleteMapping("/produto/{id}")
    public void deleteById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }

    @PutMapping("/produto")
    public Produto alterar(@RequestBody Produto produto){
        Produto produtoEntity = repository.getOne(produto.getCodProduto());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setVlProduto(produto.getVlProduto());
        produto.setCategoria(produto.getCategoria());
        return repository.save(produtoEntity);

    }

}
