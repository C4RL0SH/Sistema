package model;
/**
*
* @author Carlos
*/
public class ModelVendaProduto {

    private int idVenProduto ;
    private int produto ;
    private int vendas;
    private double venProValor;
    private int venProQuant;

    /**
    * Construtor
    */
    public ModelVendaProduto(){}

    /**
    * seta o valor de idVenProduto 
    * @param pIdVenProduto 
    */
    public void setIdVenProduto (int pIdVenProduto ){
        this.idVenProduto  = pIdVenProduto ;
    }
    /**
    * @return idVenProduto 
    */
    public int getIdVenProduto (){
        return this.idVenProduto ;
    }

    /**
    * seta o valor de produto 
    * @param pProduto 
    */
    public void setProduto (int pProduto ){
        this.produto  = pProduto ;
    }
    /**
    * @return fk_produto 
    */
    public int getProduto (){
        return this.produto ;
    }

    /**
    * seta o valor de vendas
    * @param pVendas
    */
    public void setVendas(int pVendas){
        this.vendas = pVendas;
    }
    /**
    * @return fk_vendas
    */
    public int getVendas(){
        return this.vendas;
    }

    /**
    * seta o valor de venProValor
    * @param pVenProValor
    */
    public void setVenProValor(double pVenProValor){
        this.venProValor = pVenProValor;
    }
    /**
    * @return venProValor
    */
    public double getVenProValor(){
        return this.venProValor;
    }

    /**
    * seta o valor de venProQuant
    * @param pVenProQuant
    */
    public void setVenProQuant(int pVenProQuant){
        this.venProQuant = pVenProQuant;
    }
    /**
    * @return venProQuant
    */
    public int getVenProQuant(){
        return this.venProQuant;
    }

    @Override
    public String toString(){
        return "ModelVendaProdutodos {" + "::idVenProduto  = " + this.idVenProduto  + "::produto  = " + this.produto  + "::vendas = " + this.vendas + "::venProValor = " + this.venProValor + "::venProQuant = " + this.venProQuant +  "}";
    }
}