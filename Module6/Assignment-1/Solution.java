import java.util.Scanner;
class LinkedList {
	public Node head;
	public Node tail;
    public int size;
	
    private class Node {
        private String value;
        private Node next;
    }

    LinkedList() {
        head = null;
        tail = null;
    }
	
	public void push(final String value){
    	if (tail == null) {
           Node oldTail = tail;
           tail = new Node();
           tail.value = value;
           tail.next = null;
           head = tail;
        }
        else {
           Node oldTail = tail;
    	   tail = new Node();
    	   tail.value = value;
    	   tail.next = null;
           oldTail.next = tail;
        }
        size++;
    }

    public String pop(){
    	// //if (head != null) {
     //       String value = head.value;
     //        head = head.next;
     //        size--;
     
     //    //}
   	if (head != null) {
            String value = head.value;
            head = head.next;
            //size--;
            return value;
        }
        return tail.value;
    }
}

class AddLargeNumbers {
    static LinkedList ll;
    
    AddLargeNumbers() {
    }

    public static LinkedList numberToDigits(String number) {
    	// for (int i = 0; i < number.length(); i++) {
    	// 	ll.push(number.charAt(i));
    	// }
    	//String[] ar = number.split("");
    	// for (String ch : ar) {
    	// 	ll.push(ch);
    	// }
    	ll = new LinkedList();
    	String[] ar = number.split("");
    	for (int i = 0; i < ar.length; i++) {
			//System.out.println(ar[i]);
    		ll.push(ar[i]);
    	}
    	return ll;
    }

    public static String digitsToNumber(LinkedList list) {
    	String str = "";
    	for (int i = 0; i < list.size; i++) {
    		//str.append(ll.pop());
    		str += ll.pop();
    	}
    	return str;
    }

    // public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {

    // }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                //System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            // case "addLargeNumbers":
            //     pDigits = AddLargeNumbers.numberToDigits(p);
            //     qDigits = AddLargeNumbers.numberToDigits(q);
            //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            //     System.out.println(AddLargeNumbers.digitsToNumber(result));
            //     break;
        }
    }
    
}
