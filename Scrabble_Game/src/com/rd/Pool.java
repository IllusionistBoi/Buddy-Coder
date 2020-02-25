package com.rd;

/*

 This class stores the value of every Tile i.e points of each tile, All current
 Tile in the pool according to the rule of the game. This class also allow to reset the
 pool, display number of tiles, and also check if its empty or not. We can also check
 if random drawn is possible or not from the pool. User can also get information about
 each tile in the pool

 */

public class Pool
{
    /*
      It contains the count/frequency of each tile in the pool.It remains untouched and
      is not altered anytime during the gameplay. Its sole purpose is to help reset function
      that allows the pool to be reset
     */
    int[] original_Frequency = { 9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2 };

    /*
      It contains the count/frequency of each tile and it changes as user draws a tile
      during the gameplay.
    */
    int[] game_Frequency = { 9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1,2 };

    /*
      It contains the points/value of each letter in the pool
    */
    int[] tile_Point={1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10,0};

    /*
      Responsible for ending the game, this function ends the game when it return false
      i.e no tile in the pool left
     */
    boolean check_EmptyPool() {
         return (tile_InPool() == 0);
     }

     /*
       This function helps the user to choose a random tile from the pool in two scenario.
       1. In Start, 7 tiles are chosen at random.
       2. During the game, if user need to exchange the tile with something random drawn from
          the pool
     */
     char tile_Drawn() {
         int random;

         // Generates a random number
         random=((int) (Math.random() * (26)));
         game_Frequency[random]--;
         System.out.println( "(Test to check if random number is generated after each execution :        " + random);

         return (char)('A'+ random);
     }

     /*
       This resets the game_frequency array with the original one. i.e New Game Conditions
       Enabled
     */
     void game_Reset() {
         System.arraycopy(original_Frequency, 0, game_Frequency, 0, 26);
     }

     /*
        Shows all the values of the tiles in the pool at any stage of the game
     */

     int tile_InPool() {
         int no_of_tiles = 0;

         for(int i=0;i<26;i++) {
          no_of_tiles = no_of_tiles + game_Frequency[i];
         }

     return no_of_tiles;
     }

     /*
        User can ask for detail of any tile in the pool. This function returns the point
        of tile
      */
     int tile_Value(char tile) {
         int index;

         if(tile==' ') {
             index = 26;
             return(tile_Point[index]);
         }
         else {
         index= tile-'A';

         return(tile_Point[index]);
         }
     }
}