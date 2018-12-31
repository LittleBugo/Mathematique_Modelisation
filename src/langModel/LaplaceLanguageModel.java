package langModel;


/**
 * Class LaplaceLanguageModel: class inheriting the class NaiveLanguageModel by creating 
 * a n-gram language model using a Laplace smoothing.
 * 
 * @author ... (2017)
 *
 */
public class LaplaceLanguageModel extends NaiveLanguageModel {

	@Override
	public Double getNgramProb(String ngram) {
		double nombreTotal=0.0; 			//prend le total des ngramCounts
		if(ngramCounts.getCounts(ngram)==0) //Si le ngram n'est pas dans le ngramcounts alors on renvoit 0
			return 0.0;
		else
		{
			for (String ngramm : ngramCounts.getNgrams()) //Parcours de tous les ngrams
			{
				nombreTotal += ngramCounts.getCounts(ngramm); //ajoute les comptes
			}
			return ((ngramCounts.getCounts(ngram)+1)/nombreTotal); //Equation du cours il manque + |V|
		}
	}
}
