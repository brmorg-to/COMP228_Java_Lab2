package exercise1;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.security.SecureRandom;

//Class Test simulates a test with at least five questions
public class Test{

    //String array to store all the questions
    private String [] questionsArray = {"Q1: Which of the following is not a Java features?",
                                        "Q2: Which keyword is used to define class in Java?",
                                        "Q3: An object is an instance of?",
                                        "Q4: Which method defines only once in program?",
                                        "Q5: Return type of method that does not return anything?"};

    //2d array with all answers to its respective questions
    private String [][] optionsArray = {{"a) Dynamic", "b) Use of pointer", "c) Object-oriented", "d) Inheritance"},
                                        {"a) public", "b) class", "c) Class", "d) new"},
                                        {"a) program", "b) method", "c) class", "d) variables"},
                                        {"a) finalize", "b) static", "c) private", "d) main"},
                                        {"a) int", "b) void", "c) float", "d) double"}
                                        };

    //Array with the correct answers to each of the questions
    private String [] correctAnswersArray = {"b", "b", "c", "d", "b"};

    //Array to store the answers input by the user
    private String [] answersArray = new String[5];

    //Properties to compute the number of correct and wrong answers and the percentage of good answers
    private int numCorrectAnswers = 0;
    private int numWrongAnswers = 0;
    private float percentCorrectAnswers =0;

    //Method to sequentially display the questions with its respective options, along with the messages to the users
    public void simulateQuestion(){
        System.out.println("Please select the appropriate answer for each question displayed below.");

        //Loop to iterate through both the questions and options array
        for(int i = 0; i< questionsArray.length; i++){

            System.out.println(questionsArray[i]);
            for(int j = 0; j < optionsArray[i].length; j++){
                System.out.println(optionsArray[i][j]);
            }
            //Push answers into answers array
            this.answersArray[i] = inputAnswer();

            //Check if the answers are correct
            boolean isCorrect = checkAnswer(answersArray[i], correctAnswersArray[i]);


            String message = generateMessage(isCorrect);

            //Display message to the user whether answer is correct or not
            JOptionPane.showMessageDialog(null, message);

            System.out.println("=======================================================================");

        }
        //Calculate the percentage of correct answers
        percentCorrectAnswers = (float)numCorrectAnswers*100/correctAnswersArray.length;

        //Display summary to the user
       JOptionPane.showMessageDialog(null, "End of Questions!\nCorrect answers: " + numCorrectAnswers + "\nWrong Answers: " +
               numWrongAnswers + "\n% of correct answers: " + percentCorrectAnswers + "%");

    }

    //Method to check if the input answer is correct or not
    public boolean checkAnswer(String answer, String correctAnswer){


        if(answer.equals(correctAnswer)){
            numCorrectAnswers ++;
            return true;
        }
        else{
            numWrongAnswers ++;
            return false;
        }


    }

    //Method to generate random messages to the user
    public String generateMessage(boolean isCorrect){
        SecureRandom randomNumbers = new SecureRandom();

        String message = "";

        if(isCorrect){
            switch(randomNumbers.nextInt(4)){
                case 0:
                    message = "Very good!";
                break;

                case 1:
                    message = "Excellent!";
                break;

                case 2:
                    message = "Keep up the good work!";
                break;

                case 3:
                    message = "Nice Work!";
                break;
            }
        }
        else{

            switch(randomNumbers.nextInt(4)){
                case 0:
                    message = "No. Please try again.";
                    break;

                case 1:
                    message = "Wrong answer.";
                    break;

                case 2:
                    message = "Try once more.";
                    break;

                case 3:
                    message = "No. Keep trying.";
                    break;
            }

        }

        return message;

    }

    //Method to receive and validate user's input
    public String inputAnswer(){

        String answer = JOptionPane.showInputDialog("Type the letter of the correct answer: ");
        answer = answer.toLowerCase().trim();

        ArrayList<String> optionsArray = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));

        if(optionsArray.contains(answer)){
            return answer;
        }

        else{
            answer = JOptionPane.showInputDialog("INVALID OPTION! Try again. ");
        }

        return answer;
    }


}