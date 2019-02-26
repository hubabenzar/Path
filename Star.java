/*
Course:			COMP 124
Lecturer:		DR Russel Martin
Title:			Assignment 3 - Star
Name: 			Huba Ferenc Benzar
Student ID:		201262833
Email:			H.Benzar@student.Liverpool.ac.uk
Deadline: 		27/04/2018 - 1700
*/
public class Star extends Graph{
	//Path sets vertexTrack, negative to a super.
	public Star(int vertexTrack, boolean negative){
		super(vertexTrack, negative);
	}
	//choose a random vertex and compare it with the one in the centre
	public void Trial(){
		//RNGVertex class is set as RNGVertex
		//OppositeVertex is 0
		int RNGVertex = RNGVertex();
		int OppositeVertex = 0;
		//result gets set as vertexArray index RNGVertex multiplied by vertexArray index OppositeVertex
		//multiply the values which is equal to results of them
		int result = vertexArray[RNGVertex] * vertexArray[OppositeVertex];
		//Both indexes used before get set as the result
		vertexArray[RNGVertex] = result;
		vertexArray[OppositeVertex] = result;
	}
	public void setNegative(){
		//if the current object extends negative
		//then current object vertexArray index 0 is -1
		//Otherwise current object vertexArray index 1 is set to -1
		if(this.negative){
			this.vertexArray[0] = -1;
		}
		else{
			this.vertexArray[1] = -1;
		}
	}
	public int RNGVertex(){
		//+ 1 RNGVertex -1 gets set by an RNG
		return (1 + (int)((vertexTrack-1)*Math.random()));
	}
	public void result(int trials, double average){
		//Printing out results
		if(negative){
			System.out.println("Question to Consider");
			System.out.println("Star of size "+vertexTrack+" ("+trials+" trials) with one starting -1 values: "+average);
		}
		else{
			System.out.println("Star of size "+vertexTrack+" ("+trials+" trials) with two starting -1 value: "+average);
			System.out.println();
		}
	}
}