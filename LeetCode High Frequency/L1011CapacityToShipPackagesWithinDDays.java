public class L1011CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int D) {
        //答案无非在数组总和和数组元素之间
        //利用二分查找,在此区间内寻找答案,如果能在D天内干碎,那就返回true,继续二分,直到边界处
        int left = weights[0];
        int right = 0;
        int preAnswer = left;
        for (int i : weights) {
            right = right + i;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            //如果无法完成,说明小了,向右二分
            if (!possible(mid, D, weights)) {
                left = mid + 1;
            } else {
                //如果能完成,我们向左二分,力求最小值,用preAnswer记住之前的值
                preAnswer = mid;
                right = mid - 1;
            }
        }
        return preAnswer;
    }

    public boolean possible(int answer, int D, int[] weights) {
        int count = 1;
        int temp = answer;
        for (int i = 0; i < weights.length; i++) {
            if (temp < weights[i]) {
                //不能装我们下次再运
                if (answer < weights[i]) {
                    return false;
                }
                count++;
                temp = answer;
                i--;
            }
            else {
                //能装就装
                temp = temp - weights[i];
            }
        }
        //如果装运次数小于等于目标,就可以
        return count <= D;
    }
}
