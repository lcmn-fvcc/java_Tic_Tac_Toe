/*
Laura Mills Nelson
Assignment 5.1
03/21/18
 */
package assign5.pkg1_millsnelson;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lauracmillsnelson
 */
public class Assign51_MillsNelson
{

    //create global array
    static String[] TicTacToe = new String[9];

    //create global variables to track wins, losses, draws
    static int GameCntr = 0;
    static int WinCntr = 0;
    static int LossCntr = 0;
    static int DrawCntr = 0;
    static String end = "n";
    static String again = "y";

    //create scanner
    static Scanner myScan = new Scanner(System.in);

    //function to setup and reset the game board
    static void Setup()
    {
        for (int r = 0; r < 9; r++)
        {
            TicTacToe[r] = "-";

        }

    }

    //function to print array
    static void PrintArray()
    {
        int rc = 1;

        System.out.println();
        
        //to label columns
        System.out.println("        Columns");

        System.out.println("       1   2   3");

        //to label rows
        System.out.print("Row " + rc + "  ");

        //print array
        for (int c = 0; c < 9; c++)
        {
            //causes print line to occur after 3 boxes
            if (c % 3 == 0 && c > 0)
            {
                System.out.println();

                //to label rows
                System.out.print("Row " + (++rc) + "  ");
            }

            System.out.print(TicTacToe[c]);

            //to place bars between columns
            if (c == 2 || c == 5 || c == 8)
            {

            } else
            {
                System.out.print(" | ");
            }

        }

        System.out.println();
    }

