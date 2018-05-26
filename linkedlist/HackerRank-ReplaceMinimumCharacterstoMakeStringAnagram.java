/*
*/
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
public class Solution {
    
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner scanner = new Scanner(System.in);
    int testCases = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i <= testCases; i++) {
        String line = scanner.nextLine();
        int res = checkAnagram(line);
        System.out.println(res);
    }  
    scanner.close();
}
    
private static int checkAnagram(String str){
    if(str == null) return -1;
    if(str.length() % 2 == 1) return -1;
    String test = str;
    String a = str.substring(0, str.length()/2);
    
    String b = test.substring(str.length()/2);
    
    HashMap<Character, Integer> map = new HashMap<>();
    char[] chrArray1 = a.toCharArray();
    for(char c : chrArray1){
        if(map.containsKey(c)){
            map.put(c, map.get(c) + 1);
        }else{
            map.put(c, 1);
        }        
    }
    int count = 0;
    char[] chrArray2 = b.toCharArray();
    for(char c : chrArray2){
        if(map.containsKey(c)){
            if(map.get(c) != 0)
                map.put(c, map.get(c) - 1);
            else
                count++;
        }else
            count++;
    }
    return count;
}
    
}
