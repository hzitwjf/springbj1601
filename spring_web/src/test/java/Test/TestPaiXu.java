package Test;

import org.junit.Test;

/**
 * Created by Administrator on 2016/9/26.
 */
public class TestPaiXu {
        //对数进行选择排序

        public static void selectnumber(int[] number){

            for(int i=0;i<number.length-1;i++){
                int m=i;
                for(int j=i+1;j<number.length;j++){
                    if(number[j]<number[m]){
                        m=j;
                    }
                    if(i!=m){
                        swap(number,i,m);
                    }
                }
            }
        }
        //交换两个数
        public static void swap(int number[],int i,int j){
            int t;
            t=number[i];
            number[i]=number[j];
            t=number[i];
        }
        public static void main(String[] args) {
            //定义一个十个数大小的数组
            int num[]=new int[10];
            for(int i=0;i<num.length;i++){
            //生成10个随机数
                num[i]=(int)(Math.random() * 100)+1;
            }
            //调用选择排序算法
            selectnumber(num);
            for(int i=0;i<num.length;i++){
            //输出十个排序后的值
                System.out.println(num[i]);
            }
        }

}
