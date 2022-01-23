package clean.code.chess.requirements;

public class Pawn {

    private ChessBoard chessBoard;
    private int xCoordinate;
    private int yCoordinate;
    private PieceColor pieceColor;

    public Pawn(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public ChessBoard getChessBoard() {
        return chessBoard;
    }

    public void setChessBoard(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
    }

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int value) {
        this.xCoordinate = value;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int value) {
        this.yCoordinate = value;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    private void setPieceColor(PieceColor value) {
        pieceColor = value;
    }

    public void Move(MovementType movementType, int newX, int newY) {
        /**
         * Checks to see if the position of the pawn would be available and still in the same position on the x-axis (it can only move forward)
         */
        if (movementType == MovementType.MOVE && getChessBoard().IsLegalBoardPosition(newX, newY) && newX == getXCoordinate()) {
            moveForward(getYCoordinate(), newY);
        }
    }

    private void moveForward(int oldY, int newY) {
        /**
         * From its initial position, the pawn can be moved forward, either one or two positions, otherwise it can only move one
         */
        switch (getPieceColor()) {
            case WHITE:
                if (oldY == 1 && newY == oldY + 2) setYCoordinate(newY);
                if (newY == oldY + 1) setYCoordinate(newY);
                break;
            case BLACK:
                if(oldY == 6 && newY == oldY - 2) setYCoordinate(newY);
                if(newY == oldY - 1) setYCoordinate(newY);
                break;
        }
    }

    @Override
    public String toString() {
        return CurrentPositionAsString();
    }

    protected String CurrentPositionAsString() {
        String eol = System.lineSeparator();
        return String.format("Current X: {1}{0}Current Y: {2}{0}Piece Color: {3}", eol, xCoordinate, yCoordinate, pieceColor);
    }
}
