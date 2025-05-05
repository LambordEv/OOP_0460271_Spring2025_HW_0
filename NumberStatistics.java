import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class NumberStatistics {
    private int mTotalRegisteredNumbers;
    private ArrayList<Double> mLinesAverage;
    private int mPositiveAmount;
    private int mNegativeAmount;

    /**
     * @effects Initialize the NumberStatistics class
     */
    NumberStatistics(){
        mTotalRegisteredNumbers = 0;
        mLinesAverage = new ArrayList<>();
        mPositiveAmount = 0;
        mNegativeAmount = 0;
    }

    /**
     * @effects parses the received line string by the defined rules
     * @modifies this - the statistics variables
     * @param line - a string that holds a single line from the original file
     */
    public void parseLine(String line) {
        double totalNumbersInLine = 0.0;
        double lineNumbersSum = 0.0;

        for (int i = 0; i < line.length(); i++) {
            StringBuilder currentNumber = new StringBuilder();

            if('-' == line.charAt(i)) {
                currentNumber.append('-');
                i++;
            }

            while (i < line.length() && Character.isDigit(line.charAt(i))) {
                currentNumber.append(line.charAt(i));
                i++;
            }

            if(!currentNumber.isEmpty()) {
                int actualNumber = Integer.parseInt(currentNumber.toString());
                totalNumbersInLine++;
                lineNumbersSum += actualNumber;

                if(actualNumber > 0) {
                    mPositiveAmount++;
                } else if (actualNumber < 0) {
                    mNegativeAmount++;
                }
            }
        }

        mLinesAverage.add(lineNumbersSum / totalNumbersInLine);
        mTotalRegisteredNumbers += (int)totalNumbersInLine;
    }

    /**
     * @effect constructs the Statistics result string
     * @return the reade string
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        double positiveNumPercentage = 100 * (mPositiveAmount / (double)mTotalRegisteredNumbers);
        double negativeNumPercentage = 100 * (mNegativeAmount / (double)mTotalRegisteredNumbers);
        double zerosPercentage =
                100 * ((mTotalRegisteredNumbers - mPositiveAmount - mNegativeAmount) / (double)mTotalRegisteredNumbers);

        result.append("Total numbers in file: " + mTotalRegisteredNumbers + "\n");
        for (int i = 0; i < mLinesAverage.size(); i++) {
            result.append(String.format("Line #%d average: %.2f\n", (i +1), mLinesAverage.get(i)));
        }
        result.append(String.format("Positive percentage: %.2f", positiveNumPercentage) + "%\n");
        result.append(String.format("Negative percentage: %.2f", negativeNumPercentage) + "%\n");
        result.append(String.format("Zeros percentage: %.2f", zerosPercentage) + "%\n");

        return result.toString();
    }

    /**
     * @effects parses the given file line by line and saves the statics, in the end prints them all
     * @param args - holds the filename path
     */
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: java NumberStatistics <file_path>");
            return;
        }

        NumberStatistics statistics = new NumberStatistics();
        String filename = args[0];
        try (BufferedReader in = new BufferedReader(new FileReader(filename))) {

            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                statistics.parseLine(currentLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + filename);
        }

        System.out.println(statistics);
    }
}
