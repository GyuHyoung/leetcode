class Solution {
    List<List<String>> result;
    public boolean isPalindrome(String s) {
        char[] charArr = s.toCharArray();
        int l = 0;
        int r = charArr.length - 1;

        while(l < r) {
            if(charArr[l] != charArr[r]) return false;
            l++;
            r--;
        }
        return true;
    }

    public void dfs(String s, List<String> subList) {
        if(s.length() == 0) {
            result.add(new ArrayList(subList));
        }
        int n = s.length();
        for(int i = 0; i < n; i++) {
            String subStr = s.substring(0, i+1);
            if(isPalindrome(subStr)) {
                subList.add(subStr);
                dfs(s.substring(i+1, n), subList);
                subList.remove(subList.size() - 1);
            } 
        }
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            String subStr = s.substring(0, i+1);
            if(isPalindrome(subStr)) {
                List<String> subList = new ArrayList<>();
                subList.add(subStr);
                dfs(s.substring(i+1, n), subList);
            } 
        }

        return result;
    }
}