package iVoteSimulator;

import java.util.List;

/**
 * This is a subclass of the iVoteService class
 */

public class MultipleChoiceService extends iVoteService {
	
	private List<Student> studentLists = getStudentsList();
	private char[] studentAnswers;
	private int numOfCorrectStudents = 0;

	public MultipleChoiceService(String q, String ans) {
		super(q, ans);
	}
	
	//@override
	/**
	 * This method overrides the recordAnswers(Student) method of its super class, 
	 * because it had to be slightly modified to account for multiple answers from one 
	 * student, but it has the same functionality as its parent class method.
	 */
	public void recordAnswers(Student stu) {

		//This if-else loop makes sure that the student hasn't entered an answer
		//already. If the student has, then the previous answers are eradicated from 
		//the answer records, and increments the new ones.
		if(getIndex(stu) == -1) {
			studentLists.add(stu);
		    studentAnswers = stu.getAnswerChoice().toCharArray();
	    	for (int i = 0; i < studentAnswers.length; i++) {
	    		 if (studentAnswers[i] == 'A') {
	    			 getStudentAnswers()[0] = getStudentAnswers()[0] + 1;
	    		 }
	    		 else if (studentAnswers[i] == 'B') {
	    			 getStudentAnswers()[1] = getStudentAnswers()[1] + 1;
	    		 }
	    		 else if (studentAnswers[i] == 'C') {
	    			 getStudentAnswers()[2] = getStudentAnswers()[2] + 1;
	    		 }
	    		 else if (studentAnswers[i] == 'D') {
				 getStudentAnswers()[3] = getStudentAnswers()[3] + 1;
		    	 }
	    	}
	    	
	    	if(isCorrect(stu)) {
				numOfCorrectStudents++;
			}
	    	
	    }
		else {
			int index = getIndex(stu);
			String previousAnswer = stu.getPreviousAnswer();
			char[] prevArray = previousAnswer.toCharArray();
			for (int i = 0; i <prevArray.length; i++) {
	    		 if (prevArray[i] == 'A') {
	    			 getStudentAnswers()[0] = getStudentAnswers()[0] - 1;
	    		 }
	    		 else if (prevArray[i] == 'B') {
	    			 getStudentAnswers()[1] = getStudentAnswers()[1] - 1;
	    		 }
	    		 else if (prevArray[i] == 'C') {
	    			 getStudentAnswers()[2] = getStudentAnswers()[2] - 1;
	    		 }
	    		 else if (prevArray[i] == 'D') {
				 getStudentAnswers()[3] = getStudentAnswers()[3] - 1;
		    	 }
	    	}
			studentLists.remove(index);
			recordAnswers(stu);
		}
			
	}
	
	/**
	 * This method calculates the total answers from all the students and formats a 
	 * String to display the results of the question to the user. It also displays the 
	 * correct answer, and the number of students who got at least one, and who got 
	 * all answer choices correct.
	 */
	public void printMultipleChoiceResults() {
		int totalRightAnswers = 0;
		String correctChoices = "";
		String[] correctAnswerChoice = findCorrectAnswerChoices();
		
		String answerResults = "A: " + getStudentAnswers()[0] + "\nB: " + getStudentAnswers()[1] + "\nC: " 
		            + getStudentAnswers()[2] + "\nD: " + getStudentAnswers()[3] + "\n";		
		for (int i = 0; i < correctAnswerChoice.length; i++) {
			correctChoices = correctChoices + correctAnswerChoice[i] + " ";
		}
		
		String correctAnswer = "Correct answer = " + getAnswer() + " ( " + correctChoices + ")\n" ;
		    
		    for (int y = 0; y < correctAnswerChoice.length; y++) {
		        if (correctAnswerChoice[y].equals("A")) {
		        	totalRightAnswers += getStudentAnswers()[0];
		        }
		        else if (correctAnswerChoice[y].equals("B")) {
		        	totalRightAnswers += getStudentAnswers()[1];
		        }
		        else if (correctAnswerChoice[y].equals("C")) {
		        	totalRightAnswers += getStudentAnswers()[2];
		         }
		        else if (correctAnswerChoice[y].equals("D")) {
		        	totalRightAnswers += getStudentAnswers()[3];
		        }
		    }
	    String atleastOneRight = "# of students with atleast one correct answer: " + totalRightAnswers;
	    String allRight = "\n# of students with only correct answers: " + numOfCorrectStudents;
		System.out.println(answerResults + correctAnswer + atleastOneRight + allRight + "\n");
		
		
	 }
	
	/**
	 * Return if the Student's recorded answers match the answers of the question
	 */
	private boolean isCorrect(Student stu) {
		
		int numOfCorrectAnswer = 0;
		String[] correctAnswerChoices = findCorrectAnswerChoices();
		for (int i  = 0; i < studentAnswers.length; i++) {
			for (int j = 0; j < correctAnswerChoices.length; j++) {
				if(correctAnswerChoices[j].equals(studentAnswers[i])) {
					numOfCorrectAnswer++;
				}
			}
		}
		
		if(numOfCorrectAnswer == studentAnswers.length)
			return true;
		
		
		return false;
	}

	/**
	 * Return a String Array containing the letter choices, (eg. "A", "C") of the
	 * answers to the question
	 */
	private String[] findCorrectAnswerChoices() {
		Question q = new MultipleChoiceQuestion();
		List<String> answerChoices;
		int counter = 0;
		

		int index = q.getIndex(getQuestion());
		String temp1[], temp2[];
		String correctAnswers[] = getAnswer().split(" ");
		String storeAnswers[] = new String[correctAnswers.length];
		if (index != -1) {

		    answerChoices = q.getAnswerChoices();
		    temp1= answerChoices.get(index).split(",");
		    for (int i = 0; i < temp1.length; i++) {
			
		    	temp2 = temp1[i].split(" ");
		    	for (int b = 0; b < correctAnswers.length; b++) {
		    		if(temp2[1].equals(correctAnswers[b])){
		    			storeAnswers[counter] = Character.toString(temp2[0].charAt(0));
		    			counter++;
		    		}
		    	}
		
		    }
		    
		   return storeAnswers;
		}
		
		return null;
		
	}
}
