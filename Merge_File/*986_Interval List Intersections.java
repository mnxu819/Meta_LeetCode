You are given two lists of closed intervals, firstList and secondList, where firstList[i] = [starti, endi] and secondList[j] = [startj, endj]. Each list of intervals is pairwise disjoint and in sorted order.
  
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int l1 = firstList.length;
        int l2 = secondList.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < l1 && j < l2) {
            //比较每一个interval查找有没有重叠区
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);
            if (start <= end) {
                res.add(new int[]{start, end});
            }
            //比较目前两个interval的end point小的那个就没用了，大的保留
            if (firstList[i][1] < secondList[j][1]) {
                i++;
            } else 
                j++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
