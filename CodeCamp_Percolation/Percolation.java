import java.util.*;

public class Percolation {
	public boolean[][] grid;
	public int size;
	//int count = 0;
	public WeightedQuickUnionUF obj;

	public Percolation(int size) {
		this.size = size;
		grid = new boolean[size][size];
		// for (int i = 1; i <= gridSize; i++) {
		// 	for (int j = 1; j <= gridSize; j++) {
		// 		grid[i][j] = false;
		// 	}
		// }
		obj = new WeightedQuickUnionUF(size * size + 2);
	}

	public boolean isOpen(int row, int col) {
		return grid[row][col];
	}

	public void open(int row, int col) {
		if (isOpen(row, col) == false) {
			grid[row][col] = true;
			//count += 1;
		}
		grid[row][col] = true;
		if(row == 0){
			obj.union(convert(row,col), size*size);
		}
		if(row == size-1){
			obj.union(convert(row, col), size*size+1);
		}
		if(row < size - 1 && grid[row+1][col]){ //bottom element
			obj.union(convert(row,col), convert(row+1, col));
		}
		if(row > 0 && grid[row-1][col]){ //top element
			obj.union(convert(row,col), convert(row-1, col));
		}
		if(col > 0 && grid[row][col-1]){ //left element
			obj.union(convert(row,col), convert(row, col-1));
		}
		if(col < size - 1 && grid[row][col+1]){ //right element
			obj.union(convert(row,col), convert(row, col+1));
		}


	}
	public boolean ispercolate(){
		return obj.connected(size * size, size*size+1);
	}

	public int convert(int i, int j){
		return i * size + j;
	}
	// public int numberOfOpenSites() {
	// 	return count;
	// }
}
