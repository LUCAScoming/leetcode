package java;

import java.util.*;

class Solution {
    /* 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
    现在给一串数字，返回有多少种可能的译码结果
    * */
    public int solve(String nums) {
        // write code here
        char[] chars = nums.toCharArray();
        return 0;

    }

    public boolean is26() {
        return true;
    }

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> p = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
//        result.add(pRoot.val);
//        p.add(result);
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) queue.offer(node.left);

                if (node.right != null) queue.offer(node.right);
            }
            p.add(result);
        }
        return p;
    }

    /*
     * 331. 验证二叉树的前序序列化
     * */
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() < 2) {
            return false;
        }
        String[] pre = preorder.split(",");
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < pre.length; i++) {
            deque.push(pre[i]);
            while (deque.size() >= 3 &&
                    ((LinkedList<String>) deque).get(0).equals("#") &&
                    ((LinkedList<String>) deque).get(1).equals("#") &&
                    !((LinkedList<String>) deque).get(2).equals("#")) {
                deque.pop();
                deque.pop();
                deque.pop();
                deque.push("#");
            }
        }
        return deque.size() <= 1 && deque.pop().equals("#");

    }

    /*
     * 6. Z 字形变换
     * */
    public String convert(String s, int numRows) {
        if (numRows==1) return s;
        List<StringBuilder> res = new ArrayList<>();

        for (int i =0;i<s.length();i++){
            res.add(new StringBuilder());
        }
        int cur=0;
        int flag =-1;
        for (char c:s.toCharArray()){
            res.get(cur).append(c);
            if (cur==0||cur==numRows-1) flag=-flag;
            cur=cur+flag;
        }
        StringBuilder sb=new StringBuilder();
        for (StringBuilder re :res){
            sb.append(re);
        }
        return sb.toString();

    }
/*
* 14. 最长公共前缀
* 编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。
* */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length<1){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        String s =strs[0];
        for (int i=1;i<strs.length;i++){
            s=longestCommonPrefix(s,strs[i]);
        }
        return s;
    }

    public String longestCommonPrefix(String s1,String s2){
        int i= Math.min(s1.length(),s2.length());
        String s = "";
        for (int a=0;a<i;a++){
            if (s1.charAt(a)==s2.charAt(a)){
                s=s+s1.charAt(a);
            }else {
                break;
            }
        }
        return s;
    }


    public int numberOfMatches(int n) {
        int res = 0;

        while (n > 1) {
            if (n % 2 == 0) {
                res = res + n / 2;
                n = n / 2;
            } else {
                res = res + (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return res;
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

public class MainClass {


    public static void main(String[] args) {

        String s [] ={"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(s));
    }
}