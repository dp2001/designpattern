package indi.eric.dp.strategy;

/**
 * Created by qinsheng on 2018/8/18.
 */
public class DataSorter {

    //冒泡排序
    public void sort(Comparable objects[]){
        for(int i=objects.length; i>0; i--){
            for(int j=0; j< i-1; j++){
                if(objects[j].compareTo(objects[j+1]) > 0){
                    swap(objects, j, j+1);
                }
            }
        }
    }

    //交换数据
    private void swap(Comparable c[], int x, int y) {
        Comparable temp = c[x];
        c[x] = c[y];
        c[y] = temp;
    }

    public void print(Comparable c[]){
        for(int i=0; i<c.length; i++){
            System.out.print(c[i] + " ");
        }
    }

}
