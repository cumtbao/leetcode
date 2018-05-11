package com.shang;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;

/**
 * Created by shang on 2018/5/11.
 * 有两个单链表，代表两个非负数，每一个节点代表一个数位，数字是反向存储的，
 * 即第一个结点表示最低位，最后一个结点表示最高位。求两个数的相加和，并且以链表形式返回。
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 　　Output: 7 -> 0 -> 8

 解题思路：
 对两个链表从第一个数开始处理，进行相加，结果除以10求商，作为下一位相加的进位，
 同时记录余数，作为本位的结果，一直处理，直到所有节点都处理完
 */
public class AddTwoNum {

    public static void main(String[] args) {

        LinkedList<ListNode> listNodes1 = new LinkedList<>();
        LinkedList<ListNode> listNodes2 = new LinkedList<>();

        listNodes1.add(new ListNode(2));
        listNodes1.add(new ListNode(4));
        listNodes1.add(new ListNode(3));


        listNodes2.add(new ListNode(5));
        listNodes2.add(new ListNode(6));
        listNodes2.add(new ListNode(4));

        ListNode listNode = addTwoNum(listNodes1.getFirst(), listNodes2.getFirst());
        System.out.println(JSON.toJSONString(listNode));
    }

    public static ListNode addTwoNum(ListNode l1,ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode root = new ListNode(0);//头结点
        ListNode r = root;
        root.next = l1;
        int sum;
        int carry = 0;//进位

        while (p1 != null && p2 != null) {

            sum = p1.val + p2.val + carry;
            p1.val = sum % 10;//本位的结果
            carry = sum / 10;

            r.next = p1;
            r = p1;
            p1 = p1.next;
            p2 = p2.next;

            // 最后一次相加还有进位
            if (carry == 1) {
                // 开始时r.next是第一个要相加的结点
                while (r.next != null) {
                    sum = r.next.val + carry;
                    r.next.val = sum % 10;
                    carry = sum / 10;
                    r = r.next;
                }

                // 都加完了还有进位，就要创建一个新的结点
                if (carry == 1) {
                    r.next = new ListNode(1);
                }
            }

        }
        return root.next;
    }}



      class ListNode {

        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

    }


