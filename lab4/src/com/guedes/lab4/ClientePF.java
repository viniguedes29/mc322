package com.guedes.lab4;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ClientePF extends Cliente{
    private String cpf;
    private String genero;
    private LocalDate dataLicenca;
    private String educacao;
    private LocalDate dataNascimento;
    private String classeEconomica;


    public ClientePF(String nome, String endereco, String cpf,  ArrayList<Veiculo> listaVeiculo,
					 String genero,  String educacao, LocalDate dataLicenca, LocalDate dataNascimento,
					 String classeEconomica){
        super(nome, endereco, listaVeiculo);
		this.cpf = cpf;
		this.genero = genero;
		this.dataLicenca = dataLicenca;
		this.dataNascimento = dataNascimento;
		this.educacao = educacao;
		this.classeEconomica = classeEconomica;

	
    }

    // Getters e Setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.replaceAll("[^0-9]", ""); // Deixando o cpf com apenas números.
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

    // Funções para validação do CPF.

	static int somaPrimeiroDigitoVerificadorCPF(String cpf) {
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
	
	static int somaSegundoDigitoVerificadorCPF(String cpf) {
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

	static int calculaDigitoVerificadorCPF(int soma){
		/*  O Dígito verificador está relacionado com as somas calculadas nos dois métodos anteriores e o seu resto na divisão por 11, 
		 	conforme descrita
		*/
		
		if ((soma % 11 == 0) | (soma % 11 == 1) ){ // Se o resto da divisão da soma por 11 for 0 ou 1, o dígito verificador é 0
			return 0;


		} else{ // Se não for retorna 11 - (resto da soma na divisão por 11)
			return 11 - soma%11;
	    }
	}

	static boolean validarCPF(String cpf) {
        /* Utiliza os métodos anteirores para fazer a validação do CPF.
		 */
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
	// Calculo de Score.
	public int calculaIdade() {
		LocalDate hoje = LocalDate.now();
		long idade = dataNascimento.until(hoje, ChronoUnit.YEARS);
		return (int) idade;
	}
	 public double calculaScore() {
		 int idade = calculaIdade();
		 double fatorIdade = CalcSeguro.getFatorIdade(idade);
		 double valorBase = CalcSeguro.VALOR_BASE.getValor();
		 int quantidadeCarros = super.getListaVeiculos().size();
		 
		 return fatorIdade*valorBase*quantidadeCarros;
	 }
	

	

	public String toString(){
		String texto = "Nome: " + super.getNome()
		+ "\nCPF: " + this.cpf
		+ "\nEndereco: " + super.getEndereco()
		+ "\nData de Nascimento: " + this.dataNascimento.toString()
		+ "\nGenero: " + this.genero
		+ "\nEscolaridade: " + this.educacao
		+ "\nClasse Economica: " + this.classeEconomica.toString()
		+ "\nData da liscenca: " + this.dataLicenca.toString()
		+ "\nVeículos: " + super.getListaVeiculos().toString();
		return texto;
	}


	public static void main(String args[]){
		LocalDate nascimento =  LocalDate.of(2005, 11, 2);
		LocalDate liscensa = LocalDate.of(2003, 2, 15);
		Veiculo veiculo1 = new Veiculo("XYZ3233", "Monza", "Chevrolet", 2000);
		Veiculo veiculo2 = new Veiculo("XYZ1234", "Rural", "Volksvagem", 1880);
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		listaVeiculos.add(veiculo1);
		listaVeiculos.add(veiculo2);
		ClientePF cliente1 = new ClientePF("Naruto Uzumai da Sukva", "Konohagakure","61313511390",
				listaVeiculos, "masculino","academia ninja incompleta",
				liscensa ,nascimento, "muito rico");
		int x = 2;
		System.out.println((cliente1.calculaIdade())*x);
		
	}

}
