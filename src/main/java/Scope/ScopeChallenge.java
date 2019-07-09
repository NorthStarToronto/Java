package Scope;

import java.util.Scanner;
/* Bad Practice only concept */
public class ScopeChallenge {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Please enter a number: ");
//        X x = new X(scanner.nextInt());
//        x.x();

        X x = new X(new Scanner(System.in));
        x.x();
    }
}
