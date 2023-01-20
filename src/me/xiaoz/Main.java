package me.xiaoz;

import me.xiaoz.tree.*;

import java.util.*;

public class Main {
    static volatile int a = 1;

    public static void main(String[] args) throws InterruptedException {
//        KthLargest find = new KthLargest();
//        BuildTreeInPost buildTree = new BuildTreeInPost();
//        TreeNode root = buildTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});

//        List<Integer> list = Arrays.asList(1, 2, 5, 3, 4, null, 6);
//        TreeNode root = BuildTree.build(list);
//
//        Seralise seralise = new Seralise();
//        String serialized = seralise.serialize(root);
//        TreeNode node = seralise.deserialize(serialized);
//        System.out.println(root);


//        Tree2List solution = new Tree2List();
//        solution.flatten(root);

//        MaxPathSum sum = new MaxPathSum();
//        System.out.println(sum.maxPathSum(root));

//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (a != 2) {
//
//                }
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a = 2;
//            }
//        });
//        t1.start();
//        Thread.sleep(10);
//        t2.start();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(5);
        queue.offer(2);
        queue.offer(3);

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            System.out.println(poll);
        }
    }


}
