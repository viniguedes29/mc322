package com.guedes.lab5;
import java.util.Date;
import java.time.LocalDate;
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
        System.out.println("Verificando CNPJs e CPF ");
        System.out.print("CPF: " + cpf1 + ", validade: ");
        System.out.println(ClientePF.validarCPF(cpf1));
        System.out.print("CPF: " + cpf2 + ", validade: ");
        System.out.println(ClientePF.validarCPF(cpf2));
        System.out.print("CNPJ: " + cnpj2 + ", validade: ");
        System.out.println(ClientePJ.validarCNPJ(cnpj1));
        System.out.print("CNPJ: " + cnpj1 + ", validade: ");
        System.out.println(ClientePJ.validarCNPJ(cnpj2));
  
        
        // Endereços.
        String endereco1 = "Rua Kyuube, 999, Konohagakure, Pais do Fogo";
        String endereco2 = "Rua da Névoa, 444, Kirigakure, País da Água";
        String endereco3 = "Rua Pitágora, 345, Unicamp, Barao Geraldo";
        String endereco4 = "Rua A, 888, Kumogakure, País do Relâmpago";
        String endereco5 =  "Rua do Trovão 999, Konogakure, País do fogo";
        String endereco6 =  "Rua Hichiraku 888, Konogakure, País do fogo";
        
        // Datas
		LocalDate nascimento = LocalDate.of(2002, 10, 5);
		LocalDate licensa = LocalDate.of(2023, 30, 8);
		Date fundacao = new Date(2023, 01,01);
		
        // Iniciando veículos
		Veiculo veiculo1 = new Veiculo("XYZ12345", "Monza", "Chevrolet", 2000);
		Veiculo veiculo2 = new Veiculo("XYZ3233", "Camaro", "Chevrolet", 2018);
		Veiculo veiculo3 = new Veiculo("XYZ1234", "Rural", "Volksvagem", 1980);
		Veiculo veiculo4 = new Veiculo("XYZ1298", "Polo", "Volksvagem", 2023);
		Veiculo veiculo5 = new Veiculo("ABC1298", "Rural", "Volksvagem", 2023);
		System.out.println("\nVerificando o veiculo1: ");
        System.out.println(veiculo1);
        // Iniciando lista de veículos
		ArrayList<Veiculo> veiculosCliente1 = new ArrayList<Veiculo>();
		ArrayList<Veiculo> veiculosCliente2 = new ArrayList<Veiculo>();
		ArrayList<Veiculo> veiculosCliente3 = new ArrayList<Veiculo>();
		ArrayList<Veiculo> veiculosCliente4 = new ArrayList<Veiculo>();
        // Adicionando os carros a lista dos respectivos donos
		veiculosCliente1.add(veiculo1);
        veiculosCliente2.add(veiculo2);
        veiculosCliente3.add(veiculo3);
        veiculosCliente4.add(veiculo4);
        veiculosCliente4.add(veiculo5);
		
        
		//Iniciando clientes
		ClientePF cliente1 = new ClientePF(nomePF1, endereco1, cpf1, veiculosCliente1, "M",
				"Superior Incompleto", licensa, nascimento, "Muito rico");
		ClientePF cliente2 = new ClientePF(nomePF2, endereco2, cpf2, veiculosCliente2, "M",
				"Superior Completo", licensa, nascimento, "Muito rico");
		ClientePJ cliente3 = new ClientePJ(nomePJ1, endereco3,  veiculosCliente3, cnpj1, fundacao, 10);
		ClientePJ cliente4 = new ClientePJ(nomePJ2, endereco4,  veiculosCliente4, cnpj2, fundacao, 20);
        System.out.println("Verificando o cliente1: ");
        System.out.println(cliente1);
		
		//Iniciando seguradoras
        //Lista de clientes e seguradoras iniciam vazios
		Seguradora seguradora1 = new Seguradora(nomeSeg1, telefone1, "konoha@seguros.com.br", endereco5 + ", sala 1", 
                      new ArrayList<Sinistro>(), new ArrayList<Cliente>()); 
        Seguradora seguradora2 = new Seguradora(nomeSeg2, telefone2, "seguradora@unicamp.sp", endereco5 + ", sala 2", 
                      new ArrayList<Sinistro>(), new ArrayList<Cliente>());

        // Iniciando sinistros
        Sinistro sinistro1 = new Sinistro("pegou fogo", endereco6, "02/03/2023", 
                                          seguradora1, veiculo1, cliente1);
        Sinistro sinistro2 = new Sinistro("Atingido por raio", endereco6, "05/04/2023", 
                                          seguradora2, veiculo2, cliente2);
        Sinistro sinistro3 = new Sinistro("Destruido por beeju", endereco3, "03/01/2023", 
                                            seguradora1, veiculo3, cliente3);
        Sinistro sinistro4 = new Sinistro("Destruído por meteoro", endereco4, "01/05/2023",
                                            seguradora1, veiculo4, cliente4);
        Sinistro sinistro5 = new Sinistro("Destruído por meteoro", endereco4, "01/05/2023",
                                        seguradora1, veiculo5, cliente4);
        System.out.println("Verificando o sinistro 1: ");
        System.out.println(sinistro1);
    
    // Cadastrando clientes. Retirba tre se cadastrou, false se não
    System.out.println("\n\nCadastrando clientes válidos e inválidos. ");
    System.out.print("Cadastrando cliente1 na seguradora1, resultado: ");
    System.out.println(seguradora1.cadastraCliente(cliente1));
    System.out.print("Cadastrando cliente2 na seguradora2, resultado: ");
    System.out.println(seguradora2.cadastraCliente(cliente2)); // CPF inválido
    System.out.print("Cadastrando cliente3 na seguradora1, resultado: ");
    System.out.println(seguradora1.cadastraCliente(cliente3));
    System.out.print("Cadastrando cliente4 na seguradora2, resultado: ");
    System.out.println(seguradora2.cadastraCliente(cliente4)); // CNPJ inválido
    // Atualizando CPF e CNPJ
    cliente2.setCpf("408.771.300-86");
    cliente4.setCnpj("69.589.851/0001-18");
    System.out.println("\nTentando cadastrar clientes inválidos, após atualiza-los.");
    System.out.print("Cadastrando cliente2 após atualizar o CPF para: " + cliente2.getCpf() +
                    ". Resultado: ");
    System.out.println(seguradora2.cadastraCliente(cliente2)); 
    System.out.print("Cadastrando cliente4 após atualizar o CPF para: " + cliente4.getCnpj() +
    ". Resultado: ");

    System.out.println(seguradora2.cadastraCliente(cliente4));
    // Seguradoras cadastradas, verificando
    System.out.println("\n\nVerificando as segurados: ");
    System.out.println(seguradora1.toString());
    System.out.println(seguradora2.toString());
    
    // Casastrando sinistros
    System.out.println("\n\nCadastrando sinistros da seguradora 1: ");
    System.out.print("Tentando cadastrar sinistro1, resultado: ");
    System.out.println(seguradora1.gerarSinistro(sinistro1));
    System.out.print("Tentando cadastrar sinistro3, resultado: ");
    System.out.println(seguradora1.gerarSinistro(sinistro3));
    System.out.print("Tentando cadastrar sinistro2, resultado: ");
    System.out.println(seguradora1.gerarSinistro(sinistro2)); // Tentando cadastrar um sinistro cujo cliente não é da seguradora.
    System.out.println("\nCadastrando sinistros da seguradora 2: ");
    System.out.print("Tentando cadastrar sinistro5, resultado: ");
    System.out.println(seguradora2.gerarSinistro(sinistro5));
    System.out.print("Tentando cadastrar sinistro2, resultado: ");
    System.out.println(seguradora2.gerarSinistro(sinistro2));
    System.out.print("Tentando cadastrar sinistro4, resultado: ");
    System.out.println(seguradora2.gerarSinistro(sinistro4));

    // Removendo cliente:
    System.out.println("\n\nRemovendo clientes: ");
    System.out.print("Removendo cliente1 na seguradora1, resultado: ");
    System.out.println(seguradora1.removeCliente(cliente1.getCpf()));
    // Listando os sinistros e os clientes da seguradora 1
    System.out.println("Verificando os clientes e os sinistros da seguradora1 após retirar o cliente1.");
    System.out.print("Clientes PF: ");
    seguradora1.listarCliente("PF");
    System.out.print("Sinistros PF: ");
    seguradora1.listarSinistro("PF");
    System.out.print("Clientes PJ: ");
    seguradora1.listarCliente("PJ");
    System.out.print("Sinistros PJ: ");
    seguradora1.listarSinistro("PJ");

    



    }   
}
