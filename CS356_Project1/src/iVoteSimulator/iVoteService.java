package iVoteSimulator;

import java.util.ArrayList;
import java.util.List;


public class iVoteService {
	
	private String question;
	private String answer = "";
	private int[] studentAnswers = new int[4]; //Used to store student answers
	private List<Student> studentsList;

	
	/**
	 * Initialize the iVoteService class with a question and its answer.
	 */
	public iVoteService(String q, String ans) {
		setQuestion(q);
		setAnswer(ans);
		studentsList = new ArrayList<Student>();
	}
	
	/**
	 * This method accepts a Student object and stores its answer in
	 * an integer array. The array indices match the grades such as 
	 * 'A' = 0, 'B' = 1, ... etc. up to 'D'
	 */
	public void recordAnswers(Student stu) {
		
		//This if-else loop makes sure that the student hasn't entered an answer
		//already. If the student has, then the previous answers are eradicated from 
		//the answer records, and increments the new ones.
		if(getIndex(stu) == -1) {
			studentsList.add(stu);

		    if (stu.getAnswerChoice().equals("A")) {
	    	     getStudentAnswers()[0] = getStudentAnswers()[0] + 1;
	        }
	    	else if (stu.getAnswerChoice().equals("B")) {
		     	getStudentAnswers()[1] = getStudentAnswers()[1] + 1;
	    	}
            else if (stu.getAnswerChoice().equals("C")) {
                getStudentAnswers()[2] = getStudentAnswers()[2] + 1;
		    }
            else if (stu.getAnswerChoice().equals("D")) {
       	        getStudentAnswers()[3] = getStudentAnswers()[3] + 1;
            }
		}
		else {
			int index = getIndex(stu);
			String previousAnswer = stu.getPreviousAnswer();
			
			if (previousAnswer.equals("A")) {
	    	     getStudentAnswers()[0] = getStudentAnswers()[0] - 1;
	        }
	    	else if (previousAnswer.equals("B")) {
		     	getStudentAnswers()[1] = getStudentAnswers()[1] - 1;
	    	}
           else if (previousAnswer.equals("C")) {
               getStudentAnswers()[2] = getStudentAnswers()[2] - 1;
		    }
           else if (previousAnswer.equals("D")) {
      	        getStudentAnswers()[3] = getStudentAnswers()[3] - 1;
           }
		   studentsList.remove(index);
		   recordAnswers(stu);
		}
	}
	
	/**
     * This method accepts a Student object then uses a binary search algorithm to compare
     * it's ID to the ID of the students in the studentsList. If an ID match is found, the method
     * returns the index of that question, and if its not found, the method returns -1
     */
    protected int getIndex(Student s) {
		
		for(int i = 0; i < studentsList.size(); i++) {
			if(s.getStudentID() == studentsList.get(i).getStudentID()) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * The following methods are getters-setters for the attributes of this class. That includes
	 * the studentAnswers array, current question, and current answer. A few methods are not used 
	 * outside the class so they have been set to private.
	 */

	public int[] getStudentAnswers() {
		return studentAnswers;
	}
	
	public List<Student> getStudentsList() {
		return studentsList;
	}

	public String getAnswer() {
		return answer;
	}

	private void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getQuestion() {
		return question;
	}

	private void setQuestion(String question) {
		this.question = question;
	}
	
	   //--------------------------------------------------------------------------------------------------------------
	   //
	   //    The following method(s) is/are not used in this simulation program. They can be used to enhance                               
	   //    the iVoteSimulator experience by adding features to the program. However they are not required 
	   //    for this assignment, so they have been temporarily commented out.
	   //
	   //--------------------------------------------------------------------------------------------------------------
	
	/**
	 * This method clears the results of the students answers by setting the studentAnswers
	 * integer array to 0. It is used if programmer does not want to re-initialize the iVoteService
	 * object, but wants to re-record the student answers
	 */
	/*
	public void clearResults() {
		for (int i = 0; i < getStudentAnswers().length; i++) {
			getStudentAnswers()[i] = 0;
		}
	}
	*/

}
