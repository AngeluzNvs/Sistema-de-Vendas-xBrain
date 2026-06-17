package com.Loja.xBrain.controller;

import com.Loja.xBrain.dto.Relatorio;
import com.Loja.xBrain.dto.VendaReq;
import com.Loja.xBrain.dto.VendaRes;
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
    public VendaRes criarVenda(@RequestBody VendaReq vendaReq){
        return vendaService.salvarVenda(vendaReq);
    }

    @PutMapping("{id}")
    public VendaRes editarVenda(@RequestBody VendaReq vendaReq, @PathVariable Long id){
        return vendaService.editarVenda(vendaReq, id);
    }

    @DeleteMapping("{id}")
    public void deletarVenda(@PathVariable Long id){
        vendaService.deletarVenda(id);
    }

}
