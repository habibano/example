package beans;

import java.io.Serializable;

public class Health implements Serializable{
	//健康診断に関する情報（身長、体重、BMI、体型）を持つJavaBeansモデル
	private double height = 0;
	private double weight = 0;
	private double bmi = 0;
	private String bodyType="";
	
	public Health(double height, double weight) {
		this.height = height;
		this.weight = weight;
	}
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getBodyType() {
		return bodyType;
	}
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}
	
	
}
