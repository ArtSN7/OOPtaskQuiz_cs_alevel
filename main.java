import java.util.Scanner;

class main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        InitSystem bootup = new InitSystem();

        if (bootup.GetSystemMode() == 1){ // if user has chosen to do a quiz

            new Quiz("John");

        }else{

            System.out.print("\nNumber of questions you want to add: ");

            int number_of_questions = scanner.nextInt(); // asking user to the mode

            for (int i = 0; i < number_of_questions; i++){ // iterate for each question user wants to add

                bootup.AddQuestionsToTheFile();

            }  

        }

    }
}