package br.com.rd.ecommerce.repository;

import br.com.rd.ecommerce.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByCodProdutoAndDescricao(Long codigo, String descricao);

    public List<Produto> findByDescricao(String descricao);
}
