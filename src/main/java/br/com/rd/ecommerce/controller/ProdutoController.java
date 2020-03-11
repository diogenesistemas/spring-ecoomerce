package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Produto;
import br.com.rd.ecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
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
    public ResponseEntity<List<Produto>> buscarPorCodigoDescricao(@PathParam("id") Long id,
                                                            @PathParam("descricao") String descricao) {
        List<Produto> produto = new ArrayList<>();
        if (id != null && descricao != null)
            produto = repository.findByCodProdutoAndDescricao(id, descricao);
        else if (id != null)
           produto.add(repository.findById(id).get());
        else if (descricao != null)
           produto=  repository.findByDescricao(descricao);

        if(produto != null && produto.size()>0){
            return ResponseEntity.ok().body(produto);
        }else{
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/produto/{id}")
    public void excluirProduto(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

//    @DeleteMapping("/produto")
//    public void excluirProduto(@RequestBody Produto produto) {
//        repository.delete(produto);
//    }

    @PutMapping("/produto")
    public Produto alterar(@RequestBody Produto produto) {
        Produto produtoEntity = repository.getOne(produto.getCodProduto());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setVlProduto(produto.getVlProduto());
        produto.setCategoria(produto.getCategoria());
        return repository.save(produtoEntity);

    }

}
