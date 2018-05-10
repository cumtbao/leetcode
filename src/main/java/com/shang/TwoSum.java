package com.shang;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;

/**
 * Created by shangbaobao on 2018/5/10.
 *
 * 给定一个整数数组，找出其中两个数满足相加等于你指定的目标数字
 * 思路：
 *  创建一个辅助类数组，对辅助类进行排序，使用两个指针，开始时分别指向辅助类数组的两端，看这两个下标对应的值是否等于目标值，依次类推
 *
 *  1、是否需要获取到两个值在原来数组里的下标
 *  2、
 *
 */
public class TwoSum {

    public static void main(String[] args) {

       int[] intList = {2,4,1,3};
        int[] ints = twoSum(intList, 7);
        System.out.println(JSONObject.toJSONString(ints));
    }

    /**
     * 辅助类
     */
    private static class Node implements Comparable<Node>{

        int val;//值
        int idx;//下标

        public Node(){

        }

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {

            if(o==null){
                return -1;
            }

            return this.val-o.val;
        }
    }

    /**
     *
     * @param nums 输入数组
     * @param target 两个数相加的和
     * @return 两个数对应的下标
     */
    public static int[] twoSum(int[] nums,int target){
        //用于保存返回结果
        int[] result = {-1,-1};
        //创建辅助数组
        Node[] tmp = new Node[nums.length];

        for (int i = 0; i <nums.length ; i++) {
            tmp[i]= new Node(nums[i], i);
        }
        //对辅助数组排序
        Arrays.sort(tmp);
        //记录辅助数组中左边和右边值的下标
        int lo = 0;
        int hi = nums.length -1;

        while (lo < hi){
            Node low = tmp[lo];
            Node high = tmp[hi];
            if(low.val + high.val == target){
                if(low.idx > high.idx){
                    result[0] = high.idx;
                    result[1] = low.idx;
                }else{
                    result[0] = low.idx;
                    result[1] = high.idx;
                }
                break;
            }

            if(low.val + high.val > target){
                hi --;
            }

            if(low.val + high.val < target){
                lo ++;
            }
        }

        return result;
    }

}
