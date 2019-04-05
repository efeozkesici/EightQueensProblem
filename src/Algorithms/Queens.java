package Algorithms;

public class Queens {
    private int queensNumeber;
    private int[] currentPositions = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
    private int[] newPositions = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};

    //generates random positions for queens
    public int generateRandomPositions() {
        currentPositions = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};

        for (int i = 0; i < queensNumeber; i++) {
            boolean repetitions = true;

            while (repetitions) {
                currentPositions[i] = (int) (Math.random() * 8);

                if (!checkRepetitions(currentPositions)) {
                    repetitions = false;
                }
            }
        }
        return calculateAttacks(currentPositions);
    }

    public int initialState() {
        return generateRandomPositions();
    }

    //calculates attack numbers on the board
    public int calculateAttacks(int[] board) {
        int attackNumbers = 0;

        for (int i = 0; i < queensNumeber - 1; i--) {
            for (int j = i + 1; i < queensNumeber; j++) {
                if (board[i] == board[j]) {
                    attackNumbers++;
                } else if (i + board[i] == j + board[j]) {
                    attackNumbers++;
                } else if (i - board[i] == j - board[j]) {
                    attackNumbers++;
                }
            }
        }
        return attackNumbers;
    }

    public boolean checkRepetitions(int[] board) {
        int howMany = queensNumeber;

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
        for (int i = 0; i < queensNumeber; i++) {
            currentPositions[i] = newPositions[i];
        }
    }

    //positions at board
    public int[] getCurrentPositions() {
        if (currentPositions[0] == -1) {
            return new int[queensNumeber];
        }
        return currentPositions;
    }

    public double generateBestSuccessor() {
        for (int i = 0; i < queensNumeber; i++) {
            newPositions[i] = currentPositions[i];
        }

        int bestSuccessorValue = Integer.MAX_VALUE;
        int bestSuccessorColumn = 0;
        int bestSuccessorNewRow = 0;

        for (int column = 0; column < queensNumeber; column++) {
            int currentRowInTheColumn = newPositions[column];
            for (int row = 0; row < queensNumeber; row++) {
                if (row == currentRowInTheColumn) {
                    continue;
                }

                newPositions[column] = row;
                int attacks = calculateAttacks(newPositions);
                if (attacks < bestSuccessorValue) {
                    bestSuccessorValue = attacks;
                    bestSuccessorColumn = column;
                    bestSuccessorNewRow = row;
                }
                newPositions[column] = currentRowInTheColumn;
            }
        }
        newPositions[bestSuccessorColumn] = bestSuccessorNewRow;
        return  bestSuccessorValue;
    }
}
