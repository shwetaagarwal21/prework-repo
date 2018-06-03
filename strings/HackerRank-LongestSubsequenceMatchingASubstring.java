   // Complete the longestSubsequence function below.
    static int longestSubsequence(String x, String y) {
      //find all subsequences of string x
      HashSet<String> set = subsequences(x);
      int max = 0;
      for(String sub: set){
       if(y.contains(sub))
           max = Math.max(max, sub.length());
      }
      return max;
    }

    static HashSet<String> subsequences(String str){
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
          for(int j=str.length();j>i;j--){
              String sub = str.substring(i,j);
              if(!set.contains(sub))
                set.add(sub);
              
              for(int k=1;k<sub.length()-1;k++){
                  StringBuilder sbr = new StringBuilder(sub);
                  sbr.deleteCharAt(k);
                  if(!set.contains(sbr))
                      set.add(sbr.toString());
              }
              
          }
      }
      return set;
    }
    
    
