package com.yxc.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class SortAndSearchTest {
    private SortAndSearch sortAndSearch;

    @Before
    public void initData(){

        sortAndSearch = new SortAndSearch();
    }

    @Test
    public void twoSearchTest(){
        int[] twoSearchArray = {1, 4, 6, 9, 12, 15, 18, 23, 47, 50};
        int result = sortAndSearch.twoSearch(twoSearchArray,23);
        System.out.print("======result:"+result);
    }
    @Test
    public void quickSortTest(){
        int[] quickArray =  {6,1,2,7,9,3,4,5,10,8};
        sortAndSearch.quickSort(quickArray,0,quickArray.length-1);
        System.out.println(Arrays.toString(quickArray));
    }
    @Test
    public void bubbleStoreTest(){
        int[] bubbleArray =  {6,1,2,7,9,3,4,5,10,8};
        sortAndSearch.bubbleStore(bubbleArray);
        System.out.println(Arrays.toString(bubbleArray));
    }
    @Test
    public void moveZero01Test(){
        int[] mz01 = {1,2,0,8,2,4,0,19,1,0,0,0};
        System.out.println(Arrays.toString( sortAndSearch.moveZero01(mz01)));
    }
    @Test
    public void moveZero02Test(){
        int[] mz02 = {1,2,0,8,2,4,0,19,1,0,0,0};
        sortAndSearch.moveZero02(mz02);
        System.out.println(Arrays.toString(mz02));
    }
    @Test
    public void tranctStringTest(){
        String result = sortAndSearch.tranctString("Hello World");
        System.out.println(result);
    }
    @Test
    public void descStringTest(){
        System.out.print(sortAndSearch.descString("abcdsiwoabcjsue"));
    }
}
