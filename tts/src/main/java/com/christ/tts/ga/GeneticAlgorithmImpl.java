/**
 * 
 */
package com.christ.tts.ga;

/**
 * @author spallai
 *
 */
public class GeneticAlgorithmImpl implements GeneticAlgorithm{
	
	
    private int populationSize;
    private double mutationRate;
    private double crossoverRate;
    private int elitismCount;
    protected int tournamentSize;

    /**
	 * @param populationSize
	 * @param mutationRate
	 * @param crossoverRate
	 * @param elitismCount
	 * @param tournamentSize
	 */
	public GeneticAlgorithmImpl(int populationSize, double mutationRate, double crossoverRate, int elitismCount,
			int tournamentSize) {
		super();
		this.populationSize = populationSize;
		this.mutationRate = mutationRate;
		this.crossoverRate = crossoverRate;
		this.elitismCount = elitismCount;
		this.tournamentSize = tournamentSize;
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#initPopulation(int)
	 */
	@Override
	public Population initPopulation(int chromosomeLength) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#calcFitness(com.christ.tts.ga.Individual)
	 */
	@Override
	public double calcFitness(Individual individual) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#evalPopulation(com.christ.tts.ga.Population)
	 */
	@Override
	public void evalPopulation(Population population) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#selectParent(com.christ.tts.ga.Population)
	 */
	@Override
	public Individual selectParent(Population population) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#crossoverPopulation()
	 */
	@Override
	public void crossoverPopulation() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#mutatePopulation()
	 */
	@Override
	public void mutatePopulation() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.christ.tts.ga.GeneticAlgorithm#isTerminationConditionMet()
	 */
	@Override
	public void isTerminationConditionMet() {
		// TODO Auto-generated method stub
		
	}

	
}
