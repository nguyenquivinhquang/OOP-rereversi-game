import Core.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;


public class PlayervsBot extends PlayerVsPlayer {
    private void botThink() {
        Minimax move = Minimax.getInstance();
        cond temp = move.getOptimalMove(fee, this.x, this.y);
        this.x = temp.x;  this.y = temp.y;
        fee[this.x][this.y] = 2;
        step = 1;
        System.out.println("bot move: " + this.x + " " + this.y);
    }
    public void actionGame() {

        boardFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (gamePlay.arrPosibleMove.size() != 0) {
                    getRowColumn(e.getX(), e.getY());

                    if (press(x, y) == true) {
                        gamePlay.flipChess(fee, step, x, y);
                        possibleMove = gamePlay.checkPosibleMove(fee, step);
                        computeBoard();
                        System.out.println("Score: " + p1Score + " " + p2Score);
                    }
                } else boardFrame.noMoves(step);

                if (gamePlay.checkEndGame(board) == true ) {
                    winner();
                    step = step == 1 ? 2 : 1;
                }
                score = gamePlay.CountPlayerScore(board);
                p1Score = score.x;  p2Score = score.y;
                boardFrame.setBoard(stage, p1Score, p2Score, step);
                step = 2;

                // delay some seconds
//                try {
//                    TimeUnit.SECONDS.sleep(3);
//                } catch (InterruptedException interruptedException) {
//                    interruptedException.printStackTrace();
//                }
                botThink();
                computeBoard();
                score = gamePlay.CountPlayerScore(board);
                p1Score = score.x;  p2Score = score.y;
                boardFrame.setBoard(stage, p1Score, p2Score, step);
                step = 1;

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
