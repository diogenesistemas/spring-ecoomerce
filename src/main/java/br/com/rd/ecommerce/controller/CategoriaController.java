package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping("/categoria")
    public Categoria save(@RequestBody Categoria categoria){
        return repository.save(categoria);
    }
    //Mais de um parametro coloca uma barra e coloca o proximo parametro / Necessita de tratamento variavel obrigatoria
    @GetMapping("/categoria/{idCategoria}")
    public Categoria findById(@PathVariable("idCategoria") Long idCategoria){
        return repository.findById(idCategoria).get();
    }

    //Parametro opicional
    @GetMapping("/categoria")
    public Categoria findCategoriaById(@PathParam("id") Long id){
        return  repository.findById(id).get();
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteById(@PathVariable("id") Long id){
        repository.deleteById(id);
    }
}
