import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InitSystem {

    private int SystemMode; // 1 - for quiz ; 2 - to add new file

    public InitSystem(){

        System.out.println("HELLO! MODES: ");
        System.out.println("1. Quiz");
        System.out.println("2. Add questions");

        System.out.print("\nChoose the mode: ");

        Scanner scanner = new Scanner(System.in);

        this.SystemMode = scanner.nextInt(); // asking user to the mode

    }


    public int GetSystemMode(){ // getter for SystemMode ( no need to create a setter )
        return SystemMode;
    }


    public void AddQuestionsToTheFile(){ // method to add new questions to the file

        Scanner scanner = new Scanner(System.in);

        String questionText; // question itself
        String possibleAnswer1; 
        String possibleAnswer2; 
        String possibleAnswer3; 
        String possibleAnswer4; 
        int correctAnswer; // index of the correct answer from the array 
        int pointsValue; // how many points you can get for this question 
        
        try {
            FileWriter myWriter = new FileWriter("question_file.txt", true);

            System.out.println("\nInput the question:");
            questionText = scanner.nextLine();

            System.out.println("Input the possible answer number 1:");
            possibleAnswer1 = scanner.nextLine();
            System.out.println("Input the possible answer number 2:");
            possibleAnswer2 = scanner.nextLine();
            System.out.println("Input the possible answer number 3:");
            possibleAnswer3 = scanner.nextLine();
            System.out.println("Input the possible answer number 4:");
            possibleAnswer4 = scanner.nextLine();

            System.out.println("Input the number of the correct answer (1,2,3 or 4):");
            correctAnswer = scanner.nextInt();

            System.out.println("Input the number of the points:");
            pointsValue = scanner.nextInt();

            myWriter.write("\n" + questionText + "\n");
            myWriter.write(possibleAnswer1 + "\n");
            myWriter.write(possibleAnswer2 + "\n");
            myWriter.write(possibleAnswer3 + "\n");
            myWriter.write(possibleAnswer4 + "\n");
            myWriter.write(Integer.toString(correctAnswer) + "\n");
            myWriter.write(Integer.toString(pointsValue));


            myWriter.close();
            System.out.println("\nQuestion was successfully added!");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
}
