package iVoteSimulator;

import java.util.List;

/**
 * This is a subclass of the iVoteService class
 *
 */
public class SingleChoiceService extends iVoteService{
	
	

	public SingleChoiceService(String q, String ans) {
		super(q, ans);
	}
	

	/**
	 * This method calculates the total answers from all the students and formats a 
	 * String to display the results of the question to the user. It also displays the 
	 * correct answer and the number of students who got the correct answers
	 */
	public void printSingleChoiceResults() {
		String right = "";
		String answerResults = "A: " + getStudentAnswers()[0] + "\nB: " + getStudentAnswers()[1] + "\nC: " + getStudentAnswers()[2]
				+ "\nD: " + getStudentAnswers()[3] + "\n";
		String correctAnswer = "Correct answer = " + getAnswer() + "\n";
		
		
		char correctAnswerChoice = findCorrectAnswerChoiceSingle();
		if (correctAnswerChoice == 'A') {
			right = "# of correct answers = " + getStudentAnswers()[0];
		}
		else if (correctAnswerChoice == 'B') {
			right = "# of correct answers = " + getStudentAnswers()[1];
		}
		else if (correctAnswerChoice == 'C') {
			right = "# of correct answers = " + getStudentAnswers()[2];
		}
		else if (correctAnswerChoice == 'D') {
			right = "# of correct answers = " + getStudentAnswers()[3];
		}
		
		System.out.println(answerResults + correctAnswer + right + "\n");
		
	 }
	
	/**
	 * This method returns the character of the correct answer choice eg. "A" or "B"
	 */
	private char findCorrectAnswerChoiceSingle() {
		Question q = new Question();
		List<String> answerChoices;

		int index = q.getIndex(getQuestion());
		String temp1[], temp2[];

		if (index != -1) {

		    answerChoices = q.getAnswerChoices();
		    temp1= answerChoices.get(index).split(",");
		    for (int i = 0; i < temp1.length; i++) {
			
		    	temp2 = temp1[i].split(" ");
		    	if(temp2[1].equals(getAnswer())) {
		    		return temp2[0].charAt(0);
		    	}
		    }
		}
		return (Character) null;
	}

}
