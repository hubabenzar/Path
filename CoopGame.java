/*
Course:			COMP 124
Lecturer:		DR Russel Martin
Title:			Assignment 3 - CoopGame
Name: 			Huba Ferenc Benzar
Student ID:		201262833
Email:			H.Benzar@student.Liverpool.ac.uk
Deadline: 		27/04/2018 - 1700
*/
public class CoopGame {
	//Initialising arrays
	Graph[] games;
	double[] average;
	//Start of Main Method
	public static void main(String[] args) {
		//Initialising and setting vatiables
		int vertexTrack;
		int trials = 2000;
		int lowest = 1;
		int highest = 5000;
		int minVertices = 3;
		
		//Message if there is no input
		if(args.length < 1){
			System.out.println("	Usage: java CoopGame n [trials]");
			System.out.println("	n = number of vertices");
			System.out.println("	trials = number of trials (optional, defaults to "+trials+")");
		}
		else{
			try{
				vertexTrack = Integer.parseInt(args[0]);
				//if there are two parameters
				if (args.length > 1){
					trials = Integer.parseInt(args[1]);
				}
				//Error Message if criteria not met
				if (vertexTrack < 3 || (trials < 1 || trials > 5000)){
					System.out.println("	Oops, check your parameter(s). The first parameter specifies n, the number of vertices (at least "+minVertices+").");
					System.out.println("	An optional second parameter specifies the number of trials to perform (between "+lowest+" and "+highest+").");
				}
				//Otherwise the game plays out
				else{
					new CoopGame(vertexTrack, trials);
				}
			}
			//Error Message if the input is not a number
			catch (java.lang.NumberFormatException e){
				System.out.println("	Oops, check your parameter(s). The first parameter specifies n, the number of vertices (at least "+minVertices+").");
				System.out.println("	An optional second parameter specifies the number of trials to perform (between "+lowest+" and "+highest+").");
			}
		}
	}
	public CoopGame(int vertexTrack, int trials){
		//games is new array of Graph index 6
		games = new Graph[6];
		//average is new double index 6
		average = new double[6];
		
		//Initialise games limit star to 15 vertices
		int starVertices = (vertexTrack > 15 ? 15 : vertexTrack);
		games[0] = new Cycle(vertexTrack, true);
		games[1] = new Cycle(vertexTrack, false);
		games[2] = new Path(vertexTrack, true);
		games[3] = new Path(vertexTrack, false);
		games[4] = new Star(starVertices, true);
		games[5] = new Star(starVertices, false);
		
		//move trials into Start and print
		Start(trials);
		print(trials);
	}
	public void Start(int trials){
		//for i is smaller than the number of trials i increments
		for (int i = 0; i < trials; i++){
			//for j is smaller than the length of games j increments
			for (int j = 0; j < games.length; j++){
				//average index j is average index j plus games index j extend start
				average[j] += games[j].start();
			}
		}
		//for l is smaller than the length of average l increments
		for (int l = 0; l < average.length; l++){
			//average index l is average index l divided by the number of trials
			average[l] /= trials;
		}
	}
	public void print(int trials){
		//for i is smaller than the length of games i increments
		for (int i = 0; i < games.length; i++){
			//games index i extend results outputs is trials and average index i
			games[i].result(trials, average[i]);
		}
	}
}