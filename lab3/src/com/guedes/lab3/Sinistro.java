package com.guedes.lab3;
import java.util.Random;

public class Sinistro {
    private final int id = 999999 - new Random().nextInt(89999); // Gerará um ID de  números, que será um número entre 10000 e 99999
    private String sinistro;
    private String endereco;
    private String data;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    public void setCliente(Cliente cliente) {
      this.cliente = cliente;
    }
  
      public Sinistro(String sinistro, String endereco, String data, 
                      Seguradora seguradora, Veiculo veiculo, Cliente cliente){
        
        this.endereco = endereco;
        this.sinistro = sinistro;
        this.data = data;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
      }

  // Getters e Setters
  public String getData() {
    return this.data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Seguradora getSeguradora() {
    return this.seguradora;
  }

  public void setSeguradora(Seguradora seguradora) {
    this.seguradora = seguradora;
  }

  public Veiculo getVeiculo() {
    return this.veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

    public int getId() {
		return id;
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

    public boolean verificaVeiculo(Veiculo veiculo){
      /*Função verifica se o carro está na lista do do Cliente */
      
      if(cliente.getListaVeiculos().contains(veiculo)){
        //Se está na lista, ok.
        return true;
      }else{
        return false;
      }
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
