import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node<T> {
	T value = null;
	
	Node<T> prev = null;
	Node<T> next = null;
	
	Node (T val) {
		this.value = val;
	}
}

class Linkedlist<T> {
	
	Node<T> head=null;
	Node<T> tail=null;
	
	void addList(Linkedlist<T> list) {
		Node<T> temp=head;
		int index=0;
		while(index!=list.size()) {
			push_back(temp.value);
			temp=temp.next;
			index++;
		}
	}
	
	boolean equals(Linkedlist<T> list) {
		boolean result=true;
		if(size()!=list.size()) {
			result=false;
		}
		else {
			int index=0;
			Node<T> temp1=head;
			Node<T> temp2=list.head;
			while(index!=size()) {
				if(temp1.value!=temp2.value) {
					result=false;
				}
				else {
					temp1=temp1.next;
					temp2=temp2.next;
					index++;
				}
			}
			result=true;
		}
		return result;
	}
	
	int size() {
		int len=0;
		Node<T> temp=head;
		if(head==null) {
			return 0;
		}
		while(temp.next!=null) {
			temp=temp.next;
			len++;
		}
		len++;
		return len;
	}
	
	void push_back(T val) {
		Node<T> tmp = new Node<T>(val);
		if(tail == null) {
			head=tail=tmp;
			head.prev=null;
			tail.next=null;
		}
		else {
			tail.next=tmp;
			tmp.prev=tail;
			tail=tmp;
			tail.next=null;
		}
	}

	void push_front(T val) {
		Node<T> tmp=new Node<T>(val);
		if(head==null) {
			head=tail=tmp;
			head.prev=null;
			tail.next=null;
		}
		else {
			tmp.next=head;
			head.prev=tmp;
			head=tmp;
		}
	}
	
	String print_list() {
		Node<T> tmp = this.head;
		String res = "";
		while(tmp != null) {
			System.out.print(tmp.value + " ");
			res = res + tmp.value.toString() + " ";
			tmp = tmp.next;
		}
		System.out.println();
		return res;
	}
	
	T get(int n) {
		T value=null;
		if(n>=size()) {
			return null;
		}
		int index=0;
		Node<T> temp=head;
		while(index!=n) {
			temp=temp.next;
			index++;
		}
		value=temp.value;
		return value;
	}
	
	void set(int n,T val) {
		if(n>=size()) {
			System.out.println("error");
		}
		else {
			int index=0;
			Node<T> temp=head;
			while(index!=n) {
				temp=temp.next;
				index++;
			}
			temp.value=val;
		}
	}
	
	void add(int n, T val) {
		if(n>=size()) {
			System.out.println("error");
		}
		else {
			if(head==null) {
				head=tail=new Node<T>(val);
			}
			else if(n==0) {
				Node<T> tmp=new Node<T>(val);
				tmp.next=head;
				head.prev=tmp;
				head=tmp;
			}
		    else if(n==size()) {
		    	Node<T> tmp=new Node<T>(val);
				tail.next=tmp;
				tmp.prev=tail;
				tail=tmp;
		    }
			else{
				int index=0;
				Node<T> tmp=new Node<T>(val);
				Node<T> temp=head;
				while(index!=n-1) {
					temp=temp.next;
					index++;
				}
				tmp.next=temp.next;
				tmp.prev=temp;
				temp.next=tmp;
			}
		}
		
	}
		
	void erase(int n) {
		if(n<size()) {
			if(n==0) {
				head=head.next;
				head.prev=null;
			}
				
			else if(n==size()-1) {
				if(head==null) {
					return;
				}
					
				else {
					if(head!=tail) {
						tail=tail.prev;
						tail.next=null;
					}
						
					else {
						head=tail=null;
					}
				}
			}
				
			else {
				Node<T> temp=head;
				int index=0;
				while(index!=n-1) {
					temp=temp.next;
					index++;
				}
				if(temp!=null) {
					temp.next=temp.next.next;
					temp.next.prev=temp;
				}
					
			}
		}
		else {
			System.out.println("error");
		}
		
	}
		
	void pop_back() {
		if(head==null) {
			System.out.println("error");
			return;
		}
		
		else {
			if(head!=tail) {
				tail=tail.prev;
				tail.next=null;
			}
			else {
				head=tail=null;
			}
		}
	}

	void pop_front() {
		if(size()!=0) {
			if(size()==1) {
				head=head.next;
			}
			else{
				head=head.next;
				head.prev=null;
			}
			
		}
		else {
			System.out.println("error");
		}
	}
	
