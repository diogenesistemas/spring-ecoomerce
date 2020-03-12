package br.com.rd.ecommerce.service;

import br.com.rd.ecommerce.model.Categoria;
import br.com.rd.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("CategoriaService")
public class CategoriaService {

    @Autowired
    CategoriaRepository repository;

    public ResponseEntity salvar(Categoria categoria){
        return ResponseEntity.ok().body(repository.save(categoria));
    }

    public ResponseEntity buscaPorId(Long idCategoria) {
        return ResponseEntity.ok().body(repository.findById(idCategoria).get());
    }

    public ResponseEntity findCategoriaById(Long id) {
        return ResponseEntity.ok().body(repository.findById(id).get());
    }


    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public ResponseEntity alterar(Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return ResponseEntity.ok().body(repository.save(categoria));
    }



    public ResponseEntity alteraCamposEspecificos(Categoria categoria) {
        Categoria categoriaEntity = repository.getOne(categoria.getCodigo());
        categoriaEntity.setDescricao(categoria.getDescricao());
        return ResponseEntity.ok().body(repository.save(categoriaEntity));
    }
}
