import com.kodilla.bubbles.BubbleSorter;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubblesTestSuite {

    private BubbleSorter bubbleSorter = new BubbleSorter();

    @org.junit.jupiter.api.Test
    void testBubbleSort() {
        //Given
        List<Integer> theList = Arrays.asList(2,1,8,5,4,2,4,1);
        //When
        List<Integer> expectedList = Arrays.asList(1,1,2,2,4,4,5,8);
        List<Integer> sortedList = bubbleSorter.sort(theList);
        System.out.println(sortedList);
        //Then
        assertEquals(expectedList, sortedList);
    }
}
