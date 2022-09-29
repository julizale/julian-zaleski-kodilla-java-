package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("Beginning tests...");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("End of testing.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Beginning test #" + testCounter);
    }

    @Nested
    @DisplayName("Test adding and removing figures")
    class TestAddRemoveFigures {

        @Test
        void testAddFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle(8);

            //When
            shapeCollector.addFigure(shape);

            //Then
            assertEquals(shape, shapeCollector.getFigure(0));
        }

        @Test
        void testRemoveFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle(8);
            shapeCollector.addFigure(shape);

            //When
            boolean result = shapeCollector.removeFigure(shape);

            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getShapesQuantity());
        }

        @Test
        void testRemoveFigureNotExisting() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(5);

            //When
            boolean result = shapeCollector.removeFigure(shape);

            //Then
            assertFalse(result);
        }

    }

    @Nested
    @DisplayName("Testing getting and showing figures")
    class TestGetShowFigures {

        @Test
        void testGetFigure() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Triangle(5, 8, 10.5);
            shapeCollector.addFigure(shape);

            //When
            Shape retrievedShape = shapeCollector.getFigure(0);

            //Then
            assertEquals(shape, retrievedShape);

        }

        @Test
        void testShowFigures() {
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape1 = new Triangle(5, 8, 10.5);
            Shape shape2 = new Circle(9.1);
            Shape shape3 = new Square(8);
            shapeCollector.addFigure(shape1);
            shapeCollector.addFigure(shape2);
            shapeCollector.addFigure(shape3);

            //When
            String result = shapeCollector.showFigures();

            //Then
            assertEquals("triangle circle square ", result);
        }

    }

}
