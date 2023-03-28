package lab1;

public class Veiculo {
    private String placa;
    private String modelo;
    private String marca;

    public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
    }

    public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
    }
    
    public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
    }

    public String toString(){
        String texto = "Carro de placa " + getPlaca() + ", do modelo " + getModelo() + " da marca " + getMarca();
        return texto;
    }

    public static void main(String[] args) {
      // Método main criado para testar e corrigir bugs na classe
      Veiculo veiculo1 = new Veiculo();
        veiculo1.setMarca("Chevrolet");
        veiculo1.setModelo("Monza");
        veiculo1.setPlaca("CHP1234");
        System.out.println(veiculo1.toString());


    }
}
