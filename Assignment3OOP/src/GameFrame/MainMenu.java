/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameFrame;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


public class MainMenu extends javax.swing.JFrame {
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu(ReadCsv read) {
         addInitialImg(imgArr);
        _read = read;
        initComponents();
        
    }
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
         this(new ReadCsv("Boards.csv"));       
    }

        /**
     * 
     * @return a random board from the csv file
     */
    private Integer [][] csvBoard() {
        
        Integer[][] temp = _read.randomBaord(selSize);

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                temp[i][j]--;
                if (temp[i][j] == -1) {
                    temp[i][j] = temp.length * temp.length - 1;
                }
            }
        }
        return temp;
    }
    /**
     * sets the label of the size of the board 
     * @param size 
     */
    private void setSizeLbl(String size) {
        lblSelSize.setText(size + "X" + size);
        if (lblImgSelPrev.getIcon() != null) {
            btnStart.setEnabled(true);
        }
    }
    /**
     * adds the initial images to the list of images
     * @param ImgArr 
     */
    private void addInitialImg(String[] ImgArr) {
        aList = new ArrayList<>(Arrays.asList(ImgArr));
        model = new DefaultListModel();
        for (int i = 0; i < aList.size(); i++) {
            model.addElement(aList.get(i));
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BgroupSize = new javax.swing.ButtonGroup();
        BgroupUse = new javax.swing.ButtonGroup();
        pnlMenu = new javax.swing.JPanel();
        btnTimeline = new javax.swing.JButton();
        lblTimeline = new javax.swing.JLabel();
        lblSelMenu = new javax.swing.JLabel();
        btnSelMenu = new javax.swing.JButton();
        lblHelp = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();
        lblCreatedBy = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        pnlPreview = new javax.swing.JPanel();
        pnlSelectedimg = new javax.swing.JPanel();
        lblSelImg = new javax.swing.JLabel();
        lblSelPreview = new javax.swing.JLabel();
        pnlStart = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        lblShuffleBoard = new javax.swing.JRadioButton();
        lblUseCsv = new javax.swing.JRadioButton();
        pnlSelecedSize = new javax.swing.JPanel();
        lblSize = new javax.swing.JLabel();
        lblSelSize = new javax.swing.JLabel();
        pnlSelection = new javax.swing.JPanel();
        pnlSelimg = new javax.swing.JPanel();
        btnAddImg = new javax.swing.JButton();
        lblSelImgPlease = new javax.swing.JLabel();
        imgListSP = new javax.swing.JScrollPane();
        imgList = new javax.swing.JList<>();
        pnlImagePrev = new javax.swing.JPanel();
        lblImgSelPrev = new javax.swing.JLabel();
        btnRandImg = new javax.swing.JButton();
        pnlSelSize = new javax.swing.JPanel();
        lblSelSizeMenu = new javax.swing.JLabel();
        lblSize3 = new javax.swing.JRadioButton();
        lblSize4 = new javax.swing.JRadioButton();
        lblSize5 = new javax.swing.JRadioButton();
        _lblEnterSIze = new javax.swing.JRadioButton();
        _tfEnterSize = new javax.swing.JTextField();
        pnlHelp = new javax.swing.JPanel();
        lblHelpMeu = new javax.swing.JLabel();
        pnlHeader = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MainMenu");
        setName("mainMenuFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));
        this.setVisible(true);

        pnlMenu.setBackground(new java.awt.Color(255, 146, 154));

        btnTimeline.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnTimeline.setForeground(new java.awt.Color(44, 62, 80));
        btnTimeline.setText("Preview");
        btnTimeline.setContentAreaFilled(false);
        btnTimeline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimeline.setFocusable(false);
        btnTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimelineActionPerformed(evt);
            }
        });

        lblTimeline.setBackground(new java.awt.Color(0, 204, 106));
        lblTimeline.setOpaque(true);

        lblSelMenu.setBackground(new java.awt.Color(255, 255, 255));
        lblSelMenu.setOpaque(true);

        btnSelMenu.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnSelMenu.setForeground(new java.awt.Color(44, 62, 80));
        btnSelMenu.setText("Image & Size");
        btnSelMenu.setContentAreaFilled(false);
        btnSelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSelMenu.setFocusable(false);
        btnSelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelMenuActionPerformed(evt);
            }
        });

        lblHelp.setBackground(new java.awt.Color(255, 255, 255));
        lblHelp.setOpaque(true);

        btnHelp.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(44, 62, 80));
        btnHelp.setText("HELP");
        btnHelp.setContentAreaFilled(false);
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.setFocusable(false);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Pristina", 0, 48)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(0, 0, 102));
        lblWelcome.setText("Welcome to Slider Puzzle");

        lblCreatedBy.setFont(new java.awt.Font("Microsoft Sans Serif", 3, 12)); // NOI18N
        lblCreatedBy.setForeground(new java.awt.Color(255, 51, 51));
        lblCreatedBy.setText("@created by: tal barzilay & roy levy");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTimeline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTimeline))
                .addGap(0, 0, 0)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblSelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelMenu))
                .addGap(0, 0, 0)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHelp))
                .addGap(416, 416, 416)
                .addComponent(lblCreatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHelp)
                            .addComponent(lblCreatedBy, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addComponent(lblHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                            .addComponent(btnTimeline)
                            .addGap(0, 0, 0)
                            .addComponent(lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                            .addComponent(btnSelMenu)
                            .addGap(0, 0, 0)
                            .addComponent(lblSelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pnlBody.setBackground(new java.awt.Color(204, 255, 255));
        pnlBody.setLayout(new java.awt.CardLayout());

        pnlPreview.setBackground(new java.awt.Color(153, 204, 255));

        pnlSelectedimg.setBackground(new java.awt.Color(153, 204, 255));

        lblSelImg.setBackground(new java.awt.Color(153, 204, 255));
        lblSelImg.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblSelImg.setForeground(new java.awt.Color(0, 102, 102));
        lblSelImg.setText("Selceted Image");

        lblSelPreview.setBackground(new java.awt.Color(153, 204, 255));

        pnlStart.setBackground(new java.awt.Color(153, 204, 255));

        btnStart.setBackground(new java.awt.Color(153, 204, 255));
        btnStart.setFont(new java.awt.Font("Rockwell", 2, 24)); // NOI18N
        btnStart.setForeground(new java.awt.Color(102, 0, 102));
        btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-play-50.png"))); // NOI18N
        btnStart.setText("Start");
        btnStart.setEnabled(false);
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        lblShuffleBoard.setBackground(new java.awt.Color(153, 204, 255));
        BgroupUse.add(lblShuffleBoard);
        lblShuffleBoard.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblShuffleBoard.setForeground(new java.awt.Color(0, 102, 102));
        lblShuffleBoard.setText("Shuffle Board?");
        lblShuffleBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblShuffleBoardActionPerformed(evt);
            }
        });

        lblUseCsv.setBackground(new java.awt.Color(153, 204, 255));
        BgroupUse.add(lblUseCsv);
        lblUseCsv.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblUseCsv.setForeground(new java.awt.Color(0, 102, 102));
        lblUseCsv.setText("Use Csv?");
        lblUseCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblUseCsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStartLayout = new javax.swing.GroupLayout(pnlStart);
        pnlStart.setLayout(pnlStartLayout);
        pnlStartLayout.setHorizontalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblShuffleBoard)
                    .addComponent(lblUseCsv))
                .addGap(0, 196, Short.MAX_VALUE))
        );
        pnlStartLayout.setVerticalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(lblShuffleBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUseCsv)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSelectedimgLayout = new javax.swing.GroupLayout(pnlSelectedimg);
        pnlSelectedimg.setLayout(pnlSelectedimgLayout);
        pnlSelectedimgLayout.setHorizontalGroup(
            pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                .addGroup(pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                        .addComponent(lblSelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlSelectedimgLayout.setVerticalGroup(
            pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                .addGroup(pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                        .addComponent(lblSelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(pnlStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pnlSelecedSize.setBackground(new java.awt.Color(153, 204, 255));
        pnlSelecedSize.setForeground(new java.awt.Color(102, 0, 102));

        lblSize.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblSize.setForeground(new java.awt.Color(0, 102, 102));
        lblSize.setText("Size");

        lblSelSize.setFont(new java.awt.Font("MV Boli", 0, 36)); // NOI18N
        lblSelSize.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout pnlSelecedSizeLayout = new javax.swing.GroupLayout(pnlSelecedSize);
        pnlSelecedSize.setLayout(pnlSelecedSizeLayout);
        pnlSelecedSizeLayout.setHorizontalGroup(
            pnlSelecedSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelecedSizeLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(pnlSelecedSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSize))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnlSelecedSizeLayout.setVerticalGroup(
            pnlSelecedSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelecedSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPreviewLayout = new javax.swing.GroupLayout(pnlPreview);
        pnlPreview.setLayout(pnlPreviewLayout);
        pnlPreviewLayout.setHorizontalGroup(
            pnlPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviewLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnlSelecedSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(pnlSelectedimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPreviewLayout.setVerticalGroup(
            pnlPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviewLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(pnlPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSelectedimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSelecedSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlBody.add(pnlPreview, "card2");

        pnlSelection.setBackground(new java.awt.Color(153, 204, 255));

        pnlSelimg.setBackground(new java.awt.Color(153, 204, 255));

        btnAddImg.setBackground(new java.awt.Color(153, 204, 255));
        btnAddImg.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        btnAddImg.setForeground(new java.awt.Color(102, 0, 102));
        btnAddImg.setText("Add Image");

        lblSelImgPlease.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblSelImgPlease.setForeground(new java.awt.Color(0, 102, 102));
        lblSelImgPlease.setText("Please Select an Image");

        imgList.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        imgList.setModel(model);
        imgList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        imgList.setSelectedIndex(0);
        imgList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imgListValueChanged(evt);
            }
        });
        imgListSP.setViewportView(imgList);

        javax.swing.GroupLayout pnlSelimgLayout = new javax.swing.GroupLayout(pnlSelimg);
        pnlSelimg.setLayout(pnlSelimgLayout);
        pnlSelimgLayout.setHorizontalGroup(
            pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelimgLayout.createSequentialGroup()
                .addGroup(pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelimgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSelimgLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(imgListSP, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSelImgPlease)))
                    .addGroup(pnlSelimgLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(btnAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 86, Short.MAX_VALUE))
        );
        pnlSelimgLayout.setVerticalGroup(
            pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelimgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSelImgPlease)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imgListSP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pnlImagePrev.setBackground(new java.awt.Color(153, 204, 255));

        btnRandImg.setBackground(new java.awt.Color(153, 204, 255));
        btnRandImg.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        btnRandImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-shuffle-64.png"))); // NOI18N
        btnRandImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImagePrevLayout = new javax.swing.GroupLayout(pnlImagePrev);
        pnlImagePrev.setLayout(pnlImagePrevLayout);
        pnlImagePrevLayout.setHorizontalGroup(
            pnlImagePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagePrevLayout.createSequentialGroup()
                .addComponent(lblImgSelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(pnlImagePrevLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(btnRandImg, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlImagePrevLayout.setVerticalGroup(
            pnlImagePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagePrevLayout.createSequentialGroup()
                .addComponent(lblImgSelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRandImg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlSelSize.setBackground(new java.awt.Color(153, 204, 255));

        lblSelSizeMenu.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        lblSelSizeMenu.setForeground(new java.awt.Color(0, 102, 102));
        lblSelSizeMenu.setText("Select Puzzle Size");

        lblSize3.setBackground(new java.awt.Color(153, 204, 255));
        BgroupSize.add(lblSize3);
        lblSize3.setFont(new java.awt.Font("Rockwell", 2, 14)); // NOI18N
        lblSize3.setForeground(new java.awt.Color(102, 0, 102));
        lblSize3.setText("3X3");
        lblSize3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSize3ActionPerformed(evt);
            }
        });

        lblSize4.setBackground(new java.awt.Color(153, 204, 255));
        BgroupSize.add(lblSize4);
        lblSize4.setFont(new java.awt.Font("Rockwell", 2, 14)); // NOI18N
        lblSize4.setForeground(new java.awt.Color(102, 0, 102));
        lblSize4.setText("4X4");
        lblSize4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSize4ActionPerformed(evt);
            }
        });

        lblSize5.setBackground(new java.awt.Color(153, 204, 255));
        BgroupSize.add(lblSize5);
        lblSize5.setFont(new java.awt.Font("Rockwell", 2, 14)); // NOI18N
        lblSize5.setForeground(new java.awt.Color(102, 0, 102));
        lblSize5.setText("5X5");
        lblSize5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSize5ActionPerformed(evt);
            }
        });

        _lblEnterSIze.setBackground(new java.awt.Color(153, 204, 255));
        BgroupSize.add(_lblEnterSIze);
        _lblEnterSIze.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        _lblEnterSIze.setForeground(new java.awt.Color(102, 0, 102));
        _lblEnterSIze.setText("Enter Size");
        _lblEnterSIze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _lblEnterSIzeActionPerformed(evt);
            }
        });

        _tfEnterSize.setEnabled(false);
        _tfEnterSize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _tfEnterSizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSelSizeLayout = new javax.swing.GroupLayout(pnlSelSize);
        pnlSelSize.setLayout(pnlSelSizeLayout);
        pnlSelSizeLayout.setHorizontalGroup(
            pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelSizeLayout.createSequentialGroup()
                .addGroup(pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelSizeLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSize4)
                            .addComponent(lblSize3)
                            .addComponent(lblSize5)
                            .addComponent(_lblEnterSIze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(_tfEnterSize)))
                    .addGroup(pnlSelSizeLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblSelSizeMenu)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnlSelSizeLayout.setVerticalGroup(
            pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelSizeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSelSizeMenu)
                .addGap(32, 32, 32)
                .addComponent(lblSize3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSize4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSize5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_lblEnterSIze)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfEnterSize, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSelectionLayout = new javax.swing.GroupLayout(pnlSelection);
        pnlSelection.setLayout(pnlSelectionLayout);
        pnlSelectionLayout.setHorizontalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlSelimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlImagePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(pnlSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlSelectionLayout.setVerticalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectionLayout.createSequentialGroup()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSelectionLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlImagePrev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlSelimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );

        pnlBody.add(pnlSelection, "card3");

        pnlHelp.setBackground(new java.awt.Color(153, 204, 255));

        lblHelpMeu.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout pnlHelpLayout = new javax.swing.GroupLayout(pnlHelp);
        pnlHelp.setLayout(pnlHelpLayout);
        pnlHelpLayout.setHorizontalGroup(
            pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelpLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblHelpMeu, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        pnlHelpLayout.setVerticalGroup(
            pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelpLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblHelpMeu, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pnlBody.add(pnlHelp, "card4");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(pnlBody, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    /**
     * creates a puzzle based on user request
     * @param evt 
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (_useCsv) {
            try {
                new GameFrame(ImageHandler.BuildImagesMap(selSize, imgList.getSelectedValue()), csvBoard(), imgList.getSelectedValue());
                dispose();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "No Boards By this Size,Try Again","Failure", JOptionPane.ERROR_MESSAGE);
            }
        } else if (_shuffle) {
            new GameFrame(selSize, imgList.getSelectedValue());
            dispose();
        }
    }//GEN-LAST:event_btnStartActionPerformed
    
    
    private void btnTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimelineActionPerformed
        lblTimeline.setBackground(new Color(0,204,106));

        lblSelMenu.setBackground(new Color(255,255,255));
        lblHelp.setBackground(new Color(255,255,255));

        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlPreview);
        pnlBody.repaint();
        pnlBody.revalidate();
    }//GEN-LAST:event_btnTimelineActionPerformed

    private void btnSelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelMenuActionPerformed
        lblSelMenu.setBackground(new Color(0,204,106));

        lblTimeline.setBackground(new Color(255,255,255));
        lblHelp.setBackground(new Color(255,255,255));

        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlSelection);
        pnlBody.repaint();
        pnlBody.revalidate();
        
        updateLabel(imgArr[0]);
    }//GEN-LAST:event_btnSelMenuActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        lblHelp.setBackground(new Color(0,204,106));

        lblSelMenu.setBackground(new Color(255,255,255));
        lblTimeline.setBackground(new Color(255,255,255));

        pnlBody.removeAll();
        pnlBody.repaint();
        pnlBody.revalidate();
        pnlBody.add(pnlHelp);
        pnlBody.repaint();
        pnlBody.revalidate();
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnRandImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandImgActionPerformed
        int index = (int) Math.floor(Math.random() * aList.size());
        imgList.setSelectedIndex(index);
    }//GEN-LAST:event_btnRandImgActionPerformed

    private void lblSize3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSize3ActionPerformed
        setSizeLbl("3");
        selSize = 3;
        _tfEnterSize.setEnabled(false);
    }//GEN-LAST:event_lblSize3ActionPerformed

    
    private void lblSize5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSize5ActionPerformed
      setSizeLbl("5");
      selSize = 5;
      _tfEnterSize.setEnabled(false);
    }//GEN-LAST:event_lblSize5ActionPerformed

    private void lblSize4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSize4ActionPerformed
        setSizeLbl("4");
        selSize = 4;
        _tfEnterSize.setEnabled(false);
    }//GEN-LAST:event_lblSize4ActionPerformed

    private void imgListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imgListValueChanged
        JList list = (JList)evt.getSource();
        updateLabel(imgArr[list.getSelectedIndex()]);
        if(lblSelSize.getText()!="")
            btnStart.setEnabled(true);
    }//GEN-LAST:event_imgListValueChanged

    private void updateLabel(String pic) {
        ImageHandler.setRefLbl(pic, lblImgSelPrev);
        ImageHandler.setRefLbl(pic, lblSelPreview);
    }
    private void _lblEnterSIzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__lblEnterSIzeActionPerformed
        _tfEnterSize.setEnabled(true);
    }//GEN-LAST:event__lblEnterSIzeActionPerformed

    private void _tfEnterSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfEnterSizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event__tfEnterSizeActionPerformed

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

    private void lblShuffleBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblShuffleBoardActionPerformed
        _shuffle = true;
        _useCsv = false;
    }//GEN-LAST:event_lblShuffleBoardActionPerformed

    private void lblUseCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblUseCsvActionPerformed
        _shuffle = false;
        _useCsv = true;
    }//GEN-LAST:event_lblUseCsvActionPerformed
    
    private static boolean maximized = true;
    private int xMouse;
    private int yMouse;
    private boolean _useCsv;
    private boolean _shuffle;
    private ReadCsv _read;
    private int selSize;
    private DefaultListModel model;
    private ArrayList<String> aList;
    private final String[] imgArr = {"cat","cyber","sushi"};
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BgroupSize;
    private javax.swing.ButtonGroup BgroupUse;
    private javax.swing.JRadioButton _lblEnterSIze;
    private javax.swing.JTextField _tfEnterSize;
    private javax.swing.JButton btnAddImg;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRandImg;
    private javax.swing.JButton btnSelMenu;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnTimeline;
    private javax.swing.JList<String> imgList;
    private javax.swing.JScrollPane imgListSP;
    private javax.swing.JLabel lblCreatedBy;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblHelpMeu;
    private javax.swing.JLabel lblImgSelPrev;
    private javax.swing.JLabel lblSelImg;
    private javax.swing.JLabel lblSelImgPlease;
    private javax.swing.JLabel lblSelMenu;
    private javax.swing.JLabel lblSelPreview;
    private javax.swing.JLabel lblSelSize;
    private javax.swing.JLabel lblSelSizeMenu;
    private javax.swing.JRadioButton lblShuffleBoard;
    private javax.swing.JLabel lblSize;
    private javax.swing.JRadioButton lblSize3;
    private javax.swing.JRadioButton lblSize4;
    private javax.swing.JRadioButton lblSize5;
    private javax.swing.JLabel lblTimeline;
    private javax.swing.JRadioButton lblUseCsv;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHelp;
    private javax.swing.JPanel pnlImagePrev;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPreview;
    private javax.swing.JPanel pnlSelSize;
    private javax.swing.JPanel pnlSelecedSize;
    private javax.swing.JPanel pnlSelectedimg;
    private javax.swing.JPanel pnlSelection;
    private javax.swing.JPanel pnlSelimg;
    private javax.swing.JPanel pnlStart;
    // End of variables declaration//GEN-END:variables

}
