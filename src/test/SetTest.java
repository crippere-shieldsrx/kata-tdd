package test;

import main.Set;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SetTest {

    ArrayList<Integer> membersLeft =  new ArrayList<Integer>();
    ArrayList<Integer> membersRight =  new ArrayList<Integer>();

    Integer candidateOne = 1;
    Integer candidateTwo = 2;

    @Before
    public void setUp() {
        membersLeft.add(1);
        membersLeft.add(2);
        membersLeft.add(3);

        membersRight.add(2);
        membersRight.add(3);
        membersRight.add(4);
    }
    /*
    "TDD" = Test Driven Development
    Let the tests drive your development work.
    Work to get the tests passing; you're done when the test passes, so stop
        work on a test when it passes.
    "How do I get this (test's) code working?"  Run the test and fix the
        issue that the test is failing over.
    If all the tests are passing green, but you know you still have features
        to implement, you need more tests (which fail at start but get coded green).
    If all the tests are green, and the code could be made better, cleaner,
        or more efficient, then refactor your code while still retesting that the
        code stays a working green.
    Make sure that the test fails before you start work on implementing it.  If the
        test passes before you've written any code or implemented a solution for it,
        then the code needs nothing to make it pass; write nothing.  (Why is the test
        even present if it doesn't fail?  Maybe it will come to fail later...)  Or,
        is the green-at-start test actually broken and itself mis-written?  If a
        test doesn't and can't fail, then it's not an effective test.

    Remember: "Red, Green, Refactor"

    Red: (Write and) Run -a- test and see it fail.
        (Is the test failing for the right reasons?)
        Write just enough code, retesting often...
    Green: ...to just get the one test to pass.
        Run all the other green tests and keep those other tests passing.
    Refactor: Go back, clean up your code, move it around, and make it better,
        all while seeing your tests stay green.

    Don't write code that doesn't help make a test pass now.
        "But I know we're going to need it!"
    ...then wait until you -do- need it (and have a test for it) before you write it.

    This kata is about when and how to make tests pass, where the tests are being
        provided for the kata.  -Writing- good tests is another topic and another
        kata.  "Should this feature be tested for in an extension of an existing
        test, or in a fresh test of its own?  Should this test be at the
        service- or controller-level, in a journey/integration test, or all three?
        Should I test for this edge case, such as what if someone does something weird?
        Should I include tests of the negative?  Do I need to test this at all?"
        Those questions and this discussion is out-of-scope for this kata.
    */

    /*
    Instructions:
    Make the tests pass.

    Recommendation:
    Comment out all of the tests, uncomment and RedGreenRefactor them
       one at time, and work them in the order presented.
    For this kata, write your Set.java code in order; when you create a new method
        or attribute, add it below your existing code.  Edit methods where they are.
        I would normally suggest that attributes start the class, followed by
        constructors, public methods, and then private methods.  This "as you
        write it" ordering though shows to you the order of your work.  (We will
        not ask people to pass in their work at the end of the kata.)

    Don't alter the tests themselves.
    */

    ///////////////////////////////////////////////////////////////////////////////////////

    //Note: Make this and all tests pass by the simplest method.
    @Test
    public void contains_NotsWhenNotPresent() {
        Integer candidate = 123;
        Set<Integer> target = new Set<Integer>();

        boolean result = target.contains(candidate);

        assertFalse(result);
    }
    /*
    Did you make the test above pass by fully implementing the "contains" method,
      and for that adding some "ArrayList<t>" property, or did you "return false;"?
    "return false;" makes the test pass and doesn't yet break any other non-existent tests.
    */

    @Test
    public void constructorListed_exists() {
        ArrayList<Integer> members =  new ArrayList<Integer>();
        members.add(candidateOne);

        Set<Integer> target = new Set<Integer>(members);

        //assertTrue(true == true);
        assertFalse(target == null);
    }

    @Test
    public void constructorEmpty_exists() {

        Set<Integer> target = new Set();

        //assertTrue(true == true);
        assertFalse(target == null);
    }

    @Test
    public void contains_TruesWhenPresent() {
        ArrayList<Integer> members =  new ArrayList<Integer>();
        members.add(candidateOne);
        Set<Integer> target = new Set<Integer>(members);

        boolean result = target.contains(candidateOne);

        assertTrue(result);
    }

    @Test
    public void add_Works() {
        Set<Integer> target = new Set<Integer>();

        target.add(candidateOne);

        boolean result = target.contains(candidateOne);
        assertTrue(result);
    }

    @Test
    public void constructorCopy_existsAndPopulates() {
        ArrayList<Integer> members =  new ArrayList<Integer>();
        members.add(candidateOne);
        Set<Integer> setFirst = new Set<Integer>(members);

        Set<Integer> target = new Set<Integer>(setFirst);
        boolean result = target.contains(candidateOne);

        assertTrue(result);
    }

    @Test
    public void constructorCopy_leavesOriginalIntact() {
        ArrayList<Integer> members =  new ArrayList<Integer>();
        members.add(candidateOne);
        Set<Integer> target = new Set<Integer>(members);
        Set<Integer> setDirty = new Set<Integer>(target);

        setDirty.add(candidateTwo);

        boolean result = target.contains(candidateTwo);

        assertFalse(result);
    }

    @Test
    public void union_Works() {
        Set<Integer> setLeft = new Set<Integer>(membersLeft);
        Set<Integer> setRight = new Set<Integer>(membersRight);

        Set<Integer> target = setLeft.union(setRight);

        assertTrue(target.contains(1));
        assertTrue(target.contains(2));
        assertTrue(target.contains(3));
        assertTrue(target.contains(4));
    }
    @Test
    public void intersect_Works() {
        Set<Integer> setLeft = new Set<Integer>(membersLeft);
        Set<Integer> setRight = new Set(membersRight);

        Set<Integer> target = setLeft.intersect(setRight);

        assertTrue(target.contains(2));
        assertTrue(target.contains(3));
    }

    @Test
    public void integrationLevel_Fruit() {
        final String APPLES = "apples";
        final String TOMATOES = "tomatoes";
        final String RASPBERRIES = "raspberries";
        final String ORANGES = "oranges";
        final String BANANAS = "bananas";
        final String LIMES = "limes";
        final String POTATOES = "potatoes";

        ArrayList<String> red = new ArrayList<>();
        red.add(APPLES);
        red.add(TOMATOES);
        red.add(RASPBERRIES);

        ArrayList<String> fruitSalad = new ArrayList<>();
        fruitSalad.add(APPLES);
        fruitSalad.add(ORANGES);
        fruitSalad.add(BANANAS);

        Set<String> redFruit = new Set<>(red);
        Set<String> saladFruit = new Set<>(fruitSalad);

        assertTrue(redFruit.contains(APPLES));
        assertTrue(redFruit.contains(TOMATOES));
        assertTrue(redFruit.contains(RASPBERRIES));
        assertFalse(redFruit.contains(LIMES));

        assertTrue(saladFruit.contains(ORANGES));
        assertTrue(saladFruit.contains(APPLES));
        assertTrue(saladFruit.contains(BANANAS));
        assertFalse(saladFruit.contains(RASPBERRIES));

        Set<String> union = redFruit.union(saladFruit);
        Set<String> intersect = redFruit.intersect(saladFruit);

        assertTrue(union.contains(APPLES));
        assertTrue(union.contains(TOMATOES));
        assertTrue(union.contains(BANANAS));
        assertFalse(union.contains(POTATOES));

        assertTrue(intersect.contains(APPLES));
        assertFalse(intersect.contains(TOMATOES));
        assertFalse(intersect.contains(BANANAS));
        assertFalse(intersect.contains(POTATOES));

    }


    /////////////////////////////////////////////////////////////////////////////////////
    // Don't implement the tests below;
    //     They are presented as talking points.
//
//    @Test
//    public void size_ReturnsZeroWhenEmpty() {
//        int expectation = 0;
//        Set<Integer> set = new Set();
//
//        int size = set.size();
//
//        assertTrue(size == expectation);
//    }
//
//    @Test
//    public void size_ReturnsOneWhenAddedOnce() {
//        int expectation = 1;
//        Set<Integer> set = new Set();
//        set.add(321);
//
//        int size = set.size();
//
//        assertTrue(size == expectation);
//    }
//
//    @Test
//    public void size_ReturnsTwoWhenAddedTwice() {
//        int expectation = 2;
//        Set<Integer> set = new Set();
//        set.add(321);
//        set.add(321);
//
//        int size = set.size();
//
//        assertTrue(size == expectation);
//    }
//
//    @Test
//    public void size_SetsDontAcknowledgeDuplicates() {
//        int expectation = 1;
//        Set<Integer> set = new Set();
//        set.add(321);
//        set.add(321);
//
//        int size = set.size();
//
//        assertTrue(size == expectation);
//    }

    //Talking point: Can "size_ReturnsTwoWhenAddedTwice" and
    //    "size_SetsDontAcknowledgeDuplicates" both pass?
}
