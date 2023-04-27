package com.guedes.lab3;
import java.util.ArrayList;
import java.util.Date;

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
    public boolean cadastraCliente(Cliente cliente){
        /* Função que verifica de pode adicionar se pode adicionar um cliente à listaCliente da seguradora 
         * Se puder adicionar, ele adiciona e retorna true
         * Se não puder ele retorna false.
         * O critério de adição é adionar 
        */
        if(listaCliente.contains(cliente)){
            return false;
    
        //É necessário verificar se o Cliente é do tipo ClintePF e ClientePJ
        } else if (cliente instanceof ClientePF){
            // Verifica se a instância é da classe ClientePF, se for, pega-se o CPF
            String cpf = ((ClientePF) cliente).getCpf();
            if(((ClientePF) cliente).validarCPF(cpf)){
                System.out.println("PF");
                //Se o CPF é válido, adiciona o Cliente à lista e retorna true.
                listaCliente.add(cliente);
                System.out.println("Cadastrou");
                return true;              
                
            } else{
                // Se o CPF for inválido, retorta true e volta False.
                System.out.println("CPF Inválido");
                return false;
            }
            
        } else if ((cliente instanceof ClientePJ)){
            //Analogamente ao fluxo de de PF, para validar e adicionar
            String cnpj = ((ClientePJ) cliente).getCnpj();
            if(((ClientePF) cliente).validarCPF(cnpj)){
                listaCliente.add(cliente);
                return true;
                
            } else{
                return false;
            }
        } else{
        // Para o caso que ele não está adicionado na lista, não ser uma instância PF ou PJ
        // Nesse caso considerie que não se deve adicionar
            System.out.println("Final");
            return false;
        }
    }

    public boolean gerarSinistro(Sinistro sinistro){
        // Tenta adicionar um cliente à lista. Se adicionar retorna true, se não retorna false.
        if (listaSinistro.contains(sinistro)){
            // Se já está na lista, não adiciona
            return false;
        }else if(sinistro.verificaVeiculo(sinistro.getVeiculo())){
            listaSinistro.add(sinistro);
            return true;
        }else{
            return false;
        }
    }

    public boolean vizualizarSinistro(String nome){
        // Se um cliente com um determinado nome tem sinistro nessa segura, retornamos true e printamos. Se não, retorna false.
        ArrayList<Sinistro> lista_auxiliar = new ArrayList<Sinistro>(); // Lista que conterá os sinistos que tem um cliente com nome==nome
        
        for(Sinistro sinistro: listaSinistro){
            if(sinistro.getCliente().getNome() == nome){
                // Se houver um sinistro com um cliente desse nome, adicionamos a lista auxiliar
                lista_auxiliar.add(sinistro);
            }
        }
        
        if (lista_auxiliar.size() > 0){
        // Se a lista não estiver vazia, é pq há um sinistro para um cliente com o nome passado
        System.out.println(lista_auxiliar.toString());
        return true;

        }else{
        // Se estiver vazia, retorna false.
            System.out.print(nome);
            System.out.println(" não tem sinistros nesta seguradora.");
            return false;
        }
    }

    public void removeSinistro(Sinistro sinistro){
        // Remove o sinistro.
        listaSinistro.remove(sinistro);
    }

    public void removeCliente(Cliente cliente){
    // Remove o cliente dessa seguradora. Para remover o cliente, primeiro removemos todos os sinistros desse cliente.
    
    for(Sinistro sinistro: listaSinistro){
        if(sinistro.getCliente() == cliente){
            removeSinistro(sinistro);
        }
    }
    }
	
    public String toString(){
		String texto = "Segurado: " + this.nome +
                        "\nTelefone:" + this.telefone +
                        "\nEndereco: " + this.endereco +
                        "\nEmail: " + this.email;
                
		return texto;
	}

	



	public static void main(String[] args){
		// Método main para retirar bugs da classe. Por favor, desconsiderar.
        Date data1 = new Date(2002, 10, 5);
		Date data2 = new Date(2023, 30, 8);
		Veiculo veiculo1 = new Veiculo("XYZ3233", "Monza", "Chevrolet", 2000);
		Veiculo veiculo2 = new Veiculo("XYZ1234", "Rural", "Volksvagem", 1880);
		ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		listaVeiculos.add(veiculo1);
		listaVeiculos.add(veiculo2);
		ClientePF cliente1 = new ClientePF("Naruto Uzumai da Sukva", "Konohagakure","61313511390",
				listaVeiculos, "masculino","academia ninja incompleta",
				data1 ,data2, "muito rico");
		ArrayList<Cliente> listaCliente1 = new ArrayList<Cliente>();
        ArrayList<Sinistro> listaSinistro1 = new ArrayList<Sinistro>();
        Seguradora seguradora = new Seguradora("Segura Peao", "0800", "seguuuurapeao@segura.com", 
        "Rua Pitágoras, 345", listaSinistro1, listaCliente1);
        if (seguradora.cadastraCliente(cliente1)){
            System.out.println("Cadastrado com sucesso");
        
        }else{
            System.out.println("Erro ao cadastrar");
        };
        Sinistro sinistro = new Sinistro("pegou fogo", "Konoga", "15/10/22", 
                    seguradora, veiculo1, cliente1);
        if(seguradora.gerarSinistro(sinistro)){
            System.out.println("Sinistro cadastrado");
        } else{
            System.out.println("Não cadastrado");
        }

        //sinistro1.setSinistro("Pegou fogo");
        //sinistro1.setEndereco("Rua da Névoa, 444, Kirigakure, País da Água");
        System.out.println(seguradora.toString());
	}

}
