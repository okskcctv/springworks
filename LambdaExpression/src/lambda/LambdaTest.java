package lambda;

@FunctionalInterface
interface PrintString {
	void showString(String str);
}

public class LambdaTest{
	public static void main(String[] args) {
		PrintString lambdaPrint = str -> System.out.println(str);
		lambdaPrint.showString("Hello, Java");
		
		printString(lambdaPrint);	// 매개변수로 람다 객체 전달
		
		PrintString str = returnPrint();	// 변환값으로 쓰이는 람다식
		str.showString("Hello");
	}
	
	public static void printString(PrintString p) {
		// 매개변수로 함수형 인터페이스 전달
		p.showString("Hello, Java");
	}
	
	public static PrintString returnPrint() {
		return s -> System.out.println(s + ", Java");
	}
}
