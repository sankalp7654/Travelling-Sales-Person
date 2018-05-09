package temp;

import java.util.Scanner;

public class Hamiltonian {
	
	static int n, flag = 0;
	static int adj[][] = new int[10][10];
	static int x[] = new int[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		n = sc.nextInt();
		
		System.out.println("Enter the adjacency matrix");
		for(int i=1; i<=n; i++) 
			for(int j=1; j<=n; j++)
				adj[i][j] = sc.nextInt();
		
		x[1] = 1;
		hamiltonian(2);
		
		if(flag == 0)
			System.out.println("No hamiltonian cycles present for the given graph");
		
		
	}
	
	static void hamiltonian(int k) {
		do 
		{
			NextValue(k);
			if(x[k] == 0)
				return;
			
			if(k == n) {
				flag =1;
				System.out.println("The hamiltonian cycle is ");
				
				for(int i = 1; i<=n ;i++) 
					System.out.print(x[i] + " ");
				
				System.out.print("1 \n");
				
			}
			else
				hamiltonian(k+1);
		}while(true);
	}
	
	static void NextValue(int k) {
		int j ;
		
		do{
			x[k] = (x[k] + 1) % (n+1);
			
			if(x[k]==0)
				return;
			
			if(adj[x[k-1]][x[k]] == 1)
			{
				for(j = 1; j<=k-1; j++)
					if(x[j] == x[k])
						break;
				
				if(k == j)
					if((k<n) || ((k ==n) && (adj[x[n]][x[1]] == 1)))
						return;
			}
		}while(true);
	}
}
