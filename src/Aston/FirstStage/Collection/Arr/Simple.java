package Aston.FirstStage.Collection.Arr;

import java.util.Comparator;

public interface Simple<E> extends Iterable<E> {

    //adding an element into ArrList
    boolean add(E e);

    //deleting an element from ArrList
    void delete(int index);

    //getting element from ArrList by index
    E get(int index);

    void set(int index, E element);

    //getting size of elements ArrList
    int size();

    //updating element in ArrList by index
    void update(int index, E e);

    //sorting element in ArrList
    void sort(MyArrayList<E> list, Comparator<E> comparator);
}