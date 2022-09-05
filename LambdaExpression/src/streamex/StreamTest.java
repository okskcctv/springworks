package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		List<String> companyList = Arrays.asList("LG", "Samsung", "현대");
		
		for(String company : companyList)
			System.out.println(company);
		
		// Stream 클래스 - 람다식으로 구현
		Stream<String> stream = companyList.stream();
		stream.forEach(company -> System.out.println(company));
	}

}
