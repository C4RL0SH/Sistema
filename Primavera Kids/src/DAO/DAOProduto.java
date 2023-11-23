package DAO;

import model.ModelProduto;
import connection.ConexaoMySql;
import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class DAOProduto extends ConexaoMySql {

    /**
     * grava Produto
     *
     * @param pModelProduto
     * @return int
     */
    public int salvarProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.insertSQL(
                    "INSERT INTO tbl_produto ("
                    + "prod_Nome,"
                    + "prod_NomeFornec,"
                    + "prod_DataRegistro,"
                    + "prod_Categoria,"
                    + "prod_Quantidade,"
                    + "prod_Tamanho,"
                    + "prod_Preco,"
                    + "prod_Desconto"
                    + ") VALUES ("
                    + "'" + pModelProduto.getProdNome() + "',"
                    + "'" + pModelProduto.getProdNomeFornec() + "',"
                    + "'" + pModelProduto.getProdDataRegistro() + "',"
                    + "'" + pModelProduto.getProdCategoria() + "',"
                    + "'" + pModelProduto.getProdQuantidade() + "',"
                    + "'" + pModelProduto.getProdTamanho() + "',"
                    + "'" + pModelProduto.getProdPreco() + "',"
                    + "'" + pModelProduto.getProd_Desconto() + "'"
                    + ");"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * recupera Produto
     *
     * @param pIdProduto
     * @return ModelProduto
     */
    public ModelProduto getProdutoDAO(int pIdProduto) {
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_Produto,"
                    + "prod_Nome,"
                    + "prod_NomeFornec,"
                    + "prod_DataRegistro,"
                    + "prod_Categoria,"
                    + "prod_Quantidade,"
                    + "prod_Tamanho,"
                    + "prod_Preco,"
                    + "prod_Desconto"
                    + " FROM"
                    + " tbl_produto"
                    + " WHERE"
                    + " id_produto = '" + pIdProduto + "'"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProdNome(this.getResultSet().getString(2));
                modelProduto.setProdNomeFornec(this.getResultSet().getString(3));
                modelProduto.setProdDataRegistro(this.getResultSet().getDate(4));
                modelProduto.setProdCategoria(this.getResultSet().getString(5));
                modelProduto.setProdQuantidade(this.getResultSet().getInt(6));
                modelProduto.setProdTamanho(this.getResultSet().getString(7));
                modelProduto.setProdPreco(this.getResultSet().getDouble(8));
                modelProduto.setProd_Desconto(this.getResultSet().getInt(9));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return modelProduto;
    }

    /**
     * recupera uma lista de Produto
     *
     * @return ArrayList
     */
    public ArrayList<ModelProduto> getListaProdutoDAO() {
        ArrayList<ModelProduto> listamodelProduto = new ArrayList();
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(
                    "SELECT "
                    + "id_Produto,"
                    + "prod_Nome,"
                    + "prod_NomeFornec,"
                    + "prod_DataRegistro,"
                    + "prod_Categoria,"
                    + "prod_Quantidade,"
                    + "prod_Tamanho,"
                    + "prod_Preco,"
                    + "prod_Desconto"
                    + " FROM"
                    + " tbl_produto"
                    + ";"
            );

            while (this.getResultSet().next()) {
                modelProduto = new ModelProduto();
                modelProduto.setIdProduto(this.getResultSet().getInt(1));
                modelProduto.setProdNome(this.getResultSet().getString(2));
                modelProduto.setProdNomeFornec(this.getResultSet().getString(3));
                modelProduto.setProdDataRegistro(this.getResultSet().getDate(4));
                modelProduto.setProdCategoria(this.getResultSet().getString(5));
                modelProduto.setProdQuantidade(this.getResultSet().getInt(6));
                modelProduto.setProdTamanho(this.getResultSet().getString(7));
                modelProduto.setProdPreco(this.getResultSet().getDouble(8));
                modelProduto.setProd_Desconto(this.getResultSet().getInt(9));
                listamodelProduto.add(modelProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.fecharConexao();
        }
        return listamodelProduto;
    }

    /**
     * atualiza Produto
     *
     * @param pModelProduto
     * @return boolean
     */
    public boolean atualizarProdutoDAO(ModelProduto pModelProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "UPDATE tbl_produto SET "
                    + "id_Produto = '" + pModelProduto.getIdProduto() + "',"
                    + "prod_Nome = '" + pModelProduto.getProdNome() + "',"
                    + "prod_NomeFornec = '" + pModelProduto.getProdNomeFornec() + "',"
                    + "prod_Categoria = '" + pModelProduto.getProdCategoria() + "',"
                    + "prod_Quantidade = '" + pModelProduto.getProdQuantidade() + "',"
                    + "prod_Tamanho = '" + pModelProduto.getProdTamanho() + "',"
                    + "prod_Preco = '" + pModelProduto.getProdPreco() + "',"
                    + "prod_Desconto = '" + pModelProduto.getProd_Desconto() + "'"
                    + " WHERE "
                    + "id_Produto = '" + pModelProduto.getIdProduto() + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    /**
     * exclui Produto
     *
     * @param pIdProduto
     * @return boolean
     */
    public boolean excluirProdutoDAO(int pIdProduto) {
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                    "DELETE FROM tbl_produto "
                    + " WHERE "
                    + "id_Produto = '" + pIdProduto + "'"
                    + ";"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }

    public boolean atualizarEstoqueProdutoDAO(ArrayList<ModelProduto> pListaModelProduto) {
        try {
            this.conectar();
            for (int i = 0; i < pListaModelProduto.size(); i++) {
                return this.executarUpdateDeleteSQL(
                        "UPDATE tbl_produto SET "
                        + "prod_Quantidade = '" + pListaModelProduto.get(i).getProdQuantidade() + "'"
                        + " WHERE "
                        + "id_Produto = '" + pListaModelProduto.get(i).getIdProduto() + "'"
                        + ";"
                );
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            this.fecharConexao();
        }
    }
}
