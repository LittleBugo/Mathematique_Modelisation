package langModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe JUnit qui va tester la classe NgramCounts dans son intégralité.
 */
public class NgramCountsTest {

    private NgramCounts testCounts;
    //Attribut qui va permettre de tester les différentes modifications du Map de ngramCounts.
    private Map<String, Integer> temoin;

    /**
     * Initialisation du NgramCounts avant les tests
     */
    @Before
    public void setUp()
    {
        this.testCounts = new NgramCounts();
        this.temoin = new HashMap<String, Integer>();
        this.temoin.put("écoute une", 2);
        this.temoin.put("</s>", 2);
        this.temoin.put("<s>", 2);
        this.temoin.put("une chanson", 2);
        this.temoin.put("chanson", 2);
        this.temoin.put("<s> Lionel", 1);
        this.temoin.put("une", 2);
        this.temoin.put("<s> Antoine", 1);
        this.temoin.put("Lionel", 1);
        this.temoin.put("Lionel écoute", 1);
        this.temoin.put("écoute", 2);
        this.temoin.put("Antoine écoute", 1);
        this.temoin.put("Antoine", 1);
        this.temoin.put("chanson </s>", 2);

        //this.temoin.put("<s>", 1);
    }

    /**
     * Test du constructeur en vérifiant la valeur des attributs de l'objet.
     */
    @Test
    public void testConstructeur1()
    {
        assertEquals(testCounts.order, 2);
        assertEquals(testCounts.nbWordsTotal, 7);
        assertEquals(temoin, testCounts.ngramCounts);
    }

    /**
     * Test de l'égalité de deux NgramCounts en utilisant le même lien mais un des deux explicitement.
     */
    @Test
    public void testConstructeur2()
    {
        NgramCounts test2 = new NgramCounts("data/small_corpus/corpus_fr_test.txt");
        assertEquals(testCounts.order, test2.order);
        assertEquals(testCounts.nbWordsTotal, test2.nbWordsTotal);
        assertEquals(testCounts.ngramCounts, test2.ngramCounts);
    }

    /**
     * Test de getMaximalOrder
     */
    @Test
    public void testGetMaximalOrder()
    {
        assertEquals(testCounts.order, testCounts.getMaximalOrder());
    }

    /**
     * Test de getNgramCounterSize
     */
    @Test
    public void testGetNgramCounterSize()
    {
        assertEquals(temoin.size(), testCounts.getNgramCounterSize());
    }

    /**
     * Test de getTotalWordNumber
     */
    @Test
    public void testGetTotalWordNumber()
    {
        assertEquals(7, testCounts.getTotalWordNumber());
    }

    /**
     * Test de getNgrams
     */
    @Test
    public void testGetNgrams()
    {
        assertEquals(temoin.keySet(),testCounts.getNgrams());
    }

    /**
     * Test de getCounts (1)
     */
    @Test
    public void testGetCounts1()
    {
        assertEquals(1, testCounts.getCounts("Antoine"));
    }

    /**
     * Test de getCounts (2)
     */
    @Test
    public void testGetCounts2()
    {
        assertEquals(2, testCounts.getCounts("<s>"));
    }


    /**
     * Test de getCounts quand le ngram n'existe pas
     */
    @Test
    public void testGetCountsDoesntExist()
    {
        assertEquals(0, testCounts.getCounts("SanGoku"));
    }

    /**
     * Test de incCounts (incrémentation du nombre d'apparition d'un ngram
     * avec en paramètre un ngram qui existe.
     */
    @Test
    public void testIncCountsExist()
    {
        testCounts.incCounts("Antoine");
        assertEquals(2, testCounts.getCounts("Antoine"));
    }

    /**
     * Test de incCounts (incrémentation du nombre d'apparition d'un ngram
     * avec en paramètre un ngram qui n'existe pas.
     */
    @Test
    public void testIncCountsDoesntExist()
    {
        testCounts.incCounts("Joyca BOBO");
        assertEquals(1, testCounts.getCounts("Joyca BOBO"));
    }

    /**
     * Test de setCounts
     * avec un ngram qui existe
     */
    @Test
    public void testSetCountsExist()
    {
        testCounts.setCounts("Antoine", 12);
        assertEquals(12, testCounts.getCounts("Antoine"));
    }

    /**
     * Test de setCounts
     * avec un ngram qui n'existe pas
     */
    @Test
    public void testSetCountsDoesntExist()
    {
        testCounts.setCounts("Bruno Mars", 12);
        assertEquals(12, testCounts.getCounts("Bruno Mars"));
    }
}
