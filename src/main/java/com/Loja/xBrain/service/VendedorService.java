package com.Loja.xBrain.service;

import com.Loja.xBrain.dto.VendedorReq;
import com.Loja.xBrain.dto.VendedorRes;
import com.Loja.xBrain.model.VendaModel;
import com.Loja.xBrain.model.VendedorModel;
import com.Loja.xBrain.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service

public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<VendedorRes>  listarVendedores(){
        return vendedorRepository.findAll().stream()
                .map(vendedorM -> new VendedorRes(vendedorM.getId(), vendedorM.getNome())).toList();
    }

    public void criarVendedor(VendedorReq vendedorReq){
       if (vendedorReq.getNome() == null || vendedorReq.getNome().trim().isEmpty()){
           throw new IllegalArgumentException("Você deve informar o nome do vendedor");
       }
       VendedorModel vendedorModel = new VendedorModel();
       vendedorModel.setNome(vendedorReq.getNome());

       vendedorRepository.save(vendedorModel);
    }

    public void editarVendedor(VendedorReq vendedorReq, Long id){
           if (vendedorReq.getNome() == null || vendedorReq.getNome().trim().isEmpty()){
               throw new IllegalArgumentException("Você deve informar um nome valido");
           }
           if (id==null){
               throw new IllegalArgumentException("Você deve informar é um Id valido");
           }
            VendedorModel vendedor= vendedorRepository.findById(id).get();
            vendedor.setNome(vendedorReq.getNome());
            vendedorRepository.save(vendedor);
    }

    public void deletarVendedor( Long id){
        vendedorRepository.deleteById(id);
    }
}
