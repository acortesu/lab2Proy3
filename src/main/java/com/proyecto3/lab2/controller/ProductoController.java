package com.proyecto3.lab2.controller;

import com.proyecto3.lab2.entity.Producto;
import com.proyecto3.lab2.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProductoController {

    @Autowired
    ProductoRepository productoRepository;

    //Get all
    @GetMapping("productos")
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    //Get by id
    @GetMapping("productos/{id}")
    public Optional<Producto> getProducto(@PathVariable(value = "id") Integer id) {
        return productoRepository.findById(id);
    }

    //Post
    @PostMapping("producto")
    public Producto addProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    //Put
    @PutMapping("producto/{id}")
    public ResponseEntity<Producto> updateProducto(@PathVariable(value = "id") Integer id, @RequestBody Producto productoUpdate ){
        Optional<Producto> producto = productoRepository.findById(id);
        producto.get().setNombre(productoUpdate.getNombre());
        producto.get().setDescripcion(productoUpdate.getDescripcion());
        producto.get().setCantidad(productoUpdate.getCantidad());
        producto.get().setPrecio(productoUpdate.getPrecio());

        Producto updatedEstudiate = productoRepository.save(producto.get());

        return ResponseEntity.ok(updatedEstudiate);
    }

    //Delete
    @DeleteMapping("productos/{id}")
    public ResponseEntity <?> deleteProducto(@PathVariable(value = "id") Integer id) {
        productoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //Personalized Query
    @GetMapping("producto/{nombre}")
    public List<Producto> getProductoPorNombre(@PathVariable(value = "nombre") String nombre) {
        return productoRepository.findByProductoName(nombre);
}

}
