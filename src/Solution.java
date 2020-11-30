import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode answer = new ListNode();
        ListNode current = answer;

        while(!(l1 == null && l2 == null)){
            if(l1 == null && l2 != null){
                current.val = l2.val;
                current.next = l2.next;
                l2 = null;
            }
            if(l2 == null && l1 != null){
                current.val = l1.val;
                current.next = l1.next;
                l1 = null;
            }

            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    current.val = l1.val;
                    l1 = l1.next;
                } else {
                    current.val = l2.val;
                    l2 = l2.next;
                }
                current.next = new ListNode();
                current = current.next;
            }
        }

        return answer;
    }

    public ListNode deleteNode(int node, ListNode startNode) {
        ListNode current = startNode;
        while(current.val != node){
            current = current.next;
        }
        
        return startNode;
    }

    public int majorityElement(int[] nums){
        Arrays.sort(nums);
        printArr(nums);
        int counter = 0;
        int current = nums[0];
        System.out.println("current: " + current);

        for(int i=0; i<nums.length; i++){
            if(nums[i]==current){
                counter++;
                System.out.println("current: " + current + " counter: " + counter);
                if(counter > nums.length/2) return nums[i];
            } else {
                current = nums[i];
                counter = 1;
                System.out.println("current: " + current);
            }
        }

        return 0;
    }

    public void moveZeroes(int[] nums) {
        int counter = 0;
        int aux = 0;
        while(counter < nums.length){
            if(nums[counter] != 0){
                //DO NOTHING
                counter++;
            } else if(counter == nums.length-1){
                //DO NOTHING
            } else {
                aux = counter + 1;
                while(aux < nums.length - 1 && nums[aux] == 0){
                    aux++;
                }
                nums[counter] = nums[aux];
                nums[aux] = 0;
                counter++;
            }
        }
    }

    public void printArr(int[] nums){
        System.out.print("[");
        for(int i=0; i<nums.length-1; i++){
            System.out.print(nums[i] + ",");
        }
        System.out.println(nums[nums.length-1] + "]");
    }

    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }

        if(head.next == null){
            return new ListNode(head.val, null);
        }

        ListNode next = new ListNode(head.next.val, head.next.next);
        ListNode rest = reverseList(next);

        ListNode current = rest;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ListNode(head.val, null);
        return rest;
    }

    public static void printList(ListNode l1){
        boolean print = true;
        ListNode current = l1;
        System.out.print("[");
        while(print){
            if(current.next != null){
                System.out.print(current.val + ",");
                current = current.next;
            } else {
                System.out.print(current.val);
                print = false;
            }
        }
        System.out.print("]");
        System.out.println("");
    }

    public int singleNumber(int[] nums) {
        List<Integer> arr = new ArrayList<Integer>();

        for(int i=0; i<nums.length; i++){
            if(!arr.contains(nums[i])){
                arr.add(nums[i]);
            } else {
                Iterator<Integer> itr = arr.iterator();
                while(itr.hasNext()){
                    Integer j = itr.next();
                    if(j==nums[i]){
                        itr.remove();
                    }
                }
            }
        }

        return arr.get(0);
    }

    public int singleNumberOLD3(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(nums[i] >= -30000){
                for(int j=1; j<=nums.length; j++){
                    if(nums[(j+i)%nums.length]>= -30000){
                        if(nums[i] == nums[(j+i)%nums.length] && (j%nums.length) == 0){
                            return nums[i];
                        }
                        if(nums[i] == nums[(j+i)%nums.length] && (j%nums.length) > 0){
                            nums[i] = -30001;
                            nums[(j+i)%nums.length] = -30001;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int singleNumberOLD(int[] nums) {
        for(int i=0; i<nums.length; i++){
            boolean notDone = true;
            int j = 1;
            while(notDone){
                if(nums[i] == nums[(i+j)%nums.length]){
                    notDone = false;
                } else {
                    j++;
                }
            }
            if(j%nums.length == 0){
                return nums[i];
            }
        }
        return -1;
    }

    public int singleNumberOLD2(int[] nums) {
        int j = 0;
        for(int i=0; i<nums.length; i++){
            j=1;
            while(nums[i] != nums[(i+j)%nums.length]){
                j++;
            }
            if(j%nums.length == 0){
                return nums[i];
            }
        }
        return j;
    }
}
