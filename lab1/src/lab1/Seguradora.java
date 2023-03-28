package lab1;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
	
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

	public String tostring(){
		String texto = getNome() + "As informações para contato são: \n" + "Telefone: " + getTelefone() + "\nE-mail: " + getEmail() + "\nEndereco: " + getEndereco();
		return texto;
	}

	public static void main(String[] args){
		// Método main para retirar bugs.

		Sinistro sinistro1 = new Sinistro();
        sinistro1.setSinistro("Pegou fogo");
        sinistro1.setEndereco("Rua da Névoa, 444, Kirigakure, País da Água");
        System.out.println(sinistro1.toString());


	}

}
