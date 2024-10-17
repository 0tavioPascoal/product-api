package com.Tavin.api_estudos.Repository;

import com.Tavin.api_estudos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Produtorepository extends JpaRepository<Produto, String> {

     List<Produto> findByName(String nome);
}
