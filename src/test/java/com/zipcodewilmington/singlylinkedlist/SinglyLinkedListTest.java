package com.zipcodewilmington.singlylinkedlist;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {
    private SinglyLinkedList<Integer> list;

    @org.junit.Before
    public void setUp() throws Exception {
         list = new SinglyLinkedList<Integer>();
    }

    @org.junit.Test
    public void add() {
        Assert.assertEquals(0,list.size());
        list.add(3);
        Assert.assertEquals(1,list.size());
        list.add(7);
        Assert.assertEquals(2,list.size());
    }

    @org.junit.Test
    public void contains() {
        Assert.assertFalse(list.contains(3));
        list.add(3);
        Assert.assertTrue(list.contains(3));
        Assert.assertFalse(list.contains(7));
        list.add(7);
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(7));
    }

    @Test
    public void find() {
        list.add(9);
        list.add(7);
        list.add(3);
        Assert.assertEquals(-1, list.find(5));
        Assert.assertEquals(2, list.find(3));
        Assert.assertEquals(0, list.find(9));
    }

    @Test
    public void get() {
        list.add(9);
        list.add(7);
        list.add(3);
        Assert.assertEquals(null, list.get(5));
        Assert.assertEquals((Integer) 9, list.get(0));
        Assert.assertEquals((Integer) 3, list.get(2));

    }

    @org.junit.Test
    public void remove() {
        list.add(9);
        list.add(7);
        list.add(3);
        list.add(4);
        Assert.assertTrue(list.contains(3));
        Assert.assertTrue(list.contains(7));
        list.remove(2);
        Assert.assertFalse(list.contains(3));
        Assert.assertTrue(list.contains(7));
        list.remove(0);
        Assert.assertFalse(list.contains(3));
        Assert.assertFalse(list.contains(9));
        Assert.assertTrue(list.contains(7));
    }

    @org.junit.Test
    public void copy() {
        Integer integerObj = 3;
        list.add(9);
        list.add(7);
        list.add(integerObj);
        list.add(4);
        SinglyLinkedList<Integer> copy = list.copy();
        Assert.assertEquals(9,copy.get(0),.01);
        Assert.assertEquals(2,copy.find(3),.01);
        Assert.assertNotEquals(integerObj,copy.get(3),.01);
        Assert.assertEquals(3,copy.find(4),.01);
    }

    @org.junit.Test
    public void sort() {
        list.add(9);
        list.add(7);
        list.add(3);
        list.add(4);
        list.sort();
        Assert.assertEquals(3,list.get(0),.01);
        Assert.assertEquals(4,list.get(1),.01);
        Assert.assertEquals(7,list.get(2),.01);
        Assert.assertEquals(9,list.get(3),.01);
    }

    @org.junit.Test
    public void reverse() {
        list.add(9);
        list.add(7);
        list.add(3);
        list.add(4);
        list.reverse();
        Assert.assertEquals(9,list.get(0),.01);
        Assert.assertEquals(7,list.get(1),.01);
        Assert.assertEquals(4,list.get(2),.01);
        Assert.assertEquals(3,list.get(3),.01);
    }

}
