package com.yxc.datastructure;

import java.util.*;

/**
 * 排序和查找
 *
 * **/
public class SortAndSearch {
    /**
     * 二分查找
     * 1、先定义三个参数，高阶h=数组长度减1,低阶l=0，中间变量m
     * 2、while循环，m=(l+h)/2
     * 3、用array[m]于target目标进行比较
     * 4、折半查找
     * */
    public int twoSearch(int[] array,int target){
      int l=0;
      int h=array.length-1;
      int m;
      while(l<h){
          m = (l+h)/2;
          if(array[m]==target){
              return m;
          }else if(array[m]<target){
              l = m+1;
          }else{
              h = m-1;
          }
      }
      return-1;
    }
    /**
     * 快速排序
     * 1、快速排序一定是个递归的,既然是递归，参数：数组、高阶、低阶
     * 2、快速排序也是由高阶和低阶，所以这俩一定先定义
     * 3、与快速排序相似找基准，基准就是低阶
     * 4、两层循环，高阶>基准，--；低阶<=基准，++
     * **/
    public void quickSort(int[] array,int l,int h){
         if(l>h)
             return;
         int i=l;
         int j=h;
         int m=array[i];
         while(i<j){
             while(i<j&&array[j]>m)
                 j--;
             while(i<j&&array[i]<=m)
                 i++;
             if(i<j){
                 int temp = array[i];
                 array[i] = array[j];
                 array[j] = temp;
             }
         }
         int temp = array[l];
         array[l] = array[i];
         array[i] = temp;
         quickSort(array,i+1,h);
         quickSort(array,l,i-1);

    }
    /***u
     * 冒泡排序
     * 1、两层for循环，第二层从i+1开始
     * */
    public void bubbleStore(int[] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j = (i+1); j <array.length ; j++) {
                if(array[i]>array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    /**
     * 将不等于0的元素拿出来然后从头填入数组中，
     * 之后将没填的用0补齐
     * 思路：循环数组把不等于0的加紧新数组然后剩余的填0
     * ***/
    public int[] moveZero01(int[] array){
       int[] arrayNew = new int[array.length];
       int index = 0;
        for (int i = 0; i <array.length; i++) {
            int data = array[i];
            if(data!=0){
                arrayNew[index] = data;
                index++;
            }
        }
        int surplus = array.length-index;//剩余
        for (int i = array.length-1; i>surplus; i--) {
            arrayNew[i] = 0;
        }
        return arrayNew;
    }
    /**
     * 将不等于0的元素拿出来然后从头填入数组中，
     * 之后将没填的用0补齐
     * 思路：0和非0元素交换位置
     * ***/
    public void moveZero02(int[] array){
        int k=0;
        for (int i = 0; i <array.length ; i++) {
            int kv = array[k];
            int iv = array[i];
            if(iv!=0){
                if(k!=i&&kv==0){//防止同一个位置互相交换一次的无效操作
                    int temp = array[i];
                    array[i] = array[k];
                    array[k] = temp;
                }
                k++;
            }
        }
    }
    /***
     * hello world反转成 world hello
     * */
    public String tranctString(String str){
        String target = " ";
        int kindex = str.indexOf(target);
        StringBuffer sb = new StringBuffer();
        sb.append(str.substring(kindex+1));
        sb.append(target);
        sb.append(str.substring(0,kindex));
        return sb.toString();
    }
    /**
     * 倒序输出字符串
     * abcdsiwoabcjsue输出eusjcbaowisdcba
     * **/
    public String descString(String str){
        String newStr = "";
        for (int i = str.length()-1; i >0 ; i--) {
            char c = str.charAt(i);
            newStr+=c;
        }
        return newStr;
    }
    /**
     * 给定一个元素，将数组中等于该元素的值全部删除并返回剩余元素的个数
     * 比如数组：[3,2,2,3] 给定值是3
     * 返回2，并且数组中前两个元素应该为2
     * 161 / 161 个通过测试用例 状态：通过 执行用时：20 ms
     * **/
    public int removeElement01(int[] array,int target){
        //走一遍数组有的删除，放入一个新数组，要求原来大小不变，要用temp来操作新数组，大小变了，就要用list
        List<Integer> array01 = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
            int a = array[i];
            if(array[i]!=target){
                array01.add(a);
            }
        }
        for (int i = 0; i <array01.size(); i++) {
            System.out.print(array01.get(i));
            if (i<array01.size()-1){
                System.out.print(",");
            }
        }
        return array01.size();
    }
    /**
     *   //快捷键sout
     * 删除数组中重复的元素，并且返回新数组长度
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 不需要考虑数组中超出新长度后面的元素（不必新建数组）
     * **/
    public int removeRepeatElement(int[] array){
        int k=0;
        //思路：循环遍历，用map
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            if(!map.containsKey(value)){
                map.put(value,value);
                array[k] = value;
                k++;
            }
        }
        System.out.println("排序之后的数组");
        System.out.println(Arrays.toString(array));
        return k;
    }
    /**
     * 给定 nums = [1,1,1,2,2,3],
     * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 你不需要考虑数组中超出新长度后面的元素。
     *165 / 165 个通过测试用例 状态：通过 执行用时：7 ms
     * **/
    public int removeRepeatElementOther(int[] array){
        int k=0;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i <array.length; i++) {
            if(!map.containsKey(array[i])){
                int count = 0;
                map.put(array[i],count+1);
                array[k] = array[i];
                k++;
            }else{
                int vaunt = map.get(array[i]);
                if(vaunt<2){
                    map.put(array[i],vaunt+1);
                    array[k] = array[i];
                    k++;
                }
            }
        }
        for (int i = 0; i <k ; i++) {
            System.out.print(array[i]);
            if (i<k-1){
                System.out.print(",");
            }
        }
        return k;
    }

    /**
     * 给定一个有n个元素的数组，数组中元素的取值只有0，1，2三种可能为这个数组排序
     * 方法一：计数排序：适用于元素个数非常有限的场景，分别统计0，1，2三个数组然后合并
     * 方法二：三路快排，将排序完的数组设置成0，1，2那么设置一个索引zero，[0,zero]就是0
     *         设置一个索引two，那么[two,n-1]就是2，在[zero+1,two-1]只见移动索引i，为1
     *         i++，为0把arry[i]和arry[zero+1]做交换，如果是2，就把array[two-1]和array[i]
     *         交换，交换完以后i不动，因为不能确定是0还是1，同样把这个array[i]做判断如果是0，
     *         把array[i]和array[zero+1]做交换把i向下移动，
     *         1的区间设置为[zero+1,two-1]所以i的循环区间为i<two
     * **/
    public void storColour01(int[] array){
        List<Integer> list0 = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i <array.length ; i++) {
            int a = array[i];
            if(a==0){
                list0.add(a);
            }else if(a==1){
                list1.add(a);
            }else{
                list2.add(a);
            }
        }
        List<Integer> storList = new ArrayList<Integer>();
        storList.addAll(list0);
        storList.addAll(list1);
        storList.addAll(list2);
        for (int i = 0; i <storList.size() ; i++) {
            System.out.print(storList.get(i));
            if (i!=(storList.size()-1)){
                System.out.print(",");
            }
        }
    }
    public void storColour02(int[] array){
        int zero = -1;//[0,zero];
        int two = array.length;//[two,n-1];
        for (int i=0;i<two;){
            int a = array[i];
            if(a==1){
                i++;
            }else if(a==0){
                zero++;
                int temp = array[zero];
                array[zero] = a;
                array[i] = temp;
                i++;//0的区间延长了，i自然要+1
            }else if(a==2){
                two--;
                int temp = array[two];
                array[two] = a;
                array[i] = temp;//但是i不会往下走因为你还不确定这个值是0还是1，所以要再走一遍
            }
        }
        System.out.println("处理之后："+Arrays.toString(array));
    }
}
