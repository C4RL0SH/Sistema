package controller;

import model.ModelCliente;
import DAO.DAOCliente;
import java.util.ArrayList;

/**
*
* @author Carlos
*/
public class ControllerCliente {

    private DAOCliente daoCliente = new DAOCliente();

    /**
    * grava Cliente
    * @param pModelCliente
    * @return int
    */
    public int salvarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.salvarClienteDAO(pModelCliente);
    }

    /**
    * recupera Cliente
    * @param pIdClien
    * @return ModelCliente
    */
    public ModelCliente getClienteController(int pIdClien){
        return this.daoCliente.getClienteDAO(pIdClien);
    }
    
    public ModelCliente getClienteController(String pCpfClien){
        return this.daoCliente.getClienteDAO(pCpfClien);
    }

    /**
    * recupera uma lista deCliente
    * @param pIdClien
    * @return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteController(){
        return this.daoCliente.getListaClienteDAO();
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * @return boolean
    */
    public boolean atualizarClienteController(ModelCliente pModelCliente){
        return this.daoCliente.atualizarClienteDAO(pModelCliente);
    }

    /**
    * exclui Cliente
    * @param pIdClien
    * @return boolean
    */
    public boolean excluirClienteController(int pIdClien){
        return this.daoCliente.excluirClienteDAO(pIdClien);
    }
    
    
}