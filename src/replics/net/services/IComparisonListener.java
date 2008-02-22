package replics.net.services;

/**
 * 
 * @author Virginie
 *
 */
public interface IComparisonListener {

	/**
	 * Collect results from comparisons 
	 * @param comparisonEvent
	 */
	public void notifyComparisonResults(IComparisonEvent comparisonEvent);
	
}
