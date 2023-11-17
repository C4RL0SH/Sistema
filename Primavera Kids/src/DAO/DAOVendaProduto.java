package DAO;

import model.ModelVendaProduto;
import connection.ConexaoMySql;
import java.util.ArrayList;
/**
*
* @author Carlos
*/
public class DAOVendaProduto extends ConexaoMySql {

    /**
    * grava VendaProdutodos
    * @param pModelVendaProdutodos
    * @return int
    */
    public int salvarVendaProdutodosDAO(ModelVendaProduto pModelVendaProdutodos){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO venda_produto ("                    
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_pro_valor,"
                    + "ven_pro_quant"
                + ") VALUES ("                    
                    + "'" + pModelVendaProdutodos.getProduto () + "',"
                    + "'" + pModelVendaProdutodos.getVendas() + "',"
                    + "'" + pModelVendaProdutodos.getVenProValor() + "',"
                    + "'" + pModelVendaProdutodos.getVenProQuant() + "'"
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
    * recupera VendaProdutodos
    * @param pIdVenProduto 
    * @return ModelVendaProdutodos
    */
    public ModelVendaProduto getVendaProdutodosDAO(int pIdVenProduto ){
        ModelVendaProduto modelVendaProdutodos = new ModelVendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_ven_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_pro_valor,"
                    + "ven_pro_quant"
                 + " FROM"
                     + " venda_produto"
                 + " WHERE"
                     + " id_ven_produto = '" + pIdVenProduto  + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendaProdutodos.setIdVenProduto (this.getResultSet().getInt(1));
                modelVendaProdutodos.setProduto (this.getResultSet().getInt(2));
                modelVendaProdutodos.setVendas(this.getResultSet().getInt(3));
                modelVendaProdutodos.setVenProValor(this.getResultSet().getDouble(4));
                modelVendaProdutodos.setVenProQuant(this.getResultSet().getInt(5));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelVendaProdutodos;
    }

    /**
    * recupera uma lista de VendaProdutodos
        * @return ArrayList
    */
    public ArrayList<ModelVendaProduto> getListaVendaProdutodosDAO(){
        ArrayList<ModelVendaProduto> listamodelVendaProdutodos = new ArrayList();
        ModelVendaProduto modelVendaProdutodos = new ModelVendaProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "id_ven_produto,"
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_pro_valor,"
                    + "ven_pro_quant"
                 + " FROM"
                     + " venda_produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelVendaProdutodos = new ModelVendaProduto();
                modelVendaProdutodos.setIdVenProduto (this.getResultSet().getInt(1));
                modelVendaProdutodos.setProduto (this.getResultSet().getInt(2));
                modelVendaProdutodos.setVendas(this.getResultSet().getInt(3));
                modelVendaProdutodos.setVenProValor(this.getResultSet().getDouble(4));
                modelVendaProdutodos.setVenProQuant(this.getResultSet().getInt(5));
                listamodelVendaProdutodos.add(modelVendaProdutodos);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelVendaProdutodos;
    }

    /**
    * atualiza VendaProdutodos
    * @param pModelVendaProdutodos
    * @return boolean
    */
    public boolean atualizarVendaProdutodosDAO(ModelVendaProduto pModelVendaProdutodos){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE venda_produto SET "
                    + "id_ven_produto = '" + pModelVendaProdutodos.getIdVenProduto () + "',"
                    + "fk_produto = '" + pModelVendaProdutodos.getProduto () + "',"
                    + "fk_vendas = '" + pModelVendaProdutodos.getVendas() + "',"
                    + "ven_pro_valor = '" + pModelVendaProdutodos.getVenProValor() + "',"
                    + "ven_pro_quant = '" + pModelVendaProdutodos.getVenProQuant() + "'"
                + " WHERE "
                    + "id_ven_produto = '" + pModelVendaProdutodos.getIdVenProduto () + "'"
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
    * exclui VendaProdutodos
    * @param pIdVenProduto 
    * @return boolean
    */
    public boolean excluirVendaProdutodosDAO(int pIdVenProduto ){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM venda_produto "
                + " WHERE "
                    + "id_ven_produto = '" + pIdVenProduto  + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }

    public boolean salvarVendaProdutodosDAO(ArrayList<ModelVendaProduto> pListamodelVendaProduto) {
try {
            this.conectar();
            int cont = pListamodelVendaProduto.size();
            for (int i = 0; i < cont; i++) {    
             this.insertSQL(
                "INSERT INTO venda_produto ("                                
                    + "fk_produto,"
                    + "fk_vendas,"
                    + "ven_pro_valor,"
                    + "ven_pro_quant"
                + ") VALUES ("                    
                    + "'" + pListamodelVendaProduto.get(i).getProduto()+ "',"
                    + "'" + pListamodelVendaProduto.get(i).getVendas()+ "',"
                    + "'" + pListamodelVendaProduto.get(1).getVenProValor() + "',"
                    + "'" + pListamodelVendaProduto.get(1).getVenProQuant() + "'"                    
                + ");"
            );
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }   
    }
}