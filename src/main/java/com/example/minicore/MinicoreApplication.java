package com.example.minicore;

import com.example.minicore.modelo.Regla;
import com.example.minicore.modelo.Vendedor;
import com.example.minicore.modelo.Venta;
import com.example.minicore.repositorio.ReglaRepository;
import com.example.minicore.repositorio.VendedorRepository;
import com.example.minicore.repositorio.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class MinicoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinicoreApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(
			VendedorRepository vendedorRepo,
			VentaRepository ventaRepo,
			ReglaRepository reglaRepo) {
		return args -> {

			vendedorRepo.saveAll(List.of(
					new Vendedor(1L, "Andres Sanchez"),
					new Vendedor(2L, "Manuel Endara"),
					new Vendedor(3L, "Michael Estrada"),
					new Vendedor(4L, "Miguel Sancho")
			));


			reglaRepo.saveAll(List.of(
					new Regla(1L, 0.06, 600),
					new Regla(2L, 0.08, 500),
					new Regla(3L, 0.10, 800),
					new Regla(4L, 1.15, 1000)
			));

			ventaRepo.saveAll(List.of(
					new Venta(null, LocalDate.of(2025, 5, 21), 400, vendedorRepo.getById(1L)),
					new Venta(null, LocalDate.of(2025, 5, 29), 600, vendedorRepo.getById(2L)),
					new Venta(null, LocalDate.of(2025, 6, 3), 200, vendedorRepo.getById(2L)),
					new Venta(null, LocalDate.of(2025, 6, 9), 300, vendedorRepo.getById(1L)),
					new Venta(null, LocalDate.of(2025, 6, 11), 500, vendedorRepo.getById(1L)),
					new Venta(null, LocalDate.of(2025, 6, 26), 500, vendedorRepo.getById(3L)),
					new Venta(null, LocalDate.of(2025, 6, 30), 300, vendedorRepo.getById(4L))
			));
		};
	}
}
