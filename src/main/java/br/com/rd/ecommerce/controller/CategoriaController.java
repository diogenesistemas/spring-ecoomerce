package br.com.rd.ecommerce.controller;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping("/categoria")
    public Categoria save(@RequestBody Categoria categoria){
        return repository.save(categoria);

    }
}
