
public class Calculadora implements ICalculadora {
	
	private static Calculadora CalculadoraInstance;
	
	public Calculadora () {
		
	}
	
	public static Calculadora getInstance(){
		if (CalculadoraInstance == null) {
			CalculadoraInstance =new Calculadora();
		}
		return CalculadoraInstance;
	}
	
	/**
	 * metodo de suma
	 */
	@Override
	public int sumar(int a, int b) {
		// TODO Auto-generated method stub
		return a + b;
	}

	/**
	 * metodo de resta
	 */
	@Override
	public int restar(int a, int b) {
		// TODO Auto-generated method stub
		return  a - b;
	}

	/**
	 * metodo de multiplicacion
	 */
	@Override
	public int multiplicar(int a, int b) {
		// TODO Auto-generated method stub
		return a * b;
	}

	/**
	 * metodo de division
	 */
	@Override
	public int dividir(int a, int b) {
		// TODO Auto-generated method stub
		return a / b;
	}
	

}