package Scope;

/* Visibility ?
   1. the Accessible interface? => Available to all classes within the package "Package Private"
   2. the int variable SOME_CONSTANT => all interface variables public static final
   3. method A, B, & C => All methods to be implemented must be public "Public"
 */
interface Accessible {

    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}

