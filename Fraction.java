public class Fraction {
    public String fractionToDecimal(int A, int B) {
        if(A == 0)
            return "0";
        if(B == 0)
            return "";
        String result = "";
        if ((A < 0) ^ (B < 0)) {
		    result += "-";
	    }
        
        long num = A, den = B;
        num = Math.abs(num);
        den = Math.abs(den);
        
        long res = num / den;
        result += String.valueOf(res);
        
        long remainder = (num % den) * 10;
        if(remainder == 0)
            return result;
        
        HashMap<Long, Integer> map = new HashMap<>();
        result += ".";
        while(remainder != 0){
            if(map.containsKey(remainder)){
                int beg = map.get(remainder);
                String part1 = result.substring(0, beg);
                String part2 = result.substring(beg, result.length());
                result = part1 + "(" + part2 + ")";
                return result;
            }
            map.put(remainder, result.length());
            res = remainder / den;
            result += String.valueOf(res);
		    remainder = (remainder % den) * 10;
        }
        return result;
    }
}
