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
	
	public String getCpf() {
		return cpf;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getIdade() {
		return dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}	
	
	public void setNome(String umNome) {
		this.nome = umNome;
		
	}
	
	public void setCpf(String umCpf) {
		this.cpf = umCpf;
		
	}
	public void setDataNascimento(String umaDataNascimento) {
		this.dataNascimento = umaDataNascimento;
		
	}
	
	public void setIdade(String umaIdade) {
		this.dataNascimento = umaIdade;
		
	}
	
	public void setEndereco(String umEndereco) {
		this.nome = umEndereco;
		
	}
	
	public boolean validaCPF(String Umcpf) {
		
		cpf = cpf.replaceAll("`[^0-9]`", "");
		
		if (cpf.length() != 11) {
			return false;
		}
		// Verificar se todos os dígitos são iguais. Deixa resto zero na divisão por 11111111111
		if((Integer.parseInt(cpf) % 11111111111) == 0) {
			return false;
			
		}
		
		
		
		return true;
				
		
		
	}

}
