package beans;

import java.io.Serializable;

public class Questionnaire implements Serializable{
	private int dogCnt = 0;
	private int catCnt = 0;
	
	public Questionnaire() {
	}
	
	public int getDogCnt() {
		return dogCnt;
	}
	public void setDogCnt(int dogCnt) {
		this.dogCnt = dogCnt;
	}
	public int getCatCnt() {
		return catCnt;
	}
	public void setCatCnt(int catCnt) {
		this.catCnt = catCnt;
	}

}
