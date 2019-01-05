package langModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class LaplaceLanguageModelTest {

    private NaiveLanguageModel naive;

    @Before
    public void setUp()
    {
        System.out.println("=== Before - setUp =====================");
        this.naive = new NaiveLanguageModel();
    }

    @Test
    public void testGetNgram()
    {
        langModel.NaiveLanguageModel naiv = new langModel.NaiveLanguageModel();
        //TODO : enlever le java.util.OptionalDouble.of
        assertEquals(java.util.OptionalDouble.of(1/7), this.naive.getNgramProb("Antoine"));
    }

    @Rule
    public TestName name = new TestName();

    @Before
    public void printSeparator()
    {
        System.out.println("\n=== " + name.getMethodName() + " =====================");
    }
}
