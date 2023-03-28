package lab1;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Cliente {
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String idade;
	private String endereco;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
		
	}
	public String getCpf() {
		return cpf;
		
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
		
	}
	
	public String getDataNascimento() {
		return dataNascimento;
		
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		
	}
	
	public String getIdade() {
		return idade;
		
	}
	public void setIdade(String idade) {
		this.idade = idade;
		
	}
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public int somaPrimeiroDigitoVerificadorCPF(String cpf) {
		/* Para calcular a o primeiro dígito verificador, é necessário pegar a soma do 9 primeiros dígitos. Essa função
		realiza essa soma.
		Para tanto, ela recebe como parâmetro a string cpf, que teve seus caracteres especiais retirados e passou pela vericação de 11 dígitos
		quando esse método for chamado 
		*/
		int soma = 0;
		for (int i = 0; i <= 8; i++){
			int numero_atual = Integer.parseInt(cpf.substring(i, i+1)); // Captura o dígito como int
			soma += numero_atual*(10-i); 
		}
		return soma;	
		
	}
	
	public int somaSegundoDigitoVerificadorCPF(String cpf) {
		/* Para fazer a verificação do CPF com o primeiro dígito verificador, é necessário pegar a soma do segundo ao nono dígito e usar o primeiro verificador calculado.
		Essa função realiza essa soma. São utilizadas dois métodos diferentes para cálcular as somas dos dígitos verificadores, pois usam funções diferentes.
		Para tanto, ela recebe como parâmetro a string cpf, que teve seus caracteres não numéricos retirados e passou pela vericação de 11 dígitos
		*/
		
		int soma = 0;
		for (int i = 1; i <= 8; i++){ //Iremos varrer os dígitos não verificadores a partir do segundo dígito.
			int numero_atual = Integer.parseInt(cpf.substring(i, i+1)); // Captura o dígito como int
			soma += numero_atual*(11-i); 
		}
		soma += 2*calculaDigitoVerificadorCPF(somaPrimeiroDigitoVerificadorCPF(cpf)); 
		// Para calcular o segundo dígito verificador, é necessário calcular o primeiro dígito verificador e complementar a soma com o seu dobro
		return soma;
		
	}

	public int calculaDigitoVerificadorCPF(int soma){
		/*  O Dígito verificador está relacionado com as somas calculadas nos dois métodos anteriores e o seu resto na divisão por 11, 
		 	conforme descrita
		*/
		
		if ((soma % 11 == 0) | (soma % 11 == 1) ){ // Se o resto da divisão da soma por 11 for 0 ou 1, o dígito verificador é 0
			return 0;


		} else{ // Se não for retorna 11 - (resto da soma na divisão por 11)
			return 11 - soma%11;


	}
}
	


	public boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");// Substitui todos os digitos não numéricos por um digito vazio
		
		if(cpf.length() != 11) { // Verificando se o CPF, após retirada de caracteres não numéricos, possui 11 dígitos
			return false;	
		}
		// Para realizar as demais operações é preciso grantir que o CPF tem 11 dígitos, pois pode haver Index Error se for menor.
		int soma_d1 = somaPrimeiroDigitoVerificadorCPF(cpf);
		int soma_d2 = somaSegundoDigitoVerificadorCPF(cpf); 
		int d1_cpf = Integer.parseInt(cpf.substring(9, 10)); // Primeiro dígito verificador do CPF passado como parâmetro	
		int d2_cpf = Integer.parseInt(cpf.substring(10, 11)); // Segundo dígito verificador do CPF passado como parâmetro
		int d1_calculado = calculaDigitoVerificadorCPF(soma_d1);
		int d2_calculado = calculaDigitoVerificadorCPF(soma_d2);
	
		if (Long.parseLong(cpf) % 11111111111L == 0 ) { 
		 /*Verificando se o cpf tem todos os dígitos iguais, utilizando o fato de que um número de 11 dígitos com dígitos todos inguais é múltiplo
		 de 11111111111. */
			return false;
		}

		if (d1_calculado == d1_cpf & d2_calculado == d2_cpf ){ // Se os respectivos dígitos verificadores são iguais, retorna-se o true, se não false 
			return true;
			

		} else{
			return false;
		}
	}

	public String toString(){
		String texto = "O nome do cliente é " + getNome() + " possui o CPF de número " + getCpf() + ", tem " + getIdade() + " de idade.\n" + "Nasceu em " + getDataNascimento() + " e é residente em " + getEndereco() + ".";
		
		
		return texto;
	}

	public static void main(String[] args){
		// Função main utilizada para validar os métodos criados.
		Cliente cliente1 = new Cliente();
		cliente1.setCpf("613.135.113.90");
		cliente1.setDataNascimento("02/03/2001");
		cliente1.setEndereco("Rua Pereira Coutinho 987");
		cliente1.setIdade("22");
		cliente1.setNome("Vini Guedes");
		System.out.println(cliente1.toString());

	}
	
}
