/***************************************************************************************
 *
 * NAME: Alyssa Higuchi
 *
 * HOMEWORK: 6
 *
 * CLASS: ICS 211
 *
 * INSTRUCTOR: Scott Robertson
 *
 * DATE: February 25, 2016
 *
 * FILE: Grid.java
 *
 * DESCRIPTION: This file contains the Grid class for homework 6. This Grid is a 2-D
 *              array which you will use to store your maze.
 *
 ***************************************************************************************/

public class Grid {
  private Cell[][] grid;
  private int rows;
  private int cols;

  /********************************************************************
	*
	* Method: Grid
	*
	* Description: Constructs a grid with the given dimensions
	*
	* @param  numRows  Contains the number of rows the grid should have
  *         numCols  Contains the number of columns the grid should have
	*
	* @return None
	*
	********************************************************************/
  public Grid(int numRows, int numCols) {
    grid = new Cell[numRows][numCols];
    rows = numRows;
    cols = numCols;

    for(int i = 0; i < numRows; i++) {
      for(int j = 0; j < numCols; j++) {
        grid[i][j] = new Cell();
        grid[i][j].setData("-");
      }
    }

    for(int i = 0; i < numRows; i++) {
      for(int j = 0; j < numCols; j++) {
        if(i == 0) {
          if(i + 1 < numRows) {
            grid[i][j].setSouth(grid[i+1][j]);
          }
        }
        else if(i == numRows - 1) {
          if(i - 1 >= 0) {
            grid[i][j].setNorth(grid[i-1][j]);
          }
        }
        else {
          grid[i][j].setNorth(grid[i-1][j]);
          grid[i][j].setSouth(grid[i+1][j]);
        }

        if(j == 0) {
          if(j + 1 < numCols) {
            grid[i][j].setEast(grid[i][j+1]);
          }
        }
        else if(j == numCols - 1) {
          if(j - 1 >= 0) {
            grid[i][j].setWest(grid[i][j-1]);
          }
        }
        else {
          grid[i][j].setEast(grid[i][j+1]);
          grid[i][j].setWest(grid[i][j-1]);
        }

        if(i == 0 && j == 0){
          if(i + 1 < numRows && j + 1 < numCols){
            grid[i][j].setSouthEast(grid[i+1][j+1]);
          }
        }
        else if(i == numRows - 1 && j == numCols - 1){
          if(i - 1 >= 0 && j - 1 >= 0){
            grid[i][j].setNorthWest(grid[i-1][j-1]);
          }
        }
        else if(i == numRows - 1 && j == 0){
          if(i - 1 >= 0 && j + 1 < numCols - 1){
            grid[i][j].setNorthEast(grid[i-1][j+1]);
          }
        }
        else if(i == 0 && j == numCols - 1){
          if(i + 1 < numRows && j - 1 < numCols){
            grid[i][j].setSouthWest(grid[i+1][j-1]);
          }
        }
        else if(j == 0){
          if(i > 0 && i < numRows - 1){
            grid[i][j].setNorthEast(grid[i-1][j+1]);
            grid[i][j].setSouthEast(grid[i+1][j+1]);
          }
        }
        else if(j == numCols - 1){
          if(i > 0 && i < numRows - 1){
            grid[i][j].setNorthWest(grid[i-1][j-1]);
            grid[i][j].setSouthWest(grid[i+1][j-1]);
          }
        }
        else if(i == 0){
          if(j > 0 && j < numCols - 1){
            grid[i][j].setSouthWest(grid[i+1][j-1]);
            grid[i][j].setSouthEast(grid[i+1][j+1]);
          }
        }
        else if(i == numRows - 1){
          if(j > 0 && j < numCols - 1){
            grid[i][j].setNorthWest(grid[i-1][j-1]);
            grid[i][j].setNorthEast(grid[i-1][j+1]);
          }
        }
        else{
          grid[i][j].setNorthEast(grid[i-1][j+1]);
          grid[i][j].setNorthWest(grid[i-1][j-1]);
          grid[i][j].setSouthEast(grid[i+1][j+1]);
          grid[i][j].setSouthWest(grid[i+1][j-1]);
        }
      }
    }
  }

  /********************************************************************
	*
	* Method: setData
	*
	* Description: Sets the data for a given cell, if it exists
	*
	* @param  row   The row that the cell is in
   *         col   The column that the cell is in
   *         data  The data that will go in the given cell
	*
	* @return None
	*
	********************************************************************/

  public void setData(int row, int col, String data) {
    if(row >= 0 && row < rows && col >= 0 && col < cols) {
      grid[row][col].setData(data);
    }
  }


  /********************************************************************
	*
	* Method: getData
	*
	* Description: Gets the data of a given cell
	*
	* @param  row   The row that the cell is in
   *         col   The column that the cell is in
	*
	* @return str   The data that was in the given cell
	*
	********************************************************************/

  public String getData(int row, int col) {
    String str = null;
    if(row >= 0 && row < rows && col >= 0 && col < cols) {
      str = grid[row][col].getData();
    }
    return str;
  }

  /********************************************************************
	*
	* Method: getCell
	*
	* Description: Gets a given cell in the grid
	*
	* @param  row    The row that the cell is in
   *         col    The column that the cell is in
	*
	* @return cell   The cell in the given row and column
	*
	********************************************************************/

  public Cell getCell(int row, int col) {
    Cell cell = null;
    if(row >= 0 && row < rows && col >= 0 && col < cols) {
      cell = grid[row][col];
    }
    return cell;
  }
}
