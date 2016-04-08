/* This program will intialize an array, then perform Gauss-Jordan elimination on the matrix until
   the martrix is reduced. */
/* Things that need to happen. */
/* 1. We need to get an array.  Define it by its dimensions m x n */
/* 2. Need to conduct the pivot for each row (defined by z). Converting the element on that row that matches the column so 0 0, 1 1, 2 2, to a 1.
 * 3. To do so we divide all of row elements by element z z, without clearing z z down to one by dividing it by itself first, do this in a for loop z*/
/* 3. Once all that is completed subtract row z from all subsequent rows factored up to the element for each row matching the current z row (row x element z). 
 * Referred to as row operations*/ 
/* 4. Continue until all elements are completed.  Pivoting the each element z z to 1 by dividing the whole row by element z z, with it last. Then subtracting all other rows. 
 */ 
import java.util.Scanner; 
public class mcalc
{
  public static void main(String[] args) 
  {
    Scanner skin = new Scanner(System.in);
    /*Briefly describe the program to the user. Then prompt user for number of rows.  The exact same program can perform matrix 
     inverses by adding the the matrix identity to the end*/
    System.out.println("Matrices are arrays of number's that can be used to solve linear systems.");
    System.out.println("They are always defined first in rows, then columns! Their size is defined");
    System.out.println("by m x n. We will start by defining the matrix to the computer,");
    System.out.println("then perform pivots and row operations.  This will be transparent to you.");
    System.out.println("When it is completed you will see the final output as the reduced matrix.");
    System.out.println("How many rows are in your array?");
    int m = skin.nextInt();                                                              //retrieve number of rows in our array
    System.out.println("How many columns are in your array?");
    int n = skin.nextInt();                                                              //retrieve number of columns in the array
    float matrixone [] [] = new float [m][n];                                            //initialize the array to the matrix dimensions
    //initialize the matrix
    for (int x=0 ; x<m ; ++x)
    {                                                       //create a loop to identify row elements of matrix/array.
      for (int y=0 ; y<n ;++y)
      {                                                     //create a loop to identify columnar elements of the matrix/array.
           System.out.println ("Please enter the element of the array in row " + (x+1) + " in column " + (y+1) + ":"); //1 is added since most users will not function with 0 as first.
           matrixone[x][y] = skin.nextFloat();              //get each element in the array
      }
    }
   
    for (int z=0 ; z<m ; ++z) //this for loop is needed to repeat the reduction until the last row is resolved. 
    { 
       //Pivot Operations
       for (int x=1+z ; x<n ; ++x) //this for loop performs the individual reduction from the columnar perspective which increases each time that we loop through z
       {
          matrixone[z][x] = (matrixone[z][x]/matrixone[z][z]);  //divide row z element x by the first element of row z to reduce the element at row z z (row matches column) to 1
       } 
       /*since each element must be divided by element z z the reduction to 1 cannot occur until all other elements are reduced so the last step of a pivot is to divide z z
       by itself*/
       matrixone[z][z]=(matrixone[z][z]/matrixone[z][z]);  
       
       //Row Operations
       //a row operation is then carried out on all other rows by subtracting the newly reduced row by a factor equal to the number that appears above or below the current [z][z] element 
       for (int x = 0 ; x<m ; ++x) //this for loop performs the row operations from the row perspective it starts at the element above the current z
       {
         for (int y=1+z ; y<n ;++y) //this for loop performs the row operations from the column perspective it starts at the element above the current z
         {
             /*subtract the elements in row x starting at element z+1 by the same column from row z times the column z row x element, leaving the column z row x element 
              * until after the loop is complete.  If you were to subtract the column z row x element first it would result in zero, and each subsequent subtraction 
              * would be based on that factor of zero.  So the column z row operation happens last.*/
              //do not perform this operation on row z itself or row z becomes all zeros and subsequent subtractions past row z would also not be reduced.
             if (x!=z){matrixone[x][y] = (matrixone[x][y]-(matrixone[x][z]*matrixone[z][y]));}
         }
         if (x!=z){matrixone[x][z]=matrixone[x][z]-(matrixone[z][z]*matrixone[x][z]);} //subtract the column x row z element to bring it to zero
       }
    }
    //the next block displays the final matrix
    for (int x=0 ; x<m ; ++x) //this cycles through the rows for display purposes
    {                                                    
      for (int y=0 ; y<n ;++y) //this for-loop cycles through the columns
      {  
        System.out.print(matrixone[x][y] + " "); //display each element followed by a space
      }
      System.out.println(); //put a new line character at the end of each row in the display
    }
    System.out.println("Thank you for using the Belrose-Gauss-Jordan Elmininator (c) 2013");
  }
}