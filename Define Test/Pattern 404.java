//Ques->https://www.hackerrank.com/contests/co-define/challenges/pattern-404


//Code
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
      Scanner scn=new Scanner(System.in);
      int n=scn.nextInt();
      for(int i=0;i<n;i++)
      {
        for(int j=0;j<n;j++)
        {
          if(i==n/2)
                System.out.print("* ");
         else if(i==j&&j!=n/2)
            System.out.print("* ");
            else if(i+j==n-1&&j!=n/2)
              System.out.print("* ");
          else if(j==n/2&&i!=n/2)
            System.out.print("* ");
               else
                  System.out.print("  ");
        }
        System.out.println();
      }
    }
}
