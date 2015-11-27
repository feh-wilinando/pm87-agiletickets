package br.com.caelum.agiletickets.models;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SessaoTest {

	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}
	
	@Test
	public void deveVender5ingressosSeHa10vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(5));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
<<<<<<< HEAD
	public void deveReservarTodasAsVagasDaSessao()  {
		
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		
		assertTrue(sessao.podeReservar(10));
		
	}
	
	
	
=======
	public void deveVender10ingressosSeHa10vagas() throws Exception {
		Sessao sessao = new Sessao();
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(10));
	}
	
>>>>>>> f0ae0e1206871dcd3aa76e58346fa2c3023d900e
}
