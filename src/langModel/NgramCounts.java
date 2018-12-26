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
		this.order=2;
		Scanner scan = null;
		File file = new File(fichier);
		List listeDeNgram = new ArrayList();
		Set encoreUneListe = new TreeSet();
		this.ngramCounts = new HashMap<String,Integer>();
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		if(scan!=null)
		{
			while(scan.hasNext())
			{
				listeDeNgram.add(NgramUtils.generateNgrams(scan.nextLine(), 1, this.order));
				encoreUneListe.add(NgramUtils.decomposeIntoNgrams(scan.nextLine(),1));

			}
		}

		for(int i=0; i < listeDeNgram.size(); i++)
		{
			String nGramActuel = listeDeNgram.get(i).toString();
			char[] niemeListe = listeDeNgram.get(i).toString().toCharArray();

			if(this.ngramCounts.containsKey(listeDeNgram.get(i)))
			{
				this.ngramCounts.replace(nGramActuel, this.ngramCounts.get(nGramActuel), this.ngramCounts.get(nGramActuel)+1 );
			}
			else
			{
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
	private void setMaximalOrder (int order) {
		this.order=order;
	}

	
	@Override
	public int getMaximalOrder() {
		return this.order;
	}

	
	@Override
	public int getNgramCounterSize() {
		return this.ngramCounts.size();
	}

	
	@Override
	public int getTotalWordNumber(){
		return this.nbWordsTotal;
	}
	
	
	@Override
	public Set<String> getNgrams() {
		return this.ngramCounts.keySet();
	}

	
	@Override
	public int getCounts(String ngram) {
		return this.ngramCounts.get(ngram);
	}
	

	@Override
	public void incCounts(String ngram) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void setCounts(String ngram, int counts) {
		this.ngramCounts.replace(ngram, this.ngramCounts.get(ngram), counts);
	}


	@Override
	public void scanTextFile(String filePath, VocabularyInterface vocab, int maximalOrder) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
	}

}
