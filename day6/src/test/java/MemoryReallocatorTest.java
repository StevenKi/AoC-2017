import org.junit.Before;
import org.junit.Test;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class MemoryReallocatorTest {

    private MemoryReallocator memoryReallocator;

    @Before
    public void setup() {
        memoryReallocator = new MemoryReallocator();
    }

    @Test
    public void testFindBankWithMostBlocks() {
        assertEquals(2, memoryReallocator.findBankWithMostBlocks(new int[]{0, 2, 7, 0}));
        assertEquals(1, memoryReallocator.findBankWithMostBlocks(new int[]{0, 7, 7, 0}));
    }

    @Test
    public void testRedistributeBlocks() {
        assertArrayEquals(new int[]{2, 4, 1, 2}, memoryReallocator.redistributeBlocks(new int[]{0, 2, 7, 0}));
        assertArrayEquals(new int[]{3, 1, 2, 3}, memoryReallocator.redistributeBlocks(new int[]{2, 4, 1, 2}));
        assertArrayEquals(new int[]{0, 2, 3, 4}, memoryReallocator.redistributeBlocks(new int[]{3, 1, 2, 3}));
        assertArrayEquals(new int[]{1, 3, 4, 1}, memoryReallocator.redistributeBlocks(new int[]{0, 2, 3, 4}));
        assertArrayEquals(new int[]{2, 4, 1, 2}, memoryReallocator.redistributeBlocks(new int[]{1, 3, 4, 1}));
    }

    @Test
    public void testSerializeBankConfiguration() {
        assertEquals("[2, 4, 1, 2]", memoryReallocator.serializeBankConfiguration(new int[]{2, 4, 1, 2}));
    }

    @Test
    public void testCountRedistributionCycles() {
        assertEquals(5, memoryReallocator.countRedistributionCycles(new int[]{0, 2, 7, 0}));
    }

    @Test
    public void testCountLoopCyles() {
        assertEquals(4, memoryReallocator.countLoopCycles(new int[]{2, 4, 1, 2}));
    }

}