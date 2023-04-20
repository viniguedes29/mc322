package com.guedes.lab3;
import java.util.Arrays;

public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFuncadacao;

    public ClientePJ(){
    // Montar o Init
    int x= 1;
    }

    //Getters e Setters
    
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    // Validar o CNPJ

    public String toString(){
        texto = "Nome: " + "pegar nome da classe cliente"
        + "\nCNPJ: " + this.cnpj
        +"\n Data de fundação: " + this.dataFuncadacao
        +"\nEndereco: " + "pegar endereco na classe cliente"
        + "\n Veículos: " + "pegar lista de veículos na classe cliente";
        
        return texto;
        }



}
