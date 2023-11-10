package controller;

import model.ModelFuncionario;
import DAO.DAOFuncionario;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;

/**
*
* @author Carlos
*/
public class ControllerFuncionario {

    private DAOFuncionario daoFuncionario = new DAOFuncionario();

    private static final Logger logger = Logger.getLogger(DAOFuncionario.class.getName());
    
    /**
    * grava Funcionario
    * @param pModelFuncionario
    * @return int
    */
    public int salvarFuncionarioController(ModelFuncionario pModelFuncionario){
        return this.daoFuncionario.salvarFuncionarioDAO(pModelFuncionario);
    }

    /**
    * recupera Funcionario
    * @param pIdFunc
    * @return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioController(int pIdFunc){
        return this.daoFuncionario.getFuncionarioDAO(pIdFunc);
    }

    /**
    * recupera uma lista deFuncionario
    * @param pIdFunc
    * @return ArrayList
    */
    public ArrayList<ModelFuncionario> getListaFuncionarioController(){
        return this.daoFuncionario.getListaFuncionarioDAO();
    }

    /**
    * atualiza Funcionario
    * @param pModelFuncionario
    * @return boolean
    */
    public boolean atualizarFuncionarioController(ModelFuncionario pModelFuncionario){
        return this.daoFuncionario.atualizarFuncionarioDAO(pModelFuncionario);
    }

    /**
    * exclui Funcionario
    * @param pIdFunc
    * @return boolean
    */
    public boolean excluirFuncionarioController(int pIdFunc){
        return this.daoFuncionario.excluirFuncionarioDAO(pIdFunc);
    }
     /**
      * 
      * @param pModelFuncionario
      * @return 
      */   
    public boolean alternarSituacaoFuncionarioController(ModelFuncionario pModelFuncionario) {
    return this.daoFuncionario.situacaoFuncionarioDAO(pModelFuncionario);
}

    public boolean getValidarFuncionarioController(ModelFuncionario pModelFuncionario) {
        return this.daoFuncionario.validarFunionarioDAO(pModelFuncionario);
    }

}