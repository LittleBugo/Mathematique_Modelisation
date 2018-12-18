package langModel;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Set;
import java.util.TreeSet;

public class VocabularyTest {
	
	Vocabulary vocab;
	
	@Before
	public void setUp()
	{
		vocab = new Vocabulary();
		
	}
	
	@Test
	public void testConstructeur()
	{
		Vocabulary vocab=null;
		vocab = new Vocabulary();
		assertNotNull("Vocabulaire créé", vocab);
	}
	
	@Test
	public void testsize1()
	{
		assertEquals(0, vocab.getSize());
	}
	
	@Test
	public void testaddWord1()
	{
		vocab.addWord("Congolexicomatisation");
		assertEquals(1, vocab.getSize());
	}
	
	@Test
	public void testaddWord2()
	{
		vocab.addWord("Nucléarisation");
		vocab.addWord("Anticonstitutionnellement");
		assertEquals(2, vocab.getSize());
	}
	
	@Test
	public void testaddWord3()
	{
		vocab.addWord("Nucléarisation");
		vocab.addWord("Nucléarisation");
		assertEquals(1, vocab.getSize());
	}
	
	@Test
	public void testGetWords()
	{
		vocab.addWord("z");
		vocab.addWord("a");
		Set<String> tab = new TreeSet<String>();
		tab.add("z");
		tab.add("a");
		assertEquals(tab, vocab.getWords());
	}
	
	@Test 
	public void testContains()
	{
		
	}

}
