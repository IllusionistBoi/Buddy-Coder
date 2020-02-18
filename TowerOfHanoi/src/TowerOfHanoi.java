public class TowerOfHanoi {

    // Java recursive function to solve tower of hanoi puzzle
    static void towerOfHanoi(int Dish_Number, char Initial_Rod, char Destination_Rod, char Aux_Rod)
    {
        // Base Case for recursion function
        if (Dish_Number == 1) {
            System.out.println("Move disk 1 from rod " +  Initial_Rod + " to rod " + Destination_Rod);
            return;
        }

        //Recursive Functions

        towerOfHanoi(Dish_Number-1, Initial_Rod, Aux_Rod, Destination_Rod);
        System.out.println("Move disk " + Dish_Number + " from rod " +  Initial_Rod + " to rod " + Destination_Rod);
        towerOfHanoi(Dish_Number-1, Aux_Rod, Destination_Rod, Initial_Rod);
    }

    //  Main Method
    public static void main(String args[])
    {
        int Dish_Number = 4; // Number of disks
        towerOfHanoi(Dish_Number, 'A', 'C', 'B');  // A, B and C are names of rods
    }
}