	List<Linkedlist<T>> split(T val){
		List<Linkedlist<T>> arr=new ArrayList<Linkedlist<T>>();
		int count=1;
		List<Integer> index_temp=new ArrayList<Integer>();
		Node<T> temp=this.head;
		Node<T> temp2;
		
		for(int i=0;i<size()&&temp!=null;i++,temp=temp.next) {
			if(temp.value==val) {
				count++;
				index_temp.add(i);
			}
		}
		
		if(count==1||index_temp.isEmpty()) {
			arr.add(this);
			return arr;
		}
		
		else {
			for(int i=count-1;i>0;i--) {
				temp2=this.head;
				 Linkedlist<T> newlist = new Linkedlist<T>();
		         for(int j = 0; j < index_temp.get(i - 1); j++, temp2 = temp2.next) {}
		         newlist.tail = this.tail;
		         newlist.head = temp2.next;
		         newlist.head.prev = null;
		         temp2.next = null;
		         this.tail = temp2.prev;
		         temp2.prev.next = null;
		         temp2.prev = null;
		         arr.add(newlist);

			}
			arr.add(this);
			Collections.reverse(arr);
		}
		
		return arr;
		
	}
	
	Linkedlist(){
		
	}
	
	Linkedlist(T val){
		head=new Node<T>(val);
		tail=head;
	}
	
	
}

public class PA1{
	public static void main(String[] args) {
		// example of using Linkedlist with generic type
	    //Linkedlist<Integer> list = new Linkedlist<Integer>(); 
	    
	    String[] res = new String[21];
		String[] ans = new String[21];
		ans[1] = "0";
		ans[2] = "4 ";
		ans[3] = "6 ";
		ans[4] = "9 7 5 3 1 ";
		ans[5] = "false";
		ans[6] = "true";
		ans[7] = "9 8 ";
		ans[8] = "0 0 0 0 0 ";
		ans[9] = "123 ";
		ans[10] = "1 2 3 4 ";
		ans[11] = "1";
		ans[12] = "null";
		ans[13] = "false";
		ans[14] = "true";
		ans[15] = "true";
		ans[16] = "1 2 3 4 ";
		ans[17] = "0 0 0 0 0 0 0 0 0 ";
		ans[18] = "3";
		ans[19] = "0 1 2 3 4 0 1 2 3 4 ";
		ans[20] = "1 1 1 1 1 0 1 2 3 4 ";

		
		// problem 1 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list1 = new Linkedlist<Integer>();
			System.out.println("#1: " + list1.size());
			
			res[1] = Integer.toString(list1.size());
			
		} catch (Exception e) {
			System.out.println("#1: fail");
		}
		
