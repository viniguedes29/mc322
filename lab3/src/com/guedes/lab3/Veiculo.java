package com.guedes.lab3;
public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;
    private int anoFabricacao;

	public Veiculo(String placa, String modelo, String marca, int anoFabricacao){
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.anoFabricacao = anoFabricacao;
	}

    // Getters e Setters
    public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
    }

    public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
    }
    
    public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
    }

    public String toString(){
        
    	String texto = "Informações do carro:\n" 
        		+ "Marca: " + this.marca  + "\n"
        		+ "Modelo: " + this.modelo + " ano " + this.anoFabricacao + "\n"
        		+ "Placa: " + this.placa;
        		 
        
        		return texto;
    }

    public static void main(String[] args) {
      // Método main criado para testar e corrigir bugs na classe
      Veiculo veiculo1 = new Veiculo("XYZ3233", "Monza", "Chevrolet", 2000);

        System.out.println(veiculo1.toString());


    }
}
