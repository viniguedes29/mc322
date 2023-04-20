package com.guedes.lab3;
import java.util.Random;

public class Sinistro {
    private int id = 999999 - new Random().nextInt(89999); // Gerará um ID de  números, que será um número entre 10000 e 99999
    private String sinistro;
    private String endereco;
    private String data;
    private Segurado seguradora;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sinistro(String endereco, String data, Seguradora segurado, Veiculo veiculo, Cliente cliente){
      this.endereco = endereco;
      this.data = data;
      this.seguradora = segurado;
      this.veiculo = veiculo;
      this.cliente = cliente;
      // Adicionar a o id na lista de sinistro da seguradora
      // Se eu trocar a segurado com um setSegurado(), eu tenho que dentro desse set trocar o ID da lista?
      // Como eu faço essa programação de maneira prática pra n precisar ficar indo e voltando em arquivos diferentes?
    }
    public int getId() {
		return id;
	}
    
    public void setId(int id) {
		this.id = id;
    }
	
	public String getSinistro() {
		return sinistro;
	}
    public void setSinistro(String sinistro) {
		this.sinistro = sinistro;
    }

    public String getEndereco() {
		return endereco;
	}
    
    public void setEndereco(String endereco) {
		this.endereco = endereco;
    }

    public String toString(){
        String texto = "ID: " + Integer.toString(this.id)
        + "\nTipo:" + this.sinistro
        + "\nLocal do sinistro: " + this.sinistro
        + "\nData: " + this.data
        +"\nVeiculo: " + this.veiculo.toString()
        + "\nCliente: " + this.cliente.getNome()
        + "\nSeguradora: " + this.seguradora.getNome();
        
        return texto;
    }


}
