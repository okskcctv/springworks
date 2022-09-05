package lambda;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator add, sub, mul, div;
		add = (x, y) -> x + y;
		System.out.println(add.calculatae(10, 5));
		
		sub = (x, y) -> x - y;
		System.out.println(sub.calculatae(10, 5));
		
		mul = (x, y) -> x * y;
		System.out.println(mul.calculatae(10, 5));
		
		div = (x, y) -> x / y;
		System.out.println(div.calculatae(10, 5));
	}

}
