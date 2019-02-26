//Huba Ferenc Benzar

import java.util.*;
public class Cycle extends Graph{
	//Cycle sets vertexTrack, negative to a super.
	public Cycle(int vertexTrack, boolean negative){
		super(vertexTrack, negative);
	}
	public void Trial(){
		//RNGVertex class is set as RNGVertex
		//RNGVertex +1 gets set as it's pair called OppositeVertex mod vertexTrack
		int RNGVertex = RNGVertex();
		int OppositeVertex = (RNGVertex + 1) % vertexTrack;
		//result gets set as vertexArray index RNGVertex multiplied by vertexArray index OppositeVertex
		//multiply the values which is equal to results of them
		int result = vertexArray[RNGVertex] * vertexArray[OppositeVertex];
		//Both indexes used before get set as the result
		vertexArray[RNGVertex] = result;
		vertexArray[OppositeVertex] = result;
	}
	public void setNegative(){
		//current object extends vertexArray index 0 and sets it to -1
		this.vertexArray[0] = -1;
		//if not the current object extend negative
		//then index is current object extend vertedCount -1
		//current object extend vertexArray index index is -1
		if(!(this.negative)){
			int index = this.vertexTrack / 2;
			this.vertexArray[index] = -1;
		}
	}
	public int RNGVertex(){
		//RNGVertex gets set by an RNG
		return (int)((vertexTrack)*Math.random());
	}
	public void result(int trials, double average){
		//Printing out results
		if(negative){
			System.out.println("Cycle");
			System.out.println("Cycle of size "+vertexTrack+" ("+trials+" trials) with one starting -1 values: "+average);
		}
		else{
			System.out.println("Cycle of size "+vertexTrack+" ("+trials+" trials) with two starting -1 value: "+average);
			System.out.println();
		}
	}
}
