import com.mibcloud.leetcode.common.TreeNode;
import com.mibcloud.leetcode.common.TreeUtil;
import com.mibcloud.leetcode.tree.*;

import java.util.Timer;

public class Test {
    public static void main(String[] args){
        LC501 lc = new LC501();
        TreeNode root = TreeUtil.create("[1,null,2]");
        int[] result = lc.findMode(root);
        System.out.println(result);
    }
}