    //user turn function
    static void UserTurn()
    {
        //variables
        int row = -1;
        int col = -1;

        //ask question
        System.out.print("\nYour Turn:\nWhich row do you want, 1 - 3?  ");
        
        //try catch statement to prevent incorrect entries/crashing
        try
        {
            //collect answer
            row = Integer.parseInt(myScan.nextLine());

            //ask question
            System.out.print("Which column do you want, 1 - 3? ");

            //collect answer
            col = Integer.parseInt(myScan.nextLine());

            //if functions to fill box based on collected answers
            if (row == 1 && col == 1)
            {
                if (TicTacToe[0] == "-")
                {
                    TicTacToe[0] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 1 && col == 2)
            {
                if (TicTacToe[1] == "-")
                {
                    TicTacToe[1] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 1 && col == 3)
            {
                if (TicTacToe[2] == "-")
                {
                    TicTacToe[2] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 2 && col == 1)
            {
                if (TicTacToe[3] == "-")
                {
                    TicTacToe[3] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 2 && col == 2)
            {
                if (TicTacToe[4] == "-")
                {
                    TicTacToe[4] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 2 && col == 3)
            {
                if (TicTacToe[5] == "-")
                {
                    TicTacToe[5] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 3 && col == 1)
            {
                if (TicTacToe[6] == "-")
                {
                    TicTacToe[6] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 3 && col == 2)
            {
                if (TicTacToe[7] == "-")
                {
                    TicTacToe[7] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if (row == 3 && col == 3)
            {
                if (TicTacToe[8] == "-")
                {
                    TicTacToe[8] = "O";
                } else
                {
                    System.out.print("\nThat spot is already filled. "
                        + "Try again.\n");
                    UserTurn();
                }
            }
            if ((row <=0 || row >= 4) || (col <=0 || col >= 4))
            {
                System.out.print("\nThat is not an option. Try again.\n");
                UserTurn();
            }                
        } catch (Exception e)
        {
            //error statement
            System.out.print("\nThat is not an option. Try again.\n");
            UserTurn();
        }
    }

    //computer turn function
    static void ComputerTurn()
    {
        //variables
        int x = -1;
        String stop = "n";

        //generate random number and assign it to 'x'
        Random RNG = new Random();

        x = RNG.nextInt(9);

        //if function to find and fill empty box
        if (TicTacToe[x] == "-")
        {
            TicTacToe[x] = "X";
        } else if (TicTacToe[x] != "-")
        {
            while (stop.equals("n"))
            {
                //runs until 'x' finds an empty space to fill or is greater 
                //than the length of the array, then kicks out of loop
                while (x < 9 && x > -1)
                {
                    if (TicTacToe[x] == "-")
                    {
                        TicTacToe[x] = "X";
                        x = -1;
                        stop = "y";
                    } else
                    {
                        x = x + 1;
                    }

                }

                //reset 'x' to the beginning of the array
                x = 0;

                //runs until 'x' finds an empty space to fill
                while (stop.equals("n"))
                {
                    if (TicTacToe[x] == "-")
                    {
                        TicTacToe[x] = "X";
                        stop = "y";
                    } else
                    {
                        x = x + 1;
                    }
                }
            }
        }

        System.out.println("\n\nComputer's Turn:\n");

    }

    //check for win function
    static void CheckWin()
    {
        //if statements to check for all possible wins
        if (TicTacToe[0] == TicTacToe[1] && TicTacToe[1] == TicTacToe[2])
        {
            if (TicTacToe[0] == "O")
            {
                //display win
                System.out.println("\n\nYou WON!! Congratulations!");
                //count win
                WinCntr++;
                //kick out of loop in main to move on to Summary function
                end = "y";
            } else if (TicTacToe[0] == "X")
            {
                //display loss
                System.out.println("\n\nYou lost. :( Better luck next time.");
                //count loss
                LossCntr++;
                //kick out of loop in main to move on to Summary function
                end = "y";
            }
        } else if (TicTacToe[3] == TicTacToe[4] && TicTacToe[4] == TicTacToe[5])
        {
            if (TicTacToe[3] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[3] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } else if (TicTacToe[6] == TicTacToe[7] && TicTacToe[7] == TicTacToe[8])
        {
            if (TicTacToe[6] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[6] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } else if (TicTacToe[0] == TicTacToe[3] && TicTacToe[3] == TicTacToe[6])
        {
            if (TicTacToe[0] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[0] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } else if (TicTacToe[1] == TicTacToe[4] && TicTacToe[4] == TicTacToe[7])
        {
            if (TicTacToe[1] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[1] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } else if (TicTacToe[2] == TicTacToe[5] && TicTacToe[5] == TicTacToe[8])
        {
            if (TicTacToe[2] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[2] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } else if (TicTacToe[0] == TicTacToe[4] && TicTacToe[4] == TicTacToe[8])
        {
            if (TicTacToe[0] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[0] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } else if (TicTacToe[2] == TicTacToe[4] && TicTacToe[4] == TicTacToe[6])
        {
            if (TicTacToe[2] == "O")
            {
                System.out.println("\n\nYou WON!! Congratulations!");
                WinCntr++;
                end = "y";
            } else if (TicTacToe[2] == "X")
            {
                System.out.println("\n\nYou lost. :( Better luck next time.");
                LossCntr++;
                end = "y";
            }
        } //recognize when all boxes are filled but there is no win: 
          //thus, a draw
        else if (TicTacToe[0] != "-" && TicTacToe[1] != "-"
                && TicTacToe[2] != "-" && TicTacToe[3] != "-"
                && TicTacToe[4] != "-" && TicTacToe[5] != "-"
                && TicTacToe[6] != "-" && TicTacToe[7] != "-"
                && TicTacToe[8] != "-")
        {
            System.out.println("\n\nIt is a draw.");
            DrawCntr++;
            end = "y";
        } //if there is no win, loss or draw, display nothing; game continues to 
        //loop through the if statements in main
        else
        {

        }
    }

    //function to display wins, losses, draws & ask if user wants to play again
    static void Summary()
    {
        //count game
        GameCntr++;

        System.out.println("\nGames played:  " + GameCntr + "\nGames won:  "
                + WinCntr + "\nGames lost:  " + LossCntr
                + "\nGames that were a draw:  " + DrawCntr);

        //ask question
        System.out.print("\nWould you like to play again? Y or N:  ");

        //collect answer
        again = myScan.nextLine().toLowerCase();
        
        //loop to collect incorrect entry and ask again
        while (!(again.equals("y") || again.equals("n")))
            {
                System.out.print("\nThat is not an option.\n\nWould you like to"
                    + " play again? Y or N:  ");
                
                again = myScan.nextLine().toLowerCase();
            }

        //reset variable so while loop will run in main to play game
        end = "n";
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        //variables
        String first = "n";

        //describe game to user
        System.out.print("Tic Tac Toe\n\nPlay Tic Tac Toe against the "
                + "computer.");

        //while loop to play again if user so chooses
        while (again.equals("y"))
        {
            //setup initial array
            Setup();

            //describe game to user        
            System.out.println("\n\nThe computer is X, you are O. Here is the "
                    + "game board:\n");

            //display blank game board
            PrintArray();

            //ask question
            System.out.print("\n\nWould you like to go first? Y or N:  ");

            //collect answer
            first = myScan.nextLine().toLowerCase();

            //while loop to play until there is a win, loss or draw
            while (end.equals("n"))
            {
                //if statement if user chose to go first
                if (first.equals("y"))
                {
                    if (end.equals("n"))
                    {
                        UserTurn();
                        
                        PrintArray();
                        
                        CheckWin();
                        
                    }
                    if (end.equals("n"))
                    {
                        ComputerTurn();
                        
                        PrintArray();

                        CheckWin();
                        
                    }
                } //else statement if user chose to go second
                else if (first.equals("n"))
                {
                    if (end.equals("n"))
                    {
                        ComputerTurn();
                        
                        PrintArray();

                        CheckWin();
                    }
                    if (end.equals("n"))
                    {
                        UserTurn();
                        
                        PrintArray();

                        CheckWin();
                    }
                }
                //else statement if anything other than Y or N are entered
                else
                {
                    System.out.print("\nThat is not an option. Try again."
                        + "\n\nWould you like to go first? Y or N:  ");
                    
                    first = myScan.nextLine().toLowerCase();
                }    
            }

            //display game summary function (# of games, wins, losses, draws)
            Summary();
                            
        }

        //exit message
        System.out.println("\nGoodbye.\n\n");
    }

}
