// public class Percolation {
//    public Percolation(int n)                // create n-by-n grid, with all sites blocked
//    public    void open(int row, int col)    // open site (row, col) if it is not open already
//    public boolean isOpen(int row, int col)  // is site (row, col) open?
//    public boolean isFull(int row, int col)  // is site (row, col) full?
//    public     int numberOfOpenSites()       // number of open sites
//    public boolean percolates()              // does the system percolate?
// }


// You can implement the above API to solve the problem
// public class Percolation {
// 	public boolean[][] grid;
// 	public int gridSize;
// 	int count = 0;
// 	public WeightedQuickUnionUF uf;

// 	public Percolation(int N) {
// 		gridSize = N;
// 		grid = new boolean[N][N];
// 		for (int i = 1; i <= gridSize; i++) {
// 			for (int j = 1; j <= gridSize; j++) {
// 				grid[i][j] = false;
// 			}
// 		}
// 	}

// 	public boolean isOpen(int row, int col) {
// 		return grid[row][col];
// 	}

// 	public void open(int row, int col) {
// 		if (isOpen(row, col) == false) {
// 			grid[row][col] = true;
// 			count += 1;
// 		}
// 	}

// 	public int numberOfOpenSites() {
// 		return count;
// 	}
// 	}

























import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.nextLine());
		percolate obj = new percolate(input);
		while(sc.hasNextLine()){
			String[] inputs = sc.nextLine().split(" ");
			obj.open(Integer.parseInt(inputs[0])-1, Integer.parseInt(inputs[1])-1);
		}
		System.out.println(obj.ispercolate());
	}

}

class percolate{
	boolean[][] grid;
	WeightedQuickUnionUF obj;
	int size;
	percolate(int size){
		this.size = size;
		grid = new boolean[size][size];
		obj = new WeightedQuickUnionUF(size * size + 2);
	}
	public void open(int row, int column){
		if(grid[row][column]){
			return;
		}
		grid[row][column] = true;
		if(row == 0){
			obj.union(convert(row,column), size*size);
		}
		if(row == size-1){
			obj.union(convert(row, column), size*size+1);
		}
		if(row < size - 1 && grid[row+1][column]){ //bottom element
			obj.union(convert(row,column), convert(row+1, column));
		}
		if(row > 0 && grid[row-1][column]){ //top element
			obj.union(convert(row,column), convert(row-1, column));
		}
		if(column > 0 && grid[row][column-1]){ //left element
			obj.union(convert(row,column), convert(row, column-1));
		}
		if(column < size - 1 && grid[row][column+1]){ //right element
			obj.union(convert(row,column), convert(row, column+1));
		}


	}
	public boolean ispercolate(){
		return obj.connected(size * size, size*size+1);
	}

	public int convert(int i, int j){
		return i * size + j;
	}
}

