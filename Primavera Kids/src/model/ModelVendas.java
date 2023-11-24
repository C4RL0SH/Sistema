package model;

import java.util.Date;
import java.sql.Time;

/**
*
* @author Carlos
*/
public class ModelVendas {

    private int idVendas;
    private String cliente;
    private Date venData;
    private Time venHora;
    private double venValorLiquido;
    private double venValorBruto;
    private int venDesconto;
    private double venTroco;
    private String venTipoPagamento;
    private String venNomeCliente;

    /**
    * Construtor
    */
    public ModelVendas(){}

    /**
    * seta o valor de idVendas
    * @param pIdVendas
    */
    public void setIdVendas(int pIdVendas){
        this.idVendas = pIdVendas;
    }
    /**
    * @return idVendas
    */
    public int getIdVendas(){
        return this.idVendas;
    }

    /**
    * seta o valor de cliente
    * @param pCliente
    */
    public void setCliente(String pCliente){
        this.cliente = pCliente;
    }
    /**
    * @return fk_cliente
    */
    public String getCliente(){
        return this.cliente;
    }

    /**
    * seta o valor de venData
    * @param pVenData
    */
    public void setVenData(Date pVenData){
        this.venData = pVenData;
    }
    /**
    * @return venData
    */
    public Date getVenData(){
        return this.venData;
    }
    /**
    * seta o valor de venData
    * @param pVenHora
    */
    public void setVenHora(Time pVenHora){
        this.venHora = pVenHora;
    }
    /**
    * @return venData
    */
    public Time getVenHora(){
        return this.venHora;
    }

    /**
    * seta o valor de venValorLiquido
    * @param pVenValorLiquido
    */
    public void setVenValorLiquido(double pVenValorLiquido){
        this.venValorLiquido = pVenValorLiquido;
    }
    /**
    * @return venValorLiquido
    */
    public double getVenValorLiquido(){
        return this.venValorLiquido;
    }

    /**
    * seta o valor de venValorBruto
    * @param pVenValorBruto
    */
    public void setVenValorBruto(double pVenValorBruto){
        this.venValorBruto = pVenValorBruto;
    }
    /**
    * @return venValorBruto
    */
    public double getVenValorBruto(){
        return this.venValorBruto;
    }

    /**
    * seta o valor de venDesconto
    * @param pVenDesconto
    */
    public void setVenDesconto(int pVenDesconto){
        this.venDesconto = pVenDesconto;
    }
    /**
    * @return venDesconto
    */
    public double getVenDesconto(){
        return this.venDesconto;
    }
     /**
    * seta o valor de venTroco
    * @param pVenTroco
    */
    public void setVenTroco(double pVenTroco){
        this.venTroco = pVenTroco;
    }
    /**
    * @return venTroco
    */
    public double getVenTroco(){
        return this.venTroco;
    }
    
    /**
    * seta o valor de Tipo de Pagamento
    * @param pVenTipoPagamento
    */
    public void setVenTipoPagamento(String pVenTipoPagamento){
        this.venTipoPagamento = pVenTipoPagamento;
    }
    /**
    * @return venTipoPagamento
    */
    public String getVenTipoPagamento(){
        return this.venTipoPagamento;
    }
    /**
    * seta o valor de Tipo de Pagamento
    * @param pVenNomeCliente
    */
    public void setVenNomeCliente(String pVenNomeCliente){
        this.venNomeCliente = pVenNomeCliente;
    }
    /**
    * @return pVenNomeCliente
    */
    public String getVenNomeCliente(){
        return this.venNomeCliente;
    }

    @Override
    public String toString(){
        return "ModelVendas {" + "::idVendas = " + this.idVendas + "::cliente = " + this.cliente + "::venData = " + this.venData + "::venHora = " + this.venHora + "::venValorLiquido = " + this.venValorLiquido + "::venValorBruto = " + this.venValorBruto + "::venDesconto = " + this.venDesconto + "::venTroco = " + this.venTroco + "::venTipoPagamento = " + this.venTipoPagamento + "::venNomeCliente = " + this.venNomeCliente +"}";
    }
}