package Algorithms;

public class Queens {
    private int NUM_QUEENS = 8;
    private int[] currentQueensPositions = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};
    private int[] newQueensPositions = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};

    public int generateRandomPositions() {
        currentQueensPositions = new int[] {-1, -1, -1, -1, -1, -1, -1, -1};

        for (int iQueen = 0; iQueen < NUM_QUEENS; iQueen++) {
            boolean repetitions = true;

            while (repetitions) {
                currentQueensPositions[iQueen] = (int) (Math.random() * 8);

                if (!checkRepetitions(currentQueensPositions)) {
                    repetitions = false;
                }
            }
        }

        return calculateAttacks(currentQueensPositions);
    }

    public int initialState() {
        return generateRandomPositions();
    }

    public int calculateAttacks(int[] board) {
        int numAttacks = 0;

        for (int iQueen = 0; iQueen < NUM_QUEENS - 1; iQueen++) {
            for (int iAttackingQueen = iQueen + 1; iAttackingQueen < NUM_QUEENS; iAttackingQueen++) {
                if (board[iQueen] == board[iAttackingQueen]) {
                    numAttacks++;
                } else if (iQueen + board[iQueen] == iAttackingQueen + board[iAttackingQueen]) {
                    numAttacks++;
                } else if (iQueen - board[iQueen] == iAttackingQueen - board[iAttackingQueen]) {
                    numAttacks++;
                }
            }
        }
        return numAttacks;
    }

    public boolean checkRepetitions(int[] board) {
        int howMany = NUM_QUEENS;

        for (int iQueen = 0; iQueen < howMany - 1; iQueen++) {
            if (board[iQueen] == -1) {
                continue;
            }
            for (int iCheckQueen = iQueen + 1; iCheckQueen < howMany; iCheckQueen++) {
                if (board[iCheckQueen] == -1) {
                    continue;
                }
                if (board[iQueen] == board[iCheckQueen]) {
                    return true;
                }
            }
        }
        return false;
    }

    public void acceptSuccessor() {
        for (int iQueen = 0; iQueen < NUM_QUEENS; iQueen++) {
            currentQueensPositions[iQueen] = newQueensPositions[iQueen];
        }
    }

    public int[] getCurrentPositions() {
        if (currentQueensPositions[0] == -1) {
            return new int[NUM_QUEENS];
        }
        return currentQueensPositions;
    }

    public double generateBestSuccessor() {
        for (int iQueen = 0; iQueen < NUM_QUEENS; iQueen++) {
            newQueensPositions[iQueen] = currentQueensPositions[iQueen];
        }

        int bestSuccessorValue = Integer.MAX_VALUE;
        int bestSuccessorColumn = 0;
        int bestSuccessorNewRow = 0;

        for (int column = 0; column < NUM_QUEENS; column++) {
            int currentRowInTheColumn = newQueensPositions[column];
            for (int row = 0; row < NUM_QUEENS; row++) {
                if (row == currentRowInTheColumn) {
                    continue;
                }
                newQueensPositions[column] = row;
                int attacks = calculateAttacks(newQueensPositions);
                if (attacks < bestSuccessorValue) {
                    bestSuccessorValue = attacks;
                    bestSuccessorColumn = column;
                    bestSuccessorNewRow = row;
                }
                newQueensPositions[column] = currentRowInTheColumn;
            }
        }

        newQueensPositions[bestSuccessorColumn] = bestSuccessorNewRow;
        return bestSuccessorValue;
    }
}