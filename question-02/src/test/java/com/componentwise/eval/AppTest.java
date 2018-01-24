package com.componentwise.eval;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    
    private final UserKey b1 = new UserKey("Bill Smith", "BSMITH");
    private final UserKey b2 = new UserKey("Bill Smith", "BSMITH");
    private final UserKey b3 = new UserKey("Susan Smith", "SSMITH");
    private final UserKey b4 = new UserKey(null,null);
    
    public void testPrompt1(){
        assertTrue(b1.equals(b1));
    }
    
    public void testPrompt2(){
        assertTrue(b1.equals(b2));
    }
    
    public void testPrompt3(){
        assertFalse(b1.equals(b3));
    }
    
    public void testPrompt4(){
        assertFalse(b1.equals(null));
    }
    
    public void testPrompt5(){
        assertFalse(b1.equals("Some String"));
    }
    
    public void testPrompt6(){
        assertTrue(b1.equals(b1));
    }
}
