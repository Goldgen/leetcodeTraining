import java.util.List;

public class Solution_for_merge_k_lists {
    class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }
    private ListNode mergeTowLists(ListNode l1, ListNode l2){
        ListNode result = new ListNode(0) ;
        ListNode list = result ;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                list.next = l1 ;
                l1 = l1.next ;
            }else{
                list.next = l2 ;
                l2 = l2.next ;
            }
            list = list.next ;
        }

        while(l1 != null){
            list.next = l1 ;
            l1 = l1.next ;
            list = list.next ;
        }

        while(l2 != null){
            list.next = l2 ;
            l2 = l2.next ;
            list = list.next ;
        }

        return result.next ;
    }
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end){
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return mergeTowLists(left, right);
        } else {
            return null;
        }
    }

}
