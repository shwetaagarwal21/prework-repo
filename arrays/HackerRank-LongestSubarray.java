    // Complete the maxLength function below.
    static int maxLength(int[] a, int k) {
      
      int max = 0;
      for(int start=0;start<a.length;start++){
          int sum = 0;
          int count = 0;
          for(int end=start;end<a.length;end++){
              sum += a[end];
              if(sum <= k){
                  count++;
                  max = Math.max(max, count);
              }
          }
      }
      return max;
    }
