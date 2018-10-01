import java.util.Scanner;
class Node{
	int ele;
	Node next;
}

class LinkedList{
	Node first;
	Node last;
	LinkedList(){
		first = null;
		last = null;
	}

	public void pushfront(int ele){
		Node temp = new Node();
		temp.ele = ele;
		temp.next = first;
		first = temp;
		if(first.next == null){
			last = first;
		}
	}

	public int popfront() {
		if(first == null){
			return 0;
		}
		int temp = first.ele;
		first = first.next;
		if(first == null){
			last = null;
		}
		return temp;
	}

	public void pushLast(int ele){
		Node temp = new Node();
		temp.ele = ele;
		temp.next = null;
		if(last == null){
			last = temp;
			first = last;
			return;
		}
		last.next = temp;
		last = temp;
	}

	public String print(){
		if(first == null){
			return "Steque is empty.";
		}
		Node temp = first;
		String str = "";
		while(temp.next != null){
			str += temp.ele +", ";
			temp = temp.next;
		}
		str += temp.ele;
		return str;
	}
	public boolean isEmpty(){
		return first == null;
	}
}

class stack{
	LinkedList LL;
	stack(){
		LL = new LinkedList();
	}
	public void push(int ele){
		LL.pushfront(ele);
	}
	public int pop(){
		return LL.popfront();
	}
	public boolean isEmpty(){
		return LL.isEmpty();
	}

	public String print(){
		return LL.print();
	}
}
class AddLargeNumbers {
    
    public static LinkedList numberToDigits(String number) {
    	LinkedList LL = new LinkedList();
    	for(int i = 0; i < number.length(); i++){
    		LL.pushLast(Integer.parseInt(number.charAt(i)+""));
    	}
    	return LL;
    }

    public static String digitsToNumber(LinkedList list) {
    	// System.out.println(list.print());
    	Node temp = list.first;
    	String str = "";
    	while(temp != null){
    		str += temp.ele;
    		temp = temp.next;
    	}
    	return str;
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
    	stack s1 = new stack();
    	stack s2 = new stack();
    	Node temp = list1.first;
    	while(temp != null){
    		s1.push(temp.ele);
    		temp = temp.next;
    	}
    	temp = list2.first;
    	while(temp != null){
    		s2.push(temp.ele);
    		temp = temp.next;
    	}
    	LinkedList result = new LinkedList();
    	int carry = 0;
    	while(!(s1.isEmpty() && s2.isEmpty())){
    		int sum = s1.pop() + s2.pop() + carry;
    		if(sum >= 10){
    			carry = 1;
    			sum = sum - 10;
    		}else{
    			carry = 0;
    		}
    		result.pushfront(sum);
    	}
    	if(carry == 1){
    		result.pushfront(carry);
    	}
    	return result;
    }
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
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                pDigits = AddLargeNumbers.numberToDigits(p);
                qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
        }
    }
    
}
