
package GameFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class GameFrame extends javax.swing.JFrame {

    

    /**
     * A constructor
     *
     * @param images the images of the tiles IN ORDER (1-N*N), including the
     * empty tile image
     * @param boardOrder the order to shuffle the board in
     */
    public GameFrame(String[][] images, Integer[][] boardOrder, String pic) {

        this(BuildBoard(images, boardOrder));
        ImageHandler.scaledImg(ImageHandler.SavedPhotoPath(pic), lblPicPrev);
        Verify2DArray(images);
        Verify2DArray(boardOrder);

    }

    /**
     * A constructor that randomly shuffle the board
     *
     * @param images the images of the tiles IN ORDER (1-N*N), including the
     * empty tile image
     */
    public GameFrame(String[][] images) {

        this(new BoardPanel(new Board(BuildBoardMap(images), true)));
        Verify2DArray(images);
    }

    /**
     * A constructor to build the board from saved images
     *
     * @param size
     * @param pic
     */
    public GameFrame(int size, String pic) {
        this(ImageHandler.BuildImagesMap(size, pic));
        ImageHandler.scaledImg(ImageHandler.SavedPhotoPath(pic), lblPicPrev);
    }
    
    public GameFrame(String toCut, int size) {
        this(ImageHandler.squareCut(toCut, size));
        
        Image img = new ImageIcon(toCut).getImage();
        img = img.getScaledInstance(lblPicPrev.getWidth(), lblPicPrev.getHeight(), Image.SCALE_SMOOTH);
        lblPicPrev.setIcon(new ImageIcon(img));
    }

    /**
     *  * A constructor
     *
     * @param board the board
     */
    private GameFrame(BoardPanel board) {

        _board = board;
        initComponents();
        myInitComponents();
    }

    /**
     * undo the last action done in the game
     */
    public void undo() {
        _board.undo();
    }

    /*
     * @return true if the board is solved
     */
    public boolean isComplete() {
        return _board.isComplete();
    }

    /**
     * Build the board of the game
     *
     * @param images the images of the tiles IN ORDER (1-N*N), including the
     * empty tile image
     * @param boardOrder the order to shuffle the board in
     * @return a board that is built according to the instructions
     */
    private static BoardPanel BuildBoard(String[][] images, Integer[][] boardOrder) {
        int size = boardOrder.length;
        ITile[][] boardMap = new ITile[size][size];
        int desirablePosition;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                desirablePosition = boardOrder[row][col];

                if (desirablePosition == size * size - 1) //EmptyTile
                {
                    boardMap[row][col] = new EmptyTile(desirablePosition, images[desirablePosition / size][desirablePosition % size]);
                } else {
                    boardMap[row][col] = new Tile(desirablePosition, images[desirablePosition / size][desirablePosition % size]);
                }
            }
        }

        return new BoardPanel(new Board(boardMap));
    }

    /**
     * Build the board map of the game
     *
     * @param images the images of the tiles IN ORDER (1-N*N), including the
     * empty tile image
     * @return a board map that is built by the order of images
     */
    private static ITile[][] BuildBoardMap(String[][] images) {

        int size = images.length;
        ITile[][] map = new ITile[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new Tile(i * size + j, images[i][j]);
            }
        }
        map[size - 1][size - 1] = new EmptyTile(size * size - 1, images[size - 1][size - 1]);

        return map;
    }

    /**
     * verify if a 2D array is a matrix
     *
     * @param arr the array to check
     * @throws IllegalArgumentException if not legal 2D matrix array
     */
    private <T> void Verify2DArray(T[][] arr) throws IllegalArgumentException {

        if (arr == null) {
            throw new IllegalArgumentException("The board is null!");
        }

        int size = arr.length;

        if (size == 0) {
            throw new IllegalArgumentException("The board is empty!");
        }

        for (T[] row : arr) {
            if (row == null) {
                throw new IllegalArgumentException("The board have a row that is null!");
            }

            if (row.length != size) {
                throw new IllegalArgumentException("The board have a row that is have a diffrent leangth that the baord size!");
            }

            for (T item : row) {
                if (item == null) {
                    throw new IllegalArgumentException("The board have a null item!");
                }
            }
        }
    }

    /**
     * sets the lable of the moves done in the game
     *
     * @param moves
     */
    public static void addMoves(String moves) {
        lblMovesPrev.setText(moves);
    }
    /**
     * handles updating the time lable of the game
     */
    private void updateTimelbl() {
        seconds++;
        if (seconds == 60) {
            seconds = 0;
            minutes++;
            if (minutes == 60) {
                minutes = 0;
                hours++;
            }
        }
        lblTimePrev.setText(" " + hours + " : " + minutes + " : " + seconds + " ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        pnlBoardBtns = new javax.swing.JPanel();
        pnlBoardBack = new javax.swing.JPanel();
        pnlBoard = new javax.swing.JPanel();
        pnlBtns = new javax.swing.JPanel();
        btnUndo = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        pnlGamePrev = new javax.swing.JPanel();
        pnlGameImgPrev = new javax.swing.JPanel();
        lblPicPrev = new javax.swing.JLabel();
        pnlInfo = new javax.swing.JPanel();
        lblMoves = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblMovesPrev = new javax.swing.JLabel();
        lblTimePrev = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("GameFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        pnlHeader.setForeground(new java.awt.Color(255, 255, 255));
        pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 255, 255));
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/Exit.png"))); // NOI18N
        btnExit.setContentAreaFilled(false);
        btnExit.setFocusable(false);
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(pnlHeader);
        pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(942, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pnlBoardBtns.setBackground(new java.awt.Color(153, 153, 255));

        pnlBoardBack.setBackground(new java.awt.Color(204, 204, 255));
        pnlBoardBack.setForeground(new java.awt.Color(102, 102, 102));

        pnlBoard.setBackground(new java.awt.Color(204, 204, 255));
        pnlBoard.setPreferredSize(new java.awt.Dimension(450, 450));

        javax.swing.GroupLayout pnlBoardLayout = new javax.swing.GroupLayout(pnlBoard);
        pnlBoard.setLayout(pnlBoardLayout);
        pnlBoardLayout.setHorizontalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        pnlBoardLayout.setVerticalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBoardBackLayout = new javax.swing.GroupLayout(pnlBoardBack);
        pnlBoardBack.setLayout(pnlBoardBackLayout);
        pnlBoardBackLayout.setHorizontalGroup(
            pnlBoardBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardBackLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlBoardBackLayout.setVerticalGroup(
            pnlBoardBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        pnlBtns.setBackground(new java.awt.Color(204, 204, 255));

        btnUndo.setBackground(new java.awt.Color(204, 255, 255));
        btnUndo.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-undo-50.png"))); // NOI18N
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(204, 255, 255));
        btnBack.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        btnBack.setForeground(new java.awt.Color(102, 102, 255));
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-go-back-50.png"))); // NOI18N
        btnBack.setText("Back To Menu");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnsLayout = new javax.swing.GroupLayout(pnlBtns);
        pnlBtns.setLayout(pnlBtnsLayout);
        pnlBtnsLayout.setHorizontalGroup(
            pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnsLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(btnUndo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(60, 60, 60))
        );
        pnlBtnsLayout.setVerticalGroup(
            pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUndo)
                    .addComponent(btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBoardBtnsLayout = new javax.swing.GroupLayout(pnlBoardBtns);
        pnlBoardBtns.setLayout(pnlBoardBtnsLayout);
        pnlBoardBtnsLayout.setHorizontalGroup(
            pnlBoardBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBoardBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBtns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBoardBtnsLayout.setVerticalGroup(
            pnlBoardBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBoardBtnsLayout.createSequentialGroup()
                .addComponent(pnlBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnlBoardBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pnlGamePrev.setBackground(new java.awt.Color(204, 204, 255));

        pnlGameImgPrev.setBackground(new java.awt.Color(153, 204, 255));
        pnlGameImgPrev.setForeground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout pnlGameImgPrevLayout = new javax.swing.GroupLayout(pnlGameImgPrev);
        pnlGameImgPrev.setLayout(pnlGameImgPrevLayout);
        pnlGameImgPrevLayout.setHorizontalGroup(
            pnlGameImgPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameImgPrevLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGameImgPrevLayout.setVerticalGroup(
            pnlGameImgPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameImgPrevLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPicPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlInfo.setBackground(new java.awt.Color(204, 204, 255));

        lblMoves.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        lblMoves.setForeground(new java.awt.Color(0, 102, 102));
        lblMoves.setText("moves : ");

        lblTime.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        lblTime.setForeground(new java.awt.Color(0, 102, 102));
        lblTime.setText("Time:");

        lblMovesPrev.setFont(new java.awt.Font("Lucida Calligraphy", 0, 30)); // NOI18N
        lblMovesPrev.setForeground(new java.awt.Color(153, 0, 0));

        lblTimePrev.setFont(new java.awt.Font("Lucida Calligraphy", 0, 30)); // NOI18N
        lblTimePrev.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblMoves)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMovesPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(lblTime)
                        .addGap(18, 18, 18)
                        .addComponent(lblTimePrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMoves)
                    .addComponent(lblMovesPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTimePrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGamePrevLayout = new javax.swing.GroupLayout(pnlGamePrev);
        pnlGamePrev.setLayout(pnlGamePrevLayout);
        pnlGamePrevLayout.setHorizontalGroup(
            pnlGamePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGamePrevLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(pnlGamePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlGameImgPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        pnlGamePrevLayout.setVerticalGroup(
            pnlGamePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGamePrevLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlGameImgPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlBoardBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(pnlGamePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(pnlGamePrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlBoardBtns, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myInitComponents() {
        timer = new Timer(1000, (ActionEvent ae) -> {
            updateTimelbl();
        });
        addUndo();
        timer.start();
        setVisible(true);
        pnlBoard.add(_board);
        pack();
    }
    private void addUndo(){
                BoardPanel.addKeyBinding(pnlBtns, KeyEvent.VK_Z,InputEvent.CTRL_DOWN_MASK, "undo", (ActionEvent ae) -> {
            btnUndo.doClick();
        });
    }
    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        if (maximized) {
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_pnlHeaderMousePressed

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        // TODO add your handling code here:
        undo();

    }//GEN-LAST:event_btnUndoActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        int op = JOptionPane.showConfirmDialog(this, "Are You Sure?? This Action Will Reset the Game ", "Back", JOptionPane.YES_NO_OPTION);
        if (op == 0) {
        	GameFrame.timer.stop();
            MainMenu mMenu = new MainMenu(new ReadCsv("Boards.csv"));
            mMenu.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnBackActionPerformed

    /**
     * 
     * @return the time this game tooked
     */
    public static String Time()
    {
    	return lblTimePrev.getText();
    }
    
    //variables declaration
    private static boolean maximized = true;
    private int xMouse;
    private int yMouse;
    private BoardPanel _board;
    private int seconds = 0;
    private int minutes = 0;
    private int hours = 0;
    protected static Timer timer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnUndo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMoves;
    private static javax.swing.JLabel lblMovesPrev;
    private javax.swing.JLabel lblPicPrev;
    private javax.swing.JLabel lblTime;
    private static javax.swing.JLabel lblTimePrev;
    private javax.swing.JPanel pnlBoard;
    private javax.swing.JPanel pnlBoardBack;
    private javax.swing.JPanel pnlBoardBtns;
    private javax.swing.JPanel pnlBtns;
    private javax.swing.JPanel pnlGameImgPrev;
    private javax.swing.JPanel pnlGamePrev;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlInfo;
    // End of variables declaration//GEN-END:variables
}
