package company;

public class MyLinkedList<T> implements MyList<T>{

    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;

    public boolean contains(Object o){
        MyNode<T> temp = head;
        while(temp.next != null){
            if(temp.equals(o)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void add(T item, int index){
        MyNode<T> newNode = new MyNode<>(item);
        MyNode<T> temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void clear() {
        length = 0;
    }
    
    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("index should be positive and less than size");
        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }
        return temp.data;
    }

    public int indexOf(Object o) {
        MyNode<T> temp = head;

        int index = 0;
        while (index != length - 1) {
            if(temp.data == o){
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        MyNode<T> temp = head;
        for(int i = length - 1; i >= 0; i--){
            if(temp.data == o){
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }


    public int size() {
        return length;
    }




}
