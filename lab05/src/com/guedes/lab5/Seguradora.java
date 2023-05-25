package com.guedes.lab5;

import java.security.Identity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	private ArrayList<Sinistro> listaSinistro;
	private ArrayList<Cliente> listaCliente;

	public Seguradora(String nome, String telefone, String email, String endereco, 
                ArrayList<Sinistro> listaSinistro, ArrayList<Cliente> listaCliente){
                    this.nome = nome;
                    this.telefone = telefone;
                    this.email = email;
                    this.endereco = endereco;
                    this.listaCliente = listaCliente;
                    this.listaSinistro = listaSinistro;
                }

    // Getters e Setters


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Sinistro> getListaSinistro() {
        return listaSinistro;
    }

    public void setListaSinistro(ArrayList<Sinistro> listaSinistro) {
        this.listaSinistro = listaSinistro;
    }

    public ArrayList<Cliente> getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(ArrayList<Cliente> listaCliente) {
        this.listaCliente = listaCliente;
    }

    // Adicionando Cliente

    private boolean cadastraClientePF(ClientePF cliente) {
        // Método que recebe um objetivo cliente PF e adiciona na lista de clientes.
        // Se foi adicionado, retorna um booleano.
        // É privado, pois deve ser chamado em outro método, que faz uma série de verificações
    	String cpf = cliente.getCpf();
    	if(ClientePF.validarCPF(cpf)){ // Dúvida: O VSCode reclamou que eu chamei um método estático dentro de um não estático
            //Se o CPF é válido, adiciona o Cliente à lista e retorna true.
            listaCliente.add(cliente);
            // Ao cadastrar o cliente, calcula o valor do seguro
            calcularPrecoSeguroCliente(cliente);
            return true;              
            
        } else{
            // Se o CPF for inválido, retorta true e volta False.
            return false;
        }
    	
    }
    
    private boolean cadastraClientePJ(ClientePJ cliente) {
    	String cnpj = cliente.getCnpj();
        if(ClientePJ.validarCNPJ(cnpj)){
        	// Se o CNPJ é valorido, cadastra
            listaCliente.add(cliente);
            // Ao cadastrar o cliente, calcula o valor do seguro
            calcularPrecoSeguroCliente(cliente);
            return true;
            
        } else{
            return false;
        }
        }

    public boolean cadastraCliente(Cliente cliente){
        /* Função que verifica de pode adicionar se pode adicionar um cliente à listaCliente da seguradora 
         * Se puder adicionar, ele adiciona e retorna true
         * Se não puder ele retorna false.
         * O critério de adição é adionar 
        */
    	
    	// VERIFICAR A IDADE E TUDO QUE PODE GERAR UM CLIENTE INVÁLIDO
    	
        if(listaCliente.contains(cliente)){
            return false;
    
        //É necessário verificar se o Cliente é do tipo ClintePF e ClientePJ. Após verificar, chama o método de cadastro do respectivo cliente
        } else if (cliente instanceof ClientePF){
            return cadastraClientePF((ClientePF) cliente);
            
        } else if ((cliente instanceof ClientePJ)){
        	return cadastraClientePJ((ClientePJ) cliente);
        	
        } else{
        // Para o caso que ele não está adicionado na lista, não ser uma instância PF ou PJ
        // Nesse caso considerie que não se deve adicionar
            return false;
        }
    }

    public boolean gerarSinistro(Sinistro sinistro){
        // Tenta adicionar um cliente à lista. Se adicionar retorna true, se não retorna false.
        Cliente cliente = sinistro.getCliente();
        Veiculo veiculo = sinistro.getVeiculo();
        if (listaSinistro.contains(sinistro)){
            // Se já está na lista, não adiciona
            return false;
        }else if(listaCliente.contains(cliente)){
            // Se o cliente for dessa seguradora, verifica se o veículo é do cliente
            if(sinistro.verificaVeiculo(veiculo)){
                // Se o veículo pertence ao cliente, adicionamos o sinistro à lista de sinistros
                this.listaSinistro.add(sinistro);
                // Se o sinistro for registrado, atualiza-se o valor do seguro do cliente
                calcularPrecoSeguroCliente(cliente);
            return true;
            } else {
                // Se o veículo não for do cliente, não adiciona.
                return false;
            }

        }else{
            // Se o sinistro não estiver cadastrado e o cliente não, não adiciona.
            return false;
        }
    }

        // Remove cliente
        // Há métodos para remover clientes PF e PJ privados, chamados dentro do método público

        private void removeSinistroCliente(Cliente cliente){
            // Remove todos os sinistros de um cliente
            // Para naõ dar ConcurrentModificationException, vou capturar o elementos a serem removidos, e depois remove-los.
            ArrayList<Sinistro> lista_auxiliar = new ArrayList<Sinistro>(); // Lista auxiliar que recebe os sinistros do cliente
            for (Sinistro sinistro : listaSinistro){
                // Pegando os sinistros do cliente
                if(sinistro.getCliente() == cliente){ // Se o cliente ligado ao objeto sinistro é o passado, remove-o
                    lista_auxiliar.add(sinistro);
                }
            }
            for (Sinistro sinistro: lista_auxiliar){
                // Removendo os sinsitros. 
                this.listaSinistro.remove(sinistro);

            }

            // Seta o valor do seguro.
            calcularPrecoSeguroCliente(cliente);

        } 

        private void removerClientePF(String cpf){
            // Percorre a lista de clientes e retira o que tem CPF passado
            for(Cliente cliente: listaCliente){
                if(((ClientePF) cliente).getCpf() == cpf){
                    listaCliente.remove(cliente);
                }
            }
        }
        
        public boolean removerCliente(String identificador){
            /* Função remove um cliente da seguradora
             * Se o cliente estiver na seguradora, ele é removido e retorna true 
             */
            for(Cliente cliente: listaCliente){
                if(cliente instanceof ClientePF){
                    ClientePF c1 = (ClientePF) cliente;
                    if (c1.getCpf() == identificador){
                        removerClientePF(identificador);

                    }
                }
            }
            if(! listaCliente.contains(cliente)){
                // Se o cliente está na seguradora, não remove    
                return false;
            } else{
                // Se está na lista, remove os sinsitros (atualizando o valor do seguro), remove da lista e atualiza o valor do seguro.
                removeSinistroCliente(cliente);
                listaCliente.remove(cliente);
                calcularPrecoSeguroCliente(cliente);
                return true;
            }
        }

    /*Cadastra um novo veículo para o cliente -> Feito na classe seguradora, pois ao adicionar um novo cliente
     * é necessário calcular novamente o preço do seguro */
    public boolean cadastraVeiculo(Veiculo veiculo, Cliente cliente){
        // Se o veiculo já está na lista, adiciona e retorna true, se não retorna false
        if(!cliente.getListaVeiculos().contains(veiculo)){
            //Adiciona
            cliente.getListaVeiculos().add(veiculo);
            calcularPrecoSeguroCliente(cliente);
            return true;
        } else{
            return false;
        }
        
    }

    // Vizualisar o Sinistro de um cliente

    public boolean vizualizarSinistro(String identificador){
        // Retorna todos os sinistros de um cliente com um determinado CPF ou CNPJ
        ArrayList<Sinistro> lista_auxiliar = new ArrayList<Sinistro>();
         // variável de controle para definir se será printado e retornado true ou false
        if(ClientePJ.validarCNPJ(identificador)){
            // Se for um CNPJ válido, busca-se por um cliente PJ com esse identificador na lista cliente para remove-lo
        for(Sinistro sinistro: listaSinistro){
            if(((ClientePJ) sinistro.getCliente()).getCnpj() == identificador){
                // Se o sinsitro atual, tem o cliente atual, 
                lista_auxiliar.add(sinistro);
            }

        }
        } else if(ClientePF.validarCPF(identificador)){
            // Funciona de forma análoga às primeiras verificações
            for(Sinistro sinistro: listaSinistro){
                if(((ClientePF) sinistro.getCliente()).getCpf() == identificador){
                    // Se o sinsitro atual, 
                    lista_auxiliar.add(sinistro);
                }
               
            }
        } else{
            return false; // CPF ou CNPJ inválidos
        }

        if(lista_auxiliar.size() > 0){
            // Se a lista com os sinistros do cliente é não vazia, printa-os e retorna true.
           System.out.println(lista_auxiliar);
           return true;
        } else{
            return false;
        }
    }

    // Listar o sinistros de um Sinistros PJ ou PF, conforme o parâmetro
    
    public ArrayList<String> retornaSinistroPJ(){
        // Função que retorna uma lista com os sinistros ligados a clientes PJ
        ArrayList<String> lista_auxiliar = new ArrayList<String>(); // Cotém os sinistros com cliente PJ
        for(Sinistro sinistro: listaSinistro){
            if((sinistro.getCliente() instanceof ClientePJ)){
                lista_auxiliar.add("Cliente: " + sinistro.getCliente().getNome() + ", Sinistro: " +
                sinistro.getSinistro() + ", Veiculo: " + sinistro.getVeiculo().getMarca() + 
                ", " + sinistro.getVeiculo().getModelo() + ", " + sinistro.getVeiculo().getAnoFabricacao());
            }
        }

        return lista_auxiliar;
    }

    public ArrayList<String> retornaSinistroPF(){
        // Função que retorna uma lista com os sinistros ligados a clientes PF
        ArrayList<String> lista_auxiliar = new ArrayList<String>(); // Cotém os sinistros com cliente PF
       
        for(Sinistro sinistro: listaSinistro){
            if((sinistro.getCliente() instanceof ClientePF)){
                lista_auxiliar.add("Cliente: " + sinistro.getCliente().getNome() + ", Sinistro: " +
                sinistro.getSinistro() + ", Veiculo: " + sinistro.getVeiculo().getMarca() + 
                ", " + sinistro.getVeiculo().getModelo() + ", " + sinistro.getVeiculo().getAnoFabricacao());
            }
        }
        return lista_auxiliar;
    }

    public void listarSinistro(String tipoCliente){
        ArrayList<String> sinistros = new  ArrayList<String>();
        if(tipoCliente == "PJ"){
            sinistros =  retornaSinistroPJ();

        } else if (tipoCliente == "PF" ){
            sinistros =  retornaSinistroPF();
        }

        System.out.print("Sinistro do tipo " + tipoCliente + ": ");
        System.out.println(sinistros);

    }
    // Listar o sinistros de um Sinistros PJ ou PF, conforme o parâmetro
    
    public ArrayList<String> retornaClientePJ(){
        // Função que retorna uma lista com os clientes PJ
        ArrayList<String> lista_auxiliar = new ArrayList<String>(); // Cotém os sinistros com cliente PJ
        for(Cliente cliente: listaCliente){
            if((cliente instanceof ClientePJ)){
                lista_auxiliar.add("Cliente: " + cliente.getNome() + ", CNPJ: " 
                + ((ClientePJ) cliente).getCnpj());
            }
            }

        return lista_auxiliar;
    }

    public ArrayList<String> retornaClientePF(){
        // Função que retorna uma lista com os sinistros ligados a clientes PF
        ArrayList<String> lista_auxiliar = new ArrayList<String>(); // Cotém os sinistros com cliente PF
       
        for(Cliente cliente: listaCliente){
            if((cliente instanceof ClientePF)){
                lista_auxiliar.add("Cliente: " + cliente.getNome() + ", CPF: " 
                + ((ClientePF) cliente).getCpf());
            }
            }
        return lista_auxiliar;
    }

    public void listarCliente(String tipoCliente){
        ArrayList<String> clientes = new  ArrayList<String>();
        if(tipoCliente == "PJ"){
            clientes =  retornaClientePJ();

        } else if (tipoCliente == "PF" ){
            clientes =  retornaClientePF();
        }

        System.out.print("Clientes do tipo " + tipoCliente + ": ");
        System.out.println(clientes);

    }

    // Calulando o valor do seguro de um cliente
    public void cadastrarClientePFTerminal(){
        Scanner entrada = new Scanner(System.in);
        // Recebe os dados
        String nome, endereco, cpf, genero, educacao, classeEconomica;
        int diaNascimento, mesNascimento, anoNascimento, diaLicensa, mesLicensa, anoLicensa;
        LocalDate dataNascimento, dataLiscensa;
        ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
        Cliente cliente;

        // Recebendo o parâmetro
        System.out.print("Digite o nome do cliente: ");
        nome = entrada.nextLine();
        System.out.print("Digite o endereco: ");
        endereco = entrada.nextLine();
        System.out.print("Digite o genero: ");
        genero = entrada.nextLine();
        System.out.print("Digite o educacao: ");
        educacao = entrada.nextLine();
        System.out.print("Digite a classe economica: ");
        classeEconomica = entrada.nextLine();
        System.out.print("Digite o CPF: ");
        cpf = entrada.nextLine();
        System.out.print("Digite o dia do nascimento: ");
        diaNascimento = entrada.nextInt();
        System.out.print("Digite o mes do nascimento: ");
        mesNascimento = entrada.nextInt();
        System.out.print("Digite o ano do nascimento: ");
        anoNascimento = entrada.nextInt();
        System.out.print("Digite o dia da assinatura da liscensa: ");
        diaLicensa = entrada.nextInt();
        System.out.print("Digite o mês da assinatura da liscensa: ");
        mesLicensa = entrada.nextInt();
        System.out.print("Digite o ano da assinatura da liscensa: ");
        anoLicensa = entrada.nextInt();
        dataNascimento = LocalDate.of(anoNascimento, mesNascimento, diaNascimento);
        dataLiscensa = LocalDate.of(anoLicensa, mesLicensa, diaLicensa);
        
        while(!Validacao.validaNome(nome)){
            System.out.print("Nome com caracteres especiais, corrija e digite novamente: ");
            nome = entrada.nextLine();
        }

        while(!Validacao.validaCPF(cpf)){
            System.out.print("CPF inválido, digite novamente: ");
            cpf = entrada.nextLine();
        }

        cliente = new ClientePF(nome, endereco, cpf, listaVeiculos,genero, 
                                educacao, dataLiscensa, dataNascimento, classeEconomica);
        calcularPrecoSeguroCliente(cliente);
        listaCliente.add(cliente);


    }

    //Calculando o valor do seguro

    public int numeroSinistroCliente(Cliente cliente){
        //Função retorno o número de sinsitros do cliente na seguradora
        // Percorre a lista de clientes e retorna o número de clientes e alterar o contador
        // Não verifica se o cliente está cadastrado, pois um cliente fora da seguradora tem um valor default
        int contador = 0; 
        for(Sinistro sinistro: listaSinistro){
            if (sinistro.getCliente() == cliente){
                contador++;
            }
        }
        return contador;
    }

    public void calcularPrecoSeguroCliente(Cliente cliente){
        // Calcula o valor do seguro para UM cliente, a partir do número de sinistros e do score.
        // Atualiza o valor da variável precoSeguro do objeto cliente e retorna o valor
        int numero_sinistro = numeroSinistroCliente(cliente); 
        double score = cliente.calculaScore();
        cliente.setValorSeguro(score*(1+numero_sinistro));
    }

    public void calcularPrecoSeguroCliente(){
        // Calcula o valor do seguro para TODOS os clientes na seguradora, a partir do método sobrecarregado
        for (Sinistro sinistro: listaSinistro){
            Cliente cliente = sinistro.getCliente();
            calcularPrecoSeguroCliente(cliente);
        }
    }

    // Calculando a receita
    public double calcularReceita(){
        double receita = 0;
        for (Cliente cliente: listaCliente){
            receita += cliente.getValorSeguro();
        }
        return receita;
    }

    // Cadastro a partir de input de dados

    
    public String toString(){
		String texto = "Segurado: " + this.nome +
                        "\nTelefone:" + this.telefone +
                        "\nEndereco: " + this.endereco +
                        "\nEmail: " + this.email + 
                        "\nClientes PF: " + retornaClientePF() + 
                        "\nCliente PJ: " + retornaClientePJ();
                        
                
		return texto;
	}
	public static void main(String[] args){
		// Método main para retirar bugs da classe. Por favor, desconsiderar na correção.
		Veiculo veiculo1 = new Veiculo("XYZ3233", "Monza", "Chevrolet", 2000);
		Veiculo veiculo2 = new Veiculo("XYZ1234", "Rural", "Volksvagem", 1880);
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		listaVeiculos.add(veiculo1);
		listaVeiculos.add(veiculo2);
		ArrayList<Cliente> listaCliente1 = new ArrayList<Cliente>();
        ArrayList<Sinistro> listaSinistro1 = new ArrayList<Sinistro>();
        Seguradora seguradora = new Seguradora("Segura Peao", "0800", "seguuuurapeao@segura.com", 
        "Rua Pitágoras, 345", listaSinistro1, listaCliente1);
        seguradora.cadastrarClientePFTerminal();
        seguradora.getListaCliente().toString();
        seguradora.listarCliente("PF");

        

	}

}
