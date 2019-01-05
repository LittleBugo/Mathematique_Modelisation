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
        System.out.println("=== Before - setUp =====================");
        this.naive = new NaiveLanguageModel();
    }

    /**
     * Test sur le getLMOrder
     */
    @Test
    public void testGetLMOrder()
    {
        assertEquals(2, this.naive.getLMOrder());
    }

    @Test
    public void testSetNgramCounts()
    {
        NgramCounts nn = new NgramCounts("data/small_corpus/corpus_fr_train.txt");
        Vocabulary v = new Vocabulary();
        assertEquals(7, this.naive.ngramCounts.getTotalWordNumber());
        this.naive.setNgramCounts(nn, v);
        assertEquals(12, this.naive.ngramCounts.getTotalWordNumber());
    }

    /**
     * Test de probabilité lorsque le ngram n'existe pas dans le NgramCounts
     */
    @Test
    public void testGetNgramProb1()
    {
        //double nv = 0.0;
        //TODO : enlever le java.util.OptionalDouble.of
        assertEquals(java.util.OptionalDouble.of(0.0), this.naive.getNgramProb("Dua Lipa"));
    }

    /**
     * Test de probabilité lorsque le ngram existe dans le NgramCounts
     */
    @Test
    public void testGetNgramProb2()
    {
        langModel.NaiveLanguageModel naiv = new langModel.NaiveLanguageModel();
        //TODO : enlever le java.util.OptionalDouble.of
        assertEquals(java.util.OptionalDouble.of(1/7), naive.getNgramProb("Antoine"));
    }

    @Rule
    public TestName name = new TestName();

    @Before
    public void printSeparator()
    {
        System.out.println("\n=== " + name.getMethodName() + " =====================");
    }
}
