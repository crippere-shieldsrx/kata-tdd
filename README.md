# kata-tdd
Set java code and tests towards a Kata on TDD

Set Operations: Add, Contains, Union, Intersect

##Philosophy and Preamble   
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


###Remember: "Red, Green, Refactor"

####Red: (Write and) Run -a- test and see it fail.
(Is the test failing for the right reasons?)
Write just enough code, retesting often...
    
####Green: ...to just get the one test to pass.
Run all the other green tests and keep those other tests passing.
    
####Refactor: Go back, clean up your code, move it around, and make it better, all while seeing your tests stay green.

Don't write code that doesn't help make a test pass now.
    "But I know we're going to need it!"
...then wait until you **do** need it (and have a test for it) before you write it.

This kata is about when and how to make tests pass, where the tests are being
    provided for the kata.  **Writing** good tests is another topic and another
    kata.  "Should this feature be tested for in an extension of an existing
    test, or in a fresh test of its own?  Should this test be at the
    service- or controller-level, in a journey/integration test, or all three?
    Should I test for this edge case, such as what if someone does something weird?
    Should I include tests of the negative?  Do I need to test this at all?"
    Those questions and this discussion is out-of-scope for this kata.
  
## Instructions   
Make the tests pass.

I've been running the tests within my IDE, IntelliJ, rather than trying 
to build and run the whole project.  Your mileage may vary.
    
Don't alter the tests themselves.

### Recommendation:
Comment out all of the tests, uncomment and RedGreenRefactor them
        one at time, and work them in the order presented.
       
For this kata, write your Set.java code in order; when you create a new method
        or attribute, add it below your existing code.  Edit methods where they are.
        I would normally suggest that attributes start the class, followed by
        constructors, public methods, and then private methods.  This "as you
        write it" ordering though shows to you the order of your work.  (We will
        not ask people to pass in their work at the end of the kata.)

    
   
