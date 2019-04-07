/**
 * 
 */
package com.christ.tts.ga;

/**
 * @author spallai
 * 
 *         1: generation = 0; 2: population[generation] =
 *         initializePopulation(populationSize); 3:
 *         evaluatePopulation(population[generation]); 3: While
 *         isTerminationConditionMet() == false do 4: parents =
 *         selectParents(population[generation]); 5: population[generation+1] =
 *         crossover(parents); 6: population[generation+1] =
 *         mutate(population[generation+1]); 7:
 *         evaluatePopulation(population[generation]); 8: generation++; 9: End
 *         loop;
 *
 */
public interface GeneticAlgorithm {

	public Population initPopulation(int chromosomeLength);

	public double calcFitness(Individual individual);

	public void evalPopulation(Population population);

	public Individual selectParent(Population population);

	// process in which individuals from the population trade genetic information,
	// hopefully to create a new individual which contains the best parts from its
	// parents’ genomes
	/*
	 * 1: For each individual in population: 2: newPopulation = new array; 2: If
	 * crossoverRate > random(): 3: secondParent = selectParent(); 4: offspring =
	 * crossover(individual, secondParent); 5: newPopulation.push(offspring); 6:
	 * Else: 7: newPopulation.push(individual); 8: End if 9: End loop
	 */
	public void crossoverPopulation();

	public void mutatePopulation();

	public void isTerminationConditionMet();
}
