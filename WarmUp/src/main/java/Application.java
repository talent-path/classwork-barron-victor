public class Application {
    public static void main(String[] args){
        int[] left = new int[]{1,1,1,1,1,1,1,1,1,1};
        int[] right = new int[]{1,0,0,0,0,0,0,0,0,0};
        int[] sum = addBigNum(left,right);

    }
    //given two arrays of size 100
    //each element has a value between 0 - 9
    //return 101 element sum of both numbers
    //
    public static int[] addBigNum(int[] left, int[] right){
        int[] sum = new int[101];
        int element = 0;
        for(int i = 0; i < left.length; i++){
            element = left[i] + right[i] + sum[i];
            if(element >= 10){
                sum[i+1]++;
                element = element - 10;
            }
            sum[i] = element;
        }
        return sum;
    }
}
