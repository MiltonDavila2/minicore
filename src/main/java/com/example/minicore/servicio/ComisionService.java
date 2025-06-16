package com.example.minicore.servicio;

import com.example.minicore.modelo.Regla;
import com.example.minicore.modelo.Vendedor;
import com.example.minicore.repositorio.ReglaRepository;
import com.example.minicore.repositorio.VendedorRepository;
import com.example.minicore.repositorio.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ComisionService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ReglaRepository reglaRepository;

    public Map<String, Double> calcularComisiones(LocalDate desde, LocalDate hasta){
        Map<String, Double> resultados = new LinkedHashMap<>();
        List<Object[]> sumas = ventaRepository.sumarVentasPorVendedorEnRango(desde,hasta);
        List<Regla> reglas = reglaRepository.findAll();

        for(Object[] fila: sumas){
            Long vendedorId=(Long) fila[0];
            Double totalVentas=(Double) fila[1];

            Vendedor vendedor= vendedorRepository.findById(vendedorId).orElse(null);
            if(vendedor==null) continue;

            double comision=0;

            for(Regla regla:reglas){
                if(totalVentas.equals(regla.getMonto())){
                    comision=totalVentas*regla.getPorcentaje();
                    break;
                }
            }

            resultados.put(vendedor.getNombre(), comision);
        }

        vendedorRepository.findAll().forEach(v->resultados.putIfAbsent(v.getNombre(),0.0));

        return resultados;
    }
}
