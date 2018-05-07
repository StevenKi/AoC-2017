import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MemoryReallocator {

    public int countRedistributionCycles(int[] banks) {
        Set<String> bankConfigurations = new HashSet<>();

        int cycles = 1;
        boolean sameConfigurationFound = false;
        while (!sameConfigurationFound) {
            int[] newBankConfiguration= redistributeBlocks(banks);
            String serializedBankConfiguration = serializeBankConfiguration(newBankConfiguration);
            if (bankConfigurations.contains(serializedBankConfiguration)) {
                sameConfigurationFound = true;
            } else {
                bankConfigurations.add(serializedBankConfiguration);
                cycles++;
            }
        }

        return cycles;
    }

    public int countLoopCycles(int[] banks) {
        int cylces = 0;
        String originalBankConfiguration = serializeBankConfiguration(banks);
        boolean originalBankConfigurationFound = false;
        while (!originalBankConfigurationFound) {
            int[] newBankConfiguration = redistributeBlocks(banks);
            String serializedBankConfiguration = serializeBankConfiguration(newBankConfiguration);
            if (serializedBankConfiguration.equals(originalBankConfiguration)) {
                originalBankConfigurationFound = true;
            }

            cylces++;
        }

        return cylces;
    }

    protected int[] redistributeBlocks(int[] banks) {
        int indexOfHighestBank = findBankWithMostBlocks(banks);
        int blocksToAllocate = banks[indexOfHighestBank];
        banks[indexOfHighestBank] = 0;

        int amountOfBanks = banks.length;
        int currentBankIndex = indexOfHighestBank + 1 >= amountOfBanks ? 0 : indexOfHighestBank + 1;
        while (blocksToAllocate != 0) {
            int bankValue = banks[currentBankIndex];
            banks[currentBankIndex] = bankValue + 1;
            blocksToAllocate--;

            if (currentBankIndex + 1 == amountOfBanks) {
                currentBankIndex = 0;
            } else {
                currentBankIndex++;
            }
        }

        return banks;
    }

    protected int findBankWithMostBlocks(int[] banks) {
        int indexOfHighestBank = 0;
        int highestValue = 0;
        for (int i = 0, banksLength = banks.length; i < banksLength; i++) {
            int bankValue = banks[i];
            if (bankValue > highestValue) {
                highestValue = bankValue;
                indexOfHighestBank = i;
            }
        }

        return indexOfHighestBank;
    }

    protected String serializeBankConfiguration(int[] bankConfiguration) {
        return Arrays.toString(bankConfiguration);
    }
}
