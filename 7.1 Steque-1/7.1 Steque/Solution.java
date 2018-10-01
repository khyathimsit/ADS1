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
}

class Staque{
	LinkedList LL;
	Staque(){
		LL = new LinkedList();
	}
	public void push(int ele){
		LL.pushfront(ele);
	}
	public int pop() {
		return LL.popfront();
	}
	public void enqueue(int ele){
		LL.pushLast(ele);
	}
	public String print(){
		return LL.print();
	}
}

class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < testcase; i++){
			Staque obj = new Staque();
			while(sc.hasNextLine()){
				String[] str = sc.nextLine().split(" ");
				if(str[0].equals("push")){
					obj.push(Integer.parseInt(str[1]));
				}
				else if(str[0].equals("enqueue")){
					obj.enqueue(Integer.parseInt(str[1]));
				}
				else if(str[0].equals("pop")){
					obj.pop();
				}else{
					System.out.println();
					break;
				}
				obj.print();
			}
		}
	}
}