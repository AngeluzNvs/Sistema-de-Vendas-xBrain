package com.Loja.xBrain.controller;

import com.Loja.xBrain.dto.Relatorio;
import com.Loja.xBrain.model.VendaModel;
import com.Loja.xBrain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @GetMapping("/relatorio")
    public List<Relatorio> obterRelatorio(@RequestParam("inicio") LocalDate inicio, @RequestParam("fim") LocalDate fim){
        return vendaService.gerarRelatorio(inicio, fim);
    }

    @PostMapping
    public VendaModel criarVenda(@RequestBody VendaModel venda){
        return vendaService.salvarVenda(venda);
    }

    @PutMapping("{id}")
    public void editarVenda(@RequestBody VendaModel venda, @PathVariable Long id){
        vendaService.editarVenda(venda,id);
    }

    @DeleteMapping("{id}")
    public void deletarVenda(@PathVariable Long id){
        vendaService.deletarVenda(id);
    }

}
