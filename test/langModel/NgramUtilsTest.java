package langModel;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import java.util.ArrayList;
import java.util.List;


/**
 * This JUnit Test Class has been generated by right clicking on the NgramUtils class
 * and selecting "New > Junit Test Case". After that, you have to select the methods 
 * for which you would like to generate tests. 
 * In practice, you will duplicate manually the test methods to possibly create 
 * several tests for one method.
 * 
 * Your work is then to remove the fail parts and to implement each test.
 * One method is given as an example
 * 
 * To run them:
 * either right click on the class name or simply on the method name and
 * select "Run As Junit Test".
 * 
 * @author N. Hernandez and S. Quiniou (2015)
 *
 */
public class NgramUtilsTest {
	private String sentence = "<s> cette phrase est de taille 9 . </s>";
	private String ngram = "où commence l' historique de cet n-gramme";
	
	
	/**
	 * Test method for {@link langModel.NgramUtils#getSequenceSize(java.lang.String)}.
	 */
	@Test
	public void testGetSequenceSize() {
	
		System.out.println(NgramUtils.getSequenceSize(sentence));
		// on the left the expected value and on the right the actual one 
		// (i.e. the one returned by your method)
		assertEquals(9, NgramUtils.getSequenceSize(sentence));
	}

	
	/**
	 * Test method for {@link langModel.NgramUtils#generateNgrams(java.lang.String, int, int)}.
	 * "<s> cette phrase est de taille 9 . </s>"
	 */
	@Test
	public void testGenerateNgrams() {
		List<String> temoin = new ArrayList<>();
		temoin.add("<s>");
		temoin.add("cette");
		temoin.add("phrase");
		temoin.add("est");
		temoin.add("de");
		temoin.add("taille");
		temoin.add("9");
		temoin.add(".");
		temoin.add("</s>");
		temoin.add("<s> cette");
		temoin.add("cette phrase");
		temoin.add("phrase est");
		temoin.add("est de");
		temoin.add("de taille");
		temoin.add("taille 9");
		temoin.add("9 .");
		temoin.add(". </s>");
		System.out.println(sentence.length());
		assertEquals(temoin, NgramUtils.generateNgrams(sentence,1,2));
	}

	
	/**
	 * Test method for {@link langModel.NgramUtils#getHistory(java.lang.String, int)}.
	 */
	@Test
	public void testGetHistory() {
		fail("Not yet implemented");
	}

	
	/**
	 * Test method for {@link langModel.NgramUtils#decomposeIntoNgrams(java.lang.String, int)}.
	 */
	@Test
	public void testDecomposeIntoNgrams() {
		List<String> temoin = new ArrayList<>();
		temoin.add("<s>");
		temoin.add("<s> cette");
		temoin.add("cette phrase");
		temoin.add("phrase est");
		temoin.add("est de");
		temoin.add("de taille");
		temoin.add("taille 9");
		temoin.add("9 .");
		temoin.add(". </s>");
		assertEquals(temoin, NgramUtils.decomposeIntoNgrams(sentence,2));
	}
	
	
	/**
	 * The following code displays a separator 
	 * between each method output
	 * 
	 * (manually added)
	 **/
	@Rule
	public TestName name = new TestName();

	@Before
	public void printSeparator()
	{
		System.out.println("\n=== " + name.getMethodName() + " =====================");
	}

}
