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
    public void testGetLMOrder1()
    {
        assertEquals(2, naive.getLMOrder());
    }

    @Test
    public void testSetNgramCounts()
    {
        NgramCounts nn = new NgramCounts("data/small_corpus/corpus_fr_train.txt");
        Vocabulary v = new Vocabulary();
        assertEquals(7, naive.ngramCounts.getTotalWordNumber());
        naive.setNgramCounts(nn, v);
        assertEquals(12, naive.ngramCounts.getTotalWordNumber());
    }
}
