package JavaFX;

public class Main {

    /*
      "Control": Components that allow user to interact with the application in various ways
      handles user input, have event handlers/methods
      add the association of event handler to the button
      event handler/listening
      Procedural Driven Program: No User Interface => Run from entry point of application to the last line of the code

      User dictates what code and when
      Event Driven Program: UI Applications Run/Conditional Statement Rough order of each method and line of code will be actually executed
      Run Initialization Code => Build Main User Interface => Wait for User Input => User Input e.g. Type, Click, Select
                              => Run the code that handles the corresponding User Input Event "Event Handler for that particular event"
                              => User Exit/Closes the Window => Exit the application => Clean up code

      "Life Cycle of UI Program": Application/UI Application Thread waiting for User Input
      Interact with any control e.g. app button => event is actually raised in the UI Thread
      => User interaction with the particular control => Run event handler associated with the event
      Run Application => Creates the instance of our controller class
      Assign the text field created from the fxml to the name field instance variables

      Event and Event Handling
      UI Thread busy => user input X interact X
      Won't respond/ freeze
      Thread.sleep
      Background thread



     */
}
