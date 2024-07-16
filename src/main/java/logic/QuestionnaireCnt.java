package logic;
import beans.Questionnaire;

public class QuestionnaireCnt {

	public void excuteDogCnt(Questionnaire questionnaire) {
		int dogCnt = questionnaire.getDogCnt();
		dogCnt++;
		questionnaire.setDogCnt(dogCnt);
	}
	
	public void excuteCatCnt(Questionnaire questionnaire) {
		int catCnt = questionnaire.getCatCnt();
		catCnt++;
		questionnaire.setCatCnt(catCnt);
	}

}
