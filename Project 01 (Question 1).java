// Include functions that:
//              Initialize seats
//              Show the menu
//              Assign a seat
//              Show seat assignments

import java.util.Scanner;

public class Airplane {
    public static char[][] seats = new char[13][6]; // global 2D char array; used to display/store seats
    public static boolean globFlag = true; // global boolean flag initialized to be true;
                                           // used to safely exit loops in the main()

    public static void main(String[] args){
        initialize(); // calls initialize() method to set up the array
        do{
            // do-while loop; will repeatedly call display() and menu() until flag is false
            display(); // displays current state of array
            menu(); // menu() method holds all the prompts to the user
        } while(globFlag);

        if(globFlag){
            // executes if flag is still true after the do-while loop; displays array after
            // assigning a seat
            display(); // displays current state of array; mainly used to see if seat was correctly assigned
            System.out.println(); // formatting
        }
    }

    public static void initialize(){
        // method will fill the global char array with asterisks to denote empty seats

        for(int i = 0; i < seats.length; i++){
            for(int j = 0; j < seats[i].length; j++){
                // each element in array becomes an asterisk
                seats[i][j] = '*';
            }
        }
    }

    public static void menu(){
        // method will prompt user if they want to reserve a seat, which ticket they would like,
        // and ask for their seat information

        // informs user which rows correlate with each ticket type
        System.out.println("Rows 1 and 2 are for first " +
                "class passengers.");
        System.out.println("Rows 3 through 7 are for " +
                "business class passengers.");
        System.out.println("Rows 8 through 13 are for " +
                "economy class passengers.");


        System.out.print("Reserve a seat? Yes (Y/y) " +
                "or No (N/n): "); // reservation prompt
        Scanner input = new Scanner(System.in); // declares scanner
        char ans = input.next().charAt(0); // stores character entered by user

        if (ans == 'N' || ans == 'n'){
            // executes if user does not want to reserve a seat
            globFlag = false; // sets flag to false; helps safely loop in the main
            return; // exits menu method
        }
        else // executes if user does want to reserve a seat
            System.out.println(); // formatting

        int row = 0; // initializes row value to 0; for use after the while loop
        boolean innerFlag = false; // flag to be used by the inner while loop
        boolean flag = false; // another flag value initialized to false
        while(!flag){
            // loops until flag is true; if false, process repeats until flag is true
            while(!innerFlag){
                // this loop is used to reiterate these processes in the case of an invalid ticket type
                // being entered by the user; flag is set to false, so loop will end when flag is true
                System.out.print("Enter ticket type (F/f - First " +
                        "Class, B/b - Business, E/e - Economy): "); // prompts user for ticket type
                char type = input.next().charAt(0); // scans a char value from user

                if(type == 'F' || type == 'f'){
                    // executes if user requests first class ticket; handles both letter cases
                    System.out.print("Enter row number (1 - 2): "); // prompts user for either row 1 or 2
                    row = input.nextInt(); // scans integer from user to store as row value
                    if(row == 1 || row == 2){
                        // executes if row value is 1 or 2
                        innerFlag = true;
                        flag = true; // flag is true; loop is ended
                    }
                    else{
                        // executes if user enters invalid row for first class ticket
                        System.out.println("Error: Please " +
                                "enter correct value"); // error prompt
                        flag = false; // flag remains false; user looped back
                    }
                }
                else if(type == 'B' || type == 'b'){
                    // executes if user requests a business class ticket
                    System.out.print("Enter row number (3 - 7): "); // prompts user for row 3 - 7
                    row = input.nextInt(); // scans integer from user to store as row value
                    if(row == 3 || row == 4 || row == 5
                            || row == 6 || row == 7){
                        // executes if requested row is any value from 3 to 7
                        innerFlag = true;
                        flag = true; // flag is true; loop is ended
                    }
                    else{
                        // executes if user enters invalid row for business class ticket
                        System.out.println("Error: Please " +
                                "enter correct value"); // error prompt
                        flag = false; // flag remains false; user looped back
                    }
                }
                else if(type == 'E' || type == 'e'){
                    // executes if user requests a economy class ticket
                    System.out.print("Enter row number (8 - 13): "); // prompts user for row 8 - 13
                    row = input.nextInt(); // scans integer from user to store as row value
                    if(row == 8 || row == 9 || row == 10
                            || row == 11 || row == 12 || row == 13){
                        // executes if requested row is any value from 8 to 13
                        innerFlag = true;
                        flag = true; // flag is true; loop is ended
                    }
                    else{
                        // executes if user enters invalid row for economy class ticket
                        System.out.println("Error: Please " +
                                "enter correct value"); // error prompt
                        flag = false; // flag remains false; user looped back
                    }
                }
                else{
                    // executes if user enters an invalid value for the ticket type
                    System.out.println("Error: enter valid seat type."); // error prompt
                    innerFlag = false; // flag is false; user is looped back
                }
            }
        }

        char seat = ' '; // initializes an empty char variable; used to contain upcoming scanner value
        boolean flag2 = false; // another flag value to be used by the while loop so it knows when to end
        while (!flag2){
            // this loop will continuously loop until a valid seat value is entered by the user
            System.out.print("Enter your seat (A - F): "); // prompts user for seat
            seat = input.next().charAt(0); // scans value from user and stores it in seat variable

            if(seat == 'A' || seat == 'a' || seat == 'B'
                || seat == 'b' || seat == 'C' || seat == 'c'
                || seat == 'D' || seat == 'd' || seat == 'E'
                || seat == 'e' || seat == 'F' || seat == 'f'){
                // executes if any of these values are entered by the user
                flag2 = true; // this will switch the flag to being true, ending the loop
            }
            else{
                // executes if the value entered by the user isn't one of the characters listed above
                System.out.println("Error: please enter " +
                        "valid input"); // error prompt
                flag2 = false; // flag will remain false, leading the loop to reiterate
            }
        }

        int seatInt = 0; // integer value initialized to zero; will contain seat's integer equivalent so that
                         // assigning a seat will be as easy as passing two numbers to the assign() method
        switch(seat){
            case 'A': case 'a': // handles case of user selecting seat A
                seatInt = 1; // integer equivalent is 1
                break;
            case 'B': case 'b': // handles case of user selecting seat B
                seatInt = 2; // integer equivalent is 2
                break;
            case 'C': case 'c': // handles case of user selecting seat C
                seatInt = 3; // integer equivalent is 3
                break;
            case 'D': case 'd': // handles case of user selecting seat D
                seatInt = 4; // integer equivalent is 4
                break;
            case 'E': case 'e': // handles case of user selecting seat E
                seatInt = 5; // integer equivalent is 5
                break;
            case 'F': case 'f': // handles case of user selecting seat F
                seatInt = 6; // integer equivalent is 6
                break;
        }

        assign(row, seatInt); // finally calls to the assign method to reserve a seat; takes the values of the row
                              // and seat
    }

