import java.util.*;
import java.io.*;

public class A1 {
	
	// public static int[][] generate_neighbours(int[][] curr_state){
	// 	int[][] temp=curr_state;

	// }
	double[][] dis_bw_papers;
	public static double getgoodness(int[][][] schedule){
		return(null);
	}
	// private static saveState(...){

	// }
	private static getDistance(int i,int j){

	}
	public static double get_p_goodness(int[][] schedule_in_a_timeSlot,int c_trade_off){
		double goodness=0;
		for (int i=0;i<schedule_in_a_timeSlot.length;i++) {
			for(int j=0;j<schedule_in_a_timeSlot[0].length-1;j++){
				goodness+=getDistance(schedule_in_a_timeSlot[i][j],schedule_in_a_timeSlot[i][j+1]);
			}
		}
		double term2=0;
		for (int i=0;i<schedule_in_a_timeSlot.length;i++) {
			for(int j=0;j<schedule_in_a_timeSlot[0].length;j++){
				for (int k=i+1;k<schedule_in_a_timeSlot.length ;k++ ) {
					for (int l=0;l<schedule_in_a_timeSlot[0].length ;l++) {
						term2+=getDistance(schedule_in_a_timeSlot[i][j],schedule_in_a_timeSlot[k][l]);
					}
				}
			}
		}
			
	}

	public static int[][][] randomState(int p,int k,int t){
		int[][][] a=new int[t][p][k];
		Random rand=new Random();
		int r_int=0;
		int[] random_arr=new int[t*p*k];
		for (int i=0;i<t*p*k;i++){
			random_arr[i]=(i+1);
		}
		for(int i=0;i<t*p*k;i++){
			int f=rand.nextInt(p*t*k);
			int s=rand.nextInt(p*t*k);
			int temp=random_arr[f];
			random_arr[f]=random_arr[s];
			random_arr[s]=temp;

		}
		int count=0;
		for(int i=0;i<t;i++){
			for (int j=0;j<p;j++) {
				for (int z=0;z<k;z++) {
					a[i][j][z]=random_arr[count];
					count++;
				}
				
			}
		}
		return(a);
	}
	public static void printState(int[][][] a){
		for (int i=0;i<a.length ;i++ ) {
			for (int j=0;j<a[0].length;j++) {
				for (int k=0;k<a[0][0].length;k++) {
					System.out.print(a[i][j][k]+" ");
				}
				if(j!=a[0].length-1)
					System.out.print("|");
			}
			System.out.println();
			
		}
	}
	public static int[][] partial_local_search(int[][] initial_state,int c_trade_off){
		return null;
	}
	public static localSearch(int t,int p, int k,int c_trade_off){
		int[][][] initial_state=randomState(p,t,k);
		int[][][] result=new int[t][p][k];
		double max_goodness=-100000;
		while(true){//terminate when time's up
			initial_state=randomState(p,t,k);
			for(int i=0;i<initial_state.length;i++){
				result[i]=partial_local_search(initial_state[i]);
			}
			double temp=getgoodness(result);
			if(temp>max_goodness)
				max_goodness=temp;
			//restarting
		}
	}
	public static void main(String[] args) {
		Scanner scn =new Scanner(System.in);
		int max_time=scn.nextInt();
		int paper_per_sess=scn.nextInt();
		int no_of_sess=scn.nextInt();
		int time_slots=scn.nextInt();
		int c_trade_off=scn.nextInt();
		int n=paper_per_sess*time_slots*no_of_sess;
		dis_bw_papers=new double[n+1][n+1];
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				dis_bw_papers[i][j]=scn.nextDouble();
			}
		}		
		int[][][] goal=localSearch(t,p,k,c_trade_off);
		printState(goal);
	}
}