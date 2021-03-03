package practicaJUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class TestCuenta {
	Cuenta objCuenta;
	Debito objDebito;

	
	@Before public void before() {
		System.out.println("before");
		objCuenta=new Cuenta("1234","Pepe");
		
	}
	//Apartado1
	@Test public void testIngreso() throws Exception {
		objCuenta.ingresar(500);
		assertEquals(500,objCuenta.getSaldo());
	}
	//Apartado2
	@Test public void testSaldo() throws Exception{
		objCuenta.ingresar(500);
		objCuenta.retirar(objCuenta.getSaldo());
		assertEquals(0, objCuenta.getSaldo());
	}
	//Apartado3
	@Test public void testSaldo2() throws Exception{
		objCuenta.ingresar(500);
		objCuenta.retirar(300);
		assertEquals(200, objCuenta.getSaldo());
		
	}
	//Apartado4
	@Test public void testSaldo3() throws Exception{
		objCuenta.ingresar(500);
		Date today=new Date();
		Debito objDebito = new Debito ("pepe","gonzales",today);
		objDebito.setCuenta(objCuenta);
		objDebito.retirar(500);
		assertEquals(0, objCuenta.getSaldo());
		
	}
	//Apartado5
	@Test public void testSaldo4() throws Exception{
		objCuenta.ingresar(500);
		Date today= new Date();
		Credito objCredito = new Credito("1234","pepe",today, 500);
		objCredito.setCuenta(objCuenta);
		objCredito.ingresar(500);
		System.out.println(objCuenta.getSaldo());
		assertEquals(1000, objCuenta.getSaldo());

		
	}
	//Apartado6
	@Test public void testSaldo5() throws Exception{
		objCuenta.ingresar(700);
		Date today= new Date();
		Credito objCredito = new Credito("12345","jose",today, 700);
		objCredito.setCuenta(objCuenta);
		objCredito.retirar(500);
		assertEquals(700-15, objCredito.getCreditoDisponible());
		
	}
	@Test public void testSaldo5_2() throws Exception{
		objCuenta.ingresar(700);
		Date today= new Date();
		Credito objCredito = new Credito("12345","jose",today, 700);
		objCredito.setCuenta(objCuenta);
		objCredito.retirar(50);
		assertEquals(700-3, objCredito.getCreditoDisponible());
}
	//Apartado7
		@Test public void testSaldo6() throws Exception{
			objCuenta.ingresar(500);
			Date today= new Date();
			Credito objCredito = new Credito("12345","jose",today, 700);
			objCredito.setCuenta(objCuenta);
			objCredito.pagoEnEstablecimiento("bar", 100);
			objCredito.pagoEnEstablecimiento("maquina", 200);
			objCredito.liquidar(2, 2021);
			assertEquals(200, objCuenta.getSaldo());
			
			
	}
}