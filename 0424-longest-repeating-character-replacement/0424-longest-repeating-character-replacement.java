// a.  a.  b.  a.  b.  b.  a
// p1                  p2 
class Solution {
    public int characterReplacement(String s, int k) {
        if(s.length() == 1) return 1;
        int p1 = 0;
        int p2 = 1;
        
        char[] charArr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put(charArr[p1], 1);
        int maxCnt = 1;
        int maxLen = 0;

        while(p2 < s.length()) {
            char ch = charArr[p2];  
            int cnt = map.getOrDefault(ch, 0) + 1; 
                        map.put(ch, cnt);  
            maxCnt = Math.max(maxCnt, cnt);

            while ((p2 - p1 + 1) - maxCnt > k) {
                map.put(charArr[p1], map.get(charArr[p1]) - 1);
                p1++;
            }
            
            maxLen = Math.max(maxLen, p2 - p1 + 1);
            p2++;
        }

        return maxLen;
    }
}