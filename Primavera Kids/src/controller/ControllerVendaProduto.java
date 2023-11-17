package controller;

import model.ModelVendaProduto;
import DAO.DAOVendaProduto;
import java.util.ArrayList;

/**
*
* @author Carlos
*/
public class ControllerVendaProduto {

    private DAOVendaProduto daoVendaProdutodos = new DAOVendaProduto();

    /**
    * grava VendaProdutodos
    * @param pModelVendaProdutodos
    * @return int
    */
    public int salvarVendaProdutodosController(ModelVendaProduto pModelVendaProdutodos){
        return this.daoVendaProdutodos.salvarVendaProdutodosDAO(pModelVendaProdutodos);
    }

    /**
    * recupera VendaProdutodos
    * @param pIdVenProduto 
    * @return ModelVendaProdutodos
    */
    public ModelVendaProduto getVendaProdutodosController(int pIdVenProduto ){
        return this.daoVendaProdutodos.getVendaProdutodosDAO(pIdVenProduto );
    }

    /**
    * recupera uma lista deVendaProdutodos
    * @param pIdVenProduto 
    * @return ArrayList
    */
    public ArrayList<ModelVendaProduto> getListaVendaProdutodosController(){
        return this.daoVendaProdutodos.getListaVendaProdutodosDAO();
    }

    /**
    * atualiza VendaProdutodos
    * @param pModelVendaProdutodos
    * @return boolean
    */
    public boolean atualizarVendaProdutodosController(ModelVendaProduto pModelVendaProdutodos){
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

    public boolean salvarVendaProdutodosController(ArrayList<ModelVendaProduto> pListamodelVendaProduto) {
        return this.daoVendaProdutodos.salvarVendaProdutodosDAO(pListamodelVendaProduto);
    }
}