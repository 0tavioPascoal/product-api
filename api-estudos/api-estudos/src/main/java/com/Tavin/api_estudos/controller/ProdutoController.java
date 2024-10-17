package com.Tavin.api_estudos.controller;

import com.Tavin.api_estudos.Repository.Produtorepository;
import com.Tavin.api_estudos.model.Produto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private Produtorepository produtorepository;

    public ProdutoController (Produtorepository produtorepository) {
        this.produtorepository = produtorepository;
    }
    @PostMapping
    public Produto save(@RequestBody Produto produto) {
        System.out.println("Produto: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtorepository.save(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto findById(@PathVariable String id){
       return produtorepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
  public void deleteById(@PathVariable String id){
         produtorepository.deleteById(id);
  }

  @PutMapping("{id}")
    public void update(@PathVariable String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtorepository.save(produto);
  }

  @GetMapping
    public List<Produto> findbyParams(@RequestParam("name") String name){
      return produtorepository.findByName(name);
   }

}