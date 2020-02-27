import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasUnitarias {
	Calculadora calc = Calculadora.getInstance();
	
	
	@Test
	public void testSuma() {
		int expected = 20;
		int actual = calc.sumar(5, 15);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testResta() {
		int expected = 15;
		int actual = calc.restar(50, 35);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplicacion() {
		int expected = 15;
		int actual = calc.multiplicar(5, 3);
		assertEquals(expected, actual);
	}

	@Test
	public void testDivision() {
		int expected = 15;
		int actual = calc.dividir(30, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void testStackArrayList() {
		 StackArrayList<String> lista = new  StackArrayList<String>();
		 assertEquals(true, lista.empty());
		 lista.push("palabra");
		 assertEquals("palabra", lista.pop());
	}
	
	@Test
	public void testStackVector() {
		StackVector<Integer> lista = new StackVector<Integer>();
		lista.push(12);
		assertEquals(false, lista.empty());
		assertEquals((Integer)12, lista.pop());
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
