package com.guedes.lab3;

import java.util.Arrays;

public class Cliente {
	private String nome;
	private String endereco;
	private static Veiculo listaVeiculos[];
	//Init
	
	public Cliente(String nome, String endereco, Veiculo[] listaVeiculos){
		this.nome = nome;
		this.endereco = endereco;
		this.listaVeiculos = listaVeiculos;
	} 

	// Getters and Setters
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
		
	}
		
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String toString(){
		String texto = "Nome: " + this.nome
			+ "\nEndereco: " + this.endereco 
			+ "\n Veiculos: " + Arrays.toString(listaVeiculos); // Colocar um método para printar os veiculos.
		
		return texto;
	}

	public static void main(String[] args){
		// Função main utilizada para validar os métodos criados.
		Veiculo veiculo1 = new Veiculo("XYZ12345", "Monza", "Chevrolet", 2000);
		Veiculo[] listaVeiculos = {veiculo1};
		Cliente cliente1 = new Cliente("Naruto Uzumaki", "Rua do Trovão, Konogakure, País do fogo", listaVeiculos);
		System.out.println(cliente1.toString());
	}
}
