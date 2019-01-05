package langModel;


/**
 * Class NaiveLanguageModel: class implementing the interface LanguageModelInterface by creating a naive language model,
 * i.e. a n-gram language model with no smoothing.
 * 
 * @author ... (2017)
 *
 */
public class NaiveLanguageModel implements LanguageModelInterface {
	/**
	 * The NgramCountsInterface corresponding to the language model.
	 */
	protected NgramCountsInterface ngramCounts;
	
	/**
	 * The vocabulary of the language model.
	 */
	protected VocabularyInterface vocabulary;
	
	/**
	 * Constructor.
	 */
	public NaiveLanguageModel(){
		this.ngramCounts = new NgramCounts();
		this.vocabulary = new Vocabulary();
		this.vocabulary.readVocabularyFile("src/langModel/Test.txt");
	}

	@Override
	public int getLMOrder() {
		return ngramCounts.getMaximalOrder();
	}

	@Override
	public void setNgramCounts(NgramCountsInterface ngramCounts, VocabularyInterface vocab) {
		this.vocabulary = vocab;
		this.ngramCounts = ngramCounts;
	}

	@Override
	public Double getNgramProb(String ngram) {
		// TODO A revoir je crois que ce n'est pas bon
		//prend le total des ngramCounts
		double nombreTotal = 0.0;
		//Si le ngram n'est pas dans le ngramcounts alors on renvoit 0
		if(ngramCounts.getCounts(ngram) == 0) {
			return nombreTotal;
		} else {
			//Parcours de tous les ngrams
			for (String ngramm : ngramCounts.getNgrams())
			{
				//ajoute les comptes
				nombreTotal += ngramCounts.getCounts(ngramm);
			}
			//retourne le nombre d'apparition du ngram en paramètre divisé par le nombre total d'occurences.
			return (ngramCounts.getCounts(ngram)/nombreTotal);
		}
	}

	@Override
	public Double getSentenceProb(String sentence) {
		int nombreDeNgrams=0;
		double probabiliteTotal=0;
		for (String ngram : NgramUtils.generateNgrams(sentence, 1, ngramCounts.getMaximalOrder()))
		{
			probabiliteTotal+=this.getNgramProb(ngram);
			nombreDeNgrams++;
		}
		return probabiliteTotal/nombreDeNgrams;
	}

}
