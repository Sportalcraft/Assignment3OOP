package GameFrame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class reads from the disk and temporary saved it's data
 */
public class ReadCsv {

    ///list of boards in different sizes represented by 2D Array
    private List<Integer[][]> _threeBoard;
    private List<Integer[][]> _fourBoard;
    private List<Integer[][]> _fiveBoard;
    
    private Scanner _scanner;//handles reading from Boards.csv
    
    /**
     * creates a ReadCsv instance
     * @param path file path of the csv file
     */
    public ReadCsv(String path) {
        readFromCsv(path);
    }

    /**
     * read the csv file from a given path
     * saves the boards in the list according to the size
     * @param csvPath 
     */
    public void readFromCsv(String csvPath) {
        String input = "";

        try {
            _scanner = new Scanner(new BufferedReader(new FileReader(csvPath)));
            _threeBoard = new Vector<>();
            _fourBoard = new Vector<>();
            _fiveBoard = new Vector<>();

            while (_scanner.hasNextLine()) {
                input = _scanner.nextLine();
                if (input.equals("3")) {
                    Integer[][] three = createArray(3);
                    _threeBoard.add(three);
                } else if (input.equals("4")) {
                    Integer[][] four = createArray(4);
                    _fourBoard.add(four);
                } else if (input.equals("5")) {
                    Integer[][] five = createArray(5);
                    _fiveBoard.add(five);
                }
            }
        } catch (FileNotFoundException e) {
            //message to the user that reading failed
            JOptionPane.showMessageDialog(null,
                    "Could Not Load Game Boards", "Failure", JOptionPane.ERROR_MESSAGE);
          System.exit(1);//exits the program if the reading failed
        }
    }
    
    /**
     * gets a random board in a givven size
     * @param size the size of the board
     * @return a random board
     */
    public Integer[][] randomBaord(int size) {
        return randomArray(getBoard(size));
    }
    
    /**
     * get array of boards in a given size
     * @param size of boards to return
     * @return an array of boards in the given size
     */
    private List<Integer [][]> getBoard(int size){
        if(size==3)
            return _threeBoard;
        else if(size==4)
            return _fourBoard;
        return _fiveBoard;
    }
    
    /**
     * gets a list of boards and returns a random board
     * @param boards to search randomly
     * @return a random board
     */
    private Integer[][] randomArray(List<Integer[][]> boards) {
        if (boards.isEmpty()) {
            throw new NoSuchElementException("no boards by this number");
        }
        int index = (int) Math.floor(Math.random() * boards.size());
        return boards.get(index);
    }

    /**
     * copies an array to 2D array form the csv file
     * @param num size of the array
     * @return 
     */
    private Integer[][] createArray(int num) {
        Integer[][] arr = new Integer[num][num];
        for (Integer i = 0; i < num; i++) {
            String[] lineArr = _scanner.nextLine().split(",");
            copyArray(arr, lineArr, i);
        }
        return arr;
    }

    // save a line of integers to the array in the specified line
    private void copyArray(Integer[][] copyTo, String[] toCopy, Integer line) {
        for (int j = 0; j < toCopy.length; j++) {
            int insert = Integer.parseInt(toCopy[j]);
            copyTo[line][j] = insert;
        }
    }
}
