package DAO;

import model.ModelCliente;
import connection.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Carlos
*/
public class DAOCliente extends ConexaoMySql {

    /**
    * grava Cliente
    * @param pModelCliente
    * @return int
    */
    public int salvarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tbl_cliente ("                    
                    + "clien_Nome,"
                    + "clien_Cpf,"
                    + "clien_Email,"
                    + "clien_Telefone,"
                    + "clien_Cep,"
                    + "clien_Endereco,"
                    + "clien_Cidade,"
                    + "clien_Estado,"
                    + "clien_Sexo"
                + ") VALUES ("                    
                    + "'" + pModelCliente.getClienNome() + "',"
                    + "'" + pModelCliente.getClienCpf() + "',"
                    + "'" + pModelCliente.getClienEmail() + "',"
                    + "'" + pModelCliente.getClienTelefone() + "',"
                    + "'" + pModelCliente.getClienCep() + "',"
                    + "'" + pModelCliente.getClienEndereco() + "',"
                    + "'" + pModelCliente.getClienCidade() + "',"
                    + "'" + pModelCliente.getClienEstado() + "',"
                    + "'" + pModelCliente.getClienSexo() + "'"
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
    * recupera Cliente
    * @param pIdClien
    * @return ModelCliente
    */
    public ModelCliente getClienteDAO(int pIdClien){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_clien,"
                    + "clien_Nome,"
                    + "clien_Cpf,"
                    + "clien_Email,"
                    + "clien_Telefone,"
                    + "clien_Cep,"
                    + "clien_Endereco,"
                    + "clien_Cidade,"
                    + "clien_Estado,"
                    + "clien_Sexo"
                 + " FROM"
                     + " tbl_cliente"
                 + " WHERE"
                     + " id_clien = '" + pIdClien + "'"
                + ";"
            );

            while(this.getResultSet().next()){
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
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }
    
    public ModelCliente getClienteDAO(String pClientCpf){
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_clien,"
                    + "clien_Nome,"
                    + "clien_Cpf,"
                    + "clien_Email,"
                    + "clien_Telefone,"
                    + "clien_Cep,"
                    + "clien_Endereco,"
                    + "clien_Cidade,"
                    + "clien_Estado,"
                    + "clien_Sexo"
                 + " FROM"
                     + " tbl_cliente"
                 + " WHERE"
                     + " clien_Cpf = '" + pClientCpf + "'"
                + ";"
            );

            while(this.getResultSet().next()){
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
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelCliente;
    }

    /**
    * recupera uma lista de Cliente
        * @return ArrayList
    */
    public ArrayList<ModelCliente> getListaClienteDAO(){
        ArrayList<ModelCliente> listamodelCliente = new ArrayList();
        ModelCliente modelCliente = new ModelCliente();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_clien,"
                    + "clien_Nome,"
                    + "clien_Cpf,"
                    + "clien_Email,"
                    + "clien_Telefone,"
                    + "clien_Cep,"
                    + "clien_Endereco,"
                    + "clien_Cidade,"
                    + "clien_Estado,"
                    + "clien_Sexo"
                 + " FROM"
                     + " tbl_cliente"
                + ";"
            );

            while(this.getResultSet().next()){
                modelCliente = new ModelCliente();
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
                listamodelCliente.add(modelCliente);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelCliente;
    }

    /**
    * atualiza Cliente
    * @param pModelCliente
    * @return boolean
    */
    public boolean atualizarClienteDAO(ModelCliente pModelCliente){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tbl_cliente SET "
                    + "id_clien = '" + pModelCliente.getIdClien() + "',"
                    + "clien_Nome = '" + pModelCliente.getClienNome() + "',"
                    + "clien_Cpf = '" + pModelCliente.getClienCpf() + "',"
                    + "clien_Email = '" + pModelCliente.getClienEmail() + "',"
                    + "clien_Telefone = '" + pModelCliente.getClienTelefone() + "',"
                    + "clien_Cep = '" + pModelCliente.getClienCep() + "',"
                    + "clien_Endereco = '" + pModelCliente.getClienEndereco() + "',"
                    + "clien_Cidade = '" + pModelCliente.getClienCidade() + "',"
                    + "clien_Estado = '" + pModelCliente.getClienEstado() + "',"
                    + "clien_Sexo = '" + pModelCliente.getClienSexo() + "'"
                + " WHERE "
                    + "id_clien = '" + pModelCliente.getIdClien() + "'"
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
    * exclui Cliente
    * @param pIdClien
    * @return boolean
    */
    public boolean excluirClienteDAO(int pIdClien){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tbl_cliente "
                + " WHERE "
                    + "id_clien = '" + pIdClien + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    
}