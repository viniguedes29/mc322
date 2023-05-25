package com.guedes.lab5;
import java.util.ArrayList;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private ArrayList<Veiculo> listaVeiculos;
	double valorSeguro;

	//Init
	
	public Cliente(String nome, String endereco, ArrayList<Veiculo> listaVeiculos){
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

	public double getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(double valorSeguro) {
		this.valorSeguro = valorSeguro;
		
	}
		
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public ArrayList<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public String toString(){
		final String texto = "Nome: " + this.nome
			+ "\nEndereco: " + this.endereco 
			+ "\n Veiculos: " + listaVeiculos.toString(); // Colocar um método para printar os veiculos.
		
		return texto;
	}

	// Adicionando veículo
	public void adiciona_Veiculo(Veiculo veiculo){
		// Adicona um veículo na lista de veículos de um cliente.
		
	}
	
	// Calculo de Score
	
	public abstract double calculaScore();

	
	

	public static void main(String[] args){
		// Função main utilizada para validar os métodos criados.
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		//listaVeiculos.add(veiculo1);
		//Cliente cliente1 = new Cliente("Naruto Uzumaki", "Rua do Trovão, Konogakure, País do fogo", listaVeiculos);
		//System.out.println(cliente1.toString());
	}
}
