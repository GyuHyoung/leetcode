class Entry {
    char ch;
    int count;

    Entry(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class Solution {
    public String reorganizeString(String s) {
        char[] charArr = s.toCharArray();
        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        Map<Character, Integer> map = new HashMap<>();
        
        for(char ch : charArr) {
            int cnt = map.getOrDefault(ch, 0);
            map.put(ch, cnt+1);
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(new Entry(entry.getKey(), entry.getValue()));
        }

        String result = "";

        boolean b = false;

        while(!pq.isEmpty()) {
            if(b) return "";
            Entry e = pq.poll();
            result += e.ch;
            Entry e2 = null;
            
            if(!pq.isEmpty()) {
                e2 = pq.poll();
                result += e2.ch;
            } else {
                b = true;
            }
            if(e.count > 1) {
                e.count--;
                pq.add(e);
            }
            if(e2 != null && e2.count > 1) {
                e2.count--;
                pq.add(e2);
            }
        }

        return result;
    }
}