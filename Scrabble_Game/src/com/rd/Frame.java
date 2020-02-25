package com.rd;

 /*

    This Class Frame stores the tile of each player and allow multiple operation to be
    performed upon. It allows to remove, swap, check letters in frame, if frame is empty,
    view the letters in frame and also refilling the letter into the frame

 */


public class Frame {
    char[] letters = new char [7];

    /*
      Init the letters in the frame
    */

    void get_Letter(String getletters) {
        letters = getletters.toCharArray();
    }

    /*
       Amends the Frame during the game. Removes the letter when used in the game
       from the frame after a turn is made
    */

    void edit_Letter(char ch,int freq) {
        int length = letters.length;
        int count = 0;
        String ltr = "";

        for(int i = 0; i < letters.length; i++) {
            ltr = ltr + letters[i];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ltr);

        for(int i=1;i<=freq;i++) {
            sb.deleteCharAt(ltr.indexOf(ch));
            ltr = sb.toString();
        }

        letters = sb.toString().toCharArray();
     }

     /*
        Checks if letter is present in the frame
     */

    boolean has_Letter() {
        return  (letters.length!=0);
    }

    /*
        When user needs to take tile from the pool, this fucntion put in into the frame
        thus refilling the frame
     */

    void refill_Letter() {
        // Creating a instance of pool class & using its object to drawn the tile and refill it
      Pool ob = new Pool();
      char ch = ob.tile_Drawn();

      System.out.println(ch);

      // If tile count is less than 7 then only we can add
      if (letters.length < 7) {
          String temp_Frame = "";

          // Concatenate all the tiles in the frame
          for (char letter : letters) {
              temp_Frame += letter;
          }

          temp_Frame += ch;

          letters = temp_Frame.toCharArray();
      }

    }

    /*
        Displays the Frame
     */
    void display() {
      for (char letter : letters) System.out.print(letter + " ");
        System.out.println();
    }

    /*
          Return the frame in string form
    */

    public String framereturn()
    {
        String ltr = "";
        for (char letter : letters) {
            ltr = ltr + letter;
        }
        return ltr;
    }
}
