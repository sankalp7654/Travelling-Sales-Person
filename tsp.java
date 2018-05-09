package temp;

import java.util.Scanner;

public class tsp {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number od cities");
		int n=sc.nextInt();
		
		int cost[][]=new int[n+1][n+1];
		int s[] = new int[n+1];
		
		System.out.println("enter the cost adjacency matrix");
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++)
				cost[i][j]=sc.nextInt();
			s[i] = 1;
		}
		
		int a = g(1, n-1, cost, s, n);
		
		System.out.println("The minimum cost of optimal tour is " + a);
		
		int b = approx(cost, n);
		int approx_val = ((b +100)/a) - 100;
		System.out.println("The approximation tour is " + approx_val);
		
		
		for(int i : s ) {
			System.out.println(i + " ");
		}
	}

	static int g(int i, int s, int cost[][], int set[] , int n) {
		int new_set [] = new int[n+1];
		int selected [] = new int[n+1];
		
		for(int j =1; j<=n; j++) 
			new_set[j] = set[j];
		new_set[i] = 0;
		
		if(s == 0) 
			return cost[i][1];
		
		for(int k=0, j=2; k<s; j++) {
			if(new_set[j] != 0)
			{
				selected[k] = cost[i][j] + g(j, s-1, cost, new_set, n);
				k++;
			}
		}
		
		int min = 999;
		for(int j=0; j<s;j++) {
			if(selected[j] < min) {
				min = selected[j];
			}
		}
		return min;
	}
	
	static int approx(int cost[][], int n) {
		int visited[] = new int[n+1];
		
		for(int i=1; i<=n; i++) {
			visited[i] = 0;
		}
		
		visited[1] = 1;      //////////
		int dist=0;
		int next =0;
		int min =999;
		
		for(int i = 1; i<n ; i++)
		{
			for(int j=1; j<=n; j++ )
			{
				if((cost[i][j]!=0) && (cost[i][j]< min) && (visited[j] == 0))
				{
					next = j;
					min = cost[i][j];
				}
			}
			dist = dist + min;
			visited[next] = 1;
		}
		dist = dist + cost[next][1];

	//	System.out.println("Minimum cost using approximnation algorithm is " + dist );
		return dist;
	
	}


}

