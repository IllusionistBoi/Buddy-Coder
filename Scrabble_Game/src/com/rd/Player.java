package com.rd;

  /*

    This class is responsible for storing the data of the player. It enables the user
    to reset the name & his/her data. It also enables them to access their score and view
    his/her frame that contains his file

  */

public class Player {
    String name;
    int  score;
    Frame frame;

    /*
      Player is a non- parametric constructor of which above are the data members
    */
    public Player() {
        name = "";
        score = 0;
        frame = new Frame();
    }

    /*
       Setter for players name
    */
    void set_PlayerName(String id) {
      name = id;
    }

    /*
      Increase the score during the game after each turn
    */
    int update_PlayerScore(int increment) {
        return(score+=increment);
    }

    /*
      Displays the score i.e getter function for score
    */
     int display_PlayerScore() {
         return score;
     }

    /*
       It displays the tile of the player i.e tiles that he has choosen from the pool
    */
     Frame access() {
         return frame;
     }

    /*
      Display player name
    */
     void display_PlayerName() {
         System.out.println(name);
     }

     /*
     Resets the player data to new
      */
     void reset_PlayerData() {
         name = "";
         score = 0;
         frame = null;
     }
}
