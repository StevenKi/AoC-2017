
import java.util.stream.Stream;

public class DaySix {

    public static void main(String[] args) {
        String input = retrieveInput();
        String[] bankStrings = input.split("\t");
        int[] banks = Stream.of(bankStrings).mapToInt(Integer::valueOf).toArray();

        MemoryReallocator memoryReallocator = new MemoryReallocator();
        System.out.println(memoryReallocator.countRedistributionCycles(banks));
        System.out.println(memoryReallocator.countLoopCycles(banks));
    }

    private static String retrieveInput() {
        return "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4";
    }
}
