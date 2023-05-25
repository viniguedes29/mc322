package com.guedes.lab4;

public enum CalcSeguro {
	VALOR_BASE(100.0),
	FATOR_18_30(1.2),
	FATOR_30_60(1.0),
	FATOR_60_90(1.5);
	
	private double valor;
	
	CalcSeguro(double valor){
		this.valor = valor;
	}
	
	public double getValor(){
		return valor;
		}
	
	 public static double getFatorIdade(int idade) {
		 // Função construída pensando que todas as idades são maiores que 18
		 if(18 <= idade & idade < 30) {
			 return FATOR_18_30.valor;
		 } else if(idade < 60){
			 return FATOR_30_60.valor;
		 } else {
			 return FATOR_60_90.valor;
		 }
	 }	

	}

