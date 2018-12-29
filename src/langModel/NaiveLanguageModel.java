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
		// TODO Je ne sais pas ce que c'est
		return 0;
	}

	@Override
	public void setNgramCounts(NgramCountsInterface ngramCounts, VocabularyInterface vocab) {
		this.vocabulary = vocab;
		this.ngramCounts = ngramCounts;
	}

	@Override
	public Double getNgramProb(String ngram) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double getSentenceProb(String sentence) {
		// TODO Auto-generated method stub
		return null;
	}

}
