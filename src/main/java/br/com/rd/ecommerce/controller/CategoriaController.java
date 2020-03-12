package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class CategoriaController {
//    @Autowired
//    private CategoriaService service;
//
//    @PostMapping("/categoria")
//    public ResponseEntity salvar(@RequestBody Categoria categoria) {
//        return service.salvar(categoria);
//    }
//
//    //Mais de um parametro coloca uma barra e coloca o proximo parametro / Necessita de tratamento variavel obrigatoria
//    @GetMapping("/categoria/{idCategoria}")
//    public ResponseEntity buscaPorId(@PathVariable("idCategoria") Long idCategoria) {
//        return service.buscaPorId(idCategoria);
//    }
//
//    //Parametro opicional
//    @GetMapping("/categoria")
//    public ResponseEntity findCategoriaById(@PathParam("id") Long id) {
//        return service.findCategoriaById(id);
//    }
//
//    @DeleteMapping("/categoria/{id}")
//    public void deleteById(@PathVariable("id") Long id) {
//        service.deleteById(id);
//    }
//
////
//
//    //Put alterar todos os campos, Patch alterar alguns apenas
//
//        /*
//    @PutMapping("/categoria")
//    public ResponseEntity<Categoria >alterar(@RequestBody Categoria categoria) {
//        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
//        categoriaEntity.setDescricao(categoria.getDescricao());
//        Categoria categoriaAtualizada = repository.save(categoriaEntity);
//        return ResponseEntity.ok().body(categoriaAtualizada);
//    }
//      */
//
//    @PutMapping("/categoria")
//    public ResponseEntity alterar(@RequestBody Categoria categoria) {
//        Categoria categoriaEntity = service.alterar(categoria.getCodigo());
//        categoriaEntity.setDescricao(categoria.getDescricao());
//        return service.alterar(categoriaEntity);
//    }
//
//
//    @PatchMapping("/categoria")
//    public ResponseEntity alteraCamposEspecificos(@RequestBody Categoria categoria) {
//        Categoria categoriaEntity = service.getOne(categoria.getCodigo());
//        categoriaEntity.setDescricao(categoria.getDescricao());
//        return service.save(categoriaEntity);
//    }



}
