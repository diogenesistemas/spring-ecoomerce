package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Produto;
import br.com.rd.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping("/produto")
    public Produto salvar(@RequestBody Produto produto) {
        return repository.save(produto);
    }

    @GetMapping("/produto")
    public ResponseEntity<Produto> buscarPorCodigoDescricao(@PathParam("id") Long id,
                                                            @PathParam("descricao") String descricao) {
        if (id != null && descricao != null)
            return ResponseEntity.ok().body(repository.findByCodProdutoAndDescricao(id, descricao).get(0));
        else if (id != null)
            return ResponseEntity.ok().body(repository.findById(id).get());
        else if (descricao != null)
            return ResponseEntity.ok().body(repository.findByDescricao(descricao).get(0));
        else
            return ResponseEntity.badRequest().build();

    }

    @DeleteMapping("/produto/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

    @PutMapping("/produto")
    public Produto alterar(@RequestBody Produto produto) {
        Produto produtoEntity = repository.getOne(produto.getCodProduto());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setVlProduto(produto.getVlProduto());
        produto.setCategoria(produto.getCategoria());
        return repository.save(produtoEntity);

    }

}
