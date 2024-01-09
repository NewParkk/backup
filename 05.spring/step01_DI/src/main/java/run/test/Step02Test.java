package run.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import step02.domain.Car;
import step02.domain.People;

public class Step02Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("step02.xml");
		
		Car c1 = context.getBean("c1", Car.class);
		Car c2 = context.getBean("c2", Car.class);
		
		People p1 = context.getBean("p1", People.class);
		
		People p2 = context.getBean("p2", People.class);
		
		
		System.out.println(p1);
		System.out.println(p2);
	}
}
