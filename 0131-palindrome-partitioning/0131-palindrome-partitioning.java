//  a  b. a. b. a
// p1.          p2
// a b a b a
// ababa
// a bab a 

//  b.  a.  a.  b.  a.  b
//.             i.       

class Solution {
    List<List<String>> result = new ArrayList<>();

    public boolean isPalindrome(String subStr) {
        char[] charArr = subStr.toCharArray();

        int l = 0;
        int r = charArr.length - 1;
        while(l < r) {
            if(charArr[l] != charArr[r]) return false;
            l++;
            r--;
        }

        return true;
    }

    public void dfs(int idx, String s, List<String> list) {
        if(s.length() == 0) {
            result.add(new ArrayList(list));
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            String subStr = s.substring(0, i+1);
            if(isPalindrome(subStr)) {
                list.add(subStr);
                dfs(0, s.substring(i+1, s.length()), list);
                list.remove(list.size() - 1);
            } 
        }
    }

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());

        return result;
    }
}