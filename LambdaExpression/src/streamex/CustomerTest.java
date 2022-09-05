package streamex;

import java.util.ArrayList;
import java.util.List;

public class CustomerTest {

	public static void main(String[] args) {
		
		List<Customer> customerList = new ArrayList<>();
		
		Customer lee = new Customer("이순신", 40, 100);
		Customer kang = new Customer("강감찬", 30, 100);
		Customer hong = new Customer("홍길동", 14, 100);
		
		customerList.add(lee);
		customerList.add(kang);
		customerList.add(hong);
		
		System.out.println("===고객명단 추가된 순서대로 출력===");
		customerList.stream().map(c -> c.getName()).forEach(s -> System.out.println(s));
		
		int total = customerList.stream().mapToInt(c -> c.getPrice()).sum();
		System.out.println("총 여행 비용은 : " + total + "입니다.");
		
		System.out.println("===20세 이상 고객 명단 정렬하여 출력===");
		customerList.stream().filter(c -> c.getAge() >= 20).map(c -> c.getName())
					.sorted().forEach(s -> System.out.println(s));
	}

}
