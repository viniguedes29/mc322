package com.guedes.lab5;

public  class Validacao {

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

	static boolean validaCPF(String cpf) {
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
	
	//--------------------------------------------- Validar o CNPJ-----------------------------------------

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

        if (d1_calculado == d1_fornecido & d2_fornecido == d2_calculado ){ 
            // Se os respectivos dígitos verificadores são iguais, retorna-se o true, se não false 
            return true;
            

        } else{
            return false;
        }
    }

    public static boolean validaNome(String nome){
        // Utiliza-se um regex que retorna true se o nome tiver apenas letras, de qualquer idioma e espaço 
        boolean resultado = nome.matches("[\\p{L} ]+");
        return resultado;
    }
    
    public static boolean validaIdade(int idade){
        // Valida de a idade de um cliente PF é maior que 18, para poder cadastra-lo como cliente de uma segura
        if( idade >= 18){
            return true;
        }else{
            return false;
        }
    }
    
}
