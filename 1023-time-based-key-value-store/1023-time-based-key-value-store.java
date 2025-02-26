class TimeMap {
    Map<String, TreeMap<Integer, String>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {    
        TreeMap<Integer, String> valueMap = timeMap.getOrDefault(key, new TreeMap());
        valueMap.put(timestamp, value);
        timeMap.put(key, valueMap);
        
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) return "";
        TreeMap<Integer, String> valueMap = timeMap.get(key);
        Map.Entry<Integer, String> entry = valueMap.floorEntry(timestamp);

        if(entry == null) return "";

        return entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */