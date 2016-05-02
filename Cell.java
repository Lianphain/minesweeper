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
 * FILE: Cell.java
 *
 * DESCRIPTION: This file contains the Cell class for homework 6. You can think of a
 *              Cell in the same way that you think of a node.
 *
 ***************************************************************************************/

public class Cell {
  private Cell north;
  private Cell east;
  private Cell south;
  private Cell west;
  private Cell northEast;
  private Cell northWest;
  private Cell southEast;
  private Cell southWest;
  private String data;

  /********************************************************************
	*
	* Method: Cell
	*
	* Description: Constructor for the Cell class
	*
	* @param  None
	*
	* @return None
	*
	********************************************************************/

  public Cell() {
    north = null;
    east = null;
    south = null;
    west = null;
    northEast = null;
    northWest = null;
    southEast = null;
    southWest = null;
    data = null;
  }

  /********************************************************************************
	*
	* Method: setNorth
	*
	* Description: Sets the north value of the current cell to a given cell
	*
	* @param  cell  The Cell which will be directly north of the current cell
	*
	* @return None
	*
	********************************************************************************/

  public void setNorth(Cell cell) {
    this.north = cell;
  }

  /********************************************************************************
	*
	* Method: setEast
	*
	* Description: Sets the east value of the current cell to a given cell
	*
	* @param  cell  The Cell which will be directly east of the current cell
	*
	* @return None
	*
	********************************************************************************/

  public void setEast(Cell cell) {
    this.east = cell;
  }

  /********************************************************************************
	*
	* Method: setSouth
	*
	* Description: Sets the south value of the current cell to a given cell
	*
	* @param  cell  The Cell which will be directly south of the current cell
	*
	* @return None
	*
	********************************************************************************/

  public void setSouth(Cell cell) {
    this.south = cell;
  }

  /********************************************************************************
	*
	* Method: setWest
	*
	* Description: Sets the west value of the current cell to a given cell
	*
	* @param  cell  The Cell which will be directly west of the current cell
	*
	* @return None
	*
	********************************************************************************/

  public void setWest(Cell cell) {
    this.west = cell;
  }

  /********************************************************************************
  *
  * Method: setWest
  *
  * Description: Sets the west value of the current cell to a given cell
  *
  * @param  cell  The Cell which will be directly west of the current cell
  *
  * @return None
  *
  ********************************************************************************/

  public void setNorthEast(Cell cell) {
    this.northEast = cell;
  }

  /********************************************************************************
  *
  * Method: setWest
  *
  * Description: Sets the west value of the current cell to a given cell
  *
  * @param  cell  The Cell which will be directly west of the current cell
  *
  * @return None
  *
  ********************************************************************************/

  public void setNorthWest(Cell cell) {
    this.northWest = cell;
  }

  /********************************************************************************
  *
  * Method: setWest
  *
  * Description: Sets the west value of the current cell to a given cell
  *
  * @param  cell  The Cell which will be directly west of the current cell
  *
  * @return None
  *
  ********************************************************************************/

  public void setSouthEast(Cell cell) {
    this.southEast = cell;
  }

  /********************************************************************************
  *
  * Method: setWest
  *
  * Description: Sets the west value of the current cell to a given cell
  *
  * @param  cell  The Cell which will be directly west of the current cell
  *
  * @return None
  *
  ********************************************************************************/

  public void setSouthWest(Cell cell) {
    this.southWest = cell;
  }

  /********************************************************************************
	*
	* Method: setData
	*
	* Description: Sets the data of the current cell to the given data
	*
	* @param  newData  The data which the cell should contain
	*
	* @return None
	*
	********************************************************************************/

  public void setData(String newData) {
    this.data = newData;
  }

  /********************************************************************************
	*
	* Method: getNorth
	*
	* Description: Returns the cell directly north of the given cell
	*
	* @param  None
	*
	* @return The cell directly north of the current cell
	*
	********************************************************************************/

  public Cell getNorth() {
    return this.north;
  }

  /********************************************************************************
	*
	* Method: getEast
	*
	* Description: Returns the cell directly east of the given cell
	*
	* @param  None
	*
	* @return The cell directly east of the current cell
	*
	********************************************************************************/

  public Cell getEast() {
    return this.east;
  }

  /********************************************************************************
	*
	* Method: getSouth
	*
	* Description: Returns the cell directly south of the given cell
	*
	* @param  None
	*
	* @return The cell directly south of the current cell
	*
	********************************************************************************/

  public Cell getSouth() {
    return this.south;
  }

  /********************************************************************************
	*
	* Method: getWest
	*
	* Description: Returns the cell directly west of the given cell
	*
	* @param  None
	*
	* @return The cell directly west of the current cell
	*
	********************************************************************************/

  public Cell getWest() {
    return this.west;
  }

  /********************************************************************************
  *
  * Method: getWest
  *
  * Description: Returns the cell directly west of the given cell
  *
  * @param  None
  *
  * @return The cell directly west of the current cell
  *
  ********************************************************************************/

  public Cell getNorthEast() {
    return this.northEast;
  }

  /********************************************************************************
  *
  * Method: getWest
  *
  * Description: Returns the cell directly west of the given cell
  *
  * @param  None
  *
  * @return The cell directly west of the current cell
  *
  ********************************************************************************/

  public Cell getNorthWest() {
    return this.northWest;
  }

  /********************************************************************************
  *
  * Method: getWest
  *
  * Description: Returns the cell directly west of the given cell
  *
  * @param  None
  *
  * @return The cell directly west of the current cell
  *
  ********************************************************************************/

  public Cell getSouthEast() {
    return this.southEast;
  }

  /********************************************************************************
  *
  * Method: getWest
  *
  * Description: Returns the cell directly west of the given cell
  *
  * @param  None
  *
  * @return The cell directly west of the current cell
  *
  ********************************************************************************/

  public Cell getSouthWest() {
    return this.southWest;
  }

  /********************************************************************************
	*
	* Method: getData
	*
	* Description: Returns the data contained in the current cell
	*
	* @param  None
	*
	* @return The data contained in the current cell
	*
	********************************************************************************/

  public String getData() {
    return this.data;
  }
}
