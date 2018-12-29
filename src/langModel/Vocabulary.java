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
	// set : ensemble d'objets sans doublons
	protected Set<String> vocabulary;


	/**
	 * Constructor.
	 */
	// treeset : obtenir un ensemble trié
	public Vocabulary(){
		this.vocabulary = new TreeSet<String>();
	}


	@Override
	// retourne la taille de l'ensemble
	public int getSize() {
		return this.vocabulary.size();
	}

	@Override
	// retourne les mots contenu dans l'ensemble
	public Set<String> getWords() {
		return this.vocabulary;
	}

	@Override
	// retourne si le mot est dans l'ensemble ou non
	public boolean contains(String word) {
		return this.vocabulary.contains(word);
	}

	@Override
	// ajoute un mot dans l'ensemble
	public void addWord(String word) {
		this.vocabulary.add(word);
	}

	@Override
	// supprime un mot de l'ensemble
	public void removeWord(String word) {
		this.vocabulary.remove(word);
	}

	@Override
	// analyse l'ensemble, liste les mots de chaque n-gramme puis les ajoute
	// ngramSet : l'ensemble des n-grammes dont les mots doivent être ajoutés au vocabulaire
	public void scanNgramSet(Set<String> ngramSet) {
		for (String ngram : ngramSet)
		{
			this.vocabulary.add(ngram);
		}
	}

	@Override
	// lis un fichier ayant un mot par ligne
	// filePath : le chemin du fichier contenant le vocabulaire
	public void readVocabularyFile(String filePath) {
		Scanner fichier = null;
		File essai = new File(filePath);
		try {
			fichier = new Scanner(essai);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if(fichier != null)
		{
			while(fichier.hasNextLine())
			{
				this.vocabulary.add(fichier.nextLine());
			}
		}
	}

	@Override
	// écris un mot par ligne  dans un fichier
	// filePath : le chemin du fichier contenant le vocabulaire.
	public void writeVocabularyFile(String filePath) {
		File fichier = new File(filePath);
		FileWriter writer;
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
