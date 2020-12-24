import Core.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PlayervsBot extends PlayerVsPlayer {
    private void botThink() {
        Minimax move = Minimax.getInstance();
        cond temp = move.getOptimalMove(boardStage, this.x, this.y);
        this.x = temp.x;
        this.y = temp.y;
        System.out.println("bot move: " + this.x + " " + this.y);

    }

    public void actionGame() {

        boardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                for (int i = 1; i <= 2; i++) {
                    if (gamePlay.arrPosibleMove.size() != 0) {
                        getRowColumn(e.getX(), e.getY());
                        if (step == 2) botThink();
                        if (press(x, y) == true) {
                            System.out.println(step);
                            gamePlay.flipChess(boardStage, step, x, y);

                        }
                    } else {
                        boardFrame.noMoves(step);
                        step = 1;
                    }
                    possibleMove = gamePlay.checkPosibleMove(boardStage, step);
                    computeBoard();
                    if (gamePlay.checkEndGame(board) == true) {
                        winner();
                    }
                    score = gamePlay.CountPlayerScore(board);
                    p1Score = score.x;
                    p2Score = score.y;
                    boardFrame.setBoard(stage, p1Score, p2Score, step);
                }
            }
        });
    }

    public PlayervsBot() {
        super();
    }

    public static PlayervsBot getInstance() {
        return new PlayervsBot();
    }

}