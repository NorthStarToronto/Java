package Stream;


/* Stream: A sequence of computation */
// Similar to chaining predicate, function,and consumer

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* Lambda Scope: Within the scope of the main method body => use any variable declared in main
   as long as variable are final
   gNumbers list object referenced does not change
*/
public class Main {
    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
            "N40", "N36",
            "B12", "B6",
            "G53", "G49", "G60", "G50", "g64",
            "I26", "I17", "I29",
            "O71");

        List<String> gNumbers = new ArrayList<>();

//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));

        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s->s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);




    }
}
