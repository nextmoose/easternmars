package com.componentwise.eval;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    public void testHappy(){
        assertTrue(new UserKey("a", "b").equals(new UserKey("a", "b")));
    }
    
    public void testNameNotEqual(){
        assertFalse(new UserKey("a", "b").equals(new UserKey("b", "b")));
    }
    
    public void testNameNull1(){
        assertFalse(new UserKey(null, "b").equals(new UserKey("a", "b")));
    }
    
    public void testOtherIsNotUserKey(){
        assertFalse(new UserKey("a", "b").equals("Hello World"));
    }
}
