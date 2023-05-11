package com.guedes.lab4;
import java.util.ArrayList;

public class Cliente {
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
	
	// Calculo de Score
	
	public double calculaScore() {
		/* Método que calcula o Score,.
		 * O objeto de Cliente não deve ter um score, sem um ClientePF ou ClientePJ*/
		return 0;
	}
	
	

	public static void main(String[] args){
		// Função main utilizada para validar os métodos criados.
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		//listaVeiculos.add(veiculo1);
		Cliente cliente1 = new Cliente("Naruto Uzumaki", "Rua do Trovão, Konogakure, País do fogo", listaVeiculos);
		System.out.println(cliente1.toString());
	}
}
