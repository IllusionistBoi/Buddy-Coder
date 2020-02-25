package com.rd;

/*  Scanner Class Imported*/
import java.util.Scanner;


/*
    This board class allow multi functions.
    1. Reset the board.
    2. Store the current Tile Positions
    3. Word Placement and check if its possible or not
    4. Placing of the the word on the board

*/
public class Board {

    /* Array name board that store board formed */
    char[][] board = new char[15][15];

    /* Store the special tile values i.e Double word score for scoring purpose.   ( Will be used later in the Program ) */
    String[][] square_values = new String[15][15];

    /* Generate the game board. The board is a square with a 15*15 grid of cells. Each cell accommodates one letter. */
    public Board() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = ' ';
            }
        }
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------


    /* Function that Stores the special tile value that are responsible for the scoring */
    void store_square_values()
    {
        String[][] square_values = {

                /*                           TOP OF THE BOARD                              */
                { "3W","1W","1W","2L","1W","1W","1W","3W","1W","1W","1W","2L","1W","3W","3W"},
                { "1W","2W","1W","1W","1W","3L","1W","1W","1W","3L","1W","1W","1W","2W","1W"},
                { "1W","1W","2W","1W","1W","1W","2L","1W","2L","1W","1W","1W","2W","1W","1W"},
                { "2L","1W","1W","2W","1W","1W","1W","2L","1W","1W","1W","2W","1W","1W","1W"},
                { "1W","1W","1W","1W","2W","1W","1W","1W","1W","1W","2W","1W","1W","1W","1W"},
                { "1W","3L","1W","1W","1W","3L","1W","1W","1W","3L","1W","1W","1W","3L","1W"},
                { "1W","1W","2L","1W","1W","1W","2L","1W","2L","1W","1W","1W","2L","1W","1W"},


                /*                 BOARD MIDDLE LINE : LINE OF SYMMETRY                     */
                { "3W","1W","1W","2L","1W","1W","1W","1W","1W","1W","1W","2L","1W","1W","3W"},


                /*                          BOTTOM OF THE BOARD                             */
                { "1W","1W","2L","1W","1W","1W","2L","1W","2L","1W","1W","1W","2L","1W","1W"},
                { "1W","3L","1W","1W","1W","3L","1W","1W","1W","3L","1W","1W","1W","3L","1W"},
                { "1W","1W","1W","1W","2W","1W","1W","1W","1W","1W","2W","1W","1W","1W","1W"},
                { "2L","1W","1W","2W","1W","1W","1W","2L","1W","1W","1W","2W","1W","1W","1W"},
                { "1W","1W","2W","1W","1W","1W","2L","1W","2L","1W","1W","1W","2W","1W","1W"},
                { "1W","2W","1W","1W","1W","3L","1W","1W","1W","3L","1W","1W","1W","2W","1W"},
                { "3W","1W","1W","2L","1W","1W","1W","3W","1W","1W","1W","2L","1W","3W","3W"},

        };
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------

    /*
        Runs throughout the board & performs a check if the room is empty or not. Returns boolean value i.e true if empty
        & false if not
    */
    public boolean isBoardEmpty() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (board[i][j] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------


    /*
        Passes parametric values and word to be placed on the board. If the board is empty then placement function is invoked & if board
        is not empty then placing function is invoked.
    */
    void write_Board() {

        /*
           Take the Frame ( letter user has in his frame).
           In this case it takes CAT
        */

        Frame obj = new Frame();
        obj.get_Letter("CATKUDI");

        if(isBoardEmpty())
            wordPlacement_Centre("CAT",obj );
         else
            wordPlacing("CAT","DUCATI",'C','V',7,7,'H',obj);
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------


    /*
      It prints the board with the words placed on it
    */
    public void show_Board() {

        /* Print the _ 75 times for representation purpose */
        for(int k=1;k<=75;k++)
            System.out.print("_");

        System.out.println();

        /* Print the values on the board */
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print("|" + " " + board[i][j] + " " + "|");
            }
            System.out.println();
        }

        /*Print the _ again 75 times for representation purpose */
        for(int k=1; k <= 75; k++)
            System.out.print("_");

        System.out.println();
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------


    /*
        Check if the word to be formed are present in frame. I.e letter are present in the frame. It return true/false
        depending whether the letter are preset or not
     */
    boolean frame_Check(String substr,String mainString) {

        int counterVariable = 0;

        /* Check the letters of substring are in main string */
        for (int i = 0; i < substr.length(); i++) {
            if (mainString.indexOf(substr.charAt(i)) != -1) {
                counterVariable += 1;
            }
        }

        return (counterVariable == substr.length());
    }

//--------------------------------------------END OF FUNCTION ----------------------------------------------------------


    /*
      Place the word either top-bottom or left-right on the board depending upon what user says ON THE CENTER
      OF THE BOARD.
    */
    void wordPlacement_Centre(String word, Frame frame)
    {
        /* User choose the direction of word placement */
        Scanner sc = new Scanner(System.in);
        char []words;

        String frameInput;

        /* Take frame input as a string. */
        frameInput = frame.framereturn();

        /* Changing the word into character array */
        words = word.toCharArray();


        if( isBoardEmpty() && frame_Check(word,frameInput) && (7 + word.length()) < 15) {
            System.out.println("Press 0 for top to bottom or 1 for left to right");

            int directionChoice = sc.nextInt();

            /* Variable to access each character in the word array*/
            int chr = 0;

            /* 0 means vertical placement and place it on the board character by character.
               Runs the loop in which j value is 7 is constant as words are placed in straight line and only i varies
             */
            if( directionChoice == 0) {
                for( int i = 7; i < 7 + words.length && chr < words.length; i++)
                    board[i][7]=words[chr++];
            }

            /* Reset to zero */
            chr = 0;

            /* 1 means Horizontal placement and place it on the board character by character */
            if ( directionChoice == 1) {
                for(int i = 7; i < 7 + words.length && chr < words.length; i++)
                    board[7][i]=words[chr++];
            }
        }
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------



    /*
        After the first word has been placed in the word, this function is used to place rest of the words in the game.
        it enables the user to use the letter from the word formed already in his/her new word thus forming the game
        Scrabble
     */
    void wordPlacing(String lastword,String present,char connect,char choice,int i,int j,char oldstored,Frame frame) {

        String frameInput;

        /* Take frame input as a string. */
        frameInput = frame.framereturn();

        /* Check whether if at least one letter of the word is in the user's  frame */
        if ( frame_Check(present, frameInput) ) {

            /* wordFirstCharacter and wordLastCharacter are the variable as described below. suppose the user enters CAT
               wordFirstCharacter stores the position of first letter "C" and wordLastCharacter stores the position of
               "T"
            */
            int wordFirstCharacter, wordLastCharacter = 0;

        /*
            Check if last word is vertical or not. if it is it calculates the position accordingly of variable wordFirstCharacter
            & wordLastCharacter
        */
            if (oldstored == 'V') {
                wordFirstCharacter = i + lastword.length();
                wordLastCharacter = j;
            }

        /*
            Check if last word is vertical or not. if it is it calculates the position accordingly of variable wordFirstCharacter
            & wordLastCharacter
         */
            if (oldstored == 'H') {
                wordFirstCharacter = i;
                wordLastCharacter = j + lastword.length();
            }

        /* If user wants to place the next word vertically */
            if (choice == 'V') {

                int h = lastword.indexOf(connect); // Stores the position of the connecting character of last word
                int o = present.indexOf(connect);  // Stores the position of connecting character in present word
                int x = j + h;                     // Add the last position to find the new position

                /* Letter is being placed */
                for (int p = 1; p <= o; p++) {
                    if (board[i - p][x] == ' ')
                        board[i - p][x] = present.charAt(o - p);
                }

                /* Letter is being placed */
                for (int p = 1; p < present.length() - o; p++) {
                    if (board[i + p][x] == ' ')
                        board[i + p][x] = present.charAt(o + p);
                }
            }

        /* If user wants to place the next word horizontally */
            if (choice == 'H') {

                int h = lastword.indexOf(connect); // Stores the position of the connecting character of last word
                int o = present.indexOf(connect);  // Stores the position of connecting character in present word

                /* Letter is being placed */
                for (int p = o; p > 0; p--) {
                    if (board[i][j - (o - p) - 1] == ' ')
                        board[i][j - (o - p) - 1] = present.charAt(p - 1);
                }

                o = present.indexOf(lastword.charAt(lastword.length() - 1));

                /* Letter is being placed */
                for (int p = 1; p < present.length() - o; p++) {
                    if (board[i][wordLastCharacter + p] == ' ')
                        board[i][wordLastCharacter + p] = present.charAt(o + p);
                }
            }
        }
    }
//--------------------------------------------END OF FUNCTION ----------------------------------------------------------


    /*
       Resets the Board for new game
    */
    public void resetBoard() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                board[i][j] = ' ';
            }
        }
    }
}

//--------------------------------------------END OF FUNCTION ----------------------------------------------------------
