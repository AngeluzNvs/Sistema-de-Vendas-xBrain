package com.Loja.xBrain.service;

import com.Loja.xBrain.dto.Relatorio;
import com.Loja.xBrain.dto.VendaReq;
import com.Loja.xBrain.dto.VendaRes;
import com.Loja.xBrain.model.VendaModel;
import com.Loja.xBrain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Relatorio> gerarRelatorio(LocalDate inicio, LocalDate fim){

        List<VendaModel> todasVendas = vendaRepository.findAll();
        List<Relatorio> resultado = new ArrayList<>();

        long totalDias = java.time.temporal.ChronoUnit.DAYS.between(inicio, fim) + 1;

        if(totalDias <= 0){
            totalDias = 1;
        }

        for (VendaModel venda : todasVendas) {

            LocalDate dataVenda = venda.getDataVenda();

            if(!dataVenda.isBefore(inicio) && !dataVenda.isAfter(fim)){

                String nomeVendedor = venda.getNomeVendedor();
                double valorVenda = venda.getValorVenda();

                boolean vendedorExisteNaLista = false;

                for(Relatorio r : resultado){

                    if(r.getNome().equals(nomeVendedor)){
                        r.setValorTotal(r.getValorTotal() + valorVenda);
                        vendedorExisteNaLista = true;
                        break;
                    }
                }

                if(!vendedorExisteNaLista){
                    Relatorio novoRelatorio =
                            new Relatorio(nomeVendedor, valorVenda, 0.0);

                    resultado.add(novoRelatorio);
                }
            }
        }

        for(Relatorio r : resultado){
            double media = r.getValorTotal() / totalDias;
            r.setMediaVendasDiarias(media);
        }

        return resultado;
    }

    public VendaRes salvarVenda(VendaReq vendaReq){

        if(vendaReq.getValorVenda() <= 0){
            throw new IllegalArgumentException("O valor da venda deve ser maior que zero");
        }

        if(vendaReq.getIdVendedor() == null){
            throw new IllegalArgumentException("Você deve informar o id do vendedor");
        }

        VendaModel venda = new VendaModel();

        venda.setValorVenda(vendaReq.getValorVenda());
        venda.setDataVenda(vendaReq.getDataVenda());
        venda.setIdVendedor(vendaReq.getIdVendedor());

        if(venda.getDataVenda() == null){
            venda.setDataVenda(LocalDate.now());
        }

        VendaModel vendaSalva = vendaRepository.save(venda);

        VendaRes vendaRes = new VendaRes();

        vendaRes.setId(vendaSalva.getId());
        vendaRes.setValorVenda(vendaSalva.getValorVenda());
        vendaRes.setDataVenda(vendaSalva.getDataVenda());

        return vendaRes;
    }

    public VendaRes editarVenda(VendaReq vendaReq, Long id){

        if(id == null){
            throw new IllegalArgumentException("Você deve informar um id válido");
        }

        VendaModel vendaBanco = vendaRepository.findById(id).orElse(null);

        if(vendaBanco == null){
            throw new IllegalArgumentException("Venda inexistente");
        }

        if(vendaReq.getValorVenda() > 0){
            vendaBanco.setValorVenda(vendaReq.getValorVenda());
        }

        if(vendaReq.getDataVenda() != null){
            vendaBanco.setDataVenda(vendaReq.getDataVenda());
        }

        if(vendaReq.getIdVendedor() != null){
            vendaBanco.setIdVendedor(vendaReq.getIdVendedor());
        }

        VendaModel vendaAtualizada = vendaRepository.save(vendaBanco);

        VendaRes vendaRes = new VendaRes();

        vendaRes.setId(vendaAtualizada.getId());
        vendaRes.setValorVenda(vendaAtualizada.getValorVenda());
        vendaRes.setDataVenda(vendaAtualizada.getDataVenda());

        return vendaRes;
    }

    public void deletarVenda(Long id){

        if(id == null){
            throw new IllegalArgumentException("Você deve informar um id válido");
        }

        if(vendaRepository.existsById(id)){
            vendaRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Não existe venda cadastrada com esse id informado");
        }
    }
}