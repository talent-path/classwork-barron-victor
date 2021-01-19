public class Application {
    public static void main(String[] args){
        int num = Console.readInt("please enter a numerical value", 1, 5);
        System.out.println(num);
        double dub = Console.readDouble("Enter a double value: ", 2.0, 7.5);
        System.out.println(dub);
    }
}
