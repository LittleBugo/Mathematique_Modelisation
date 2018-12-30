package langModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class NaiveLanguageModelTest {

    private NaiveLanguageModel naive;
    @Before
    public void setUp()
    {
        this.naive = new NaiveLanguageModel();
    }

    /**
     * Test sur le getLMOrder
     */
    @Test
    public void getLMOrderTest1()
    {
        assertEquals(2, naive.getLMOrder());
    }


}
