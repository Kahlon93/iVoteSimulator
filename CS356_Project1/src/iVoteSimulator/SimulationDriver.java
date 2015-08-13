package iVoteSimulator;

import java.util.List;
import java.util.Random;

public class SimulationDriver {

	
	public static void main(String[] args) {
		
		iVoteService singleAnswerVote;
		iVoteService multipleAnswerVote;
		String question, answer;
		String alphabet = "ABCD"; //This string is used to pick the random answer choice(s)
		Random choice = new Random();
		
		
		System.out.println("This is an iVote Simulator");
	
		Random numOfStudents = new Random(); 
		//Store random number of Students in an array
		Student[] students = new Student[numOfStudents.nextInt(30) + 1];
		
		System.out.println("The random number of students is: " + students.length + "\nLets Begin!\n\n");
		System.out.println("The first set of questions are single choice questions.\n");
		
		//Initialize Question subclass for single choice questions
		Question SCquestion = new SingleChoiceQuestion();
		List<String> questions = SCquestion.getQuestions();
		
		//This loop runs through the question list and displays every question
		for (int i = 0; i < questions.size(); i++) {
			question = SCquestion.getQuestion(i);
			System.out.println(question); //Display the question
			
			//Display answer choices for the question
			String temp[] = SCquestion.getAnswerChoice(question).split(",");
			for(int c = 0; c < temp.length; c++) {
				System.out.println(temp[c]);
			}
			
			System.out.println("\nWaiting for students to respond...\n\nResults:");
			answer = SCquestion.getAnswer(question); //Get the answer from Question subclass
			
			//Initialize iVoteService subclass using the question and answer as arguments
			singleAnswerVote = new SingleChoiceService(question, answer); 
			
			//This loop initializes the Students and records their random answers into the iVoteService
			for(int j = 0; j < students.length; j++) {
				students[j] = new Student(j);
				students[j].setSingleAnswerChoice(alphabet.charAt(choice.nextInt(alphabet.length())));
				singleAnswerVote.recordAnswers(students[j]);
			}
			
			//Displays the results of all the students
		    ((SingleChoiceService) singleAnswerVote).printSingleChoiceResults();
		    
		    //This loop demonstrates the ability of the program to allow students to re-enter their answers.
		    //To simulate the case, the last student changes his/her answer for the last question to another
		    //random answer. The new results are then displayed on the screen 
		    if(i == questions.size() - 1) {
		        students[students.length - 1].setSingleAnswerChoice(alphabet.charAt(choice.nextInt(alphabet.length())));
		        singleAnswerVote.recordAnswers(students[students.length - 1]);
		        System.out.println("***Simulating the case if student submits another answer...");
		        System.out.println("   The last student to submit the answer changed his/her answer from " 
		        		+ students[students.length - 1].getPreviousAnswer() + " to " + students[students.length - 1].getAnswerChoice());
		        System.out.println("   (If the answer does not change, please run program again to re-randomize)\n");
		        System.out.println("Modified results: ");
		        ((SingleChoiceService) singleAnswerVote).printSingleChoiceResults();
		    }
		    

		}
		
		
		
		System.out.println("\n\n----------------------------------------------------");
		System.out.println("This next segment allows multiple choice selection");
		System.out.println("----------------------------------------------------\n");
		
		//Initialize Question subclass for multiple choice questions
		MultipleChoiceQuestion MCquestion = new MultipleChoiceQuestion();		
		List<String> mcQuestions = MCquestion.getQuestions();
				
		//This loop runs through the question list and displays every question
		for (int i = 0; i < mcQuestions.size(); i++) {
			question = MCquestion.getQuestion(i);
			System.out.println(question);
			
			//Display answer choices for the question
			String temp[] = MCquestion.getAnswerChoice(question).split(",");
			for(int c = 0; c < temp.length; c++) {
				System.out.println(temp[c]);
			}
			System.out.println("\nWaiting for students to respond...\n\nResults:");
			answer = MCquestion.getAnswer(question);
			
			//Initialize iVoteService subclass using the question and answer as arguments	
			multipleAnswerVote = new MultipleChoiceService(question, answer);
					           
            // This loop records all the random answers of the students into the iVoteService.
		    for(int w = 0; w < students.length; w++) {
		    	
			    //Record the answers in the iVoteService
		    	students[w] = new Student(w);
		    	students[w].setMultipleAnswerChoice(getRandomMCAnswer());
		    	multipleAnswerVote.recordAnswers(students[w]);

			    }		    
		    
		    //Display the results of the question, and clear iVoteService for next question
		   ((MultipleChoiceService) multipleAnswerVote).printMultipleChoiceResults();
		   

	       if(i == mcQuestions.size() - 1) {
	            students[students.length - 1].setMultipleAnswerChoice(getRandomMCAnswer());
	            multipleAnswerVote.recordAnswers(students[students.length - 1]);
	            System.out.println("***Simulating the case if student submits another answer...");
	            System.out.println("   The last student to submit the answer changed his/her answer from " 
	            		+ students[students.length - 1].getPreviousAnswer() + " to " + students[students.length - 1].getAnswerChoice());
	            System.out.println("   (If the answer does not change, please run program again to re-randomize)\n");
	            System.out.println("Modified results: ");
	            ((MultipleChoiceService) multipleAnswerVote).printMultipleChoiceResults();
	        }

		}
	}
	
	/**
	 * This method returns a String of random multiple answer choices
	 */
	private static String getRandomMCAnswer() {
		
        String studentAnswers = "";
		char a[] = "ABCD".toCharArray(); //Create a char array of the string "ABCD"
		Random mc = new Random(); 
        Random rnd = new Random();
        
	    	
	    	   //This loop scrambles the string "ABCD"
	        for (int j = a.length - 1; j > 0; j--)
			{
			      int index = rnd.nextInt(j + 1);
			      // Swap the characters of the array
			      char z = a[index];
			      a[index] = a[j];
			      a[j] = z;
			    }
	    	   
	    	//Create a string out of the scrambled array.   
			String shuffle = new String(a);
			
			//This loop runs a random amount of times (between 1-4) and sequentially picks
			//the characters of the scrambled string. This way it allows the Students to 
			//generate a random number of random answer choices. 
		    for(int k = 0; k < mc.nextInt(4) + 1; k++) {
		    	studentAnswers = studentAnswers + Character.toString(shuffle.charAt(k));
		    }
		    
		    return studentAnswers;
	}

}
