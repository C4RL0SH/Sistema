/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import DAO.DAOVendasCliente;
import java.util.ArrayList;
import model.ModelVendasCliente;

/**
 *
 * @author Carlos
 */
public class ControllerVendasCliente {
    
    private DAOVendasCliente daoVendasCliente = new DAOVendasCliente();

    public ArrayList<ModelVendasCliente> getListaVendasClienteController() {
        return this.daoVendasCliente.getListaVendasClienteDAO();
    }
    
}
