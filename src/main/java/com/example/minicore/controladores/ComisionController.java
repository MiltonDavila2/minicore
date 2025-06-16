package com.example.minicore.controladores;

import com.example.minicore.servicio.ComisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Map;

@Controller
public class ComisionController {

    @Autowired
    private ComisionService comisionService;

    @GetMapping("/")
    public String formulario(Model model){
        model.addAttribute("resultado",null);
        return "comisiones";
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
                           @RequestParam("hasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta,
                           Model model) {
        Map<String, Double> resultado = comisionService.calcularComisiones(desde, hasta);
        model.addAttribute("resultado", resultado);
        return "comisiones";
    }
}
