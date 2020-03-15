import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class graphPathFindingTest {

    @Test
    public void pathTest() {

        LinkedList<pointLocation> test = graphPathFinding.findPath(0,0, 50,50, new int[]{0}, new int[]{0}, new int[]{50});

        if(test != null) {
            test.forEach(System.out::println);

            Assert.assertArrayEquals(null, test.toArray());
        }

        else {

            System.out.println("It's null!");

        }

    }

    @Test
    public void morePaths() {

        int[] xValues = new int[]{100};
        int[] yValues = new int[]{0};
        int[] radius = new int[]{30};

        LinkedList<pointLocation> test = graphPathFinding.findPath(0,0, 150,50, xValues, yValues, radius);

        test.stream().forEach(System.out::println);

        System.out.println("\nNext case");

        xValues = new int[]{100, 100, 100, 100, 100};
        yValues = new int[]{0, 70, 140, 220, 300};
        radius = new int[]{70, 70, 70, 70, 70};

        test = graphPathFinding.findPath(0,0, 300,50, xValues, yValues, radius);

        if(test == null){
            System.out.println("NULL!");
        } else {
            test.stream().forEach(System.out::println);
        }

    }

    @Test
    public void pointLocationTests() {
        Assert.assertEquals(new pointLocation(1,2), new pointLocation(1,2));

        pointLocation a = new pointLocation(1,2);
        a.parent = new pointLocation(2,3);

        Assert.assertEquals(a.parent, new pointLocation(1,2).parent);

    }
}