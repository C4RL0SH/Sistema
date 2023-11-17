package model;
/**
*
* @author Carlos
*/
import java.sql.Date;

public class ModelProduto {

    private int idProduto ;
    private String prodNome;
    private String prodNomeFornec;
    private Date prodDataRegistro;
    private String prodCategoria;
    private int prodQuantidade;
    private String prodTamanho;
    private double prodPreco;    
    private int prod_Desconto;

    /**
    * Construtor
    */
    public ModelProduto(){}

    /**
    * seta o valor de idProduto 
    * @param pIdProduto 
    */
    public void setIdProduto (int pIdProduto ){
        this.idProduto  = pIdProduto ;
    }
    /**
    * @return pk_idProduto 
    */
    public int getIdProduto (){
        return this.idProduto ;
    }

    /**
    * seta o valor de prodNome
    * @param pProdNome
    */
    public void setProdNome(String pProdNome){
        this.prodNome = pProdNome;
    }
    /**
    * @return prodNome
    */
    public String getProdNome(){
        return this.prodNome;
    }

    /**
    * seta o valor de prodNomeFornec
    * @param pProdNomeFornec
    */
    public void setProdNomeFornec(String pProdNomeFornec){
        this.prodNomeFornec = pProdNomeFornec;
    }
    /**
    * @return prodNomeFornec
    */
    public String getProdNomeFornec(){
        return this.prodNomeFornec;
    }

    /**
    * seta o valor de prodDataRegistro
    * @param pProdDataRegistro
    */
    public void setProdDataRegistro(Date pProdDataRegistro){
        this.prodDataRegistro = pProdDataRegistro;
    }
    /**
    * @return prodDataRegistro
    */
    public Date getProdDataRegistro(){
        return this.prodDataRegistro;
    }

    /**
    * seta o valor de prodCategoria
    * @param pProdCategoria
    */
    public void setProdCategoria(String pProdCategoria){
        this.prodCategoria = pProdCategoria;
    }
    /**
    * @return prodCategoria
    */
    public String getProdCategoria(){
        return this.prodCategoria;
    }

    /**
    * seta o valor de prodQuantidade
    * @param pProdQuantidade
    */
    public void setProdQuantidade(int pProdQuantidade){
        this.prodQuantidade = pProdQuantidade;
    }
    /**
    * @return prodQuantidade
    */
    public int getProdQuantidade(){
        return this.prodQuantidade;
    }

    /**
    * seta o valor de prodTamanho
    * @param pProdTamanho
    */
    public void setProdTamanho(String pProdTamanho){
        this.prodTamanho = pProdTamanho;
    }
    /**
    * @return prodTamanho
    */
    public String getProdTamanho(){
        return this.prodTamanho;
    }

    /**
    * seta o valor de prodPreco
    * @param pProdPreco
    */
    public void setProdPreco(double pProdPreco){
        this.prodPreco = pProdPreco;
    }
    /**
    * @return prodPreco
    */
    public double getProdPreco(){
        return this.prodPreco;
    }    

    /**
    * seta o valor de prod_Desconto
    * @param pProd_Desconto
    */
    public void setProd_Desconto(int pProd_Desconto){
        this.prod_Desconto = pProd_Desconto;
    }
    /**
    * @return prod_Desconto
    */
    public int getProd_Desconto(){
        return this.prod_Desconto;
    }

    @Override
    public String toString(){
        return "ModelProduto {" + "::idProduto  = " + this.idProduto  + "::prodNome = " + this.prodNome + "::prodNomeFornec = " + this.prodNomeFornec + "::prodDataRegistro = " + this.prodDataRegistro + "::prodCategoria = " + this.prodCategoria + "::prodQuantidade = " + this.prodQuantidade + "::prodTamanho = " + this.prodTamanho + "::prodPreco = " + this.prodPreco + "::prod_Desconto = " + this.prod_Desconto +  "}";
    }
}