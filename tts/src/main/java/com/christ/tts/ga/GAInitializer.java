/**
 * 
 */
package com.christ.tts.ga;

//import com.christ.tts.model.Timetable;

/**
 * @author spallai
 *
 */
public class GAInitializer {

	/*
	 * population size = 100; mutation rate = 0.01; crossover rate = 0.95, and an elitism count of 0 (effectively disabling it – for now).
	 * After you have completed your implementation at the end of the chapter, you can experiment with how 
	 * changing these parameters affect the performance of the algorithm
	 * 
	 */
	public static void main(String[] args) {
		
		// Get a Timetable object with all the available information.
		//Timetable timetable = initializeTimetable();
		
        // Create GA object
        GeneticAlgorithm genAlgo = new GeneticAlgorithmImpl(100, 0.01, 0.9, 2, 5);
        // We’ll add a lot more here...
	}

	
}
