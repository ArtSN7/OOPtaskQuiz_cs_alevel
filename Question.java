// class for Question object
public class Question { 

    private String questionText; // question itself
    private String[] possibleAnswers; // array of possible answers ( all strings )
    private int correctAnswer; // index of the correct answer from the array 
    private int pointsValue; // how many points you can get for this question 


    // CONSTRUCTORS:

        // empty constructor
    public Question(){
    }

        // non-empty constructor 
    public Question(String questionText, String[] possibleAnswers, int correctAnswer, int pointsValue) {

        this.questionText = questionText;
        this.possibleAnswers = possibleAnswers;
        this.correctAnswer = correctAnswer;
        this.pointsValue = pointsValue;
        
    }
    
    // -----------------------------------------------

    // GETTERS AND SETTERS FOR VALUES:

        // Question Text
    public String getQuestionText() {
        return this.questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

        // Possible Answers
    public String[] getPossibleAnswers() {
        return this.possibleAnswers;
    }

    public void setPossibleAnswers(String[] possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

        // Correct Answer ( index )
    public int getCorrectAnswer() {
        return this.correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

        // Points Value
    public int getPointsValue() {
        return this.pointsValue;
    }

    public void setPointsValue(int pointsValue) {
        this.pointsValue = pointsValue;
    }

    // -----------------------------------------------


    // Method to check if the answer is correct
    public boolean checkAnswer(int userAnswer) { // input is an index ( use -1 as we will list values like 1.2.3.4. => index is 0.1.2.3.)

        return userAnswer == this.correctAnswer;

    }
}

