package clean.code.chess.requirements;

public class ChessBoard {

    public static int MAX_BOARD_WIDTH = 7;
    public static int MAX_BOARD_HEIGHT = 7;
    public int numberOfWhitePawnsRemaining = 8;
    public int numberOfBlackPawnsRemaining = 8;

    private final Pawn[][] pieces;

    public ChessBoard() {
        pieces = new Pawn[MAX_BOARD_WIDTH + 1][MAX_BOARD_HEIGHT + 1];
    }

    public void Add(Pawn pawn, int xCoordinate, int yCoordinate, PieceColor pieceColor) {
        /**
         * We're not allowed to put the pawn in a position that's outside the table or if the position is on the table but already taken by other piece
         */
        if (!IsLegalBoardPosition(xCoordinate, yCoordinate)) {
            pawn.setXCoordinate(-1);
            pawn.setYCoordinate(-1);
            return;
        }

        /**
         * If the position is available, as long as we have available pieces (8 of each color) we place them in the specified positions
         */
        switch (pieceColor) {
            case WHITE:
                if (numberOfWhitePawnsRemaining > 0) {
                    pawn.setXCoordinate(xCoordinate);
                    pawn.setYCoordinate(yCoordinate);
                    pieces[xCoordinate][yCoordinate] = pawn;
                    numberOfWhitePawnsRemaining--;
                }
            case BLACK:
                if (numberOfBlackPawnsRemaining > 0) {
                    pawn.setXCoordinate(xCoordinate);
                    pawn.setYCoordinate(yCoordinate);
                    pieces[xCoordinate][yCoordinate] = pawn;
                    numberOfBlackPawnsRemaining--;
                }
        }
    }

    public boolean IsLegalBoardPosition(int xCoordinate, int yCoordinate) {
        return OnTable(xCoordinate, yCoordinate) && FreePosition(xCoordinate, yCoordinate);
    }

    private boolean OnTable(int xCoordinate, int yCoordinate) {
        return (xCoordinate >= 0 && xCoordinate < 7) && (yCoordinate >= 0 && yCoordinate < 7);
    }

    private boolean FreePosition(int xCoordinate, int yCoordinate) {
        return pieces[xCoordinate][yCoordinate] == null;
    }
}
