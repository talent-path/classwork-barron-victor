import java.util.*;

public class Application {
    public static void main(String[] args) {
//        int[] left = new int[]{1,1,1,1,1,1,1,1,1,1};
//        int[] right = new int[]{1,0,0,0,0,0,0,0,0,0};
//        int[] sum = addBigNum(left,right);


        //given two arrays of size 100
        //each element has a value between 0 - 9
        //return 101 element sum of both numbers
        //
//    public static int[] addBigNum(int[] left, int[] right){
//        int[] sum = new int[101];
//        int element = 0;
//        for(int i = 0; i < left.length; i++){
//            element = left[i] + right[i] + sum[i];
//            if(element >= 10){
//                sum[i+1]++;
//                element = element - 10;
//            }
//            sum[i] = element;
//        }
//        return sum;
//    }
       // System.out.println("Max sequence from 0 to 1,000,000 is: " + maxSequence());

        System.out.println(digitReversal(123456));
    }

    public static int digitReversal(int toFlip){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int count;
        int newSum = 0;
        for(int i = toFlip; i > 0; i = i/10){
            arr.add(i%10);
        }
        count = arr.size() -1;
        for(int i = 0; i < arr.size(); i++){
            newSum = newSum + (arr.get(i) * (int)Math.pow(10.0,count));
            count--;
        }
        return newSum;
    }


    public static Long maxSequence(){
        int maxSequenceLen = 0;
        Long maxNumber = 0L;
        int tempLen;
        for(Long i = 1L; i < 1000000; i++){
            tempLen = evaluate(i);
            if(tempLen > maxSequenceLen){
                maxSequenceLen = tempLen;
                maxNumber = i;
            }
            System.out.println(i);
        }
        return maxNumber;
    }

    public static int evaluate(Long num){
        boolean done = false;
        int count = 0;
        while(!done){
            if(num == 1) done = true;
            else if (num%2 == 0){
                num = num /2;
                count++;
            }
            else {
                num = (3 * num) +1;
                count++;
            }
        }
        return count;
    }

}

