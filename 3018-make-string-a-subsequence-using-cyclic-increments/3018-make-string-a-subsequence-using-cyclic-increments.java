class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i = 0; 
        int j = 0;
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();     

        while(j < charArr2.length) {
            if(i == charArr1.length) return false;
            char c1 = charArr1[i];
            char c2 = charArr2[j];            
            if(c1 == c2 || c1 + 1 == c2 || c1 == 'z' && c2 == 'a') {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return true;
    }
}