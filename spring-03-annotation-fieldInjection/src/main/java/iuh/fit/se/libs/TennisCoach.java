package iuh.fit.se.libs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
	@Autowired 
	private FortuneService fortuneService;

	public TennisCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return ">> tennisCoach : inside default constructor ";
	}

	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getDailyWorkout();
	}
	
}
