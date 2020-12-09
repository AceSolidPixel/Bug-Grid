/*Prince Angulo & Denise Paredes
/ CECS 277
/ This program is a game that involes the player moving from the top left of a grid to the bottom right using the WASD keys
*/
import java.util.Scanner;
public class Angulo1Paredes2L2
{
   public static void main(String[] args) throws ArrayIndexOutOfBoundsException
   {
      String bug = "O"; //declare variable for locating the Ladybug on the grid
      String grid [][] = { {"." , ".", ".", ".", ".", ".", ".", ".", ".", "."}, //Create the grid
                         {".", ".", ".", "X", ".", ".", "X", ".", ".", "."},
                         {".", ".", ".", ".", ".", ".", ".", ".", "X", "."},
                         {".", "X", ".", ".", ".", ".", ".", ".", ".", "."},
                         {".", ".", ".", ".", "X", ".", ".", ".", ".", "."},
                         {".", ".", ".", ".", ".", ".", ".", "X", ".", "."},
                         {".", ".", "X", ".", ".", ".", ".", ".", ".", "."},
                         {".", ".", ".", ".", ".", "X", ".", ".", "X", "."},
                         {".", "X", ".", ".", ".", ".", ".", ".", ".", "."},
                         {".", ".", ".", ".", ".", ".", ".", ".", ".", "f"},
                         };
      int row = 0; //To keep record of where the ladybug is
      int column = 0;
      grid[column][row] = bug; //Setting the bug's initial position
      while(true) //Will loop infintely until both row and column are equal to 9, which is the finishing position
      {
         drawGrid(grid, row, column); //calling the method to draw the grid
         System.out.println("Which Direction: ");
         System.out.println("W. Up");
         System.out.println("A. Left");
         System.out.println("S. Down");
         System.out.println("D. Right");
         Scanner in = new Scanner (System.in);
         String direction = in.nextLine();
         switch(direction)
            {
               case "W":
               case "w":
                  if(row-1 < 0) //Check to see if this input would put the ladybug out of bounds
                  {
                     System.out.println("Cannot move outside of grid!");
                     break;
                  }                              
                  else if((grid[row-1][column]).equals("X"))
                  {
                     System.out.println("There is a barrier in the way!");
                     break;
                  }
                  grid[row][column] = "x";
                  row--; //the lower the value of "row", the higher on the grid the position is.
                  break;
                  
               case "A":
               case "a":
                  if(column-1 < 0) //Check to see if this input would put the ladybug out of bounds
                  {
                     System.out.println("Cannot move outside of grid!");
                     break;
                  }
                  else if((grid[row][column-1]).equals("X"))
                  {
                     System.out.println("There is a barrier in the way!");
                     break;
                  }
                  grid[row][column] = "x";                     
                  column--;
                  break;
               
               case "S":
               case "s":
                  if(row + 1 > 9) //Check to see if this input would put the ladybug out of bounds
                  {
                     System.out.println("Cannot move outside of grid!");
                     break;
                  }
                  else if((grid[row+1][column]).equals("X"))
                  {
                     System.out.println("There is a barrier in the way!");
                     break;
                  }
                  grid[row][column] = "x";
                  row++;                    
                  break;
                  
               case "D":
               case "d":
                  if(column + 1 > 9) //Check to see if this input would put the ladybug out of bounds
                  {
                     System.out.println("Cannot move outside of grid!");
                     break;
                  }
                  else if((grid[row][column+1]).equals("X"))
                  {
                     System.out.println("There is a barrier in the way!");
                     break;
                  }
                  grid[row][column] = "x";
                  column++;
                  break;
                  
               default:
                  System.out.println("That is not a valid input!"); //This is here just in case the user inputs anything else
                  break;
            } 
         if(row == 9 && column == 9) //Check to see if the player has reached the goal.
         {
            drawGrid(grid, row, column);
            System.out.println("You Win!");
            break;
         }
      }
   }
   
   public static void drawGrid(String map[][], int x, int y) //Draws any 2d array that has been passed to it
   {
      map[x][y] = "O";
      for (int i = 0; i < map.length; i++)
      {
         for (int j = 0; j < map[0].length; j++)
         {
            System.out.print(map[i][j] );
         }
         System.out.println();
      }
   }
   
}