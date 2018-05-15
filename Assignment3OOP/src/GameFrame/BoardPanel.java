package GameFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Stack;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class BoardPanel extends JPanel implements ActionListener {
        /**
         * board size that presented on the screen
         */
	private final int PANEL_SIZE = 450;
	
        /**
         * the currunt panel's board
         */
	private Board _board;
	
        /**
         * buttons array that represents the tiles of the board
         */
	private JButton[][] _buttons;
	
	/**
	 * The undo stack that track this game
	 */
	private Stack<Integer> _undo;
        private boolean _undoBool = false;
	
	/**
	 * The amount of moves that were made on this game
	 */
	private int _moves; 
	
        /**
         * gets a board instance and build a panel of JButtons that represents the tiles of the board
         * @param board 
         */
	public BoardPanel(Board board)
	{
		super(new GridLayout(board.boardSize(), board.boardSize()));
		
		setSize(new Dimension(PANEL_SIZE,PANEL_SIZE));
		
		_board = board;		
		_buttons = new JButton[_board.boardSize()][_board.boardSize()];
		_undo = new Stack<>();
		_moves = 0;
		addPanelMap();
                addKeysActions();
	}
    /**
     * creates the map of JButtons that represents the board 
     * each button given the picture according to it's position
     */
    private void addPanelMap() {
        try {
            String file;
            for (int i = 0; i < _buttons.length; i++) {
                for (int j = 0; j < _buttons.length; j++) {
                    file = _board.boardMap()[i][j].content();

                    if (file != null) {
                        _buttons[i][j] = new JButton();
                        _buttons[i][j].setSize(new Dimension(PANEL_SIZE / _board.boardSize(), PANEL_SIZE / _board.boardSize()));
                        _buttons[i][j].setIcon(new ImageIcon(ImageHandler.scaledImg(file, _buttons[i][j])));
                    } else {
                        _buttons[i][j] = new JButton(new ImageIcon());
                        _buttons[i][j].setSize(new Dimension(PANEL_SIZE / _board.boardSize(), PANEL_SIZE / _board.boardSize()));
                    }

                    _buttons[i][j].addActionListener(this);

                    add(_buttons[i][j]);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Board is Already Solved","solved",JOptionPane.INFORMATION_MESSAGE);
        }
    }

        public static void addKeyBinding(JComponent comp, int keyCode ,int inputCode,String id, ActionListener aListener){
            InputMap im = comp.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
            ActionMap ap = comp.getActionMap();
            
            im.put(KeyStroke.getKeyStroke(keyCode,inputCode, false),id);
            //im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK,false),"undo");
            ap.put(id, new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    aListener.actionPerformed(ae);
                }
            });
        }
    /**
     * Arrows key actions for moving the tiles 
     */
    private void addKeysActions() {

        addKeyBinding(this, KeyEvent.VK_LEFT,0, "turnLeft", (ActionEvent ae) -> {
            turn("turnLeft");
        });
        addKeyBinding(this, KeyEvent.VK_RIGHT,0, "turnRight", (ActionEvent ae) -> {
            turn("turnRight");
        });
        addKeyBinding(this, KeyEvent.VK_UP,0, "turnUp", (ActionEvent ae) -> {
            turn("turnUp");
        });
        addKeyBinding(this, KeyEvent.VK_DOWN,0, "turnDown", (ActionEvent ae) -> {
            turn("turnDown");
        });
        
    }
        /**
         * gets a string represantation of the turn action and moves the according button
         * @param turn 
         */
        public  void turn(String turn){
        int emptyTile = _board.getEmptyTilePosition();
        int i = _board.getTileRow(emptyTile);
        int j = _board.getTileCol(emptyTile);

        if (turn.equals("turnLeft")) {
            if (checkRange(j + 1)) {
                _buttons[i][j + 1].doClick();
            }
        }
        else if (turn.equals("turnRight")) {
            if (checkRange(j -1)) {
                _buttons[i][j-1].doClick();
            }
        }
        else if (turn.equals("turnUp")) {
            if (checkRange(i+1)) {
                _buttons[i+1][j].doClick();
            }
        }
        else{
            if (checkRange(i-1)) {
                _buttons[i-1][j].doClick();
            }
        }
    }
        /**
         * checks if a tile position is between 0 - size*size-1
         * @param tile
         * @return 
         */
         private boolean checkRange(int tile) {
            return (tile >= 0 & tile < (_board.boardSize()));
         }
         
         /**
          * 
          * @return the amount of moves performed in the board
          */
	public int moves()
	{
		return _moves;
	}
        /**
         * 
         * @return true if there are moves to undo
         */
	public boolean undoable()
	{
		return !_undo.isEmpty();
	}
	
        /**
         * finds the last tile that was moved and moves it again
         */
	public void undo() {		
		
		if(undoable())
		{
                    int pop = _undo.pop();
                    int i = _board.getTileRow(pop);
                    int j = _board.getTileCol(pop);
                    _undoBool=true;
                    move(_buttons[i][j]);		
		}
	}
	/**
         * 
         * @return true if the board is solved
         */
	public boolean isComplete() {
		return _board.isComplete();
	}
	
        /**
         * gets an action and calls move method to move the button
         * @param e 
         */
	@Override
	public void actionPerformed(ActionEvent e) {
            try{
		move(e.getSource());
            }
            catch(Exception exp){}
	}
	/**
         * gets a buttton and moves it according to the position of the empty tile
         * @param source 
         */
	private void move(Object source)
	{
		int swappedWith;
		Icon tIcon;
		int row, col;
		int empty = _board.getEmptyTilePosition();
                
		out : for(int i = 0; i< _buttons.length; i++)
		{		
			for(int j = 0; j< _buttons.length; j++)
			{
				tIcon = _buttons[i][j].getIcon();
				
				if(source.equals(_buttons[i][j]))
				{
					swappedWith = _board.moveTile(i*_board.boardSize() + j );
					
					row = swappedWith / _buttons.length;
					col = swappedWith % _buttons.length;
										
					//Swapping images of buttons
                                        
					_buttons[i][j].setIcon(_buttons[row][col].getIcon());
					_buttons[row][col].setIcon(tIcon); 
					
                                    if (!_undoBool) {
                                        _moves++;
                                        _undo.push(empty);
                                        GameFrame.addMoves(_moves + "");
                                    }
                                    
					
					break out; //Break the loop
				}
			}
		}
        _undoBool=false;
		
		if(isComplete())
		{
			GameFrame.timer.stop(); //stops the game timer
			int size = _board.boardSize()-1;
			String file = _board.boardMap()[size][size].content();
			_buttons[size][size].setIcon(new ImageIcon(ImageHandler.scaledImg(file, _buttons[size][size])));
			 
			JOptionPane.showMessageDialog(null,
	                    "Time : " + GameFrame.Time() + "\nMoves : " + moves(), "You won!", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
