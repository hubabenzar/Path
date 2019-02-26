/*
Course:			COMP 124
Lecturer:		DR Russel Martin
Title:			Assignment 3 - Graph
Name: 			Huba Ferenc Benzar
Student ID:		201262833
Email:			H.Benzar@student.Liverpool.ac.uk
Deadline: 		27/04/2018 - 1700
*/
import java.util.*;
abstract class Graph {
	//Initialising public abstract and public methods
	public abstract void setNegative();
	public abstract void Trial();
	public abstract int RNGVertex();
	protected boolean negative;
	protected int[] vertexArray;
	protected int vertexTrack;
	//Print Result
	public abstract void result(int trial, double avrg);
	
	public Graph(int vertexTrack, boolean negative){
		//extending the current object into methods and setting it
		this.vertexTrack = vertexTrack;
		this.vertexArray = new int[vertexTrack];
		this.negative = negative;
		//current object extends Default
		this.Default();
	}
	public void Default(){
		//for i is smaller than vertexCount i increments
		//Then the current object extends vertexArray index i is set to 1
		for (int i = 0; i < vertexTrack; i++){
			this.vertexArray[i] = 1;
		}
		//the current object extends setNegative
		this.setNegative();
	}
	public boolean Check(){
		//check whether all vertexArray are 1
		//Checking if all vertexArray are 1
		//By default positive is true
		boolean positive = true;
		//for i is smaller than the current object that extends extends vertexArray index i increments
		for (int i = 0; i < this.vertexArray.length; i++){
			//if the index is not 1 then positive turns false.
			if (this.vertexArray[i] != 1){
				positive = false;
			}
		}
		//Return positive
		return positive;
	}
	public int start(){
		//While not check Trial gets called and step increments
		int step = 0;
		//while not check the current object extends Trial and step increments
		while (!(Check())){
			this.Trial();
			step++;
		}
		//this object extends default and returns the step count
		this.Default();
		return step;
	}
}