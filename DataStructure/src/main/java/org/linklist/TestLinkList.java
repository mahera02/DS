package org.linklist;

public class TestLinkList {

	public static void main(String[] args) {
        MyLinkList<Integer> list = new MyLinkList<Integer>();
        list.addFirst(5);
        list.addFirst(7);
        list.addFirst(8);
        list.addFirst(9);
        list.addFirst(6);
        
        //using iterator
        for(Object a : list) {
        	System.out.println(a);
        }
        
        boolean found = list.contains(10);
        System.out.println(found);
        System.out.println(list.removeLast());
        boolean foundl = list.contains(5);
        System.out.println(foundl);
        System.out.println(list.getCurrentSize());
        System.out.println(list.remove(8));
        System.out.println(list.getCurrentSize());
  
	}

}
