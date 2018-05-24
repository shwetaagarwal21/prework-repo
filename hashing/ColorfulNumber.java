/*
For Given Number N find if its COLORFUL number or not
Return 0/1
COLORFUL number:
A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:
N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 
Output : 1
*/
public class ColorfulNumber {
    public int colorful(int A) {
        if(A < 10) return 1;
        String num = String.valueOf(A);
        int length = num.length();
        List<Integer> prods = new ArrayList<Integer>();
        String sub;
        int product;
        for(int i = 0; i<length; i++){
            for(int j = 1; j+i <= length; j++){
                sub = num.substring(i, j+i);
                product = getProductOfDigits(Integer.parseInt(sub));
                if(prods.contains(product)) return 0;
                else
                    prods.add(product);
            }
        }
        return 1;
    }
    
    int getProductOfDigits(int number){
        if(number < 10) return number;
        int prod = 1;
        int div = number;
        int mod;
        while(div > 0){
            mod = div % 10;
            div = div/10;
            prod = prod * mod;
        }
        return prod;
    }
}
