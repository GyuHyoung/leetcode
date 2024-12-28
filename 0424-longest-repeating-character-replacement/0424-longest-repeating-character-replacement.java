class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        char[] charArr = s.toCharArray();

        int p1 = 0;
        int p2 = 0;
        int maxFreq = 0;
        int maxLen = 0;
        while(p2 < charArr.length) {
            freq[charArr[p2] - 'A']++;
            maxFreq = Math.max(maxFreq, freq[charArr[p2] - 'A']);
            while(p2 - p1 + 1 - maxFreq > k) {
                freq[charArr[p1] - 'A']--;
                p1++;

            }
            maxLen = Math.max(maxLen, p2 - p1 + 1);
            p2++;
            
        }

        return maxLen;
    }
}