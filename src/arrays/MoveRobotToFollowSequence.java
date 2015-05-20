package arrays;

/*
    Grid           - (100*500)
    Robot Position – (5,3)
    Sequence       — {N,S,M,M,E,W,E,S,M,S,M}    North, East, West, South, Move forward
 */

public class MoveRobotToFollowSequence {

    private Direction currentFacing = Direction.EAST;
    private Position currentPosition;
    private final int ROW_SIZE, COLUMN_SIZE;

    public MoveRobotToFollowSequence(int currentRow, int currentColumn, int rowSize, int columnSize) {
        this.currentPosition = new Position(currentRow, currentColumn);
        this.ROW_SIZE = rowSize;
        this.COLUMN_SIZE = columnSize;
    }

    private class Position {
        int row = 0;
        int column = 0;

        public Position(int currentRow, int currentColumn) {
            this.row = currentRow;
            this.column = currentColumn;
        }
    }

    public enum Direction {
        North('N'), South('S'), EAST('E'), WEST('W');

        private char direction;

        Direction(char n) {
            this.direction = n;
        }

        public int getDirection() {
            return direction;
        }
    }

    private void followSequence(String sequence) {
        String[] seq = sequence.split(",");
        for (String s : seq) {
            char ch = s.charAt(0);
            if (ch == 'M') {
                System.out.println(currentPosition.row + " " + currentPosition.column);
                moveRobot();
            } else {
                System.out.println(currentFacing.name());
                changeDirection(ch);
            }
        }
    }

    private void moveRobot() {
        switch (currentFacing) {
            case North:
                if (currentPosition.row - 1 >= 0)
                    currentPosition.row--;
                break;
            case South:
                if (currentPosition.row + 1 < ROW_SIZE)
                    currentPosition.row++;
                break;
            case EAST:
                if (currentPosition.row + 1 < COLUMN_SIZE)
                    currentPosition.column++;
                break;
            case WEST:
                if (currentPosition.column - 1 >= 0)
                    currentPosition.column--;
                break;
        }
    }

    private void changeDirection(char ch) {
        Direction d = convertCharToDirection(ch);
        assert d != null;
        switch (d) {
            case North:
                currentFacing = Direction.North;
                break;
            case South:
                currentFacing = Direction.South;
                break;
            case EAST:
                currentFacing = Direction.EAST;
                break;
            case WEST:
                currentFacing = Direction.WEST;
                break;
        }
    }

    private Direction convertCharToDirection(char ch) {
        for (Direction d : Direction.values()) {
            if (ch == d.getDirection()) {
                return d;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new MoveRobotToFollowSequence(5, 3, 100, 500).followSequence("N,S,M,M,E,W,E,S,M,S,M");
    }
}
