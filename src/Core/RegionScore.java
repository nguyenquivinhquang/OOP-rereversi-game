package Core;

public class RegionScore {
    private static final int column = 8;
    private static final int row = 8;
    private static int[][] regionScore = new int[row + 2][column + 2];

    private static void setRegionScore() {
        int[][] temp =
                {
                        {20, -10, 11, 8, 8, 11, -10, 20},
                        {-3, -15, -4, 1, 1, -4, -15, -3},
                        {11, -4, 2, 2, 2, 2, -4, 11},
                        {8, 1, 2, -3, -3, 2, 1, 8},
                        {8, 1, 2, -3, -3, 2, 1, 8},
                        {11, -4, 2, 2, 2, 2, -4, 11},
                        {-10, -15, -4, 1, 1, -4, -15, -10},
                        {20, -3, 11, 8, 8, 11, -10, 20}
                };
        for (int i = 1; i <= row; i++)
            for (int j = 1; j <= column; j++)
                regionScore[i][j] = temp[i - 1][j - 1];
    }

    public static int[][] getRegionScore() {
        setRegionScore();
        return regionScore;
    }
}
