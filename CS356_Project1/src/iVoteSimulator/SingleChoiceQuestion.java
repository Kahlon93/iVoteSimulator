package iVoteSimulator;

import java.util.List;

public class SingleChoiceQuestion extends Question{
	
	public SingleChoiceQuestion () {
		super();
	}
	
	/**
	 * This method accepts a question and a answer string, and then 
	 * finds their respective indices. If the indices are the same then it returns
	 * true, indicating the answer matches the question. 
	 */
	public boolean isCorrect(String question, String ans) {
		
		List<String> answersList = getAnswers();
		int index = getIndex(question);
		if (index == -1)
			return false;
		else {
			if (answersList.get(index).equals(ans)) {
				return true;
			}
		}
		return false;
	}

}
