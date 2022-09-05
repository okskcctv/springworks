package streamex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StudentTest {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("콩쥐", 90),
				new Student("팥쥐", 70),
				new Student("심청", 80)
		);
		
		// 클래스로부터 스트림 얻기
		Stream<Student> stream = list.stream();
		stream.forEach(student -> {
			String name = student.getName();
			int score =student.getScore();
			System.out.println(name + ", " + score);
		});
		
		// map() 함수와 함께 사용하기 - 학생의 이름 출력
		stream = list.stream();	// 1번 사용하면 소모(Consumer)되므로 다시 생성
		stream.map(c -> c.getName()).forEach(s -> System.out.println(s));
		
		stream = list.stream();	// 학생의 점수 출력
		stream.map(c -> c.getScore()).forEach(s -> System.out.println(s));
		
		// filter()와 함께 사용하기 - 점수가 90 이상인 학생의 이름 출력
		list.stream().filter(c -> c.getScore() > 80).map(c -> c.getName())
					.forEach(s -> System.out.println(s));
	}

}
