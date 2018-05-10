package GameFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardPanel extends JPanel implements ActionListener {

	private final int PANEL_SIZE = 600;
	
	private IBoard _board;
	
	private JButton[][] _buttuns;
	
	/**
	 * The undo stack that track this game
	 */
	private Stack<Integer> _undo;
	
	/**
	 * The amount of moves that were made on this game
	 */
	private int _moves; 
	
	public BoardPanel(IBoard boad)
	{
		super(new GridLayout(boad.boardSize(), boad.boardSize()));
		
		setSize(new Dimension(PANEL_SIZE,PANEL_SIZE));
		
		String file;
		
		_board = boad;		
		_buttuns = new JButton[_board.boardSize()][_board.boardSize()];
		_undo = new Stack<>();
		_moves = 0;
		
		for(int i = 0; i< _buttuns.length; i++)
		{
			for(int j = 0; j< _buttuns.length; j++)
			{	
			   file = _board.boardMap()[i][j].content();
				
				if(file != null)
					_buttuns[i][j] = new JButton( new ImageIcon(BoardPanel.class.getResource(file)));
				else
					_buttuns[i][j] = new JButton( new ImageIcon());
				
				_buttuns[i][j].addActionListener(this);
				_buttuns[i][j].setSize(new Dimension(PANEL_SIZE/_board.boardSize(),PANEL_SIZE/_board.boardSize()));
				
				add(_buttuns[i][j]);
			}
		}
	}
	
	public int moves()
	{
		return _moves;
	}

	public boolean undoable()
	{
		return !_undo.isEmpty();
	}
	
	public void undo() {		
		
		if(undoable())
		{
			move(_undo.pop());		
		}
	}
	
	public boolean isComplete() {
		return _board.isComplete();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {		
		move(e.getSource());
	}
	
	private void move(Object source)
	{
		int swappedWith;
		Icon tIcon;
		int row, col;
		
		out : for(int i = 0; i< _buttuns.length; i++)
		{		
			for(int j = 0; j< _buttuns.length; j++)
			{
				tIcon = _buttuns[i][j].getIcon();
				
				if(source.equals(_buttuns[i][j]))
				{
					swappedWith = _board.moveTile(i*_board.boardSize() + j );
					_moves++;
					row = swappedWith / _buttuns.length;
					col = swappedWith % _buttuns.length;
										
					//Swapping images of buttons
					_buttuns[i][j].setIcon(_buttuns[row][col].getIcon());
					_buttuns[row][col].setIcon(tIcon); 
					
					_undo.push(i*_board.boardSize() + j);
					
					break out; //Break the loop
				}
			}
		}
		
		if(isComplete())
		{
			int size = _board.boardSize()-1;
			String file = _board.boardMap()[size][size].content();
			_buttuns[size][size].setIcon(new ImageIcon(BoardPanel.class.getResource(file)));
		}
	}
}
