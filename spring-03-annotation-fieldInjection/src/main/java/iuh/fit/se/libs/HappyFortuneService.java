package iuh.fit.se.libs;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService{
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Today is a lucky day";
	}

}
