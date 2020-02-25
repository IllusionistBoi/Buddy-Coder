package com.rd;

/* BOARD TEST FILE */
/*  The values and the frame and the word to be formed are passed through the function wordPlacing and
    wordPlacement_Centre
    in the class board inspite of passing through main for now.
*/

public class Main {

        public static void main(String[] args) {
          /* Object is created of Class Board */
            Board ob= new Board();

            /* Write, Show board function called*/
            ob.write_Board();
            System.out.println("The first Move");
            ob.show_Board();

            System.out.println("The second Move");

            /* Write, Show board function called*/
            ob.write_Board();
            ob.show_Board();

            /* Reset, Show board function called*/
            System.out.println("The board has been reset");
            ob.resetBoard();
            ob.show_Board();

            ob.
        }

    }
