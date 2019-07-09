package Scope;


// Inner class has access to all the inner class variables
// and fields of its containing class

/* The Scope of Each Variable */
// varOne: Entire class check => Main Constructor and Inner Constructor
// If same name use this
// Object scope => block it's declared & including any contained blocks
// varTwo: declared block and within block
/* Variable can only shadow one with the same name if it's declared in enclosed block */
// narrower scope priority
// narrower scope priority
// Object Scope: The block in which it's declared including any contained blocks


/* Visibility is governed by the axis modifiers
   Visibility is connected to scope

 */

public class ScopeCheck {

    public int publicVar = 0;
    private int varOne = 1; // this.varOne "class variable"

    // create constructor
    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + "varOne = " + varOne);
    }

    // create getter
    public int getVarOne() {
        return varOne;
    }

    // create timesTwo method
    public void timesTwo() {
        int varTwo = 2;
        for(int i=0; i<10; i++) {
            System.out.println(i + " times two is " + i * varTwo);
        }
    }

    public void useInner() {
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree); // ScopeCheck.this.varOne
    }

    // create InnerClass
    public class InnerClass {
        private int varThree = 3;

        public void InnerClass() {
            System.out.println("InnerClass created, varOne is " + varOne +" and varThree is " + varThree);
        }

        public void timeTwo() {
            System.out.println("varOne is still available here " + varOne);
            for(int i=0; i<10; i++) {
                System.out.println(i + " times two is " + i*varThree);
            }
        }
    }
}
