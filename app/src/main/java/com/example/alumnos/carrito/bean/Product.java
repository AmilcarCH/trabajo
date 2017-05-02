package com.example.alumnos.carrito.bean;

/**
 * Created by Alumnos on 02/05/2017.
 */

public class Product {

    private Long codProduct;
    private String desProduct;
    private Integer cantidad;
    private Double precio;
    private Double total;


    public Product(Long codProduct, String desProduct, Integer cantidad, Double precio, Double total) {
        this.codProduct = codProduct;
        this.desProduct = desProduct;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public Product() {

    }

    public Long getCodPrduct() {
        return codProduct;
    }

    public void setCodPrduct(Long codPrduct) {
        this.codProduct = codPrduct;
    }

    public String getDesProduct() {
        return desProduct;
    }

    public void setDesProduct(String desProduct) {
        this.desProduct = desProduct;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return codProduct + " " + desProduct + " " + cantidad + " - " + precio + " - " + total;
    }
}
