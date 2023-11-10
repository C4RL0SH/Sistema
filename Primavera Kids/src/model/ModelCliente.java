package model;
/**
*
* @author Carlos
*/
public class ModelCliente {

    private int idClien;
    private String clienNome;
    private String clienCpf;
    private String clienEmail;
    private String clienTelefone;
    private String clienCep;
    private String clienEndereco;
    private String clienCidade;
    private String clienEstado;
    private String clienSexo;

    /**
    * Construtor
    */
    public ModelCliente(){}

    /**
    * seta o valor de idClien
    * @param pIdClien
    */
    public void setIdClien(int pIdClien){
        this.idClien = pIdClien;
    }
    /**
    * @return pk_idClien
    */
    public int getIdClien(){
        return this.idClien;
    }

    /**
    * seta o valor de clienNome
    * @param pClienNome
    */
    public void setClienNome(String pClienNome){
        this.clienNome = pClienNome;
    }
    /**
    * @return clienNome
    */
    public String getClienNome(){
        return this.clienNome;
    }

    /**
    * seta o valor de clienCpf
    * @param pClienCpf
    */
    public void setClienCpf(String pClienCpf){
        this.clienCpf = pClienCpf;
    }
    /**
    * @return clienCpf
    */
    public String getClienCpf(){
        return this.clienCpf;
    }

    /**
    * seta o valor de clienEmail
    * @param pClienEmail
    */
    public void setClienEmail(String pClienEmail){
        this.clienEmail = pClienEmail;
    }
    /**
    * @return clienEmail
    */
    public String getClienEmail(){
        return this.clienEmail;
    }

    /**
    * seta o valor de clienTelefone
    * @param pClienTelefone
    */
    public void setClienTelefone(String pClienTelefone){
        this.clienTelefone = pClienTelefone;
    }
    /**
    * @return clienTelefone
    */
    public String getClienTelefone(){
        return this.clienTelefone;
    }

    /**
    * seta o valor de clienCep
    * @param pClienCep
    */
    public void setClienCep(String pClienCep){
        this.clienCep = pClienCep;
    }
    /**
    * @return clienCep
    */
    public String getClienCep(){
        return this.clienCep;
    }

    /**
    * seta o valor de clienEndereco
    * @param pClienEndereco
    */
    public void setClienEndereco(String pClienEndereco){
        this.clienEndereco = pClienEndereco;
    }
    /**
    * @return clienEndereco
    */
    public String getClienEndereco(){
        return this.clienEndereco;
    }

    /**
    * seta o valor de clienCidade
    * @param pClienCidade
    */
    public void setClienCidade(String pClienCidade){
        this.clienCidade = pClienCidade;
    }
    /**
    * @return clienCidade
    */
    public String getClienCidade(){
        return this.clienCidade;
    }

    /**
    * seta o valor de clienEstado
    * @param pClienEstado
    */
    public void setClienEstado(String pClienEstado){
        this.clienEstado = pClienEstado;
    }
    /**
    * @return clienEstado
    */
    public String getClienEstado(){
        return this.clienEstado;
    }

    /**
    * seta o valor de clienSexo
    * @param pClienSexo
    */
    public void setClienSexo(String pClienSexo){
        this.clienSexo = pClienSexo;
    }
    /**
    * @return clienSexo
    */
    public String getClienSexo(){
        return this.clienSexo;
    }

    @Override
    public String toString(){
        return "ModelCliente {" + "::idClien = " + this.idClien + "::clienNome = " + this.clienNome + "::clienCpf = " + this.clienCpf + "::clienEmail = " + this.clienEmail + "::clienTelefone = " + this.clienTelefone + "::clienCep = " + this.clienCep + "::clienEndereco = " + this.clienEndereco + "::clienCidade = " + this.clienCidade + "::clienEstado = " + this.clienEstado + "::clienSexo = " + this.clienSexo +  "}";
    }
}