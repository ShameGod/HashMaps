import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        for (int t = 1; t <= cases; t++) {
            int length = in.nextInt();
            String p = in.next();
            HashMap<Character, String> composedColors = new HashMap<>();
            HashMap<Character, Integer> colorIndex = new HashMap<>();
            int strokCount = 0;

            composedColors.put('O',"RY");
            composedColors.put('P',"RB");
            composedColors.put('G',"YB");
            composedColors.put('A',"RYB");
            for (int i=0; i<p.length() ; i++ ) {
                if (!composedColors.containsKey(p.charAt(i))) {
                    if(colorIndex.containsKey(p.charAt(i)) 
                    && i - colorIndex.get(p.charAt(i)) ==1){
                        //Nothing
                    }else{
                        strokCount = strokCount +1;
                    }
                    colorIndex.put(p.charAt(i), i);
                } else{
                    String str = composedColors.get(p.charAt(i));
                    for (int j =0 ;j< str.length() ; j++ ) {
                        if(colorIndex.containsKey(str.charAt(j)) 
                            && i - colorIndex.get(str.charAt(j)) ==1){
                            //Nothing
                        }else{
                            strokCount = strokCount +1;
                        }
                        colorIndex.put(str.charAt(j), i); 
                        }
                }
            }
            System.out.printf("Case #%d: %d\n", t, strokCount);
        }
        in.close();
        
    }

}
