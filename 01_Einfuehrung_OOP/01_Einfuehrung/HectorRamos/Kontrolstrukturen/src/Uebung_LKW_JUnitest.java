import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.JUnit4TestAdapter;
          
public class JUnitest {
    @Before
    public void setUp(){
        
    }
    @Test
    public void execute(){
        float seite = 2.0f;
        float flache = seite * seite;
        assertEquals(5,0, flache);
    }
    @After
    public void after(){
    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run( new JUnit4TestAdapter(JUnitest.class) );
        
    }
}
