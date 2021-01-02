package GUI;

public class Parameter {
    public static int xStart = 100, yStart = 50;
    public static int row = 8, column = 8;
    public static int size = 560;
    public static int stepSize = size / row, width = size / row, height = size / row;

    public static String path = "Image";
    public static String board = path + "\\board.png\\";
    public static String grayBoard = path + "\\grayBoard.png\\";
    public static String greenBoard = path + "\\greenBoard.png\\";
    public static String defaultBoard = path + "\\board.png\\";
    public static String brownBoard = path + "\\brownBoard.png\\";

    public static String whiteChess = path + "\\whiteChess.png\\";
    public static String blackChess = path + "\\blackChess.png\\";

    public static String winner = path + "\\chickenShake.gif\\";
    public static String suggest = path + "\\Suggestions.png\\";
    public static String logo = path + "\\Logo.png\\";
    public static String cannotMove = path + "\\cannotMove.gif\\";

    public static String background = path + "\\background.jpg\\";

    public static String music = "Audio\\" + "hitman.wav";

    public static String player1 = "PLayer 1";
    public static String player2 = "Player 2";
}
