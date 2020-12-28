package Core;

public class RegionScore {
    private static final int column = 8;
    private static final int row = 8;
    private static int[][] regionScore = new int[row + 2][column + 2];

    private static void setRegionScore() {
        regionScore[1][1] = 100;
        regionScore[1][2] = -70;
        regionScore[1][3] = 70;
        regionScore[1][4] = 70;
        regionScore[1][5] = 70;
        regionScore[1][6] = 70;
        regionScore[1][7] = -70;
        regionScore[1][8] = 100;
        regionScore[2][1] = -50;
        regionScore[2][2] = -50;
        regionScore[2][3] = -30;
        regionScore[2][4] = -30;
        regionScore[2][5] = -30;
        regionScore[2][6] = -30;
        regionScore[2][7] = -70;
        regionScore[2][8] = -70;
        regionScore[3][1] = 70;
        regionScore[3][2] = -70;
        regionScore[3][3] = 20;
        regionScore[3][4] = 20;
        regionScore[3][5] = 20;
        regionScore[3][6] = 20;
        regionScore[3][7] = -70;
        regionScore[3][8] = 70;
        regionScore[4][1] = 70;
        regionScore[4][2] = -70;
        regionScore[4][3] = 20;
        regionScore[4][4] = 20;
        regionScore[4][5] = 20;
        regionScore[4][6] = 20;
        regionScore[4][7] = -70;
        regionScore[4][8] = 70;
        regionScore[5][1] = 70;
        regionScore[5][2] = -70;
        regionScore[5][3] = 20;
        regionScore[5][4] = 20;
        regionScore[5][5] = 20;
        regionScore[5][6] = 20;
        regionScore[5][7] = -70;
        regionScore[5][8] = 70;
        regionScore[6][1] = 70;
        regionScore[6][2] = -70;
        regionScore[6][3] = 20;
        regionScore[6][4] = 20;
        regionScore[6][5] = 20;
        regionScore[6][6] = 20;
        regionScore[6][7] = -70;
        regionScore[6][8] = 70;
        regionScore[7][1] = -70;
        regionScore[7][2] = -70;
        regionScore[7][3] = -30;
        regionScore[7][4] = -30;
        regionScore[7][5] = -30;
        regionScore[7][6] = -30;
        regionScore[7][7] = -70;
        regionScore[7][8] = -70;
        regionScore[8][1] = 100;
        regionScore[8][2] = -70;
        regionScore[8][3] = 70;
        regionScore[8][4] = 70;
        regionScore[8][5] = 70;
        regionScore[8][6] = 70;
        regionScore[8][7] = -70;
        regionScore[8][8] = 100;
    }

    public static int[][] getRegionScore() {
        setRegionScore();
        return regionScore;
    }
}
