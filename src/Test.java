import com.mibcloud.leetcode.common.TreeNode;
import com.mibcloud.leetcode.common.TreeUtil;
import com.mibcloud.leetcode.tree.LC108;
import com.mibcloud.leetcode.tree.LC111;
import com.mibcloud.leetcode.tree.LC872;
import com.mibcloud.leetcode.tree.LC94;

import java.util.Timer;

public class Test {
    public static void main(String[] args){
        LC108 lc = new LC108();
        int[] array = {-10,-3,0,5,9};
        TreeNode result = lc.sortedArrayToBST1(array);
        System.out.println(result);
    }
}
