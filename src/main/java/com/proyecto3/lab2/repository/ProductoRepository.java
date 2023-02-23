package com.proyecto3.lab2.repository;

import com.proyecto3.lab2.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepository extends JpaRepository <Producto, Integer> {

    @Query("select c from Producto c where c.nombre like %?1%")
    List<Producto> findByProductoName(String nombre);
}
