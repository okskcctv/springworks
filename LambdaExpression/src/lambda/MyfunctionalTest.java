package lambda;

public class MyfunctionalTest {

	public static void main(String[] args) {
		MyfunctionalEx fi;
		
		fi = () -> {	// 매개 변수가 없는 경우 () - 빈 괄호
			String str = "Hello~ lambda";
			System.out.println(str);
		};
		fi.method();
		
		// 중괄호 생략 가능
		fi = () -> System.out.println("Hello~ lambda");
		fi.method();
		
		MyfunctionalEx2 fi2;
		
		fi2 = (x) -> {
			x = x + 10;
			System.out.println(x);
		};
		fi2.method(11);
		
		// 더하기
		fi2 = (x) -> System.out.println(x + 10);
		fi2.method(11);
		
		// 제곱수
		fi2 = (x) -> System.out.println(x * x);
		fi2.method(4);
	}

}
