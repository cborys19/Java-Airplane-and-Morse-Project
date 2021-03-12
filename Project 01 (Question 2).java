// Reads English and converts to Morse code (one method)
// Reads Morse phrase and converts to English (one method)
//
// Use one blank between each Morse-coded letter
// Use three blanks between each Morse-coded word

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        System.out.print("Enter an English phrase: "); // prompt user to enter a phrase in English
        Scanner input = new Scanner(System.in); // declare scanner variable to accept input from user
        String phrase = input.nextLine(); // scanner input will be type String

        System.out.println("Phrase in Morse: " + engToMorse(phrase)); // outputs user's input in Morse code

        System.out.print("Enter a phrase in Morse Code: "); // prompts user to enter phrase in Morse code
        String mPhrase = input.nextLine(); // next scanner input of type String
        System.out.println("Phrase in English: " + morseToEng(mPhrase)); // output's user's morse input in English
    }

    public static String engToMorse(String s){
        String newString = ""; // initializes empty String; will contain converted phrase in Morse code

        // for loop to cycle through the string passed into the method and converts each English character
        // to its Morse equivalent; done through switch statement
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case 'A': case 'a':
                    newString = newString.concat(".- ");
                    break;
                case 'B': case 'b':
                    newString = newString.concat("-... ");
                    break;
                case 'C': case 'c':
                    newString = newString.concat("-.-. ");
                    break;
                case 'D': case 'd':
                    newString = newString.concat("-.. ");
                    break;
                case 'E': case 'e':
                    newString = newString.concat(". ");
                    break;
                case 'F': case 'f':
                    newString = newString.concat("..-. ");
                    break;
                case 'G': case 'g':
                    newString = newString.concat("--. ");
                    break;
                case 'H': case 'h':
                    newString = newString.concat(".... ");
                    break;
                case 'I': case 'i':
                    newString = newString.concat(".. ");
                    break;
                case 'J': case 'j':
                    newString = newString.concat(".--- ");
                    break;
                case 'K': case 'k':
                    newString = newString.concat("-.- ");
                    break;
                case 'L': case 'l':
                    newString = newString.concat(".-.. ");
                    break;
                case 'M': case 'm':
                    newString = newString.concat("-- ");
                    break;
                case 'N': case 'n':
                    newString = newString.concat("-. ");
                    break;
                case 'O': case 'o':
                    newString = newString.concat("--- ");
                    break;
                case 'P': case 'p':
                    newString = newString.concat(".--. ");
                    break;
                case 'Q': case 'q':
                    newString = newString.concat("--.- ");
                    break;
                case 'R': case 'r':
                    newString = newString.concat(".-. ");
                    break;
                case 'S': case 's':
                    newString = newString.concat("... ");
                    break;
                case 'T': case 't':
                    newString = newString.concat("- ");
                    break;
                case 'U': case 'u':
                    newString = newString.concat("..- ");
                    break;
                case 'V': case 'v':
                    newString = newString.concat("...- ");
                    break;
                case 'W': case 'w':
                    newString = newString.concat(".-- ");
                    break;
                case 'X': case 'x':
                    newString = newString.concat("-..- ");
                    break;
                case 'Y': case 'y':
                    newString = newString.concat("-.-- ");
                    break;
                case 'Z': case 'z':
                    newString = newString.concat("--.. ");
                    break;
                case '1':
                    newString = newString.concat(".---- ");
                    break;
                case '2':
                    newString = newString.concat("..--- ");
                    break;
                case '3':
                    newString = newString.concat("...-- ");
                    break;
                case '4':
                    newString = newString.concat("....- ");
                    break;
                case '5':
                    newString = newString.concat("..... ");
                    break;
                case '6':
                    newString = newString.concat("-.... ");
                    break;
                case '7':
                    newString = newString.concat("--... ");
                    break;
                case '8':
                    newString = newString.concat("---.. ");
                    break;
                case '9':
                    newString = newString.concat("----. ");
                    break;
                case '0':
                    newString = newString.concat("----- ");
                    break;
                case ' ':
                    newString = newString.concat("  ");
                    break;
                default:
                    System.out.print("Invalid character.");
            }
        }

        return newString; // returns the new String of Morse characters with proper spacing
    }

    public static String morseToEng(String s){
        String[] wordBank = s.split(" "); // splits string at all spaces and stores the split characters
                                                // in a string array
        String x = ""; // initializes empty string; will contain converted phrase in English

        // for loop to cycle through the string array and convert each Morse character to its English equivalent;
        // done through a switch statement
        for(int i = 0; i < wordBank.length; i++){
            switch(wordBank[i]){
                case ".-":
                    x = x.concat("A");
                    break;
                case "-...":
                    x = x.concat("B");
                    break;
                case "-.-.":
                    x = x.concat("C");
                    break;
                case "-..":
                    x = x.concat("D");
                    break;
                case ".":
                    x = x.concat("E");
                    break;
                case "..-.":
                    x = x.concat("F");
                    break;
                case "--.":
                    x = x.concat("G");
                    break;
                case "....":
                    x = x.concat("H");
                    break;
                case "..":
                    x = x.concat("I");
                    break;
                case ".---":
                    x = x.concat("J");
                    break;
                case "-.-":
                    x = x.concat("K");
                    break;
                case ".-..":
                    x = x.concat("L");
                    break;
                case "--":
                    x = x.concat("M");
                    break;
                case "-.":
                    x = x.concat("N");
                    break;
                case "---":
                    x = x.concat("O");
                    break;
                case ".--.":
                    x = x.concat("P");
                    break;
                case "--.-":
                    x = x.concat("Q");
                    break;
                case ".-.":
                    x = x.concat("R");
                    break;
                case "...":
                    x = x.concat("S");
                    break;
                case "-":
                    x = x.concat("T");
                    break;
                case "..-":
                    x = x.concat("U");
                    break;
                case "...-":
                    x = x.concat("V");
                    break;
                case ".--":
                    x = x.concat("W");
                    break;
                case "-..-":
                    x = x.concat("X");
                    break;
                case "-.--":
                    x = x.concat("Y");
                    break;
                case "--..":
                    x = x.concat("Z");
                    break;
                case ".----":
                    x = x.concat("1");
                    break;
                case "..---":
                    x = x.concat("2");
                    break;
                case "...--":
                    x = x.concat("3");
                    break;
                case "....-":
                    x = x.concat("4");
                    break;
                case ".....":
                    x = x.concat("5");
                    break;
                case "-....":
                    x = x.concat("6");
                    break;
                case "--...":
                    x = x.concat("7");
                    break;
                case "---..":
                    x = x.concat("8");
                    break;
                case "----.":
                    x = x.concat("9");
                    break;
                case "-----":
                    x = x.concat("0");
                    break;
                case "   ":
                    x = x.concat(" ");
                    break;
            }
        }

        return x; // returns string of English characters
    }
}
