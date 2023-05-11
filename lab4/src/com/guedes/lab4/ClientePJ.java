package com.guedes.lab4;
import java.util.ArrayList;
import java.util.Date;
public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;
    private int qtdeFuncionarios;

    public ClientePJ(String nome, String endereco, ArrayList<Veiculo> listaVeiculo, 
		   String cnpj, Date dataFundacao, int qtdeFuncionarios){
    // Montar o Init
    	super(nome, endereco, listaVeiculo);
    	this.cnpj = cnpj;
    	this.dataFundacao = dataFundacao;
    	this.qtdeFuncionarios = qtdeFuncionarios;
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
    public static int calcula_soma_d1(String cnpj){
        // Calcula a soma para definir o primeiro dígito verificador.
        // Esse método é invocado depois de o cnpj ter garantidamente 14 dígitos numéricos    

        int[] numeros_multiplicacao = {5,4,3,2,9,8,7,6,5,4,3,2}; // Número pelos quais cada dígito do CNPJ deve ser múltiplica, a partir do número correspondente na lista
        int soma = 0; // inicializando a soma
        for (int i = 0; i < 12; i++){
        // Pega-se o elemento i da string, transforma-o em inteiro e multiplica-o pelo número da posição i da lista e adiciona-a à soma
            int digito_cnpj = Integer.parseInt(cnpj.substring(i, i+1));
            soma += numeros_multiplicacao[i]*digito_cnpj;
        }
        return soma;
    }


    public static int calcula_soma_d2(String cnpj){
        // Calcula a soma para definir o segundo dígito verificador.
        // Esse método é invocado depois de o cnpj ter garantidamente 14 dígitos numéricos    

        int[] numeros_multiplicacao = {6,5,4,3,2,9,8,7,6,5,4,3,2}; // Número pelos quais cada dígito do CNPJ deve ser múltiplica, a partir do número correspondente na lista
        int soma = 0; // inicializando a soma
        for (int i = 0; i < 12; i++){
        // Pega-se o elemento i da string, transforma-o em inteiro e multiplica-o pelo número da posição i da lista e adiciona-a à soma
        // Nesse passo pegamos os 12 primeiros dígitos, sem pegar o primeiro dígito verificador.   
            int digito_cnpj = Integer.parseInt(cnpj.substring(i, i+1));
            soma += numeros_multiplicacao[i]*digito_cnpj;
        }
            // Pega o primeiro dígito verificador, multiplica pelo fator multiplicativo definido na lista e adiciona a soma, pois é necessário 
            soma += numeros_multiplicacao[12]*calcula_digito_verificador(calcula_soma_d1(cnpj));
        return soma;
    }

    public static int calcula_digito_verificador(int soma){
        /* Pega a soma dos dígitos ponderados pelo fator multiplicativo e verifica o resto por 11.
         * A depender do valor, retorna o dígito
         * Essa regra serve para calcular os dois dígitos verificadores
         * Soma deve ser o retorno do método calcula_soma_d1() ou calcula_soma_d2()
        */
        int resto = soma%11;
        if(resto < 2){ // Se o resto for 0 ou 1 retorna 0
            return 0;
        }else{// Se não for retorna 11 - (resto da soma na divisão por 11)
			return 11 - soma%11;
        }    
    }
    
    
    public static boolean validarCNPJ(String cnpj) {
        /* Utiliza os métodos anteirores para fazer a validação do CNPJ.
		 */
		cnpj = cnpj.replaceAll("[^0-9]", "");// Substitui todos os caracteres não numéricos por um vazio
		
		if(cnpj.length() != 14) { // Verificando se o CPF, após retirada de caracteres não numéricos, possui 11 dígitos
			return false;
            // Para realizar as demais operações é preciso grantir que o CPF tem 11 dígitos, pois pode haver Index Error se for menor	
		}
		
		int soma_d1 = calcula_soma_d1(cnpj);
		int soma_d2 = calcula_soma_d2(cnpj); 
		int d1_fornecido = Integer.parseInt(cnpj.substring(12, 13)); // Primeiro dígito verificador do CPF passado como parâmetro	
		int d2_fornecido = Integer.parseInt(cnpj.substring(13, 14)); // Segundo dígito verificador do CPF passado como parâmetro
		int d1_calculado = calcula_digito_verificador(soma_d1);
		int d2_calculado = calcula_digito_verificador(soma_d2);

		if (Long.parseLong(cnpj) % 11111111111111L == 0 ) { 
		 /*Verificando se o CNPJ tem todos os dígitos iguais, utilizando o fato de que um número de 11 dígitos com dígitos todos inguais é múltiplo
		 de 11111111111. */
			return false;
		}

		if (d1_calculado == d1_fornecido & d2_fornecido == d2_calculado ){ // Se os respectivos dígitos verificadores são iguais, retorna-se o true, se não false 
			return true;
			

		} else{
			return false;
        }
		                }

    
    // Calcula score.
    public double calculaScore() {
		
    	int quantidadeCarros = super.getListaVeiculos().size();
		double valorBase = CalcSeguro.VALOR_BASE.getValor();
		
		return valorBase*quantidadeCarros*qtdeFuncionarios;
    }
    
    public String toString(){
        String texto = "Nome: " + super.getNome()
        + "\nCNPJ: " + this.cnpj
        +"\n Data de fundação: " + this.dataFundacao
        +"\nEndereco: " + super.getEndereco()
        + "\n Veículos: " + super.getListaVeiculos().toString();
        
        return texto;
        }
    
    public static void main(String args[]){
        Veiculo veiculo1;
        Date fundacao = new Date(2023, 30, 8);
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        ClientePJ cliente1 = new ClientePJ("Sasuke Uchiha de Sousa", "Konohagakure", 
                                           listaVeiculos , "98.987.883/0001-70", fundacao, 30);
        System.out.println(cliente1.validarCNPJ(cliente1.getCnpj()));
        System.out.println(cliente1.toString());

    }



}
