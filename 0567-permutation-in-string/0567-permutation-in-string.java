class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] subStr = s1.toCharArray();
        char[] str = s2.toCharArray();
        int p1 = 0;
        int p2 = subStr.length - 1;
        int[] count = new int[26];
        if(subStr.length > str.length) return false;
        if(s2.equals(s1)) return true;

        while(p2 < str.length) {
            for(int i = p1; i < p2+1; i++) {
                char ch = str[i];
                count[ch - 'a']++;
            }
            for(char subCh : subStr) {
                count[subCh - 'a']--;
            }
            boolean isPermutation = true;
            for(int i = 0; i < 26; i++){
                if(count[i] != 0) {
                    isPermutation = false;
                    p1++;
                    p2++;
                    count = new int[26];
                    break;
                }
            }
            if(isPermutation) return true;
        }

        return false;
        
    }
}