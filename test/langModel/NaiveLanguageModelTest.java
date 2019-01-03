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
    public void testGetLMOrder()
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

    /**
     * Test de probabilité lorsque le ngram n'existe pas dans le NgramCounts
     */
    @Test
    public void testGetNgramProb1()
    {
        NaiveLanguageModel nv = new NaiveLanguageModel();
        //TODO regler le soucis qu'il y a sur la ligne du dessous. (enlever le java.util.Optionnel.of
        assertEquals(nv, this.naive.getNgramProb("Dua Lipa"));
    }

    /**
     * Test de probabilité lorsque le ngram existe dans le NgramCounts
     */
    @Test
    public void testGetNgramProb2()
    {
        langModel.NaiveLanguageModel naiv = new langModel.NaiveLanguageModel();
        //TODO idem qu'au dessus je sais pas pourquoi faut mettre ça...
        assertEquals(java.util.Optional.of(1/7), naive.getNgramProb("Antoine"));
    }
}
