package exercise2;
import javax.swing.JOptionPane;
import java.security.SecureRandom;

public class Lotto {

    //Declare constants
    static final int SIZE = 3;
    static final int MAX_ATTEMPT = 5;

    //Array property to store three random integers
    private int lottoNumbers[] = new int[SIZE];

    //Constructor that populates the lottoNumbers array
    public Lotto(){
        SecureRandom randomNumbers = new SecureRandom();
        for(int i=0; i<SIZE; i++){
            int lottoNum = 1+ randomNumbers.nextInt(10);
            this.lottoNumbers[i] = lottoNum;
        }
    }

    //Method to retrieve the lottoNumbers array
    public int[] getLottoNumbers(){
        return lottoNumbers;
    }

    //Method to calculate and return the sum of the numbers in a single lotto game
    private static int sumLottoNumbers(Lotto game){
        int [] lottoArray = game.getLottoNumbers();
        int sum = 0;
        for(int i=0; i<lottoArray.length; i++){
            sum+=lottoArray[i];
        }
        return sum;
    }

    //Method to run the Lotto game
    public static void runLotto(){

        String number;
        int num;


        for(int a=0; a<MAX_ATTEMPT; a++){

            //Instantiate a new game and get the sum of its numbers
            Lotto game = new Lotto();
            int sumGame = sumLottoNumbers(game);

            //Accept user's input
            number = JOptionPane.showInputDialog("Enter a number between 3 and 27");
            num = Integer.parseInt(number);

            System.out.printf("The sum of the game is: %s%n", sumGame);
            System.out.printf("The number chosen by the user is: %d%n", num);

            //Compares the input number and the sum of the Lotto game
            if(sumGame == num){
                JOptionPane.showMessageDialog(null, "You Win!");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "You lose!");
    }


}
