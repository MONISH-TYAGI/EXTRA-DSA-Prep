//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function template for JAVA

class Solution

{

    //Function to find the minimum indexed character.

    public static int minIndexChar(String str, String patt)

    {

        // Your code here

        HashMap<Character,Integer> hs =new HashMap<>();

        for(int i =0;i<str.length();i++){

            char ch = str.charAt(i);

           hs.put(ch,hs.getOrDefault(ch,0)+1);

        }

        int index =Integer.MAX_VALUE ;

        for(int i =0;i<patt.length();i++){

            if(hs.containsKey(patt.charAt(i))){

                index = Math.min(index,str.indexOf(patt.charAt(i)));

            }

        }

       if(index == Integer.MAX_VALUE){

           return -1;

       }else{

           return index;

       }

    }

}

//{ Driver Code Starts.

class GFG {
	public static void main (String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t>0)
		{
		    t--;
		    
		    String s1=sc.next();
		    String s2=sc.next();
		    
		    int res = new Solution().minIndexChar(s1, s2);
		    System.out.println(res);
		}
	}
}

// } Driver Code Ends