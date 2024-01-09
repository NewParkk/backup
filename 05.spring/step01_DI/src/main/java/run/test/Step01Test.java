package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step01.domain.Car;
import step01.domain.People;

public class Step01Test {
	public static void main(String[] args) {
		// step01.xml 등록된 bean 불러오기
		ApplicationContext context = new ClassPathXmlApplicationContext("step01.xml");
		
//		Car c1 = context.getBean("c1", Car.class);
//		System.out.println(c1);
		
		People p1 = context.getBean("p1" ,People.class);
		System.out.println(p1);
		
		People p2 = context.getBean("p2" ,People.class);
		System.out.println(p2);

		People p3 = context.getBean("p2" ,People.class);
		System.out.println(p3);
		
		System.out.println(p2.equals(p3));
		
		/* 
		 * p2, p3같은객체인 이유 : scope="singleton"
		 * 
		 */
		
		
		
		
		
		
		
		
		
	}
}