package lab1;

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
	
	public int somaDigitoVerificador(String cpf) {
		int soma = 0;
		for (i 1)
				
		
	}
	

	public boolean validarCPF(String cpf) {
		cpf = cpf.replaceAll("[^0-9]", "");
		
		if(cpf.length() != 11) {
			return false;	
		}
		
		if (Integer.parseInt(cpf) % 11111111111L != 0 ) {
			return false;
		}
		
		
		
		return true;
		
		
		
		
	
	}


		

}
