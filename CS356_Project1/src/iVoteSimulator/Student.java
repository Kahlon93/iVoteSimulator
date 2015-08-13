package iVoteSimulator;

public class Student {
	
	private int id;
	private String answerChoice = "";
	private String prevAnswer = "";
	
	public Student(int n) {
		id = n;
	}
	
	/**
	 * This method saves the answer of a single choice type question as a String, and 
	 * saves the previous answer as well.
	 */
	public void setSingleAnswerChoice(char ans) {
		prevAnswer = answerChoice;
		answerChoice = Character.toString(ans);;
	}
	
	/**
	 * This method saves the answers of a multiple choice type question as a String, and 
	 * saves the previous answer as well.
	 */
	public void setMultipleAnswerChoice(String str) {
		prevAnswer = answerChoice;
		if (!str.isEmpty())
		   answerChoice = str;
	}
	
	public String getAnswerChoice() {
		return answerChoice;
	}
	
	public int getStudentID() {
		return id;
	}
	
	public String getPreviousAnswer() {
		return prevAnswer;
	}

}
