/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelodatos;
import java.util.Date;
/**
 *
 * @author asus
 */
public class Pedidos {
    private int id_pedido;
    private Date emision;
    private Date entrega;
    private Double ptotal;
    public Pedidos() {
    // Constructor vacío necesario para instanciar sin parámetros
}

    public Pedidos(int id_pedido, Date emision, Date entrega, Double ptotal) {
        this.id_pedido = id_pedido;
        this.emision = emision;
        this.entrega = entrega;
        this.ptotal = ptotal;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getEmision() {
        return emision;
    }

    public void setEmision(Date emision) {
        this.emision = emision;
    }

    public Date getEntrega() {
        return entrega;
    }

    public void setEntrega(Date entrega) {
        this.entrega = entrega;
    }

    public Double getPtotal() {
        return ptotal;
    }

    public void setPtotal(Double ptotal) {
        this.ptotal = ptotal;
    }
     }
    
