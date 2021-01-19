public class Aggregate {
    public static int min(int[] arr){

        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static int max(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static int sum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }
    public static double sum(double[] arr){
        double sum = 0.0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    public static int avg(int[] arr){
        int sum = sum(arr);
        return sum / arr.length;
    }

    public static double avg(double[] arr){
        double sum = sum(arr);
        return sum / (double)arr.length;
    }

    public static double standardDevi(int[] arr){
        double avg = avg(arr);
        double[] temp = new double[arr.length];
        for(int i = 0; i < arr.length; i++){
            temp[i] = (double)arr[i] - avg;
            temp[i] = Math.sqrt(Math.abs(temp[i]));
            System.out.println("debug" + temp[i]);

        }
        return sum(temp) / (double)temp.length;
    }
}
