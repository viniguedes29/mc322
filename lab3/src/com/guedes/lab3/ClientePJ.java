package com.guedes.lab3;
import java.util.Arrays;
import java.util.Date;
public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;

    public ClientePJ(String nome, String endereco, Veiculo[] listaVeiculo, 
		   String cnpj, Date dataFundacao){
    // Montar o Init
    	super(nome, endereco, listaVeiculo);
    	this.cnpj = cnpj;
    	this.dataFundacao = dataFundacao;
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
        String texto = "Nome: " + super.getNome()
        + "\nCNPJ: " + this.cnpj
        +"\n Data de fundação: " + this.dataFundacao
        +"\nEndereco: " + super.getEndereco()
        + "\n Veículos: " + super.getListaVeiculos().toString();
        
        return texto;
        }



}
