
package GameFrame;

import java.awt.Color;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

import ImageHandling.ImageHandler;

import GameLogic.*;

import CsvReader.ReadCsv;


public class GameFrame extends JFrame {
    /**
     * A constructor
     *
     * @param images the images of the tiles IN ORDER (1-N*N), including the
     * empty tile image
     * @param boardOrder the order to shuffle the board in
     */
    public GameFrame(String[][] images, Integer[][] boardOrder, String pic) {

        this(BuildBoard(images, boardOrder));
        ImageHandler.scaledImg(ImageHandler.SavedPhotoPath(pic), _lblPicPrev);
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
        ImageHandler.scaledImg(ImageHandler.SavedPhotoPath(pic), _lblPicPrev);
    }

    /**
     * creates a new GameFrame with an image uploaded by the user
     * @param toCut image uploaded
     * @param size wished size by the user
     * @param boardOrder the order of the board
     */
    public GameFrame(String toCut, Integer[][] boardOrder) {
        this(BuildBoard(ImageHandler.squareCut(toCut, boardOrder.length),boardOrder ));
        
        Image img = new ImageIcon(toCut).getImage();
        img = img.getScaledInstance(_lblPicPrev.getWidth(), _lblPicPrev.getHeight(), Image.SCALE_SMOOTH);
        _lblPicPrev.setIcon(new ImageIcon(img));
    }
    
    /**
     * creates a new GameFrame with an image uploaded by the user
     * @param toCut image uploaded
     * @param size wished size by the user
     */
    public GameFrame(String toCut, int size) {
        this(ImageHandler.squareCut(toCut, size));
        
        Image img = new ImageIcon(toCut).getImage();
        img = img.getScaledInstance(_lblPicPrev.getWidth(), _lblPicPrev.getHeight(), Image.SCALE_SMOOTH);
        _lblPicPrev.setIcon(new ImageIcon(img));
    }

    /**
     *  * A constructor
     *
     * @param board the board
     */
    private GameFrame(BoardPanel board) {

        _board = board;
        initComponents();
    }

