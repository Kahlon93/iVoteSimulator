package iVoteSimulator;

import java.util.ArrayList;


public class Question {
	
	private ArrayList<String> questionsArrayList; 
	private ArrayList<String> answersArrayList;
	private ArrayList<String> answerChoicesArrayList;
	
	/**Upon initializing the Question class, the questionArray, answerArray, and
	 * answerchoicesArray are initialized with the default hard-coded questions.
	 */
	public Question() {
		
		questionsArrayList = new ArrayList<String>();
		answersArrayList = new ArrayList<String>();
		answerChoicesArrayList = new ArrayList<String>();
		setdefaultQuestionsAndAnswers();

	}
	
	/**
	 * This method is called by the constructor to initialize the default questions,
	 * answer choices, and the answers. The answers and the answer choices are stored in
	 * their respective arrays, parallel to their corresponding questions so as to make
	 * it easier to match an answer to its question, and vice-versa
	 */
	private void setdefaultQuestionsAndAnswers() {
		
		questionsArrayList.add("What animal is the larva of a butterfly or moth?");
		answerChoicesArrayList.add("A: earthworm,B: caterpillar,C: silkworm,D: pterodactyl");
		answersArrayList.add("caterpillar");
		questionsArrayList.add("What insects flap their wings 300 times a second? ");
		answerChoicesArrayList.add("A: bees,B: beetles,C: hummingbird,D: flys");
		answersArrayList.add("bees");
		questionsArrayList.add("Mosquitoes prefer to bite which of the following: Men, Women, or Both Equally?");
		answerChoicesArrayList.add("A: Men,B: women,C: both");
		answersArrayList.add("women");
		questionsArrayList.add("When water passes through the gills of fish, the fish get what?");
		answerChoicesArrayList.add("A: nitrogen,B: fluoride,C: oxygen,D: hydrogen");
		answersArrayList.add("oxygen");
		questionsArrayList.add("What is the heaviest land animal in North America? ");
		answerChoicesArrayList.add("A: buffalo,B: hippopotamus,C: elephant,D: orcas");
		answersArrayList.add("buffalo");
		
	}
	
	/**
	 * This method returns a question from the questionsArray, based on the integer 
	 * argument that it accepts. The method checks to make sure the integer is in 
	 * bounds of the array, then uses the integer as an index to return a corresponding 
	 * question. If the integer is out of bounds, the method will return a null statement
	 */
	public String getQuestion(int index) {
		if (index < questionsArrayList.size()) {
			return questionsArrayList.get(index);
		}
		return null;
	}

	
	/**
	 * This method accepts a String as a question, and then finds the index of that question
	 * in the questionArray. Since the answers are stored in parallel to their corresponding
	 * questions, the method then uses that index to return the answer to the question. If the
	 * question does not exist in the array, the method returns a statement informing the user
	 * that the String passed is not a valid question.
	 */
	public String getAnswer(String q) {
		
		int index = getIndex(q);
		if (index != -1)
			return answersArrayList.get(index);
		
		return "That is not a valid question!";
	}
	
	/**
	 * This method accepts a String as a question, and then finds the index of that question
	 * in the questionArray. Since the answer choices are stored in parallel to their corresponding
	 * questions, the method then uses that index to return the answer choices of the question. If the
	 * question does not exist in the array, the method returns a statement informing the user
	 * that the String passed is not a valid question.
	 */
    public String getAnswerChoice(String q) {
		
		int index = getIndex(q);
		if (index != -1)
			return answerChoicesArrayList.get(index);
		
		return "That is not a valid question!";
	}

    /**
     * This method accepts a String as a question then uses a binary search algorithm to 
     * search for the question in the questionsArray. If the question is found, the method
     * returns the index of that question, and if its not found, the method returns -1
     */
	protected int getIndex(String q) {
		
		for(int i = 0; i < questionsArrayList.size(); i++) {
			if(q.equals(questionsArrayList.get(i))) {
				return i;
			}
		}
		
		return -1;
	}
	
	/**
	 * Return the ArrayList of the questions.
	 */
	protected ArrayList<String> getQuestions() {
		
		return questionsArrayList;
		
	}
	
	/**
	 * Return the ArrayList of the answers.
	 */
   protected ArrayList<String> getAnswers() {
		
		return answersArrayList;
		
	}

   /**
	 * Return the ArrayList of the answer choices.
	 */
   protected ArrayList<String> getAnswerChoices() {
	
	    return answerChoicesArrayList;
	
   }
   
   
   /**
     * These method is used for multiple choice question types ONLY. it is called by the
     * constructor of the MultipleChoiceQuestion subclass to initialize the default questions,
	 * answer choices, and the answers. The answers and the answer choices are stored in
	 * their respective arrays, parallel to their corresponding questions so as to make
	 * it easier to match an answer to its question, and vice-versa
    */
   protected void setMultpleChoiceDefaultQuestionsAndAnswers() {
	   
	    questionsArrayList.clear();
		answersArrayList.clear();
		answerChoicesArrayList.clear();
	    questionsArrayList.add("Which of these do not have 6 legs?");
	    answerChoicesArrayList.add("A: spider,B: bees,C: hornets,D: scorpion");
		answersArrayList.add("scorpion spider");
		questionsArrayList.add("Which of these belong in the same family ");
		answerChoicesArrayList.add("A: cats,B: dogs,C: wolves,D: giraffes");
		answersArrayList.add("wolves dogs");
		questionsArrayList.add("which of these are not domestic animals");
		answerChoicesArrayList.add("A: cow,B: giraffe,C: goat,D: lion");
		answersArrayList.add("giraffe lion");
		questionsArrayList.add("which of these are mammals?");
		answerChoicesArrayList.add("A: whales,B: kangaroos,C: crows,D: clownfish");
		answersArrayList.add("whales kangaroos");
		questionsArrayList.add("which of these are reptiles? ");
		answerChoicesArrayList.add("A: lizards,B: hippos,C: frogs,D: snakes");
		answersArrayList.add("lizards frogs");
		
   }


   
   //--------------------------------------------------------------------------------------------------------------
   //
   //    The following methods are not used in this simulation program. They can be used to enhance                               
   //    the iVoteSimulator experience by adding features to the program. However they are not required 
   //    for this assignment, so they have been temporarily commented out.
   //
   //--------------------------------------------------------------------------------------------------------------
   
   /**
    * This method allows user to add a question, and its corresponding answer and answer choices
    * into the arrays. If the question already exists, then the program will change the answer and its
    * answer choices respectively. A File object would be required to store the question-answer combo 
    * permanently so as to not lose user information upon terminating the program. 
    */
   
   /*
	public void setAnswerChoices(String question, String answer, String choices) {
		
		int index = getIndex(question);
		if (index == -1) {
			questionsArrayList.add(question);
			answersArrayList.add(answer);
			answerChoicesArrayList.add(choices);
		}
		else {
			answersArrayList.add(index, answer);
			answerChoicesArrayList.add(index, choices);
		}
	}
	*/

	/**
	 * This method returns a random question from the questionsArray
	 */
   /*
	public String getRandomQuestion() {
		Random rand = new Random();
		
		return questionsArrayList.get(rand.nextInt(questionsArrayList.size()-1));
	}
	*/
 
}
