package lambda;

public class MyNumberTest {

	public static void main(String[] args) {
		MyNumber num;
		
		num = (x, y) -> {
			return (x >= y) ? x : y;
		};
		System.out.println(num.getMax(10, 20));
		
		num = (x, y) -> (x >= y) ? x : y;
		System.out.println("더 큰 수는 " + num.getMax(10, 20));
	}

}
