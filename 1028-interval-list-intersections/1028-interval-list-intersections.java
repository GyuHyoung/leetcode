class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int p1 = 0;
        int p2 = 0;
        List<int[]> result = new ArrayList<>();

        while(p1 < firstList.length && p2 < secondList.length) {
            int start = Math.max(firstList[p1][0], secondList[p2][0]);
            int end = Math.min(firstList[p1][1], secondList[p2][1]);
            if(start <= end) {
                result.add(new int[]{start, end});
            }

            if(firstList[p1][1] < secondList[p2][1]) p1++;
            else p2++;
            
        }

        int[][] ret = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            ret[i][0] = result.get(i)[0];
            ret[i][1] = result.get(i)[1];
        }

        return ret;
    }
}