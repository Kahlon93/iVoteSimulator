package iVoteSimulator;

import java.util.List;

/**
 * This is a subclass of the Question class
 *
 */
public class MultipleChoiceQuestion extends Question {
	
	/**
	 * This method overrides the superclass constructor, and sets different
	 * question, answer choices, and answer combos in their respective arrays.
	 */
	public MultipleChoiceQuestion () {
		setMultpleChoiceDefaultQuestionsAndAnswers();
	}
	
	/**
	 * This method accepts a question and a answer string, and then 
	 * finds their respective indices. If the indices are the same then it returns
	 * true, indicating the answer matches the question. 
	 */
   public boolean isCorrect(String question, String ans) {
		
		List<String> answersList = getAnswers();
		String temp[];
		int index = getIndex(question);
		if (index == -1)
			return false;
		else {
			temp = answersList.get(index).split(" ");
			for(int i = 0; i < temp.length; i++) {
				if(ans.equals(temp[i]))
					return true;
			}
		}
		return false;
	}

}
