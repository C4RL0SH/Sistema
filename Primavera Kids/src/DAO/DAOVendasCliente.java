/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import connection.ConexaoMySql;
import java.util.ArrayList;
import model.ModelCliente;
import model.ModelVendas;
import model.ModelVendasCliente;

/**
 *
 * @author Carlos
 */
public class DAOVendasCliente extends ConexaoMySql{
        public ArrayList<ModelVendasCliente> getListaVendasClienteDAO(){
        ArrayList<ModelVendasCliente> listaModelVendasClientes = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        ModelCliente modelCliente = new ModelCliente();
        ModelVendasCliente modelVendasCliente = new ModelVendasCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT *"
                        + " FROM "
                        + "vendas INNER JOIN tbl_cliente"
                        + " ON tbl_cliente.id_clien = vendas.cpf_cliente"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelCliente = new ModelCliente();
                modelVendasCliente = new ModelVendasCliente();
                modelVendas.setIdVendas(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getString(2));
                modelVendas.setVenData(this.getResultSet().getDate(3));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(4));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(5));
                modelVendas.setVenDesconto(this.getResultSet().getInt(6));
                modelVendas.setVenTroco(this.getResultSet().getDouble(7));
                modelVendas.setVenTipoPagamento(this.getResultSet().getString(8));
                
                modelCliente.setIdClien(this.getResultSet().getInt(1));
                modelCliente.setClienNome(this.getResultSet().getString(2));
                modelCliente.setClienCpf(this.getResultSet().getString(3));
                modelCliente.setClienEmail(this.getResultSet().getString(4));
                modelCliente.setClienTelefone(this.getResultSet().getString(5));
                modelCliente.setClienCep(this.getResultSet().getString(6));
                modelCliente.setClienEndereco(this.getResultSet().getString(7));
                modelCliente.setClienCidade(this.getResultSet().getString(8));
                modelCliente.setClienEstado(this.getResultSet().getString(9));
                modelCliente.setClienSexo(this.getResultSet().getString(10));
                
                modelVendasCliente.setModelVendas(modelVendas);
                modelVendasCliente.setModelCliente(modelCliente);
                listaModelVendasClientes.add(modelVendasCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listaModelVendasClientes;
        }
}
