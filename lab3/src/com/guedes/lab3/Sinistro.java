package com.guedes.lab3;
import java.util.Random;

public class Sinistro {
    private int id = 999999 - new Random().nextInt(89999); // Gerará um ID de  números, que será um número entre 10000 e 99999
    private String sinistro;
    private String endereco;

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
        String texto = "O sinistro do tipo" + getSinistro() + ", ocorreu em " + getEndereco() + ".\nFoi registrado com o ID " + Integer.toString(getId());
        return texto;
    }


}
