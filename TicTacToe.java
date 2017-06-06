import java.awt.*;
import java.awt.event.*;
import javax.swing.*;




public class TicTacToe {
	JFrame _frame = new JFrame("Tic-Tac-Toe");
	JPanel _ttt = new JPanel();
	JPanel _newPanel = new JPanel();
	JButton[] _buttons = new JButton[9];
	JButton _newGameButton= new JButton("new game");
	boolean XvsO=false;
	
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("_")) {
				if(XvsO){
					source.setText("X");
					XvsO=false;
				}else{
					source.setText("O");
					XvsO=true;
				}
			
			}else if(currentText.equals("new game")){
				for(int i=0;i<9;i++){
					_buttons[i].setText("_");
				}
			}
		}
		
	}
	

	public static void main(String[] args) {
		new TicTacToe();
	}
	
	public TicTacToe(){
		for(int j=0;j<9;j++){
			_buttons[j]=new JButton("_");
			ActionListener buttonListener=new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
	    	_ttt.add(_buttons[j]);
		}
		_newGameButton.addActionListener(new ButtonListener());
		_newGameButton.setFont(new Font("Courier", Font.PLAIN,32));
		_newPanel.add(_newGameButton);
		_ttt.setLayout(new GridLayout(3,3));
		_newPanel.setLayout(new FlowLayout());
		_frame.add(_ttt,BorderLayout.NORTH);
		_frame.add(_newPanel,BorderLayout.SOUTH);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setSize(300,400);
		_frame.setVisible(true);
	}
	

	
	
}
