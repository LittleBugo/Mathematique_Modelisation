package langModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * Class Vocabulary: class implementing the interface VocabularyInterface.
 * 
 * @author ... (2017)
 *
 */
public class Vocabulary implements VocabularyInterface {
	/**
	 * The set of words corresponding to the vocabulary.
	 */
	protected Set<String> vocabulary;

	
	/**
	 * Constructor.
	 */
	public Vocabulary(){
		this.vocabulary= new TreeSet<String>();
		}

	/**
	 *
	 * @return int Size of the Set Vocabulary
	 */
	@Override
	public int getSize() {
		return this.vocabulary.size();
	}

	/**
	 * @return Set return all the vocabulary
	 */
	@Override
	public Set<String> getWords() {
		return this.vocabulary;
	}

	/**
	 *
	 * @param word the word to find in the vocabulary.
	 * @return false is Vocabulary don't contain the word
	 * true if the vocabulary contains the word
	 */
	@Override
	public boolean contains(String word) {
		return this.vocabulary.contains(word);
	}

	/**
	 * Add a word in the Vocabulary
	 * @param word the word to add.
	 */
	@Override
	public void addWord(String word) {
		this.vocabulary.add(word);
	}

	/**
	 * Remove a word from the Vocabulary
	 * @param word the word to remove.
	 */
	@Override
	public void removeWord(String word) {
		this.vocabulary.remove(word);
		
	}

	/**
	 * Add a list of Words in the vocabulary from a Set
	 * @param ngramSet the set of n-grams whose words to add to the vocabulary.
	 */
	@Override
	public void scanNgramSet(Set<String> ngramSet) {
		for (String ngram : ngramSet)
		{
			this.vocabulary.add(ngram);
		}
	}

	/**
	 * Add a list of Words in the vocabulary from a file
	 * @param filePath the path of the file containing the vocabulary.
	 */
	@Override
	public void readVocabularyFile(String filePath) {
			Scanner fichier = null;
			File essai = new File(filePath);
				try {
					fichier = new Scanner(essai);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			if(fichier!=null)
			{
				while(fichier.hasNextLine())
				{
					this.vocabulary.add(fichier.nextLine());
				}
			}
	}

	/**
	 * Write the vocabulary in a file.
	 * @param filePath the path of the file which contain the vocabulary.
	 */
	@Override
	public void writeVocabularyFile(String filePath) {
		File fichier = new File(filePath);
		FileWriter writer = null;
		try {
			writer = new FileWriter(fichier);
			
			for(String mots : this.vocabulary)
			{
				writer.write(mots + "\n");
			}
			writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		
		

}
