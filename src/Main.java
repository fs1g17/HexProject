import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        /*
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(3,a);
        ListNode c = new ListNode(1,b);

        ListNode x = new ListNode(4);
        ListNode y = new ListNode(2,x);
        ListNode z = new ListNode(1,y);

        ListNode d = new ListNode(1);
        ListNode e = new ListNode(2);

        Solution solution = new Solution();
        printList(solution.mergeTwoLists(d,e));
         */

        /*
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(1,a);
        ListNode c = new ListNode(5,b);
        ListNode d = new ListNode(4,c);

        Solution solution = new Solution();
        printList(solution.deleteNode(1,d));
         */

        /*
        Solution solution = new Solution();
        int[] arr = {1,1,5,2,2,4,6,4,6};
        System.out.println(solution.singleNumber(arr));
        */

        /*
        ListNode a = new ListNode(9);
        ListNode b = new ListNode(1,a);
        ListNode c = new ListNode(5,b);
        ListNode d = new ListNode(4,c);
        printList(d);

        Solution solution = new Solution();
        printList(solution.reverseList(d));
         */

        //Solution solution = new Solution();
        //System.out.println(solution.majorityElement(new int[] {3,2,3}));

        /*
        float f = (float) 1.000;
        float ff = f*1000;
        int i = (int) ff;

        BigInteger bigInt = BigInteger.valueOf(i);
        byte[] arr = bigInt.toByteArray();

        for(byte b : arr){
            int positive = b & 0xff;
            System.out.println(positive);
        }

        System.out.println("success");
         */

        byte[] opcode = convertIntToByteArray(81);
        System.out.println(byteToHex(opcode[0]));

        convertIntToHex(1000);


        char[] test = {0x03e8};
        System.out.println(test[0]);


    }

    public static String toHex(String arg) {
        return String.format("%040x", new BigInteger(1, arg.getBytes(/*YOUR_CHARSET?*/)));
    }

    public static String convertIntToHex(int i){
        byte[] b = convertIntToByteArray(i);
        String s = "0x";
        for(byte a : b){
            s += new String(byteToHex(a));
        }
        return s;
    }

    public static char[] byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return hexDigits;
    }

    public static byte[] convertIntToByteArray(int i){
        BigInteger bigInt = BigInteger.valueOf(i);
        return bigInt.toByteArray();
    }

    public static byte[] convertFloatToByteArray(float f){
        float ff = f*1000;
        int i = (int) ff;

        return convertIntToByteArray(i);
    }

    public static void printArr(int[] arr){
        System.out.print("[");
        for(int i=0; i<arr.length; i++){
            if(i==arr.length-1){
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ",");
            }
        }
        System.out.print("]");
        System.out.println("");
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
}
