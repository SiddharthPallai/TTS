package com.christ.tts.ga;

//An Individual class, which represents a single candidate solution and its chromosome
/**
 * @author spallai
 *
 */
public class Individual {

	private int[] chromosome;
	private double fitness = -1;

	/**
	 * @param chromosome
	 */
	public Individual(int[] chromosome) {
		super();
		this.chromosome = chromosome;
	}

	/**
	 * @return the chromosome
	 */
	public int[] getChromosome() {
		return chromosome;
	}

	/**
	 * @param chromosome the chromosome to set
	 */
	public void setChromosome(int[] chromosome) {
		this.chromosome = chromosome;
	}

	/**
	 * @return the fitness
	 */
	public double getFitness() {
		return fitness;
	}

	/**
	 * @param fitness the fitness to set
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

}
