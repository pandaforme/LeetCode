package _138;

import datastructure.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 * int label;
 * RandomListNode next, random;
 * RandomListNode(int x) { this.label = x; }
 * };
 */

class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode tmp = head;
        while (tmp != null) {
            map.put(tmp, new RandomListNode(tmp.label));
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp != null) {
            if (tmp.next != null)
                map.get(tmp).next = map.get(tmp.next);

            if (tmp.random != null)
                map.get(tmp).random = map.get(tmp.random);

            tmp = tmp.next;
        }

        return map.get(head);
    }
}
