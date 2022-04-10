package src;

public class compare {
   
public static double similarity(String s1, String s2) {
    String l;
    String s;
    if (s1.length() < s2.length()) {
      l = s2; 
      s = s1;
    }
    else {
        l = s1;
        s = s2;
    }
    int longLen = l.length();
    if (longLen == 0) { return 1.0;}
    return (longLen - Distance(l, s)) / (double) longLen;
  }
  // you can use StringUtils.getLevenshteinDistance() as the editDistance() function

        public static int Distance(String s1, String s2) {
            s1 = s1.toLowerCase();
            s2 = s2.toLowerCase();
        
            int[] costs = new int[s2.length() + 1];
            for (int i = 0; i <= s1.length(); i++) {
              int lastValue = i;
              for (int j = 0; j <= s2.length(); j++) {
                if (i == 0)
                  costs[j] = j;
                else {
                  if (j > 0) {
                    int newValue = costs[j - 1];
                    if (s1.charAt(i - 1) != s2.charAt(j - 1))
                      newValue = Math.min(Math.min(newValue, lastValue),
                          costs[j]) + 1;
                    costs[j - 1] = lastValue;
                    lastValue = newValue;
                  }
                }
              }
              if (i > 0)
                costs[s2.length()] = lastValue;
            }
            return costs[s2.length()];
          }
    }

