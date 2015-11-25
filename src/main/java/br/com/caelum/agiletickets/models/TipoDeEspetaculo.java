package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {
	
	CINEMA {
		@Override
		public BigDecimal calculaPreco(Sessao sessao, double percentualDisponivel) {
			BigDecimal preco;
			
			
			if(percentualDisponivel <= 0.05) { 
				preco = sessao.aplicaPercentual(0.10);
			} else {
				preco = sessao.getPreco();
			}
			return preco;
		}
		
	}, 
	
	SHOW {
		@Override
		public BigDecimal calculaPreco(Sessao sessao, double percentualDisponivel) {
			BigDecimal preco;
			
			if(percentualDisponivel <= 0.05) { 
				preco = sessao.aplicaPercentual(0.10);
			} else {
				preco = sessao.getPreco();
			}
			return preco;
		}
	}, 
	
	TEATRO {
		@Override
		public BigDecimal calculaPreco(Sessao sessao, double percentualDisponivel) {
			return sessao.getPreco();
		}
	}, 
	
	BALLET {
		@Override
		public BigDecimal calculaPreco(Sessao sessao, double percentualDisponivel) {
			BigDecimal preco;
			
			if(percentualDisponivel<= 0.50) { 
				preco = sessao.aplicaPercentual(0.20);
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPercentualDoPreco(0.10));
			}
			
			return preco;
		}
	}, 
	
	ORQUESTRA {
		@Override
		
		public BigDecimal calculaPreco(Sessao sessao, double percentualDisponivel) {
			BigDecimal preco;
				
			if(percentualDisponivel <= 0.50) { 
				preco = sessao.aplicaPercentual(0.20);
			} else {
				preco = sessao.getPreco();
			}

			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(sessao.getPercentualDoPreco(0.10));
			}
			
			return preco;
		}
	};

	
	public abstract BigDecimal calculaPreco(Sessao sessao, double percentualDisponivel);
	
	
}
