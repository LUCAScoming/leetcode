package leetcode;

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

    /*题目描述
   一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）*/
    public int JumpFloor(int target) {
        if (target <= 1) return 1;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor2(int target) {
        int a = 1;
        int b = 2;
        int c = 0;
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        for (int i = 3; i <= target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;

    }

    /*
     * 7. 整数反转
     * */
    public int reverse(int x) {
//        String s = Integer.toString(x);
//        int f =1;
//        if (x<0){
//            f=-1;
//        }
//        return Integer.valueOf(new StringBuilder(s).reverse().toString())*f;
/*
需要处理反转之后int溢出的问题
* */
        int res = 0;
        while (x != 0) {
            //每次取末尾数字
            int temp = x % 10;
            //判断是否 大于 最大32位整数
            if (res > 214748364 || res == 214748364 && temp > 7) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res < -214748364 || (res == -214748364 && temp < -8)) {
                return 0;
            }
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }


    /*判断回文*/
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
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


    /*剑指 Offer 63. 股票的最大利润*/
    public int maxProfit(int[] prices) {
        int c = 0;
        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minP = Math.min(minP, prices[i]);
            c = Math.max(c, prices[i] - minP);
        }
        return c;
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


    /*
     * 11. 盛最多水的容器
     * */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right ) {
           int t = (right-left)*Math.min(height[left],height[right]);
           res=Math.max(t,res);
           if (height[left]<height[right]){
               left++;
           }else {
               right--;
           }
        }
        return res;

    }

    /*
    快排
    * */
    public int[] quick(int[] arg) {
        sort(arg, 0, arg.length - 1);
        return arg;
    }

    public void sort(int[] arg, int low, int height) {
        if (low >= height) return;
        int index = partion(arg, low, height);
        sort(arg, low, index - 1);
        sort(arg, index + 1, height);
    }

    private int partion(int[] arg, int low, int height) {
        int key = arg[height];
        int temp = 0;
        int t;
        while (low < height) {
            while (arg[low] < key && low < height) low++;
            while (arg[height] > key && low < height) height--;
            temp = arg[height];
            arg[height] = arg[low];
            arg[low] = temp;
        }
        t = key;
        key = arg[height];
        arg[height] = t;
        return height;

    }
/*
19. 删除链表的倒数第 N 个结点
* */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null){
            return new ListNode();
        }
        ListNode reverListNode =reverseList(head);
        ListNode pre = new ListNode(0);
        pre.next=reverListNode;
        ListNode cur =pre;
        for (int i=0;i<n-1&&cur.next!=null;i++){
            cur = cur.next;
        }
        cur.next=cur.next.next;
//        while (cur.next!=null&&n>0){
//
//            if (cur.next.val==n){
//                cur.next=cur.next.next;
//            }else {
//                cur=cur.next;
//            }
//        }
        return reverseList(pre.next);
    }
/*
* 反转链表
* */
    public ListNode reverseList (ListNode head){
        ListNode pre =null;
        ListNode cur = head;

        while (cur!=null){
            ListNode nextNode = cur.next;
            cur.next =pre;
            pre=cur;
            cur=nextNode;
        }
        return pre;
    }
/*
* 54. 螺旋矩阵
*
* 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
* */
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix[0].length;
        int n=matrix.length;
        List<Integer>res= new ArrayList<>();
        cycle(res,0,0,n-1,m-1,matrix);
        return res;

    }

    private void cycle(List<Integer> res, int x, int y, int x1, int y1, int[][] matrix) {
        if (x1<x||y1<y) return;

        if(x==x1){
            for(int i=y;i<=y1;i++){
                res.add(matrix[x][i]);
            }
            return;
        }

        if(y==y1){
            for(int i =x;i<=x1;i++){
                res.add(matrix[i][y]);
            }
            return;
        }
       for (int i=y;i<y1;i++)res.add(matrix[x][i]);
       for (int i=x;i<x1;i++)res.add(matrix[i][y1]);
       for (int i=y1;i>y;i--)res.add(matrix[x1][i]);
       for (int i=x1;i>x;i--)res.add(matrix[i][y]);
       cycle(res,x+1,y+1,x1-1,y1-1,matrix);
    }
    /*
     * 59. 螺旋矩阵 II
     * */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int total = n * n;
        cycle2(res, 0, 0, n - 1, n - 1, total, 1);
        return res;

    }

    private void cycle2(int[][] res, int x, int y, int x1, int y1, int total, int s) {
        if (x > x1 || y > y1) return;

        if (x1 == x) {
            for (int i = y; i <= y1; i++) {
                res[x][i] = s;
            }
        }
        if (y == y1) {
            for (int i = x; i <= x1; i++) {
                res[i][y] = s;
            }
        }

        for (int i = y; i < y1; i++) {
            res[x][i] = s;
            s++;
        }

        for (int i = x; i < x1; i++) {
            res[i][y1] = s;
            s++;
        }

        for (int i = y1; i > y; i--) {
            res[x1][i] = s;
            s++;
        }

        for (int i = x1; i > x; i--) {
            res[i][y] = s;
            s++;
        }
        cycle2(res, x + 1, y + 1, x1 - 1, y1 - 1, total, s);
    }

    public int numDistinct(String s, String t) {
        int slen = s.length(), tlen = t.length();
        int[] f = new int[tlen + 1];
        f[0] = 1;
        for(int i = 1; i <= slen; i ++ )
            for(int j = tlen; j >= 1; j -- )
                if(s.charAt(i - 1) == t.charAt(j - 1))
                    f[j] += f[j - 1];
        return f[tlen];
    }


    //102.二叉树的层序遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        deque.push(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = deque.size(); i > 0; i--) {
            TreeNode node =deque.pollLast();
            temp.add(node.val);

           if (node.left!=null)   deque.push(node.left);
           if (node.right!=null)  deque.push(node.right);
            }
            list.add(temp);
        }
        return list;
    }
/*
* 198. 打家劫舍
* */
    public int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int [] dp = new int [nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];

    }

    /*
    * 213. 打家劫舍 II
    * */
    public int rob2(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        if (nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int dp1[] = new int[nums.length];
        dp1[0]=nums[0];
        dp1[1]=Math.max(nums[0],nums[1]);
        dp1[2]=Math.max(dp1[1],nums[2]+dp1[0]);
        for (int i=2;i<nums.length-1;i++){
            dp1[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }

        int dp2[] = new int[nums.length];
        dp2[0]=nums[1];
        dp2[1]=Math.max(nums[2],nums[1]);
        dp2[2]=Math.max(dp2[1],nums[3]+dp2[0]);
        for (int i=3;i<nums.length;i++){
            dp2[i]=Math.max(dp1[i-2]+nums[i],dp1[i-1]);
        }
        int max= Math.max(dp1[nums.length-2],dp2[nums.length-1]);
        return max;

    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class ListNodeProcess {
    public ListNode head = new ListNode(-100);

    public ListNode getListNode (int [] nums){
         ListNode t= head;

         for (int a:nums){
             ListNode node = new ListNode(a);
             t.next=node;
             t=t.next;
         }
         return head;
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
/*string 转 二叉树*/
    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }
    public static void main(String[] args) {



        String s [] ={"flower", "flow", "flight"};
//        [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        int num [][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int nums[]={2,3,2};
        System.out.println(new Solution().rob2(nums));
    }
}