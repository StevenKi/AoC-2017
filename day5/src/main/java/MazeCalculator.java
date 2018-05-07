import java.util.ArrayList;
import java.util.List;

public class MazeCalculator {

    public int countStepsToExitPartOne(List<Integer> maze) {
        List<Integer> mazeCopy = new ArrayList<>(maze);

        int steps = 0;
        int mazeIndex = 0;
        while (mazeIndex < mazeCopy.size()) {
            Integer mazeValue = mazeCopy.get(mazeIndex);
            mazeCopy.set(mazeIndex, mazeValue + 1);

            mazeIndex += mazeValue;
            steps++;
        }

        return steps;
    }

    public int countStepsToExitPartTwo(List<Integer> maze) {
        List<Integer> mazeCopy = new ArrayList<>(maze);

        int steps = 0;
        int mazeIndex = 0;
        while (mazeIndex < mazeCopy.size()) {
            Integer mazeValue = mazeCopy.get(mazeIndex);

            if (mazeValue >= 3) {
                mazeCopy.set(mazeIndex, mazeValue - 1);
            } else {
                mazeCopy.set(mazeIndex, mazeValue + 1);
            }

            mazeIndex += mazeValue;
            steps++;
        }

        return steps;
    }

}
