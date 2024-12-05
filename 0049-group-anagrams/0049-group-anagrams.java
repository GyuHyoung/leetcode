class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> group = new ArrayList<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = String.valueOf(charArr);
            if(map.get(sortedStr) != null) {
                List<String> strList = map.get(sortedStr);
                strList.add(str);
                map.put(sortedStr, strList);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                map.put(sortedStr, strList);
            }
        }
        
        map.forEach((sortedStr, strList) -> {
            group.add(strList);
        });

        return group;
    }
}