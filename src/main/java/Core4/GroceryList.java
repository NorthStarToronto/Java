package Core4;

import java.util.ArrayList;

/* ArrayList: Defining Type X,
   Hold Objects => Tell the type of object to be saved in the ArrayList
   ArrayList is a class. => Empty Constructor

 */
public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>();

    /* Add Item to List */
    public void addGroceryItems(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " items in your grocery list");
        for(int i=0; i< groceryList.size(); i++) {
            System.out.println( (i+1) + ". " + groceryList.get(i));
        }
    }

    /* Modify Item to List */
    public void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery itme " + (position+1) + " has been modified.");
    }

    /* Remove Item from List */
    public void removeGroceryItem(int position) {
        String theItem  = groceryList.get(position);
        groceryList.remove(position);
    }

    /* Query: ArrayList's fast search */
    public String findItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem);
        int position = groceryList.indexOf(searchItem);
        if(position >=0) {
            return groceryList.get(position);
        }

        return null;
    }

}
