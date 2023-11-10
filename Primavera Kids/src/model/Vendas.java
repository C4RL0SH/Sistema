/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;
/**
 *
 * @author Carlos
 */
public class Vendas {
    private int id_venda;
    private int cliente;
    private Date ven_data;
    private double ven_valor_liquido;
    private double ven_valor_bruto;

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public Date getVen_data() {
        return ven_data;
    }

    public void setVen_data(Date ven_data) {
        this.ven_data = ven_data;
    }

    public double getVen_valor_liquido() {
        return ven_valor_liquido;
    }

    public void setVen_valor_liquido(double ven_valor_liquido) {
        this.ven_valor_liquido = ven_valor_liquido;
    }

    public double getVen_valor_bruto() {
        return ven_valor_bruto;
    }

    public void setVen_valor_bruto(double ven_valor_bruto) {
        this.ven_valor_bruto = ven_valor_bruto;
    }

    public double getVen_desconto() {
        return ven_desconto;
    }

    public void setVen_desconto(double ven_desconto) {
        this.ven_desconto = ven_desconto;
    }
    private double ven_desconto;
}
