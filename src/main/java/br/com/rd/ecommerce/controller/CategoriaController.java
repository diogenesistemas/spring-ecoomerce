package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping("/categoria")
    public Categoria save(@RequestBody Categoria categoria) {
        return repository.save(categoria);
    }

    //Mais de um parametro coloca uma barra e coloca o proximo parametro / Necessita de tratamento variavel obrigatoria
    @GetMapping("/categoria/{idCategoria}")
    public Categoria findById(@PathVariable("idCategoria") Long idCategoria) {
        return repository.findById(idCategoria).get();
    }

    //Parametro opicional
    @GetMapping("/categoria")
    public Categoria findCategoriaById(@PathParam("id") Long id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

//

    //Put alterar todos os campos, Patch alterar alguns apenas

        /*
    @PutMapping("/categoria")
    public ResponseEntity<Categoria >alterar(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
        categoriaEntity.setDescricao(categoria.getDescricao());
        Categoria categoriaAtualizada = repository.save(categoriaEntity);
        return ResponseEntity.ok().body(categoriaAtualizada);
    }
      */

    @PutMapping("/categoria")
    public Categoria alterar(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return repository.save(categoriaEntity);
    }


    @PatchMapping("/categoria")
    public Categoria alteraCamposEspecificos(@RequestBody Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return repository.save(categoriaEntity);
    }



}
