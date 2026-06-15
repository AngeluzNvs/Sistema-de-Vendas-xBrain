package com.Loja.xBrain.controller;

import com.Loja.xBrain.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;
}
