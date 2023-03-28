package lab1;

public class Main{
    public static void main(String[] args) {
        // Criando um objeto seguradora, que para o contexto desse script será uma única
        Seguradora seguradora = new Seguradora();
        seguradora.setNome("Konoha Seguros SA");
        seguradora.setEmail("sac@konohaseguradora.com");
        seguradora.setTelefone("85 1234-5678");
        seguradora.setEndereco("Rua Kyuube, 999, Konohagakure, Pais do Fogo");
        System.out.println(seguradora.toString());

        // Criando o objeto cliente e preenchendo as variáveis
        Cliente cliente1 = new Cliente();
		cliente1.setCpf("226.721.213-80"); //CPF inválido gerado em site da internet
		cliente1.setDataNascimento("02/03/2001");
		cliente1.setEndereco("Rua Pitágora, 345, Unicamp, Barao Geraldo");
		cliente1.setIdade("22");
		cliente1.setNome("Sasuke Uchiha da Silva");
		System.out.println(cliente1.toString());

        if(cliente1.validarCPF(cliente1.getCpf())){
            System.out.println("O CPF digitado e valido.");
        } else{
            System.out.println("O CPF " + cliente1.getCpf() + " é invalido, por favor revisar.");
        }

        // Para esse cliente, vamos criar um veículo
        Veiculo veiculo1 = new Veiculo();
        veiculo1.setMarca("Chevrolet");
        veiculo1.setModelo("Monza");
        veiculo1.setPlaca("CHP1234");
        System.out.println(veiculo1.toString());
        
        // Criando um sinistro para o veículo do cliente.
        Sinistro sinistro1 = new Sinistro();
        sinistro1.setSinistro("Pegou fogo");
        sinistro1.setEndereco("Rua da Névoa, 444, Kirigakure, País da Água");
        System.out.println(sinistro1.toString());
        
        // Formatando um espaçamento entre as saídas
        System.out.println("\n");
        System.out.println("__________________");
        System.out.println("\n");

        // Criando um segundo objeto cliente e preenchendo as variáveis
        Cliente cliente2 = new Cliente();
		cliente2.setCpf("156.245.813-27"); //CPF válido gerado em site da internet
		cliente2.setDataNascimento("02/03/2001");
		cliente2.setEndereco("Rua Pitágora, 345, Unicamp, Barao Geraldo"); // Mora no mesmo endereço que o cliente 1
		cliente2.setIdade("22"); // Mesma idade que o cliente 1
		cliente2.setNome("Naruto Uzumaki Rodrigues");
		System.out.println(cliente2.toString());

        if(cliente1.validarCPF(cliente2.getCpf())){
            System.out.println("O CPF digitado e valido.");
        } else{
            System.out.println("O CPF " + cliente2.getCpf() + " é invalido, por favor revisar.");
        }

        // Para esse cliente, vamos criar um veículo
        Veiculo veiculo2 = new Veiculo();
        veiculo2.setMarca("BMW");
        veiculo2.setModelo("X30");
        veiculo2.setPlaca("HKG0007");
        System.out.println(veiculo2.toString());
        
        // Criando um sinistro para o veículo do cliente.
        Sinistro sinistro2 = new Sinistro();
        sinistro2.setSinistro("Danificado por raio");
        sinistro2.setEndereco("Rua A, 888, Kumogakure, País do Relâmpago");
        System.out.println(sinistro2.toString());

    
}
}
