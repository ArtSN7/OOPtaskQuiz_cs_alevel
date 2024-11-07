import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// class for Quiz
public class Quiz {

    private ArrayList<Question> questions; // using list as there might be hell a lot of questions 
    private String user; // name of the user
    private int score; // score of the user
    

    // CONSTRUCTORS:

        // empty constructor
    public Quiz(){
        this.score = 0;

        this.questions = new ArrayList<>(); // using list as there might be hell a lot of questions 

        load_questions_file("question_file.txt"); // call func to load questions
        startQuiz(); // start quiz
    }

        // non-empty constructor
    public Quiz(String user) {


        this.score = 0;
        this.user = user; // get the name of the user

        this.questions = new ArrayList<>(); // using list as there might be hell a lot of questions 

        
        load_questions_file("question_file.txt"); // call func to load questions
        startQuiz(); // start quiz
    }

    // -----------------------------------------------

    // GETTERS AND SETTERS FOR VALUES:

    // questions
    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    // score
    public int getScore() {
        return score;
    }

    // user 
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    // -----------------------------------------------


    // Load questions from file
    private void load_questions_file(String filename) {

        int count; // needed to check what value is now read (count = 1 - question ; count = 2 - answer 1...)
        count = 1; 

        
        String question_text = ""; // question text
        int ra_index = 0; // index of the right answer
        int points = 0; // number of points for the question
        String[] answers = new String[4]; // array to add answers there

        try {
            File myObj = new File(filename); 
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                switch ( count ){ // setting read data to variables 
                    case 1: 
                        question_text = data;
                        break;
                    case 2: 
                        answers[0] = data;
                        break;
                    case 3: 
                        answers[1] = data;
                        break;
                    case 4: 
                        answers[2] = data;
                        break;
                    case 5: 
                        answers[3] = data;
                        break;
                    case 6: 
                        ra_index = Integer.parseInt(data); 
                        break;
                    case 7:
                        points = Integer.parseInt(data);
                        break;
                }

                if (count == 7){ // reset count if it is the end for the set of values for each question AND create a new object

                    count = 1;

                    this.questions.add(new Question(question_text, answers, ra_index, points)); // adding question to the array

                }else{

                    count += 1;

                }

            }

            myReader.close();


        } catch (IOException e) {

            System.out.println("An error occurred while reading file: " + e.getMessage());

          }

    }


    // Start the quiz
    private void startQuiz() {

        System.out.println("Let's begin the quiz!");

        Scanner scanner = new Scanner(System.in);

        for (Question question : questions) {

            System.out.println("\nQuestion:\n"); // printing out the questions
            System.out.println(question.getQuestionText()); 

            System.out.println("\nOptions:"); // printing out the options
            System.out.println("1. " + question.getPossibleAnswers()[0]);
            System.out.println("2. " + question.getPossibleAnswers()[1]);
            System.out.println("3. " + question.getPossibleAnswers()[2]);
            System.out.println("4. " + question.getPossibleAnswers()[3]);

            System.out.print("\nYour answer: ");

            int userAnswer = scanner.nextInt(); // asking user to input value

            if (question.checkAnswer(userAnswer)) { // checking the input

                System.out.println("Correct!");

                this.score += question.getPointsValue(); // adding the score

            } else {

                System.out.println("Incorrect");

            }
        }
        System.out.println("FINITO LA COMEDI :) " + this.user + "managed to score " + this.score);
        scanner.close();
        
    }



}