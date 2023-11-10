package controller;

import model.ModelVendaProdutodos;
import DAO.DAOVendaProdutodos;
import java.util.ArrayList;

/**
*
* @author Carlos
*/
public class ControllerVendaProdutodos {

    private DAOVendaProdutodos daoVendaProdutodos = new DAOVendaProdutodos();

    /**
    * grava VendaProdutodos
    * @param pModelVendaProdutodos
    * @return int
    */
    public int salvarVendaProdutodosController(ModelVendaProdutodos pModelVendaProdutodos){
        return this.daoVendaProdutodos.salvarVendaProdutodosDAO(pModelVendaProdutodos);
    }

    /**
    * recupera VendaProdutodos
    * @param pIdVenProduto 
    * @return ModelVendaProdutodos
    */
    public ModelVendaProdutodos getVendaProdutodosController(int pIdVenProduto ){
        return this.daoVendaProdutodos.getVendaProdutodosDAO(pIdVenProduto );
    }

    /**
    * recupera uma lista deVendaProdutodos
    * @param pIdVenProduto 
    * @return ArrayList
    */
    public ArrayList<ModelVendaProdutodos> getListaVendaProdutodosController(){
        return this.daoVendaProdutodos.getListaVendaProdutodosDAO();
    }

    /**
    * atualiza VendaProdutodos
    * @param pModelVendaProdutodos
    * @return boolean
    */
    public boolean atualizarVendaProdutodosController(ModelVendaProdutodos pModelVendaProdutodos){
        return this.daoVendaProdutodos.atualizarVendaProdutodosDAO(pModelVendaProdutodos);
    }

    /**
    * exclui VendaProdutodos
    * @param pIdVenProduto 
    * @return boolean
    */
    public boolean excluirVendaProdutodosController(int pIdVenProduto ){
        return this.daoVendaProdutodos.excluirVendaProdutodosDAO(pIdVenProduto );
    }
}