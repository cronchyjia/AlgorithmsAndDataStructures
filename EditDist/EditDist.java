// number operations to convert str1 to str2
// First need to compile it in terminal: 
		//javac EditDist.java
// In order to run it in terminal: 
		//java EditDist str1 str2
class EditDist {
	static int min(int x, int y, int z)
	{
		if (x <= y && x <= z)
			return x;
		if (y <= x && y <= z)
			return y;
		else
			return z;
	}

	static int editDistDP(String str1, String str2, int m,
						int n)
	{
		// Create a table to store results of subproblems
		int D[][] = new int[m + 1][n + 1];

		//TODO fill matrix D 
			//1. Find the base subproblems: D[i][0] and D[0][j]
		for(int i = 0; i < m+1; i++){
			D[i][0] = i;
		}
		for(int i = 0; i < n+1; i++){
			D[0][i] = i;
		}
		
			//2. Update matrix D for bigger subproblems.
				//2.1 If their last characters are the same.
				//2.2 If their last characters are different
				
		for(int i = 1; i < m+1; i++){
			for(int j = 1; j < n+1; j++){
				int insert = D[i][j-1]+1;
				int delete = D[i-1][j]+1;
				int replace = str1.charAt(i-1) == str2.charAt(j-1) ? 
					D[i-1][j-1] :
					D[i-1][j-1]+1; 
				
				D[i][j] = min(insert, delete, replace);
			}
		}

		return D[m][n];
	}

	public static void main(String args[])
	{

		String str1 = args[0];
		String str2 = args[1];
		System.out.println(editDistDP(
			str1, str2, str1.length(), str2.length()));
	}
} 

