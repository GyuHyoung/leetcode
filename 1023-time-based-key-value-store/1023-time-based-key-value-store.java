class TimeMap {
    Map<String, List<List<String>>> map = new HashMap<>();
    
    public TimeMap() {
        
    }
    
    public void set(String key, String value, int timestamp) {
        List<List<String>> list = map.getOrDefault(key, new ArrayList<>());
        list.add(List.of(String.valueOf(timestamp), value));
        map.put(key, list);    
    }
    
    public String get(String key, int timestamp) {
        List<List<String>> list = map.get(key);
                if(list == null) return "";
        int r = list.size() - 1;
        int l = 0;
        while(l <= r) {
            int m = (l + r) / 2;
            int prevTimeStamp = Integer.valueOf(list.get(m).get(0));
            if(prevTimeStamp > timestamp) {
                r = m - 1;
            } else if(prevTimeStamp == timestamp) {
                return list.get(m).get(1);
            } else {
                l = m + 1;
            }
        }
        if(r == -1) return "";
        return list.get(r).get(1);
    }
}