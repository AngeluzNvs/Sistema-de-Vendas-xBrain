package com.Loja.xBrain.controller;

import com.Loja.xBrain.dto.VendedorReq;
import com.Loja.xBrain.dto.VendedorRes;
import com.Loja.xBrain.model.VendedorModel;
import com.Loja.xBrain.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public List<VendedorRes> listarVendedores(){
        return vendedorService.listarVendedores();
    }

    @PostMapping
    public void criarVendedor(@RequestBody VendedorReq vendedor){
        vendedorService.criarVendedor(vendedor);
    }

    @PutMapping("{id}")
    public void editarVendedor(@RequestBody VendedorReq vendedor, @PathVariable Long id){
        vendedorService.editarVendedor(vendedor, id);
    }

    @DeleteMapping("{id}")
    public void deleteVendedor(@PathVariable Long id){
        vendedorService.deletarVendedor(id);
    }

}
