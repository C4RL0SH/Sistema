package DAO;

import model.ModelFuncionario;
import connection.ConexaoMySql;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.ArrayList;
/**
*
* @author Carlos
*/
public class DAOFuncionario extends ConexaoMySql {
    
    private static final Logger logger = Logger.getLogger(DAOFuncionario.class.getName());

    /**
    * grava Funcionario
    * @param pModelFuncionario
    * @return int
    */
    public int salvarFuncionarioDAO(ModelFuncionario pModelFuncionario){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_funcionario ("                    
                    + "func_Nome,"
                    + "func_Cpf,"
                    + "func_Email,"
                    + "func_Data,"
                    + "func_Sexo,"
                    + "func_Telefone,"
                    + "func_Telefone2,"
                    + "func_Cep,"
                    + "func_Endereco,"
                    + "func_Cidade,"
                    + "func_Estado,"
                    + "func_Cargo,"
                    + "func_Turno,"
                    + "func_Salario,"
                    + "func_Situacao,"
                    + "func_User,"
                    + "func_Senha"
                + ") VALUES ("
                    
                    + "'" + pModelFuncionario.getFuncNome() + "',"
                    + "'" + pModelFuncionario.getFuncCpf() + "',"
                    + "'" + pModelFuncionario.getFuncEmail() + "',"
                    + "'" + pModelFuncionario.getFuncData() + "',"
                    + "'" + pModelFuncionario.getFuncSexo() + "',"
                    + "'" + pModelFuncionario.getFuncTelefone() + "',"
                    + "'" + pModelFuncionario.getFuncTelefone2() + "',"
                    + "'" + pModelFuncionario.getFuncCep() + "',"
                    + "'" + pModelFuncionario.getFuncEndereco() + "',"
                    + "'" + pModelFuncionario.getFuncCidade() + "',"
                    + "'" + pModelFuncionario.getFuncEstado() + "',"
                    + "'" + pModelFuncionario.getFuncCargo() + "',"
                    + "'" + pModelFuncionario.getFuncTurno() + "',"
                    + "'" + pModelFuncionario.getFuncSalario() + "',"
                    + "'" + pModelFuncionario.getFuncSituacao() + "',"
                    + "'" + pModelFuncionario.getFuncUser() + "',"
                    + "'" + pModelFuncionario.getFuncSenha() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * recupera Funcionario
    * @param pIdFunc
    * @return ModelFuncionario
    */
    public ModelFuncionario getFuncionarioDAO(int pIdFunc){
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_func,"
                    + "func_Nome,"
                    + "func_Cpf,"
                    + "func_Email,"
                    + "func_Data,"
                    + "func_Sexo,"
                    + "func_Telefone,"
                    + "func_Telefone2,"
                    + "func_Cep,"
                    + "func_Endereco,"
                    + "func_Cidade,"
                    + "func_Estado,"
                    + "func_Cargo,"
                    + "func_Turno,"
                    + "func_Salario,"
                    + "func_Situacao,"
                    + "func_User,"
                    + "func_Senha"
                 + " FROM"
                     + " tbl_funcionario"
                 + " WHERE"
                     + " id_func = '" + pIdFunc + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionario.setIdFunc(this.getResultSet().getInt(1));
                modelFuncionario.setFuncNome(this.getResultSet().getString(2));
                modelFuncionario.setFuncCpf(this.getResultSet().getString(3));
                modelFuncionario.setFuncEmail(this.getResultSet().getString(4));
                modelFuncionario.setFuncData(this.getResultSet().getDate(5));
                modelFuncionario.setFuncSexo(this.getResultSet().getString(6));
                modelFuncionario.setFuncTelefone(this.getResultSet().getString(7));
                modelFuncionario.setFuncTelefone2(this.getResultSet().getString(8));
                modelFuncionario.setFuncCep(this.getResultSet().getString(9));
                modelFuncionario.setFuncEndereco(this.getResultSet().getString(10));
                modelFuncionario.setFuncCidade(this.getResultSet().getString(11));
                modelFuncionario.setFuncEstado(this.getResultSet().getString(12));
                modelFuncionario.setFuncCargo(this.getResultSet().getString(13));
                modelFuncionario.setFuncTurno(this.getResultSet().getString(14));
                modelFuncionario.setFuncSalario(this.getResultSet().getDouble(15));
                modelFuncionario.setFuncSituacao(this.getResultSet().getString(16));
                modelFuncionario.setFuncUser(this.getResultSet().getString(17));
                modelFuncionario.setFuncSenha(this.getResultSet().getString(18));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelFuncionario;
    }

    /**
    * recupera uma lista de Funcionario
        * @return ArrayList
    */
    public ArrayList<ModelFuncionario> getListaFuncionarioDAO(){
        ArrayList<ModelFuncionario> listamodelFuncionario = new ArrayList();
        ModelFuncionario modelFuncionario = new ModelFuncionario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_func,"
                    + "func_Nome,"
                    + "func_Cpf,"
                    + "func_Email,"
                    + "func_Data,"
                    + "func_Sexo,"
                    + "func_Telefone,"
                    + "func_Telefone2,"
                    + "func_Cep,"
                    + "func_Endereco,"
                    + "func_Cidade,"
                    + "func_Estado,"
                    + "func_Cargo,"
                    + "func_Turno,"
                    + "func_Salario,"
                    + "func_Situacao,"
                    + "func_User,"
                    + "func_Senha"
                 + " FROM"
                     + " tbl_funcionario"
                + ";"
            );

            while(this.getResultSet().next()){
                modelFuncionario = new ModelFuncionario();
                modelFuncionario.setIdFunc(this.getResultSet().getInt(1));
                modelFuncionario.setFuncNome(this.getResultSet().getString(2));
                modelFuncionario.setFuncCpf(this.getResultSet().getString(3));
                modelFuncionario.setFuncEmail(this.getResultSet().getString(4));
                modelFuncionario.setFuncData(this.getResultSet().getDate(5));
                modelFuncionario.setFuncSexo(this.getResultSet().getString(6));
                modelFuncionario.setFuncTelefone(this.getResultSet().getString(7));
                modelFuncionario.setFuncTelefone2(this.getResultSet().getString(8));
                modelFuncionario.setFuncCep(this.getResultSet().getString(9));
                modelFuncionario.setFuncEndereco(this.getResultSet().getString(10));
                modelFuncionario.setFuncCidade(this.getResultSet().getString(11));
                modelFuncionario.setFuncEstado(this.getResultSet().getString(12));
                modelFuncionario.setFuncCargo(this.getResultSet().getString(13));
                modelFuncionario.setFuncTurno(this.getResultSet().getString(14));
                modelFuncionario.setFuncSalario(this.getResultSet().getDouble(15));
                modelFuncionario.setFuncSituacao(this.getResultSet().getString(16));
                modelFuncionario.setFuncUser(this.getResultSet().getString(17));
                modelFuncionario.setFuncSenha(this.getResultSet().getString(18));
                listamodelFuncionario.add(modelFuncionario);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelFuncionario;
    }

    /**
    * atualiza Funcionario
    * @param pModelFuncionario
    * @return boolean
    */
    public boolean atualizarFuncionarioDAO(ModelFuncionario pModelFuncionario){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_funcionario SET "
                    + "id_func = '" + pModelFuncionario.getIdFunc() + "',"
                    + "func_Nome = '" + pModelFuncionario.getFuncNome() + "',"
                    + "func_Cpf = '" + pModelFuncionario.getFuncCpf() + "',"
                    + "func_Email = '" + pModelFuncionario.getFuncEmail() + "',"
                    + "func_Data = '" + pModelFuncionario.getFuncData() + "',"
                    + "func_Sexo = '" + pModelFuncionario.getFuncSexo() + "',"
                    + "func_Telefone = '" + pModelFuncionario.getFuncTelefone() + "',"
                    + "func_Telefone2 = '" + pModelFuncionario.getFuncTelefone2() + "',"
                    + "func_Cep = '" + pModelFuncionario.getFuncCep() + "',"
                    + "func_Endereco = '" + pModelFuncionario.getFuncEndereco() + "',"
                    + "func_Cidade = '" + pModelFuncionario.getFuncCidade() + "',"
                    + "func_Estado = '" + pModelFuncionario.getFuncEstado() + "',"
                    + "func_Cargo = '" + pModelFuncionario.getFuncCargo() + "',"
                    + "func_Turno = '" + pModelFuncionario.getFuncTurno() + "',"
                    + "func_Salario = '" + pModelFuncionario.getFuncSalario() + "',"
                    + "func_Situacao = '" + pModelFuncionario.getFuncSituacao() + "',"
                    + "func_User = '" + pModelFuncionario.getFuncUser() + "',"
                    + "func_Senha = '" + pModelFuncionario.getFuncSenha() + "'"
                + " WHERE "
                    + "id_func = '" + pModelFuncionario.getIdFunc() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    /**
    * exclui Funcionario
    * @param pIdFunc
    * @return boolean
    */
    public boolean excluirFuncionarioDAO(int pIdFunc){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_funcionario "
                + " WHERE "
                    + "id_func = '" + pIdFunc + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public boolean situacaoFuncionarioDAO(ModelFuncionario pModelFuncionario) {
    try {
        this.conectar();
        return this.executarUpdateDeleteSQL(
            "UPDATE tbl_funcionario SET "
                + "func_Situacao = '" + pModelFuncionario.getFuncSituacao() + "'"
                + " WHERE "
                + "id_func = " + pModelFuncionario.getIdFunc()
                + ";"
        );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
        
     
    }

    public boolean validarFunionarioDAO(ModelFuncionario pModelFuncionario) {
    ModelFuncionario modelFuncionario = new ModelFuncionario();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT * From tbl_funcionario"                
                 + " WHERE"
                     + " func_User = '" + modelFuncionario.getFuncUser() + "'"
                     + " AND func_Senha = '" + modelFuncionario.getFuncSenha()+ "'"
                + ";"
            );

            
        }catch(Exception e){
            e.printStackTrace();
            return true;
        }finally{
            this.fecharConexao();
            return false;
        }
        
}
}
