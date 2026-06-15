package com.Loja.xBrain.service;

import com.Loja.xBrain.model.VendaModel;
import com.Loja.xBrain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public VendaModel salvarVenda(VendaModel venda){
        if (venda.getNomeVendedor()==null || venda.getNomeVendedor().trim().isEmpty()){
            throw new IllegalArgumentException("Você deve informar o nome do vendedor");
        }
        if (venda.getValorVenda()<=0){
            throw new IllegalArgumentException("O valor da venda é maior do que zero");
        }
        if (venda.getDataVenda() == null){
            venda.setDataVenda(LocalDate.now());
        }

        return vendaRepository.save(venda);
    }

}
