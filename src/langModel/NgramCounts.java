package langModel;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


/**
 * Class NgramCounts: class implementing the interface NgramCountsInterface. 
 * 
 * @author N. Hernandez and S. Quiniou (2017)
 *
 */
public class NgramCounts implements NgramCountsInterface {
	/**
	 * The maximal order of the n-gram counts.
	 */
	protected int order;

	/**
	 * The map containing the counts of each n-gram.
	 */
	protected Map<String,Integer> ngramCounts;

	/**
	 * The total number of words in the corpus.
	 * In practice, the total number of words will be increased when parsing a corpus 
	 * or when parsing a NgramCountsInterface file (only if the ngram encountered is a unigram one).
	 */
	protected int nbWordsTotal;
	
	
	/**
	 * Constructor.
	 */
	public NgramCounts(String fichier){
        //Intialisation de l'order maximum
		this.order=2;
        //Initialisation du Scanner qui va parcourir le document
		Scanner scan = null;
        //Création du FILE qui est le document
		File file = new File(fichier);
        //Création du tableau qui va permettre de par la suite remplir le map
		List listeDeNgram = new ArrayList();
        //Création du tableau qui va permettre de compter le nombre de mots.
		Set encoreUneListe = new TreeSet();
        //Création de la map qui contiendra les ngram avec leurs nombre d'apparition dans le fichier
		this.ngramCounts = new HashMap<String,Integer>();

		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		if(scan != null)
		{
			while(scan.hasNextLine())
			{
				String ligne = scan.nextLine();

				for (String nGram: NgramUtils.generateNgrams(ligne, 1, this.order)){
					listeDeNgram.add(nGram);
				}
				for(String gram : NgramUtils.decomposeIntoNgrams(ligne,1))
				{
					encoreUneListe.add(gram);
				}
			}
		}

		for(int i=0; i < listeDeNgram.size(); i++)
		{
			String nGramActuel = listeDeNgram.get(i).toString();
			char[] niemeListe = listeDeNgram.get(i).toString().toCharArray();

			if(this.ngramCounts.containsKey(listeDeNgram.get(i)))
			{
				this.ngramCounts.replace(nGramActuel, this.ngramCounts.get(nGramActuel), this.ngramCounts.get(nGramActuel)+1 );
			} else {
				ngramCounts.put(nGramActuel, 1);
			}
		}
		this.nbWordsTotal= encoreUneListe.size();
	}

	public NgramCounts()
	{
		this("data/small_corpus/corpus_fr_test.txt");
	}

	/**
	 * Setter of the maximal order of the ngrams considered.
	 * 
	 * In practice, the method will be called when parsing the training corpus, 
	 * or when parsing the NgramCountsInterface file (using the maximal n-gram length encountered).
	 * 
	 * @param order the maximal order of n-grams considered.
	 */
	//C'est en privé, à voir si faut la laisser ou non en privé
	private void setMaximalOrder (int order) {
		this.order = order;
	}

	/**
	 * Getter order maximum
	 *
	 * @return int : max order possible
	 */
	@Override
	public int getMaximalOrder() {
		return this.order;
	}

	/**
	 * getter NgramCounterSize
	 * @return int : size onf the counter.
	 */
	@Override
	public int getNgramCounterSize() {
		return this.ngramCounts.size();
	}

	/**
	 * Getter of the Number total of words.
	 * @return int : nbWOrdsTotal
	 */
	@Override
	public int getTotalWordNumber(){
		return this.nbWordsTotal;
	}

	/**
	 * Getter Of all Ngram of ngramCounts
	 * @return Set : table of all keys of the map NgramCounts
	 */
	@Override
	public Set<String> getNgrams() {
		return this.ngramCounts.keySet();
	}

	/**
	 *
	 * @param ngram the n-gram to consider.
	 * @return int : number of copy of the ngram.
	 */
	@Override
	public int getCounts(String ngram) {
		if(this.ngramCounts.containsKey(ngram)){
			return this.ngramCounts.get(ngram);
		}else{
			return 0;
		}
	}

	/**
	 * Increase the number of copy of the ngram.
	 * @param ngram the n-gram whose counts is to increase.
	 */
	@Override
	public void incCounts(String ngram) {
		if(this.ngramCounts.containsKey(ngram)) {
            this.ngramCounts.replace(ngram, this.ngramCounts.get(ngram), this.ngramCounts.get(ngram) + 1);
        } else {
		    ngramCounts.put(ngram, 1);
		}
	}

	/**
	 * Set the number of copy of each ngram.
	 *
	 * @param ngram the n-gram to consider.
	 * @param counts the counts of the given n-gram.
	 */
	@Override
	public void setCounts(String ngram, int counts) {
		if(this.ngramCounts.containsKey(ngram)) {
            this.ngramCounts.replace(ngram, this.ngramCounts.get(ngram), counts);
        } else {
			ngramCounts.put(ngram, counts);
		}
	}


	@Override
	public void scanTextFile(String filePath, VocabularyInterface vocab, int maximalOrder) {
		HashMap<String, Integer> newNgramCounts = new HashMap<String, Integer>();
		for(String sentence : MiscUtils.readTextFileAsStringList(filePath))
		{
			for(String ngram: NgramUtils.generateNgrams(sentence, 1, maximalOrder))
			{
				if(vocab.contains(ngram.split(" ")[0]))
				{
					if(!newNgramCounts.containsKey(ngram))
						newNgramCounts.put(ngram, 1);
					else
					{
						newNgramCounts.replace(ngram, newNgramCounts.get(ngram)+1);
					}
				}
			}
		}
	}

	public Map<String, Integer> getNgramCounts() {
		return ngramCounts;
	}

	@Override
	public void writeNgramCountFile(String filePath) {
		NgramCounts n = new NgramCounts(filePath);
		this.ngramCounts = n.getNgramCounts();
		this.nbWordsTotal = n.getTotalWordNumber();
	}
	
	@Override
	public void readNgramCountsFile(String filePath) {

		for(String words : MiscUtils.readTextFileAsStringList(filePath))
		{
			String [] mots = words.split("\t");
			this.ngramCounts.put(mots[0], Integer.parseInt(mots[1]));
		}
	}

}
