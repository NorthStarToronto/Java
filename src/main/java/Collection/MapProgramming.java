package Collection;

import java.util.HashMap;
import java.util.Map;

public class MapProgramming {

    public static void main(String[] args) {

        /* All Core Collection Interface = Generic; can be objects
           Map replaces dictionary: key value pair
           Map Interface => HashMap, Linked HashMap
           Sorted Map Interface => Tree Map
         */
        Map<String, String> languages = new HashMap<>();
        /* Concurrency: Only one key value wriet*/
        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        }  else {
            languages.put("Java", "a compiled high level, object-oriented, platform independent language");
            System.out.println("Java added successfully");
        }

        languages.put("Python", "an interpreted, object-oriented, high-level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        System.out.println(languages.put("BASIC", "Beginners all purposes symbolic instruction code"));
        System.out.println(languages.put("LISP", "Therein lies madness"));

        if(languages.containsKey("Java")) {
            System.out.println("Java already in the map");
        }  else {
            languages.put("Java", "this course is about Java");
        }

        System.out.println("=======================================================================");

        languages.remove("LISP");
        /* remove only if it exists */
        if(languages.remove("Algol", "an ass")) {
            System.out.println("Algo removed");
        } else {
            System.out.println("Algo not removed");
        }

        if(languages.replace("Algol", "an algorithmic language", "hey wow")) {
            System.out.println("Algol replaced");
        } else {
            System.out.println("Algol was not replaced");
        }

        /* Loop through key value pairs; No Order */
        for(String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get(key));
        }
    }
}
