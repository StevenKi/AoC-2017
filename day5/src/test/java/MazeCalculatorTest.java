import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MazeCalculatorTest {

    private MazeCalculator mazeCalculator;

    @Before
    public void setup() {
        mazeCalculator = new MazeCalculator();
    }

    @Test
    public void testCountStepsToExitPartOne() {
        // Prepare
        List<Integer> maze = new ArrayList<>();
        maze.add(0);
        maze.add(3);
        maze.add(0);
        maze.add(1);
        maze.add(-3);

        // Execute
        int steps = mazeCalculator.countStepsToExitPartOne(maze);

        // Verify
        assertEquals(5, steps);
    }

    @Test
    public void testCountStepsToExitPartTwo() {
        // Prepare
        List<Integer> maze = new ArrayList<>();
        maze.add(0);
        maze.add(3);
        maze.add(0);
        maze.add(1);
        maze.add(-3);

        // Execute
        int steps = mazeCalculator.countStepsToExitPartTwo(maze);

        // Verify
        assertEquals(10, steps);
    }

}