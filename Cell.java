import javax.swing.JButton;


public class Cell extends JButton {

	private static final long serialVersionUID = 1L;
	private int data = 0;
	private boolean mine = false;
	private boolean check = false;
	private int i;
	private int j;
	private boolean flagged = false;

	public void increment(){
		data++;
	}
	public boolean isFlagged(){
		return flagged;
	}
	public void setFlag(boolean flag){
		flagged = flag;
	}
	public boolean isMine(){
		return mine;
	}
	public boolean isChecked(){
		return check;
	}
	public boolean checkMine(){
		if(mine == true){
			return true;
		}
		else{
			return false;
		}
	}
	public int setMine(){
		if(mine == false){
			mine = true;
			return 1;
		}
		return 0;
	}
	public void setId(int x, int y){
		i = x;
		j = y;
	}
	public int getI(){
		return i;
	}
	public int getJ(){
		return j;
	}
	public void reveal(){
		if(mine == true){
			this.setText("Mine");
			check = true;
			this.setEnabled(false);
		}
		else{
			this.setText(String.valueOf(data));
			check = true;
			this.setEnabled(false);
		}
	}
	public boolean isEmpty(){
		return data == 0;
	}
	public boolean checkCell(){
		if(data == 0){
			return true;
		}
		else{
			return false;
		}
	}
	public int getData(){
		return data;
	}

}
