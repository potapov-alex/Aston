package Aston.FirstStage.Collection.Arr;

import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<E> implements Simple<E> {


//    public static void main(String[] args) {
//        MyArrayList<String> strings = new MyArrayList<>();
//        strings.add("one");
//        strings.add("two");
//        strings.add("three");
//        strings.add("four");
//        strings.add("five");
//        strings.add("six");
//
//        System.out.println("before");
//        for (String s : strings
//        ) {
//            System.out.println(s);
//        }
//
//        strings.sort(strings,String::compareTo);
//
//        System.out.println("after");
//        for (String s : strings
//        ) {
//            System.out.println(s);
//        }
//
//    }


    private E[] elements;

    public MyArrayList() {
        elements = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = elements;
            elements = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, elements, 0, temp.length);
            elements[elements.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = elements;
            elements = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, elements, 0, index);
            int afterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, elements, index, afterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public void set(int index, E e) {
        try {
            E[] temp = elements;
            elements = (E[]) new Object[temp.length];
            System.arraycopy(temp, 0, elements, 0, index);
            elements[index] = e;
            int afterIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, elements, index+1, afterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public void update(int index, E e) {
        elements[index] = e;
    }

    @Override
    public void sort(MyArrayList<E> list, Comparator<E> comparator) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(list.get(j), list.get(j + 1)) > 0) {
                    E temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }


    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(elements);
    }
}