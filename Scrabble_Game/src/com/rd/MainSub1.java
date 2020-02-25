package com.rd;
//
// /*
//
//    This main file calls all the functions called in other class Pool,Frame & Player. It creates objects for each class and then carry out test
//    for all the functions created in respective classes
//
// */
//
//public class Main {
//    public static  void main(String[] args) {
//
//        Pool ob1 = new Pool();
//        Player ob2 = new Player();
//        Frame ob3 = new Frame();
//
//        System.out.println("Random Tile Chosen from the pool of tile (Reference Class : Pool.JAVA):   " + ob1.tile_Drawn() + "\n");
//
//        // Iterating Through the game_Frequency array and Updating (Decrease as of now) the chosen letter Ocurrence
//        System.out.print("The updated frequency of the letter is as follow :                        ");
//        for(int i=0;i<=25;i++)
//            System.out.print(ob1.game_Frequency[i] + ",");
//        System.out.println(ob1.game_Frequency[26]);  // Could have run the loop till 26 but because of Comma Done this way
//
//        // Blank Tile Value Printed.
//        System.out.println( "\n" + "Value of Blank Tile is :                                                  " + ob1.tile_Value(' ') + "\n");
//
//        // Setting up the frame of our choice & Displaying it
//        System.out.print("The letters in the frame our as follow :                                  ");
//        ob3.get_Letter("RDSAAA");
//        ob3.display();
//
//        //Boolean value printed and printing true if any letter exist in frame
//        System.out.print("Does the frame has any letter or not :                                    ");
//        System.out.print(ob3.has_Letter() + "\n");
//
//        //Checks the occuranace of letter R and removes it as many times as frequency is mentioned. if not throws an exception
//        ob3.edit_Letter('R',1);
//        System.out.print("Letter Above Removed from the frame. The update Frame is now as follow :  ");
//        ob3.display();
//
//        //Choosing Random tile from the pool and adding it to the pool
//        System.out.print("The Random tile from the pool is ");
//
//        // Refilling the frame and printing
//        ob3.refill_Letter();
//
//        System.out.print("The Updated letters in the frame our as follow :                          ");
//        ob3.display();
//
//        // Set the players name to the input entered
//        ob2.set_PlayerName("Rowfdy");
//
//        // Displays the name
//        System.out.print("Player Name is :                                                          ");
//        ob2.display_PlayerName();
//
//        // Updating the PlayerScore by input value as of file
//        ob2.update_PlayerScore(22);
//
//        //Displaying Score now
//        System.out.print("The Updated Score of the player is                                        ");
//        System.out.println(ob2.display_PlayerScore());
//
//        // Player Data reset
//        ob2.reset_PlayerData();
//
//        //Check the player name and it would be empty as reset
//        System.out.print("Player Name is :                                                          ");
//        ob2.display_PlayerName();
//        System.out.print("Player Score is :                                                          ");
//
//        System.out.println(ob2.display_PlayerScore());
//
//
//    }
//}

