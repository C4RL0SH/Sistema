package DAO;

import model.ModelVendas;
import connection.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Carlos
*/
public class DAOVendas extends ConexaoMySql {

    /**
    * grava Vendas
    * @param pModelVendas
    * @return int
    */
    public int salvarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO vendas ("                    
                    + "cpf_cliente,"
                    + "ven_data,"
                    + "ven_Hora,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_Troco,"
                    + "ven_TipoPagamento,"  
                    + "ven_NomeCli"  
                + ") VALUES ("                    
                    + "'" + pModelVendas.getCliente() + "',"
                    + "'" + pModelVendas.getVenData() + "',"
                    + "'" + pModelVendas.getVenHora() + "',"
                    + "'" + pModelVendas.getVenValorLiquido() + "',"
                    + "'" + pModelVendas.getVenValorBruto() + "',"
                    + "'" + pModelVendas.getVenTroco()+ "',"
                    + "'" + pModelVendas.getVenTipoPagamento()+ "',"
                    + "'" + pModelVendas.getVenNomeCliente()+ "'"
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
    * recupera Vendas
    * @param pIdVendas
    * @return ModelVendas
    */
    public ModelVendas getVendasDAO(int pIdVendas){
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_vendas,"
                    + "cpf_cliente,"
                    + "ven_data,"
                    + "ven_Hora,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_Troco,"
                    + "ven_TipoPagamento,"  
                    + "ven_NomeCli"  
                 + " FROM"
                     + " vendas"
                 + " WHERE"
                     + " id_vendas = '" + pIdVendas + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas.setIdVendas(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getString(2));
                modelVendas.setVenData(this.getResultSet().getDate(3));
                modelVendas.setVenHora(this.getResultSet().getTime(4));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(5));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(6));               
                modelVendas.setVenTroco(this.getResultSet().getDouble(7));
                modelVendas.setVenTipoPagamento(this.getResultSet().getString(8));
                modelVendas.setVenNomeCliente(this.getResultSet().getString(9));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendas;
    }

    /**
    * recupera uma lista de Vendas
        * @return ArrayList
    */
    public ArrayList<ModelVendas> getListaVendasDAO(){
        ArrayList<ModelVendas> listamodelVendas = new ArrayList();
        ModelVendas modelVendas = new ModelVendas();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_vendas,"
                    + "cpf_cliente,"
                    + "ven_data,"
                    + "ven_Hora,"
                    + "ven_valor_liquido,"
                    + "ven_valor_bruto,"
                    + "ven_Troco,"
                    + "ven_TipoPagamento,"    
                    + "ven_NomeCli"    
                 + " FROM"
                     + " vendas"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendas = new ModelVendas();
                modelVendas.setIdVendas(this.getResultSet().getInt(1));
                modelVendas.setCliente(this.getResultSet().getString(2));
                modelVendas.setVenData(this.getResultSet().getDate(3));
                modelVendas.setVenHora(this.getResultSet().getTime(4));
                modelVendas.setVenValorLiquido(this.getResultSet().getDouble(5));
                modelVendas.setVenValorBruto(this.getResultSet().getDouble(6));                
                modelVendas.setVenTroco(this.getResultSet().getDouble(7));
                modelVendas.setVenTipoPagamento(this.getResultSet().getString(8));
                modelVendas.setVenNomeCliente(this.getResultSet().getString(9));
                listamodelVendas.add(modelVendas);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendas;
    }

    /**
    * atualiza Vendas
    * @param pModelVendas
    * @return boolean
    */
    public boolean atualizarVendasDAO(ModelVendas pModelVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE vendas SET "
                    + "id_vendas = '" + pModelVendas.getIdVendas() + "',"
                    + "cpf_cliente = '" + pModelVendas.getCliente() + "',"
                    + "ven_data = '" + pModelVendas.getVenData() + "',"
                    + "ven_Hora = '" + pModelVendas.getVenHora() + "',"
                    + "ven_valor_liquido = '" + pModelVendas.getVenValorLiquido() + "',"
                    + "ven_valor_bruto = '" + pModelVendas.getVenValorBruto() + "',"
                    + "ven_Troco = '" + pModelVendas.getVenTroco() + "',"
                    + "ven_TipoPagamento = '" + pModelVendas.getVenTipoPagamento() + "',"
                    + "ven_NomeCli = '" + pModelVendas.getVenNomeCliente()+ "'"
                + " WHERE "
                    + "id_vendas = '" + pModelVendas.getIdVendas() + "'"
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
    * exclui Vendas
    * @param pIdVendas
    * @return boolean
    */
    public boolean excluirVendasDAO(int pIdVendas){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM vendas "
                + " WHERE "
                    + "id_vendas = '" + pIdVendas + "'"
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