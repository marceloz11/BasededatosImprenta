/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodatos;




public class Productos {
    private int id_producto;
    private String nombre_prod;
    private double precio;
    private String tipo;
    private int id_pedido;
    private int id_supervisor;

    public Productos() {
    }

    public Productos(int id_producto, String nombre_prod, double precio, String tipo, int id_pedido, int id_supervisor) {
        this.id_producto = id_producto;
        this.nombre_prod = nombre_prod;
        this.precio = precio;
        this.tipo = tipo;
        this.id_pedido = id_pedido;
        this.id_supervisor = id_supervisor;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getId_supervisor() {
        return id_supervisor;
    }

    public void setId_supervisor(int id_supervisor) {
        this.id_supervisor = id_supervisor;
    }
    
}