    /**
     * undo the last action done in the game
     */
    public void undo() {
       try{
    	_board.undo();
       }
       catch (Exception e) {}
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
        _lblMovesPrev.setText(moves);
    }
    /**
     * handles updating the time lable of the game
     */
    private void updateTimelbl() {
        _seconds++;
        if (_seconds == 60) {
            _seconds = 0;
            _minutes++;
            if (_minutes == 60) {
                _minutes = 0;
                _hours++;
            }
        }
        _lblTimePrev.setText(" " + _hours + " : " + _minutes + " : " + _seconds + " ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initialization">//GEN-BEGIN:initComponents
    private void initComponents() {

        _pnlHeader = new javax.swing.JPanel();
        _btnExit = new javax.swing.JButton();
        _pnlBoardBtns = new javax.swing.JPanel();
        _pnlBoardBack = new javax.swing.JPanel();
        _pnlBoard = new javax.swing.JPanel();
        _pnlBtns = new javax.swing.JPanel();
        _btnUndo = new javax.swing.JButton();
        _btnBack = new javax.swing.JButton();
        _pnlGamePrev = new javax.swing.JPanel();
        _pnlGameImgPrev = new javax.swing.JPanel();
        _lblPicPrev = new javax.swing.JLabel();
        _pnlInfo = new javax.swing.JPanel();
        _lblMoves = new javax.swing.JLabel();
        _lblTime = new javax.swing.JLabel();
        _lblMovesPrev = new javax.swing.JLabel();
        _lblTimePrev = new javax.swing.JLabel();
        _pnlSeperator = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("GameFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        _pnlHeader.setBackground(new java.awt.Color(255, 255, 255));
        _pnlHeader.setForeground(new java.awt.Color(255, 255, 255));
        _pnlHeader.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                pnlHeaderMouseDragged(evt);
            }
        });
        _pnlHeader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHeaderMousePressed(evt);
            }
        });

        _btnExit.setBackground(new java.awt.Color(255, 255, 255));
        _btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/Exit.png"))); // NOI18N
        _btnExit.setContentAreaFilled(false);
        _btnExit.setFocusable(false);
        _btnExit.setOpaque(true);
        _btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        _btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderLayout = new javax.swing.GroupLayout(_pnlHeader);
        _pnlHeader.setLayout(pnlHeaderLayout);
        pnlHeaderLayout.setHorizontalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeaderLayout.createSequentialGroup()
                .addContainerGap(942, Short.MAX_VALUE)
                .addComponent(_btnExit)
                .addContainerGap())
        );
        pnlHeaderLayout.setVerticalGroup(
            pnlHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        _pnlBoardBtns.setBackground(new java.awt.Color(153, 153, 255));

        _pnlBoardBack.setBackground(new java.awt.Color(204, 204, 255));
        _pnlBoardBack.setForeground(new java.awt.Color(102, 102, 102));

        _pnlBoard.setBackground(new java.awt.Color(204, 204, 255));
        _pnlBoard.setPreferredSize(new java.awt.Dimension(450, 450));

        javax.swing.GroupLayout pnlBoardLayout = new javax.swing.GroupLayout(_pnlBoard);
        _pnlBoard.setLayout(pnlBoardLayout);
        pnlBoardLayout.setHorizontalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );
        pnlBoardLayout.setVerticalGroup(
            pnlBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlBoardBackLayout = new javax.swing.GroupLayout(_pnlBoardBack);
        _pnlBoardBack.setLayout(pnlBoardBackLayout);
        pnlBoardBackLayout.setHorizontalGroup(
            pnlBoardBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardBackLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(_pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnlBoardBackLayout.setVerticalGroup(
            pnlBoardBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBoardBackLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_pnlBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        _pnlBtns.setBackground(new java.awt.Color(204, 204, 255));

        _btnUndo.setBackground(new java.awt.Color(204, 255, 255));
        _btnUndo.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-undo-50.png"))); // NOI18N
        _btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });

        _btnBack.setBackground(new java.awt.Color(204, 255, 255));
        _btnBack.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _btnBack.setForeground(new java.awt.Color(102, 102, 255));
        _btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-go-back-50.png"))); // NOI18N
        _btnBack.setText("Back To Menu");
        _btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBtnsLayout = new javax.swing.GroupLayout(_pnlBtns);
        _pnlBtns.setLayout(pnlBtnsLayout);
        pnlBtnsLayout.setHorizontalGroup(
            pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnsLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(_btnUndo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(_btnBack)
                .addGap(60, 60, 60))
        );
        pnlBtnsLayout.setVerticalGroup(
            pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBtnsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_btnUndo)
                    .addComponent(_btnBack))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBoardBtnsLayout = new javax.swing.GroupLayout(_pnlBoardBtns);
        _pnlBoardBtns.setLayout(pnlBoardBtnsLayout);
        pnlBoardBtnsLayout.setHorizontalGroup(
            pnlBoardBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_pnlBoardBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(_pnlBtns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlBoardBtnsLayout.setVerticalGroup(
            pnlBoardBtnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBoardBtnsLayout.createSequentialGroup()
                .addComponent(_pnlBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(_pnlBoardBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        _pnlGamePrev.setBackground(new java.awt.Color(204, 204, 255));

        _pnlGameImgPrev.setBackground(new java.awt.Color(153, 204, 255));
        _pnlGameImgPrev.setForeground(new java.awt.Color(153, 153, 0));

        javax.swing.GroupLayout pnlGameImgPrevLayout = new javax.swing.GroupLayout(_pnlGameImgPrev);
        _pnlGameImgPrev.setLayout(pnlGameImgPrevLayout);
        pnlGameImgPrevLayout.setHorizontalGroup(
            pnlGameImgPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameImgPrevLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblPicPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlGameImgPrevLayout.setVerticalGroup(
            pnlGameImgPrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGameImgPrevLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblPicPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        _pnlInfo.setBackground(new java.awt.Color(204, 204, 255));

        _lblMoves.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        _lblMoves.setForeground(new java.awt.Color(0, 102, 102));
        _lblMoves.setText("moves : ");

        _lblTime.setFont(new java.awt.Font("MV Boli", 0, 24)); // NOI18N
        _lblTime.setForeground(new java.awt.Color(0, 102, 102));
        _lblTime.setText("Time:");

        _lblMovesPrev.setFont(new java.awt.Font("Lucida Calligraphy", 0, 30)); // NOI18N
        _lblMovesPrev.setForeground(new java.awt.Color(153, 0, 0));

        _lblTimePrev.setFont(new java.awt.Font("Lucida Calligraphy", 0, 30)); // NOI18N
        _lblTimePrev.setForeground(new java.awt.Color(153, 0, 0));

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(_pnlInfo);
        _pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(_lblMoves)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(_lblMovesPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(_lblTime)
                        .addGap(18, 18, 18)
                        .addComponent(_lblTimePrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_lblMoves)
                    .addComponent(_lblMovesPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_lblTimePrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGamePrevLayout = new javax.swing.GroupLayout(_pnlGamePrev);
        _pnlGamePrev.setLayout(pnlGamePrevLayout);
        pnlGamePrevLayout.setHorizontalGroup(
            pnlGamePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGamePrevLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(pnlGamePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_pnlGameImgPrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        pnlGamePrevLayout.setVerticalGroup(
            pnlGamePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGamePrevLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(_pnlGameImgPrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(_pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        _pnlSeperator.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(_pnlSeperator);
        _pnlSeperator.setLayout(jPanel1Layout);
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
                    .addComponent(_pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(_pnlBoardBtns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(_pnlSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(_pnlGamePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(_pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(_pnlGamePrev, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_pnlBoardBtns, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(_pnlSeperator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        timer = new Timer(1000, (ActionEvent ae) -> {
            updateTimelbl();
        });
        addUndo();
        timer.start();
        setVisible(true);
        _pnlBoard.add(_board);
        pack();
        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addUndo(){
                BoardPanel.addKeyBinding(_pnlBtns, KeyEvent.VK_Z,InputEvent.CTRL_DOWN_MASK, "undo", (ActionEvent ae) -> {
            _btnUndo.doClick();
        });
    }
    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        _btnExit.setBackground(new Color(232, 17, 35));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        _btnExit.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void pnlHeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMouseDragged
        if (_maximized) {
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - _xMouse, y - _yMouse);
        }
    }//GEN-LAST:event_pnlHeaderMouseDragged

    private void pnlHeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHeaderMousePressed
        _xMouse = evt.getX();
        _yMouse = evt.getY();
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
    	return _lblTimePrev.getText();
    }

    // Variables declaration//GEN-BEGIN:variables
    private static boolean _maximized = true;
    private int _xMouse;
    private int _yMouse;
    private BoardPanel _board;
    //Timer
    private int _seconds = 0;
    private int _minutes = 0;
    private int _hours = 0;
    protected static Timer timer;
    //end Timer
    private JButton _btnBack;
    private JButton _btnExit;
    private JButton _btnUndo;
    private JPanel _pnlSeperator;
    private JLabel _lblMoves;
    private static JLabel _lblMovesPrev;
    private JLabel _lblPicPrev;
    private JLabel _lblTime;
    private static JLabel _lblTimePrev;
    private JPanel _pnlBoard;
    private JPanel _pnlBoardBack;
    private JPanel _pnlBoardBtns;
    private JPanel _pnlBtns;
    private JPanel _pnlGameImgPrev;
    private JPanel _pnlGamePrev;
    private JPanel _pnlHeader;
    private JPanel _pnlInfo;
    // End of variables declaration//GEN-END:variables
}
