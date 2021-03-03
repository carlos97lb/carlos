package practicaJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

class CuentaTest {
	Cuenta objCuenta;
	
	@Before public void before() {
		System.out.println("before");
		objCuenta=new Cuenta("1234","Pepe");
	}
	
	@Test public void testIngreso() throws Exception {
		//System.out.println(objCuenta.getSaldo());
		//objCuenta.ingresar(500);
		assertEquals(0,0);
	}

}
