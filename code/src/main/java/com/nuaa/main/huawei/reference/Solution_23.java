package com.nuaa.main.huawei.reference;

import com.nuaa.main.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_23 {
    public ListNode mergeKLists(ListNode[] lists) {

        List<ListNode> list = new ArrayList<>();

        for (ListNode node : lists) {
            list.add(node);
        }
        while (list.size() != 1 && list.size() != 0) {
            // 创建新的list
            List<ListNode> temp = new ArrayList<>();
            for (int i = 0; i < list.size(); i += 2) {
                if (i + 1 == list.size()) {
                    temp.add(list.get(i));
                    continue;
                }
                ListNode node1 = list.get(i);
                ListNode node2 = list.get(i + 1);
                ListNode mergeNode = merge(node1, node2);
                temp.add(mergeNode);
            }
            list.clear();
            list = temp;
        }
        return list.size() == 0 ? null : list.get(0);
    }

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        ListNode ans = new ListNode();
        ListNode head = new ListNode();
        ans.next = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        head.next = list1 == null ? list2 : list1;
        return ans.next.next;
    }
}
