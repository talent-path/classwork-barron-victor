public class App {
    public static void main(String[] args){
        int[] arr = {82, 95, 71, 6, 34};
        int sum = Aggregate.sum(arr);
        int avg = Aggregate.avg(arr);
        int min = Aggregate.min(arr);
        int max = Aggregate.max(arr);
        double standardDevi = Aggregate.standardDevi(arr);

        System.out.println( min );      //should give 6
        System.out.println( max );      //should give 95
        System.out.println(sum);        //should give 288
        System.out.println( avg );      //should give 57.6 (roughly)
        System.out.println(standardDevi);     //should give 36.719 (roughly)
    }
}
