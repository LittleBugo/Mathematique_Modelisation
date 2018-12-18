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
	public void testContains1()
	{
		vocab.addWord("Nucléarisation");
		vocab.addWord("Anticonstitutionnellement");
		assertTrue(vocab.contains("Anticonstitutionnellement"));
	}

	@Test
	public void testContains2()
	{
		vocab.addWord("Nucléarisation");
		vocab.addWord("Anticonstitutionnellement");
		assertFalse(vocab.contains("Terrrrrrrible"));
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
	public void testRemoveWord()
	{
		vocab.addWord("Nucléarisation");
		vocab.addWord("Anticonstitutionnellement");
		vocab.removeWord("Anticonstitutionnellement");
		assertEquals(1, vocab.getSize());
	}

	@Test
	public void testScanNgramSet()
	{
		Set<String> ngram = new TreeSet<String>();
		ngram.add("Malcolm");
		ngram.add("Hall");
		ngram.add("Reeze");
		vocab.addWord("Loïs");
		vocab.scanNgramSet(ngram);
		assertTrue(vocab.contains("Malcolm"));
		assertTrue(vocab.contains("Hall"));
		assertTrue(vocab.contains("Reeze"));
		assertTrue(vocab.contains("Loïs"));
		assertFalse(vocab.contains("Francis"));

	}

	@Test
	public void testReadVocabularyFile()
	{
		vocab.readVocabularyFile("src/langModel/Test.txt");
		assertTrue(vocab.contains("antoine"));
	}

	@Test
	public void testWriteVocabularyFile()
	{
		Vocabulary voc = new Vocabulary();
		vocab.addWord("Eddy-Malou");
		vocab.writeVocabularyFile("src/langModel/Test.txt");

		voc.readVocabularyFile("src/langModel/Test.txt");

		assertTrue(voc.contains("antoine"));
		assertTrue(voc.contains("Eddy-Malou"));
		//Test de PUSH

	}

}
