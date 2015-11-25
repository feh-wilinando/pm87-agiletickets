package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
		int ingressosDisponiveis = sessao.getTotalIngressos() - sessao.getIngressosReservados();
		double quantidadeDeIngressos = sessao.getTotalIngressos().doubleValue();
		double percentualDisponivel = ingressosDisponiveis / quantidadeDeIngressos;
		
		
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			//quando estiver acabando os ingressos... 
			if(percentualDisponivel <= 0.05) { 
				preco = sessao.getPreco().add(calculaPercentual(sessao, 0.10));
			} else {
				preco = sessao.getPreco();
			}
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)) {
			if(percentualDisponivel <= 0.50) { 
				preco = sessao.getPreco().add(calculaPercentual(sessao, 0.20));
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(calculaPercentual(sessao, 0.10));
			}
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			if(percentualDisponivel <= 0.50) { 
				preco = sessao.getPreco().add(calculaPercentual(sessao, 0.20));
			} else {
				preco = sessao.getPreco();
			}

			if(sessao.getDuracaoEmMinutos() > 60){
				preco = preco.add(calculaPercentual(sessao, 0.10));
			}
		}  else {
			//nao aplica aumento para teatro (quem vai é pobretão)
			preco = sessao.getPreco();
		} 

		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaPercentual(Sessao sessao, double percentual) {
		return sessao.getPreco().multiply(BigDecimal.valueOf(percentual));
	}

}