		// problem 2 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list2 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list2.push_front(i);
			}
			list2.erase(0);
			for (int j=1;j<4;j++) {
				list2.pop_back();
				list2.pop_front();
			}
			list2.erase(0);
			System.out.print("#2: ");
			res[2] = list2.print_list();
		} catch (Exception e) {
			System.out.println("#2: fail");
		}
		
		// problem 3 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list3 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list3.push_back(i);
			}
			list3.erase(0);
			for (int j=1;j<4;j++) {
				list3.pop_back();
				list3.pop_front();
			}
			list3.erase(0);
			System.out.print("#3: ");
			res[3] = list3.print_list();
		} catch (Exception e) {
			System.out.println("#3: fail");
		}
		// problem 4 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list4 = new Linkedlist<Integer>();
			
			for (int i=1;i<10;i++) {
				list4.push_front(i);
			}
			for (int i=1;i<10;i++) {
				list4.erase(i);
			}
			System.out.print("#4: ");
			res[4] = list4.print_list();
		} catch (Exception e) {
			System.out.println("#4: fail");
		}
		// problem 5 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list5 = new Linkedlist<Integer>();
			Linkedlist<Double> list6 = new Linkedlist<Double>();
			for (int i=1;i<10;i++) {
				list5.push_front(i);
				list6.push_front((double)i);
			}
			System.out.println("#5: " + list5.equals(list6));
			res[5] = String.valueOf(list5.equals(list6));
		} catch (Exception e) {
			System.out.println("#5: fail");
		}
		// problem 6 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list7 = new Linkedlist<Integer>();
			Linkedlist<Integer> list8 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list7.push_front(i);
			}
			for (int i=1;i<10;i++) {
				list8.push_front(i);
				list8.push_front(i);
				list8.erase(0);
			}
			System.out.println("#6: " + list7.equals(list8));
			res[6] = String.valueOf(list7.equals(list8));
		} catch (Exception e) {
			System.out.println("#6: fail");
		}
		// problem 7 ////////////////////////////////////////////////////////////////////////////

		try {
			Linkedlist<Integer> list9 = new Linkedlist<Integer>();
			list9.push_back(0);
			for (int i=1;i<10;i++) {
				list9.add(0, i);
			}
			for (int i=1;i<9;i++) {
				list9.pop_back();
			}
			
			System.out.print("#7: ");
			res[7] =  list9.print_list();
			
		} catch (Exception e) {
			System.out.println("#7: fail");
		}
		
		// problem 8 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list10 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list10.push_back(i);
			}
			for (int i=1;i<10;i++) {
				list10.set(i,0);
			}
			for (int i=1;i<3;i++) {
				list10.pop_back();
				list10.pop_front();
			}
			System.out.print("#8: ");
			res[8] =  list10.print_list();
			
		} catch (Exception e) {
			System.out.println("#8: fail");
		}
		// problem 9 ////////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list11 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list11.push_back(i);
			}
			for (int i=1;i<20;i++) {
				list11.erase(0);
			}
			list11.push_front(123);
			System.out.print("#9: ");
			res[9] =  list11.print_list();
			
		} catch (Exception e) {
			System.out.println("#9: fail");
		}
		// problem 10 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list12 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list12.push_back(i);
			}
			for (int i=1;i<20;i++) {
				list12.add(100,123);
			}
			for (int i=2;i<20;i++) {
				list12.erase(4);
			}
			
			System.out.print("#10: ");
			res[10] =  list12.print_list();
			
		} catch (Exception e) {
			System.out.println("#10: fail");
		}
		// problem 11 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list13 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list13.push_back(i);
			}

			System.out.println("#11: " + list13.get(0));
			res[11] = list13.get(0).toString();
			
		} catch (Exception e) {
			System.out.println("#11: fail");
		}
		// problem 12 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list14 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list14.push_back(i);
			}

			System.out.println("#12: " + list14.get(100));
			res[12] = String.valueOf(list14.get(100));
		} catch (Exception e) {
			System.out.println("#12: fail");
		}
		// problem 13 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list15 = new Linkedlist<Integer>();
			Linkedlist<Integer> list16 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list15.push_back(i);
				list16.push_back(i);
			}
			list16.push_back(0);
			System.out.println("#13: " + list15.equals(list16));
			res[13] = String.valueOf(list15.equals(list16));
		} catch (Exception e) {
			System.out.println("#13: fail");
		}
		// problem 14 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list17 = new Linkedlist<Integer>();
			Linkedlist<Integer> list18 = new Linkedlist<Integer>();

			list17.push_back(0);
			list17.pop_back();
			System.out.println("#14: " + list17.equals(list18));
			res[14] = String.valueOf(list17.equals(list18));
		} catch (Exception e) {
			System.out.println("#14: fail");
		}
		// problem 15 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list19 = new Linkedlist<Integer>();
			Linkedlist<Integer> list20 = new Linkedlist<Integer>(1);

			list19.push_back(1);
			
			System.out.println("#15: " + list19.equals(list20));
			res[15] = String.valueOf(list19.equals(list20));
		} catch (Exception e) {
			System.out.println("#15: fail");
		}
		// problem 16 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list20 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list20.push_back(i);
			}
			System.out.print("#16: ");
			res[16] = list20.split(5).get(0).print_list();
		} catch (Exception e) {
			System.out.println("#16: fail");
		}
		
		// problem 17 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list21 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list21.push_back(0);
			}
			System.out.print("#17: ");
			res[17] = list21.split(123).get(0).print_list();
		} catch (Exception e) {
			System.out.println("#17: fail");
		}
		// problem 18 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list22 = new Linkedlist<Integer>();
			for (int i=1;i<10;i++) {
				list22.push_back(i);
			}
			int size = list22.split(4).get(0).size();
			System.out.println("#18: " + size);
			res[18] = String.valueOf(size);
		} catch (Exception e) {
			System.out.println("#18: fail");
		}
		// problem 19 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list24 = new Linkedlist<Integer>();
			Linkedlist<Integer> list25 = new Linkedlist<Integer>();
			for (int i=0;i<5;i++) {
				list25.push_back(i);
				list24.push_back(i);
			}
			list24.addList(list25);
			System.out.print("#19: ");
			res[19] = list24.print_list();
		
		} catch (Exception e) {
			System.out.println("#19: fail");
		}

		// problem 20 ///////////////////////////////////////////////////////////////////////////
		try {
			Linkedlist<Integer> list24 = new Linkedlist<Integer>();
			Linkedlist<Integer> list25 = new Linkedlist<Integer>();
			for (int i=0;i<5;i++) {
				list24.push_back(1);
				list25.push_back(i);
			}
			list24.addList(list25);
			System.out.print("#20: ");
			res[20] = list24.print_list();
			

		} catch (Exception e) {
			System.out.println("#20: fail");
		}
		System.out.println("");
		int score = 0;
		for (int i=1;i<21;i++) {
			try {
				if (res[i].contentEquals(ans[i])) {
					
					score++;
				}
			} catch (Exception e) {
				continue;
			}
			
		}
		System.out.println("Score: " + score);
		for (int i=1;i<21;i++) {
			try {
				if (res[i].contentEquals(ans[i])) {
					
					System.out.print("1\t");
				}
				else {
					System.out.print("0\t");
				}
				

			} catch (Exception e) {
				System.out.print("-\t");
			}
			
		}
		System.out.println("");

	}

}


