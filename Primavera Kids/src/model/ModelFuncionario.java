package model;

import java.sql.Date;

/**
*
* @author Carlos
*/
public class ModelFuncionario {

    private int idFunc;
    private String funcNome;
    private String funcCpf;
    private String funcEmail;
    private Date funcData;
    private String funcSexo;
    private String funcTelefone;
    private String funcTelefone2;
    private String funcCep;
    private String funcEndereco;
    private String funcCidade;
    private String funcEstado;
    private String funcCargo;
    private String funcTurno;
    private Double funcSalario;
    private String funcSituacao;
    private String funcUser;
    private String funcSenha;

    /**
    * Construtor
    */
    public ModelFuncionario(){}

    /**
    * seta o valor de idFunc
    * @param pIdFunc
    */
    public void setIdFunc(int pIdFunc){
        this.idFunc = pIdFunc;
    }
    /**
    * @return pk_idFunc
    */
    public int getIdFunc(){
        return this.idFunc;
    }

    /**
    * seta o valor de funcNome
    * @param pFuncNome
    */
    public void setFuncNome(String pFuncNome){
        this.funcNome = pFuncNome;
    }
    /**
    * @return funcNome
    */
    public String getFuncNome(){
        return this.funcNome;
    }

    /**
    * seta o valor de funcCpf
    * @param pFuncCpf
    */
    public void setFuncCpf(String pFuncCpf){
        this.funcCpf = pFuncCpf;
    }
    /**
    * @return funcCpf
    */
    public String getFuncCpf(){
        return this.funcCpf;
    }

    /**
    * seta o valor de funcEmail
    * @param pFuncEmail
    */
    public void setFuncEmail(String pFuncEmail){
        this.funcEmail = pFuncEmail;
    }
    /**
    * @return funcEmail
    */
    public String getFuncEmail(){
        return this.funcEmail;
    }

    /**
    * seta o valor de funcData
    * @param pFuncData
    */
    public void setFuncData(Date pFuncData){
        this.funcData = pFuncData;
    }
    /**
    * @return funcData
    */
    public Date getFuncData(){
        return this.funcData;
    }

    /**
    * seta o valor de funcSexo
    * @param pFuncSexo
    */
    public void setFuncSexo(String pFuncSexo){
        this.funcSexo = pFuncSexo;
    }
    /**
    * @return funcSexo
    */
    public String getFuncSexo(){
        return this.funcSexo;
    }

    /**
    * seta o valor de funcTelefone
    * @param pFuncTelefone
    */
    public void setFuncTelefone(String pFuncTelefone){
        this.funcTelefone = pFuncTelefone;
    }
    /**
    * @return funcTelefone
    */
    public String getFuncTelefone(){
        return this.funcTelefone;
    }

    /**
    * seta o valor de funcTelefone2
    * @param pFuncTelefone2
    */
    public void setFuncTelefone2(String pFuncTelefone2){
        this.funcTelefone2 = pFuncTelefone2;
    }
    /**
    * @return funcTelefone2
    */
    public String getFuncTelefone2(){
        return this.funcTelefone2;
    }

    /**
    * seta o valor de funcCep
    * @param pFuncCep
    */
    public void setFuncCep(String pFuncCep){
        this.funcCep = pFuncCep;
    }
    /**
    * @return funcCep
    */
    public String getFuncCep(){
        return this.funcCep;
    }

    /**
    * seta o valor de funcEndereco
    * @param pFuncEndereco
    */
    public void setFuncEndereco(String pFuncEndereco){
        this.funcEndereco = pFuncEndereco;
    }
    /**
    * @return funcEndereco
    */
    public String getFuncEndereco(){
        return this.funcEndereco;
    }

    /**
    * seta o valor de funcCidade
    * @param pFuncCidade
    */
    public void setFuncCidade(String pFuncCidade){
        this.funcCidade = pFuncCidade;
    }
    /**
    * @return funcCidade
    */
    public String getFuncCidade(){
        return this.funcCidade;
    }

    /**
    * seta o valor de funcEstado
    * @param pFuncEstado
    */
    public void setFuncEstado(String pFuncEstado){
        this.funcEstado = pFuncEstado;
    }
    /**
    * @return funcEstado
    */
    public String getFuncEstado(){
        return this.funcEstado;
    }

    /**
    * seta o valor de funcCargo
    * @param pFuncCargo
    */
    public void setFuncCargo(String pFuncCargo){
        this.funcCargo = pFuncCargo;
    }
    /**
    * @return funcCargo
    */
    public String getFuncCargo(){
        return this.funcCargo;
    }

    /**
    * seta o valor de funcTurno
    * @param pFuncTurno
    */
    public void setFuncTurno(String pFuncTurno){
        this.funcTurno = pFuncTurno;
    }
    /**
    * @return funcTurno
    */
    public String getFuncTurno(){
        return this.funcTurno;
    }

    /**
    * seta o valor de funcSalario
    * @param pFuncSalario
    */
    public void setFuncSalario(Double pFuncSalario){
        this.funcSalario = pFuncSalario;
    }
    /**
    * @return funcSalario
    */
    public Double getFuncSalario(){
        return this.funcSalario;
    }

    /**
    * seta o valor de funcSituacao
    * @param pFuncSituacao
    */
    public void setFuncSituacao(String pFuncSituacao){
        this.funcSituacao = pFuncSituacao;
    }
    /**
    * @return funcSituacao
    */
    public String getFuncSituacao(){
        return this.funcSituacao;
    }

    /**
    * seta o valor de funcUser
    * @param pFuncUser
    */
    public void setFuncUser(String pFuncUser){
        this.funcUser = pFuncUser;
    }
    /**
    * @return funcUser
    */
    public String getFuncUser(){
        return this.funcUser;
    }

    /**
    * seta o valor de funcSenha
    * @param pFuncSenha
    */
    public void setFuncSenha(String pFuncSenha){
        this.funcSenha = pFuncSenha;
    }
    /**
    * @return funcSenha
    */
    public String getFuncSenha(){
        return this.funcSenha;
    }

    @Override
    public String toString(){
        return "ModelFuncionario {" + "::idFunc = " + this.idFunc + "::funcNome = " + this.funcNome + "::funcCpf = " + this.funcCpf + "::funcEmail = " + this.funcEmail + "::funcData = " + this.funcData + "::funcSexo = " + this.funcSexo + "::funcTelefone = " + this.funcTelefone + "::funcTelefone2 = " + this.funcTelefone2 + "::funcCep = " + this.funcCep + "::funcEndereco = " + this.funcEndereco + "::funcCidade = " + this.funcCidade + "::funcEstado = " + this.funcEstado + "::funcCargo = " + this.funcCargo + "::funcTurno = " + this.funcTurno + "::funcSalario = " + this.funcSalario + "::funcSituacao = " + this.funcSituacao + "::funcUser = " + this.funcUser + "::funcSenha = " + this.funcSenha +  "}";
    }
}