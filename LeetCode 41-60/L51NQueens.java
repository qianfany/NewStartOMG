import java.util.ArrayList;
import java.util.List;

public class L51NQueens {
    /*
    Level by Level
                                root = 0 queen
                          /        |       |       |       |       |       |
level 1             Q0 (0, 0)   (0, 1)   (0, 2)                            (0,7)
                  /||||||||\
level 2         (1,0) .....(1,7)
Time = O(8 ^ 8 * 8)  -> O(n^n * n)          -> O(n!)

        check valid:
        base case: The last row is done, 0 row left
        recursive rule: iff position(i,j) valid -> go to the next row (i + i)
     */
    public List<List<String>> solve (int n) {
        List<List<String>> list=new ArrayList<List<String>>();
        dfs(new int[n],0,n,list);
        return list;
    }
    public void dfs(int[] pos,int step,int n,List<List<String>> list) {
        if(step==n) {
            ArrayList<String> ls= print(pos,n);
            list.add(new ArrayList<String>(ls));
            return;
        }
        for(int i=0;i<n;i++) {
            pos[step]=i;
            if(isValid(pos,step)) {
                dfs(pos,step+1,n,list);
            }
        }
    }
    public boolean isValid(int[] pos, int step) {
        for(int i = 0; i < step; i++) {
            if(pos[i] == pos[step] || (Math.abs(pos[i] - pos[step])) ==(step - i)) {
                return false;
            }
        }
        return true;
    }
    public ArrayList<String> print(int[] pos, int n) {
        ArrayList<String> ls = new ArrayList<String>();
        for(int i=0;i<n;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<n-1;j++) sb.append('.');
            sb.insert(pos[i],'Q');
            ls.add(sb.toString());
        }
        return ls;
    }
}
