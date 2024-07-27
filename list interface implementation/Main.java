import java.util.*;

public class Main {

}





class CustomList<E> implements List<E> {
    private Node<E> head;
    private int size;

    private class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }




    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Node<E> current = head; current != null; current = current.next) {
            if (Objects.equals(o, current.data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            array[index] = current.data;
            index++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = Arrays.copyOf(a, size);
        }
        int index = 0;
        for (Node<E> current = head; current != null; current = current.next) {
            a[index] = (T) current.data;
            index++;
        }
        if (index < a.length) {
            a[index] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        Node<E> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty()) {
            return false;
        }

        if (Objects.equals(o, head.data)) {
            head = head.next;
            size--;
            return true;
        }

        Node<E> current = head;
        while (current.next != null) {
            if (Objects.equals(o, current.next.data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }









    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            add(element);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        Node<E> current = head;
        Node<E> previous = null;

        while (current != null) {
            if (c.contains(current.data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                modified = true;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;

        Node<E> current = head;
        Node<E> previous = null;

        while (current != null) {
            if (!c.contains(current.data)) {
                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }
                modified = true;
            } else {
                previous = current;
            }
            current = current.next;
        }

        return modified;
    }


    @Override
    public void clear() {
        for (Node<E> node = head; node != null; ) {
            Node<E> next = node.next;
            node.data = null;
            node.next = null;
            node = next;
        }
        head = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        int i = 0;
        Node<E> temp = head;
        while (i!=index){
            i++;
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public E set(int index, E element) {
        int i = 0;
        Node<E> temp = head;
        while (i!=index){
            i++;
            temp = temp.next;
        }
        E oldValue = temp.data;
        temp.data = element;
        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        Node<E> temp = head;
        int i = 0;
        while (i+1 != index){
            temp=temp.next;
            i++;
        }
        Node<E> node = new Node<E>(element);
        node.next = temp.next.next;
        temp.next = node;
        size++;
    }

    @Override
    public E remove(int index) {
        Node<E> node = head;
        int i = 0;
        int l = this.size;
        if (index >= l){
            return null;
        }
        while (i+1 != index){
            node = node.next;
            i++;
        }
        E temp = node.next.data;
        node.next = node.next.next;

        return temp;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
            for (Node<E> x = head; x != null; x = x.next) {
                if (o.equals(x.data)) {
                    return index;
                }
                index++;
            }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int lastindex = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            if (o.equals(x.data)) {
                lastindex = index;
            }
            index++;
        }
        return lastindex;
    }



















    @Override
    public Iterator<E> iterator() {
        return new CustomIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new CustomListIterator(0);
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return new CustomListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }







    private class CustomIterator implements Iterator<E> {
        public Node<E> current = head;
        public Node<E> previous = null;

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            previous = current;
            current = current.next;
            return current.data;
        }

        @Override
        public void remove() {
            previous.next = current.next;
            current.next = null;
            current.data = null;
            current = previous.next.next;
        }
    }

    private class CustomListIterator extends CustomIterator implements ListIterator<E> {
        private int currentIndex;

        public CustomListIterator(int index) {
            super();
            currentIndex = index;
            for (int i = 0; i < index; i++) {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException();
                }
                next();
            }
        }
        public CustomListIterator() {
            super();
        }

        @Override
        public boolean hasPrevious() {
            return previous!=null ;
        }

        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            current=head;
            previous=null;
            int i =0;
            while (i+1!=currentIndex){
                previous.next =current;
                current = current.next;
            }
            return current.data;

        }

        @Override
        public int nextIndex() {
            return currentIndex + 1;
        }

        @Override
        public int previousIndex() {
            return currentIndex - 1;
        }

        @Override
        public void set(E e) {
            current.data = e;
        }

        @Override
        public void add(E e) {
            Node<E> newNode = new Node<>(e);
            if (previous == null) {
                newNode.next = head;
                head = newNode;
                current=head;
            } else {
                newNode.next = current;
                previous.next = newNode;
            }
            size++;
        }
    }

}
