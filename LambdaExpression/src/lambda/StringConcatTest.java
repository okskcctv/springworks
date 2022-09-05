package lambda;

public class StringConcatTest {

	public static void main(String[] args) {
		String str1 = "Hill";
		String str2 = "State";
		
		StringConcatImpl concat1 = new StringConcatImpl();
		concat1.makeString(str1, str2);
	}

}