    public static void assign(int r, int s){
        // method handles assigning a spot in the array as the "seat"; r is the row, s is the seat

        if(seats[r - 1][s - 1] != 'X') // executes if seat is not already reserved
            seats[r - 1][s - 1] = 'X'; // reserves seat by replacing asterisk at this spot with an X
        else{
            // executes if seat is already reserved; will end up starting program from the top
            System.out.println("Error: Seat already reserved. " +
                    "Please choose another."); // error prompt
            System.out.println(); // formatting
        }
    }

    public static void display(){
        // method handles displaying the current layout of the seating arrangements

        System.out.println("       A B C D E F"); // formatted to place seat markers above asterisk columns
        for(int i = 0; i < seats.length; i++){
            // outer for loop handles printing the rows
            if(i < 9) // executes if the current row index is 0 - 9
                System.out.print("Row " + (i+1) + "  "); // prints the row number and keeps columns parallel
            else // executes if the current row index is 10 - 13
                System.out.print("Row " + (i+1) + " "); // prints the row number and keeps columns parallel

            for (int j = 0; j < seats[i].length; j++){
                // handles printing the columns
                System.out.print(seats[i][j] + " "); // prints each asterisk or X separated by a space
            }
            System.out.println(); // formatting
        }

        System.out.println("* -- available seat"); // prompts user that an asterisk means an empty seat
        System.out.println("X -- occupied seat"); // prompts user that an X means an occupied seat
    }
}