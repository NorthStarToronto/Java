package OOP4;

import OOP4.Team;

import java.util.ArrayList;
import java.util.Collections;


/*
  Defined league to be parameterized type
  => Team or any sub classes would be allowed as an argument
     when create an instance team
  => Parameterized Type used in
      ArrayList declaration
      Use in addTeam
      for loop
 */
public class League <T extends Team> {

    public String name;
    private ArrayList<T> league = new ArrayList<>();

    public League(String name) {
        this.name = name;
    }

    public boolean addTeam(T team) {
        if(league.contains(team)) {
            return false;
        } else {
            league.add(team);
            return true;
        }
    }

    public void showLeagueTable() {
        Collections.sort(league);
        for(T t: league) {
            System.out.println(t.getName() + ": " + t.ranking());
        }
    }




}
