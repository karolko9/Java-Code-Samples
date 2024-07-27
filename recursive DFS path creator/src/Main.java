import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[][] tab;
        tab = new int[10][10];
        PathCreator path = new PathCreator(10,10);
        tab = path.create();
        System.out.println(Arrays.deepToString(tab));
    }
}
