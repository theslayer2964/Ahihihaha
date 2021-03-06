package iuh.fit.se.apps;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import iuh.fit.se.libs.Coach;

public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		Coach coach = applicationContext.getBean("myCoach", Coach.class);
		System.out.println(coach.getDailyWordout());
		
		applicationContext.close();
	}
}
