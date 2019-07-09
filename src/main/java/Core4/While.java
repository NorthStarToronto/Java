package Core4;

public class While {

    public static void main(String[] args) {

        /* While Loop */
        int count = 0; // initialization
        while(count!=5) { // condition
            System.out.println("Count value is " + count);
            count++; // increment
        }

        // another version

        count=1;
        while(true) {
            if(count==0) {
                break;
            }
            System.out.println("Count value is = " + count);
            count++;
        }

        /* For Loop */
        // Continue (By-pass to start of the loop) vs Break
        for(count=1; count!=5; count++) { // initialization condition increment
            System.out.println("Count value is " + count);
        }

        // While
        int number = 4;
        int finishNumber=20;
        int evenNumbersFound =0;

        while(number<=finishNumber) {
            number++;
            if(!isEvenNumber(number)) {
                continue;
            }
            System.out.println("Even number " + number);
            evenNumbersFound++;
            if(evenNumbersFound>=5) {
                break;
            }

        }

        System.out.println("Total even numbers found " + evenNumbersFound);

        /* Digit */
        System.out.println("The sum of the digits in number 125 is " + sumDigits(125));
    }

    private static boolean isEvenNumber(int number) {
        if(number%2==0) {
            return true;
        } else {
            return false;
        }
    }

    private static int sumDigits(int number) {

        if(number <10) {
            return -1;
        }

        int sum=0;

        while(number >0) {
            int digit = number%10;
            sum +=digit;

            number /=10;
        }
        return sum;
    }
}
