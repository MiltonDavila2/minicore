package com.example.minicore.repositorio;

import com.example.minicore.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface VentaRepository extends JpaRepository<Venta,Long> {
    @Query("SELECT v.vendedor.id, SUM(v.cantidad) FROM Venta v WHERE v.fecha BETWEEN :start AND :end GROUP BY v.vendedor.id")
    List<Object[]> sumarVentasPorVendedorEnRango(@Param("start") LocalDate start, @Param("end") LocalDate end);
}

