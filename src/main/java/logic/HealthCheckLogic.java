package logic;

import beans.Health;

public class HealthCheckLogic {
	public void excute(Health health) {
		double bmi = 0;
		double height = 0;
		double weight = 0;
		String bodyType ="";
		
		height = health.getHeight();
		weight = health.getWeight();
		bmi = (weight / (height / 100) / (height / 100));
		health.setBmi(bmi);
		

		if(bmi <= 18.5) {
			bodyType = "やせ ";
		}else if(18.5 < bmi && bmi <= 25.0 ) {
			bodyType = "普通";
		}else {
			bodyType = "肥満";
		}
		
		health.setBodyType(bodyType);
		
	}
	
}
