package com.guedes.lab3;

import java.util.Date;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        // Iniciando variáveis para rodar o código de forma mais prática
        // Nomes
        String nomePF1 = "Naruto Uzumaki Rodrigues";
        String nomePF2 = "Sasuke Uchiha da Silva";
        String nomePJ1 = "Akatsuki Nukenins SA";
        String nomePJ2 = "Alianaça Shinobi LTDA";
        String nomeSeg1 =  "Konoha Seguros SA";
        String nomeSeg2 = "Unicamp Seguros SA";
        
        // Telefones
        String telefone1 = "080008000";
        String telefone2 = "080006000";
        
        // CPFs (gerados com ferramentas da internet
        String cpf1 = "364.136.217-29";
        String cpf2 = "297.140.784-55"; //Inválido
        String cnpj1 = "23.262.618/0001-25";
        String cnpj2 = "69.268.612/0001-68"; //Inválido
        
        // Endereços.
        String endereco1 = "Rua Kyuube, 999, Konohagakure, Pais do Fogo";
        String endereco2 = "Rua da Névoa, 444, Kirigakure, País da Água";
        String endereco3 = "Rua Pitágora, 345, Unicamp, Barao Geraldo";
        String endereco4 = "Rua A, 888, Kumogakure, País do Relâmpago";
        String endereco5 =  "Rua do Trovão 999, Konogakure, País do fogo";
        String endereco6 =  "Rua Hichiraku 888, Konogakure, País do fogo";
        
        // Datas
		Date nascimento = new Date(2002, 10, 5);
		Date licensa = new Date(2023, 30, 8);
		Date dia_sinistro = new Date(2023, 01,01);
		
        // Iniciando veículos
		Veiculo veiculo1 = new Veiculo("XYZ12345", "Monza", "Chevrolet", 2000);
		Veiculo veiculo2 = new Veiculo("XYZ3233", "Camaro", "Chevrolet", 2018);
		Veiculo veiculo3 = new Veiculo("XYZ1234", "Rural", "Volksvagem", 1880);
		Veiculo veiculo4 = new Veiculo("XYZ1298", "Polo", "Volksvagem", 2023);
		
		// Iniciando lista de veículos
		ArrayList<Veiculo> veiculosCliente1 = new ArrayList<Veiculo>();
		ArrayList<Veiculo> veiculosCliente2 = new ArrayList<Veiculo>();
		ArrayList<Veiculo> veiculosCliente3 = new ArrayList<Veiculo>();
		ArrayList<Veiculo> veiculosCliente4 = new ArrayList<Veiculo>();
		veiculosCliente1.add(veiculo1);
		
		// Lista de clientes
		ArrayList<Cliente> clientes1 = new ArrayList<Cliente>();
		ArrayList<Cliente> clientes2 = new ArrayList<Cliente>();
        
		//Iniciando clientes
		Cliente cliente1 = new ClientePF(nomePF1, endereco1, cpf1, veiculosCliente1, "M",
				"Superior Incompleto", licensa, nascimento, "Muito rico");
		Cliente cliente2 = new ClientePF(nomePF2, endereco2, cpf2, veiculosCliente2, "M",
				"Superior Completo", licensa, nascimento, "Muito rico");
		Cliente cliente3 = new ClientePJ(nomePJ1, endereco3,  veiculosCliente3, cnpj1, nascimento);
		Cliente cliente4 = new ClientePJ(nomePJ1, endereco4,  veiculosCliente4, cnpj2, nascimento);
		
		//Iniciando seguradora
		Seguradora = new
    
}
}
