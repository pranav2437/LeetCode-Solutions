//1019 : https://leetcode.com/problems/next-greater-node-in-linked-list/submissions/
/* Problem: We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.

Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val, and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.

Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
*/
//Solution:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Time complexity : O(n), Space Complexity : O(n)
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        int n = 0;
        ListNode temp = head;
        ArrayList<Integer> arr = new ArrayList<>();
        while(temp!=null){
            n++;                                 //count elements in linked list
            arr.add(temp.val);                   // add them to an array list
            temp = temp.next;
        }
        int[] res = new int[n];
        if(head==null){
            return res;
        }
        if(n==1){
            return new int[]{0};
        }
        Stack<Integer> st = new Stack<>();       //finding next greater element in arraylist using stack approach
        st.push(n-1);                            //pushing indexes to avoid problems when duplicate values
        for (int i = n-2; i >=0; i--){          //run a backwards loop
            while(st.size()>0 && arr.get(i)>=arr.get(st.peek())){
                st.pop();                       //pop from stack while size>0 and current element is greater than stack top
            }
            res[i] = st.size()==0?0:arr.get(st.peek());    // stack size=0 means no greater element
            st.push(i);
        }        
        return res;
    }
}