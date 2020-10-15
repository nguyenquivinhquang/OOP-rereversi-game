public class DebugArr {
    public static  int row = 8, column = 8;

    public static  void debug(int[][] arr, String content) {
        System.out.println(content + "\n");
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
        System.out.println("\n" + "--------------------");

    }


}
