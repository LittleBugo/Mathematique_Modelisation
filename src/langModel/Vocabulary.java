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
	
	
	@Override
	public int getSize() {
		return this.vocabulary.size();
	}

	@Override
	public Set<String> getWords() {
		return this.vocabulary;
	}

	@Override
	public boolean contains(String word) {
		return this.vocabulary.contains(word);
	}

	@Override
	public void addWord(String word) {
		this.vocabulary.add(word);

	}

	@Override
	public void removeWord(String word) {
		this.vocabulary.remove(word);
		
	}

	@Override
	public void scanNgramSet(Set<String> ngramSet) {
		for (String ngram : ngramSet)
		{
			this.vocabulary.add(ngram);
		}
	}

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
