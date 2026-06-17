package com.Loja.xBrain.service;

import com.Loja.xBrain.dto.Relatorio;
import com.Loja.xBrain.model.VendaModel;
import com.Loja.xBrain.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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

        long totalDias = java.time.temporal.ChronoUnit.DAYS.between(inicio,fim) +1;
        if (totalDias<=0) totalDias = 1;

        for (VendaModel venda : todasVendas) {
            LocalDate dataVenda = venda.getDataVenda();

            if (!dataVenda.isBefore(inicio) && !dataVenda.isAfter(fim)){
                String nomeVendedor = venda.getNomeVendedor();
                double valorVenda = venda.getValorVenda();
                boolean vendedorExiteNaLista= false;

                for (Relatorio r:  resultado) {
                    if (r.getNome().equals(nomeVendedor)){
                        r.setValorTotal(r.getValorTotal()+ valorVenda);
                        vendedorExiteNaLista = true;
                        break;
                    }
                }
                if (!vendedorExiteNaLista){
                    Relatorio novoRelatorio = new Relatorio(nomeVendedor, valorVenda, 0.0);
                    resultado.add(novoRelatorio);
                }
            }
        }
        for (Relatorio r : resultado) {
            double media = r.getValorTotal() / totalDias;
            r.setMediaVendasDiarias(media);
        }
        return resultado;
    }

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

    public VendaModel editarVenda(VendaModel venda, Long id){

        if(id == null){
            throw new IllegalArgumentException("Você deve informar um Id valido");
        }

        VendaModel vendaBanco = vendaRepository.findById(id).orElse(null);

        if(vendaBanco == null){
            throw new IllegalArgumentException("Venda inexistente");
        }

        if(venda.getValorVenda() > 0){
            vendaBanco.setValorVenda(venda.getValorVenda());
        }

        if(venda.getDataVenda() != null){
            vendaBanco.setDataVenda(venda.getDataVenda());
        }

        return vendaRepository.save(vendaBanco);
    }

    public void deletarVenda(Long id){
        if(vendaRepository.existsById(id)){
            vendaRepository.deleteById(id);
        }else{
            throw new IllegalArgumentException("Não existe venda cadastrada com esse id informado");
        }
    }
}
