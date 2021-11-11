package exercise3;

public class OverloadApp {

    public static void main(String[] args){

        //Call overload 1
        OverloadedMethods.displayInput(10, 12);

        // Call overload 2
        OverloadedMethods.displayInput("Bruno", 15);

        //Call overload 3
        OverloadedMethods.displayInput(15.50, 37.5);
    }
}
