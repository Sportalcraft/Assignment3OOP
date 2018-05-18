/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.*;

import ImageHandling.ImageHandler;

import CsvReader.ReadCsv;


public class MainMenu extends JFrame {
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu(ReadCsv read) {
         addInitialImg(_imgArr);
        _read = read;
        _newImage = false;
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
        
        Integer[][] temp = _read.randomBaord(_selSize);

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
        _lblSelSize.setText(size + "X" + size);
        enableStartIfPossible();
    }
    /**
     * adds the initial images to the list of images
     * @param ImgArr 
     */
    private void addInitialImg(String[] ImgArr) {
        _aList = new ArrayList<>(Arrays.asList(ImgArr));
        _model = new DefaultListModel();
        for (int i = 0; i < _aList.size(); i++) {
            _model.addElement(_aList.get(i));
        }
        
    }
    private String addHelpText(){
        String help ="<html>Welcome to Slider Puzzle!!!<br/><br/>" +
                "Here are some tips and rules for making your experience more fun:<br/>" +
                "-----------------------------------------------------------------------------------------------------------------" +
                "<br/>GENERAL DESCRIPTION: The game consist of sliding parts of an image to it's right position," +
                "<br/>to do so you can use the arrows on your keyBoard or click on the image you wish to move.</br>" +
                "<br/>In order to undo your last moves you can press CTRL+Z or click on the undo Button.</br>" +
                "<br/><br/>Choosing Image and Size: In the Image & Size tab you can choose from a 3 default images we provided," +
                "<br/> or you can upload your own image.<br/> You can also choose an image randomly from the deafult images" +
                " by clicking on the Random button. " +
                "<br/> NOTICE: uploaded images must by in jpeg/jpg format only<br/>" +
                "<br/>For Choosing size there are few possibilities:<br/>1. if you choose our default images you must choose from" +
                " our provided sizes.<br/> 2. if you uploaded an images you must choose from provided sizes, or enter a size that is grater than 1." +
                "<br/><br/>Board Representation : In the Preview Tab you can either choose to use CSV file or shuffle" +
                " randomly the board,<br/> either one will determine how the board will be presented in the game." +
                "<br/><br/>At any time you can Exit the game via the X button on the top of the Screen, <br/> you can also return to the Main Menu" +
                " when you are in game session.<br/>NOTICE: this action will end the current game.";
        return help;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="initialization">//GEN-BEGIN:initComponents
    private void initComponents() {

        _BgroupSize = new javax.swing.ButtonGroup();
        _BgroupUse = new javax.swing.ButtonGroup();
        _pnlMenu = new javax.swing.JPanel();
        _btnTimeline = new javax.swing.JButton();
        _lblTimeline = new javax.swing.JLabel();
        _lblSelMenu = new javax.swing.JLabel();
        _btnSelMenu = new javax.swing.JButton();
        _lblHelp = new javax.swing.JLabel();
        _btnHelp = new javax.swing.JButton();
        _lblWelcome = new javax.swing.JLabel();
        _lblCreatedBy = new javax.swing.JLabel();
        _pnlBody = new javax.swing.JPanel();
        _pnlPreview = new javax.swing.JPanel();
        _pnlSelectedimg = new javax.swing.JPanel();
        _lblSelImg = new javax.swing.JLabel();
        _lblSelPreview = new javax.swing.JLabel();
        _pnlStart = new javax.swing.JPanel();
        _btnStart = new javax.swing.JButton();
        _lblShuffleBoard = new javax.swing.JRadioButton();
        _lblUseCsv = new javax.swing.JRadioButton();
        _pnlSelecedSize = new javax.swing.JPanel();
        _lblSize = new javax.swing.JLabel();
        _lblSelSize = new javax.swing.JLabel();
        _pnlSelection = new javax.swing.JPanel();
        _pnlSelimg = new javax.swing.JPanel();
        _btnAddImg = new javax.swing.JButton();
        _lblSelImgPlease = new javax.swing.JLabel();
        _imgListSP = new javax.swing.JScrollPane();
        _imgList = new javax.swing.JList<>();
        _pnlImagePrev = new javax.swing.JPanel();
        _lblImgSelPrev = new javax.swing.JLabel();
        _btnRandImg = new javax.swing.JButton();
        _pnlSelSize = new javax.swing.JPanel();
        _lblSelSizeMenu = new javax.swing.JLabel();
        _lblSize3 = new javax.swing.JRadioButton();
        _lblSize4 = new javax.swing.JRadioButton();
        _lblSize5 = new javax.swing.JRadioButton();
        _lblEnterSIze = new javax.swing.JRadioButton();
        _tfEnterSize = new javax.swing.JTextField();
        _pnlHelp = new javax.swing.JPanel();
        _lblHelpMenu = new javax.swing.JLabel(addHelpText());
        _pnlHeader = new javax.swing.JPanel();
        _btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main Menu");
        setName("mainMenuFrame"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        setSize(new java.awt.Dimension(1000, 600));
        this.setVisible(true);

        _pnlMenu.setBackground(new java.awt.Color(255, 146, 154));

        _btnTimeline.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        _btnTimeline.setForeground(new java.awt.Color(44, 62, 80));
        _btnTimeline.setText("Preview");
        _btnTimeline.setContentAreaFilled(false);
        _btnTimeline.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _btnTimeline.setFocusable(false);
        _btnTimeline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimelineActionPerformed(evt);
            }
        });

        _lblTimeline.setBackground(new java.awt.Color(0, 204, 106));
        _lblTimeline.setOpaque(true);

        _lblSelMenu.setBackground(new java.awt.Color(255, 255, 255));
        _lblSelMenu.setOpaque(true);

        _btnSelMenu.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        _btnSelMenu.setForeground(new java.awt.Color(44, 62, 80));
        _btnSelMenu.setText("Image & Size");
        _btnSelMenu.setContentAreaFilled(false);
        _btnSelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _btnSelMenu.setFocusable(false);
        _btnSelMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelMenuActionPerformed(evt);
            }
        });    
        
        _lblHelp.setBackground(new java.awt.Color(255, 255, 255));
        _lblHelp.setOpaque(true);

        _btnHelp.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 16)); // NOI18N
        _btnHelp.setForeground(new java.awt.Color(44, 62, 80));
        _btnHelp.setText("HELP");
        _btnHelp.setContentAreaFilled(false);
        _btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        _btnHelp.setFocusable(false);
        _btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        _lblWelcome.setFont(new java.awt.Font("Pristina", 0, 35)); // NOI18N
        _lblWelcome.setForeground(new java.awt.Color(0, 0, 102));
        _lblWelcome.setText("Welcome to Slider Puzzle");

        _lblCreatedBy.setFont(new java.awt.Font("Microsoft Sans Serif", 3, 12)); // NOI18N
        _lblCreatedBy.setForeground(new java.awt.Color(255, 51, 51));
        _lblCreatedBy.setText("@created by: tal barzilay & roy levy");

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(_pnlMenu);
        _pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_lblTimeline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btnTimeline))
                .addGap(0, 0, 0)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_lblSelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btnSelMenu))
                .addGap(0, 0, 0)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(_lblHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(_btnHelp))
                .addGap(416, 416, 416)
                .addComponent(_lblCreatedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(_lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(_lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuLayout.createSequentialGroup()
                        .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_btnHelp)
                            .addComponent(_lblCreatedBy, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(0, 0, 0)
                        .addComponent(_lblHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                            .addComponent(_btnTimeline)
                            .addGap(0, 0, 0)
                            .addComponent(_lblTimeline, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuLayout.createSequentialGroup()
                            .addComponent(_btnSelMenu)
                            .addGap(0, 0, 0)
                            .addComponent(_lblSelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        _pnlBody.setBackground(new java.awt.Color(204, 255, 255));
        _pnlBody.setLayout(new java.awt.CardLayout());

        _pnlPreview.setBackground(new java.awt.Color(153, 204, 255));

        _pnlSelectedimg.setBackground(new java.awt.Color(153, 204, 255));

        _lblSelImg.setBackground(new java.awt.Color(153, 204, 255));
        _lblSelImg.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _lblSelImg.setForeground(new java.awt.Color(0, 102, 102));
        _lblSelImg.setText("Selceted Image");

        _lblSelPreview.setBackground(new java.awt.Color(153, 204, 255));

        _pnlStart.setBackground(new java.awt.Color(153, 204, 255));

        _btnStart.setBackground(new java.awt.Color(153, 204, 255));
        _btnStart.setFont(new java.awt.Font("Rockwell", 2, 24)); // NOI18N
        _btnStart.setForeground(new java.awt.Color(102, 0, 102));
        _btnStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-play-50.png"))); // NOI18N
        _btnStart.setText("Start");
        _btnStart.setEnabled(false);
        _btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        _lblShuffleBoard.setBackground(new java.awt.Color(153, 204, 255));
        _BgroupUse.add(_lblShuffleBoard);
        _lblShuffleBoard.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _lblShuffleBoard.setForeground(new java.awt.Color(0, 102, 102));
        _lblShuffleBoard.setText("Shuffle Board?");
        _lblShuffleBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblShuffleBoardActionPerformed(evt);
            }
        });

        _lblUseCsv.setBackground(new java.awt.Color(153, 204, 255));
        _BgroupUse.add(_lblUseCsv);
        _lblUseCsv.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _lblUseCsv.setForeground(new java.awt.Color(0, 102, 102));
        _lblUseCsv.setText("Use Csv?");
        _lblUseCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblUseCsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStartLayout = new javax.swing.GroupLayout(_pnlStart);
        _pnlStart.setLayout(pnlStartLayout);
        pnlStartLayout.setHorizontalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGroup(pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_lblShuffleBoard)
                    .addComponent(_lblUseCsv))
                .addGap(0, 196, Short.MAX_VALUE))
        );
        pnlStartLayout.setVerticalGroup(
            pnlStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStartLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(_btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(_lblShuffleBoard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_lblUseCsv)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSelectedimgLayout = new javax.swing.GroupLayout(_pnlSelectedimg);
        _pnlSelectedimg.setLayout(pnlSelectedimgLayout);
        pnlSelectedimgLayout.setHorizontalGroup(
            pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                .addGroup(pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_lblSelImg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                        .addComponent(_lblSelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_pnlStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlSelectedimgLayout.setVerticalGroup(
            pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                .addGroup(pnlSelectedimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                        .addComponent(_lblSelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(_lblSelPreview, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSelectedimgLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(_pnlStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        _pnlSelecedSize.setBackground(new java.awt.Color(153, 204, 255));
        _pnlSelecedSize.setForeground(new java.awt.Color(102, 0, 102));

        _lblSize.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _lblSize.setForeground(new java.awt.Color(0, 102, 102));
        _lblSize.setText("Size");

        _lblSelSize.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        _lblSelSize.setForeground(new java.awt.Color(102, 0, 102));

        javax.swing.GroupLayout pnlSelecedSizeLayout = new javax.swing.GroupLayout(_pnlSelecedSize);
        _pnlSelecedSize.setLayout(pnlSelecedSizeLayout);
        pnlSelecedSizeLayout.setHorizontalGroup(
            pnlSelecedSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelecedSizeLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(pnlSelecedSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_lblSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_lblSize))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        pnlSelecedSizeLayout.setVerticalGroup(
            pnlSelecedSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelecedSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_lblSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlPreviewLayout = new javax.swing.GroupLayout(_pnlPreview);
        _pnlPreview.setLayout(pnlPreviewLayout);
        pnlPreviewLayout.setHorizontalGroup(
            pnlPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviewLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(_pnlSelecedSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(_pnlSelectedimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPreviewLayout.setVerticalGroup(
            pnlPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreviewLayout.createSequentialGroup()
                .addContainerGap(58, Short.MAX_VALUE)
                .addGroup(pnlPreviewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(_pnlSelectedimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(_pnlSelecedSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        _pnlBody.add(_pnlPreview, "card2");

        _pnlSelection.setBackground(new java.awt.Color(153, 204, 255));

        _pnlSelimg.setBackground(new java.awt.Color(153, 204, 255));

        _btnAddImg.setBackground(new java.awt.Color(153, 204, 255));
        _btnAddImg.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _btnAddImg.setForeground(new java.awt.Color(153, 0, 255));
        _btnAddImg.setText("Add Image");

        
        
        
        
        
        _btnAddImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                try{
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				String s = f.getAbsolutePath();
				
				String[] temp = s.split(Pattern.quote("."));
				
				if(temp.length == 0 || !temp[temp.length -1].equals("jpg") & !temp[temp.length -1].equals("jpeg"))
				{
					JOptionPane.showMessageDialog(null,
		                    "Please upload a JPEG/JPG file only", "Not valid photo", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				ImageIcon imgIc = new ImageIcon(s);
			    Image img = imgIc.getImage();
			    
			    Image scImg = img.getScaledInstance(_lblImgSelPrev.getWidth(), _lblImgSelPrev.getHeight(), Image.SCALE_SMOOTH);
				_lblImgSelPrev.setIcon(new ImageIcon(scImg));
				
				scImg = img.getScaledInstance(_lblImgSelPrev.getWidth(), _lblImgSelPrev.getHeight(), Image.SCALE_SMOOTH);
				_lblSelPreview.setIcon(new ImageIcon(scImg));
				
				_newImage = true;
				_newImagePath = s;
                }
                catch(Exception exp){}
			}});

        
        
        
        
        
        

        _lblSelImgPlease.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _lblSelImgPlease.setForeground(new java.awt.Color(0, 102, 102));
        _lblSelImgPlease.setText("Please Select an Image");

        _imgList.setFont(new java.awt.Font("MV Boli", 0, 18)); // NOI18N
        _imgList.setModel(_model);
        _imgList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        _imgList.setSelectedIndex(0);
        _imgList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                imgListValueChanged(evt);
            }
        });
        _imgListSP.setViewportView(_imgList);

        javax.swing.GroupLayout pnlSelimgLayout = new javax.swing.GroupLayout(_pnlSelimg);
        _pnlSelimg.setLayout(pnlSelimgLayout);
        pnlSelimgLayout.setHorizontalGroup(
            pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelimgLayout.createSequentialGroup()
                .addGroup(pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelimgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSelimgLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(_imgListSP, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(_lblSelImgPlease)))
                    .addGroup(pnlSelimgLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(_btnAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 86, Short.MAX_VALUE))
        );
        pnlSelimgLayout.setVerticalGroup(
            pnlSelimgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelimgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_lblSelImgPlease)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_imgListSP, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(_btnAddImg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        _pnlImagePrev.setBackground(new java.awt.Color(153, 204, 255));

        _btnRandImg.setBackground(new java.awt.Color(153, 204, 255));
        _btnRandImg.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        _btnRandImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UIres/icons8-shuffle-64.png"))); // NOI18N
        _btnRandImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRandImgActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImagePrevLayout = new javax.swing.GroupLayout(_pnlImagePrev);
        _pnlImagePrev.setLayout(pnlImagePrevLayout);
        pnlImagePrevLayout.setHorizontalGroup(
            pnlImagePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagePrevLayout.createSequentialGroup()
                .addComponent(_lblImgSelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
            .addGroup(pnlImagePrevLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(_btnRandImg, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlImagePrevLayout.setVerticalGroup(
            pnlImagePrevLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlImagePrevLayout.createSequentialGroup()
                .addComponent(_lblImgSelPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(_btnRandImg, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        _pnlSelSize.setBackground(new java.awt.Color(153, 204, 255));

        _lblSelSizeMenu.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        _lblSelSizeMenu.setForeground(new java.awt.Color(0, 102, 102));
        _lblSelSizeMenu.setText("Select Puzzle Size");

        _lblSize3.setBackground(new java.awt.Color(153, 204, 255));
        _BgroupSize.add(_lblSize3);
        _lblSize3.setFont(new java.awt.Font("Rockwell", 2, 14)); // NOI18N
        _lblSize3.setForeground(new java.awt.Color(102, 0, 102));
        _lblSize3.setText("3X3");
        _lblSize3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSize3ActionPerformed(evt);
            }
        });

        _lblSize4.setBackground(new java.awt.Color(153, 204, 255));
        _BgroupSize.add(_lblSize4);
        _lblSize4.setFont(new java.awt.Font("Rockwell", 2, 14)); // NOI18N
        _lblSize4.setForeground(new java.awt.Color(102, 0, 102));
        _lblSize4.setText("4X4");
        _lblSize4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSize4ActionPerformed(evt);
            }
        });

        _lblSize5.setBackground(new java.awt.Color(153, 204, 255));
        _BgroupSize.add(_lblSize5);
        _lblSize5.setFont(new java.awt.Font("Rockwell", 2, 14)); // NOI18N
        _lblSize5.setForeground(new java.awt.Color(102, 0, 102));
        _lblSize5.setText("5X5");
        _lblSize5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSize5ActionPerformed(evt);
            }
        });

        _lblEnterSIze.setBackground(new java.awt.Color(153, 204, 255));
        _BgroupSize.add(_lblEnterSIze);
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

        javax.swing.GroupLayout pnlSelSizeLayout = new javax.swing.GroupLayout(_pnlSelSize);
        _pnlSelSize.setLayout(pnlSelSizeLayout);
        pnlSelSizeLayout.setHorizontalGroup(
            pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelSizeLayout.createSequentialGroup()
                .addGroup(pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSelSizeLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(_lblSize4)
                            .addComponent(_lblSize3)
                            .addComponent(_lblSize5)
                            .addComponent(_lblEnterSIze, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(_tfEnterSize)))
                    .addGroup(pnlSelSizeLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(_lblSelSizeMenu)))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        pnlSelSizeLayout.setVerticalGroup(
            pnlSelSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelSizeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(_lblSelSizeMenu)
                .addGap(32, 32, 32)
                .addComponent(_lblSize3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_lblSize4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_lblSize5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_lblEnterSIze)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_tfEnterSize, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlSelectionLayout = new javax.swing.GroupLayout(_pnlSelection);
        _pnlSelection.setLayout(pnlSelectionLayout);
        pnlSelectionLayout.setHorizontalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSelectionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(_pnlSelimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(_pnlImagePrev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(_pnlSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        pnlSelectionLayout.setVerticalGroup(
            pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSelectionLayout.createSequentialGroup()
                .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlSelectionLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(pnlSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(_pnlSelSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(_pnlImagePrev, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlSelectionLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(_pnlSelimg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );

        _pnlBody.add(_pnlSelection, "card3");

        _pnlHelp.setBackground(new java.awt.Color(153, 204, 255));

        _lblHelpMenu.setBackground(new java.awt.Color(153, 204, 255));
        _lblHelpMenu.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        _lblHelpMenu.setForeground(new java.awt.Color(44, 62, 80));

        javax.swing.GroupLayout pnlHelpLayout = new javax.swing.GroupLayout(_pnlHelp);
        _pnlHelp.setLayout(pnlHelpLayout);
        pnlHelpLayout.setHorizontalGroup(
            pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelpLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(_lblHelpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        pnlHelpLayout.setVerticalGroup(
            pnlHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHelpLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(_lblHelpMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        _pnlBody.add(_pnlHelp, "card4");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(_pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(_pnlBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(_pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(_pnlHeader, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(_pnlMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(_pnlBody, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);     
    }// </editor-fold>//GEN-END:initComponents

    

    /**
     * creates a puzzle based on user request
     * @param evt 
     */
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
    	try {	  		
    		if(_useCsv)
    		{
    			if(_newImage)
    				new GameFrame(_newImagePath, csvBoard());
    			else
    				new GameFrame(ImageHandler.BuildImagesMap(_selSize, _imgList.getSelectedValue()), csvBoard(), _imgList.getSelectedValue());
    		}
    		
    		if (_shuffle)
    		{
    			if(_newImage)
    				new GameFrame(_newImagePath, _selSize);
    			else
    				new GameFrame(_selSize, _imgList.getSelectedValue());
    		}
    	}
    	catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Failed to create the board","Failure", JOptionPane.ERROR_MESSAGE);
        }
    	
    	dispose();
    }//GEN-LAST:event_btnStartActionPerformed
    
    
    private void btnTimelineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimelineActionPerformed
        _lblTimeline.setBackground(new Color(0,204,106));

        _lblSelMenu.setBackground(new Color(255,255,255));
        _lblHelp.setBackground(new Color(255,255,255));

        _pnlBody.removeAll();
        _pnlBody.repaint();
        _pnlBody.revalidate();
        _pnlBody.add(_pnlPreview);
        _pnlBody.repaint();
        _pnlBody.revalidate();
    }//GEN-LAST:event_btnTimelineActionPerformed

    private void btnSelMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelMenuActionPerformed
        _lblSelMenu.setBackground(new Color(0,204,106));

        _lblTimeline.setBackground(new Color(255,255,255));
        _lblHelp.setBackground(new Color(255,255,255));

        _pnlBody.removeAll();
        _pnlBody.repaint();
        _pnlBody.revalidate();
        _pnlBody.add(_pnlSelection);
        _pnlBody.repaint();
        _pnlBody.revalidate();

        //updateLabel(_imgArr[0]);
        
    }//GEN-LAST:event_btnSelMenuActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        _lblHelp.setBackground(new Color(0,204,106));

        _lblSelMenu.setBackground(new Color(255,255,255));
        _lblTimeline.setBackground(new Color(255,255,255));

        _pnlBody.removeAll();
        _pnlBody.repaint();
        _pnlBody.revalidate();
        _pnlBody.add(_pnlHelp);
        _pnlBody.repaint();
        _pnlBody.revalidate();
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnRandImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRandImgActionPerformed
        int index = (int) Math.floor(Math.random() * _aList.size());
        _imgList.setSelectedIndex(index);
    }//GEN-LAST:event_btnRandImgActionPerformed

    private void lblSize3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSize3ActionPerformed
        setSizeLbl("3");
        _selSize = 3;
        _tfEnterSize.setEnabled(false);
    }//GEN-LAST:event_lblSize3ActionPerformed

    
    private void lblSize5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSize5ActionPerformed
      setSizeLbl("5");
      _selSize = 5;
      _tfEnterSize.setEnabled(false);
    }//GEN-LAST:event_lblSize5ActionPerformed

    private void lblSize4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSize4ActionPerformed
        setSizeLbl("4");
        _selSize = 4;
        _tfEnterSize.setEnabled(false);
    }//GEN-LAST:event_lblSize4ActionPerformed

    private void imgListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_imgListValueChanged
        JList list = (JList)evt.getSource();
        updateLabel(_imgArr[list.getSelectedIndex()]);
        
    }//GEN-LAST:event_imgListValueChanged

    private void updateLabel(String pic) {
        ImageHandler.scaledImg(ImageHandler.SavedPhotoPath(pic), _lblImgSelPrev);
        ImageHandler.scaledImg(ImageHandler.SavedPhotoPath(pic), _lblSelPreview);
        enableStartIfPossible();
    }
    private void _lblEnterSIzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__lblEnterSIzeActionPerformed
    	_tfEnterSize.setEnabled(true);
    }//GEN-LAST:event__lblEnterSIzeActionPerformed

    private void _tfEnterSizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__tfEnterSizeActionPerformed
    	Integer t = null; 
		
		try
       	 {
			 t = Integer.parseInt(_tfEnterSize.getText());
       	 }
       	 catch(Exception e)
       	 {
 			try
 			{
 				String[] temp = _tfEnterSize.getText().split("X");
 				
 				if(temp.length != 2)
 				{
 					temp = _tfEnterSize.getText().split("x");
 					
 					if(temp.length != 2)
 	 				{
 	 					temp = _tfEnterSize.getText().split("x");
 	 					
 	 					JOptionPane.showMessageDialog(null,
 	 	 	                    "Not valid size!", "check input!", JOptionPane.ERROR_MESSAGE);
 	 	 	 			return;
 	 				}
 				} 				
 				
 				if(!temp[0].equals(temp[1]))
 				{
 					JOptionPane.showMessageDialog(null,
 	 	                    "Sqares Only!", "check input!", JOptionPane.ERROR_MESSAGE);
 	 	 			return;
 				}
 				
 				t = Integer.parseInt(temp[0]);
 			}
 			 catch(Exception ex)
 	       	 {
 				JOptionPane.showMessageDialog(null,
 	                    "Your input is not a number", "check input!", JOptionPane.ERROR_MESSAGE);
 	 			return;
 	       	 }
       	 }
	
         if(t < 2) //Not legal board size
 		{
 			JOptionPane.showMessageDialog(null,
                     "bords size must be atleast 2!", "error", JOptionPane.ERROR_MESSAGE);
 			return;
 		}
         
		if(!_newImage & (t <3 | t>5)) //Not legal for static saved images
		{
			JOptionPane.showMessageDialog(null,
                    "pre saved images can be used only in sizes between 3 and 5!", "error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		 setSizeLbl(t.toString());
         _selSize = t;
		
		
    }//GEN-LAST:event__tfEnterSizeActionPerformed

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
        enableStartIfPossible();
    }//GEN-LAST:event_lblShuffleBoardActionPerformed

    private void lblUseCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblUseCsvActionPerformed
        _shuffle = false;
        _useCsv = true;
        enableStartIfPossible();
    }//GEN-LAST:event_lblUseCsvActionPerformed

    /**
     * enables the start button if size and image has been selected
     */
    private void enableStartIfPossible()
    {
    	if(_lblSelSize.getText()!="" & _lblImgSelPrev.getIcon() != null & _BgroupUse.getSelection() != null) //All info selected
            _btnStart.setEnabled(true);
    }

    // Variables declaration//GEN-BEGIN:variables
    private static boolean maximized = true;
    private int xMouse;
    private int yMouse;
    private boolean _useCsv;
    private boolean _shuffle;
    private boolean _newImage;
    private String _newImagePath;
    private ReadCsv _read;
    private int _selSize;
    private DefaultListModel _model;
    private ArrayList<String> _aList;
    private final String[] _imgArr = {"cat","cyber","sushi"};
    private ButtonGroup _BgroupSize;
    private ButtonGroup _BgroupUse;
    private JRadioButton _lblEnterSIze;
    private JTextField _tfEnterSize;
    private JButton _btnAddImg;
    private JButton _btnExit;
    private JButton _btnHelp;
    private JButton _btnRandImg;
    private JButton _btnSelMenu;
    private JButton _btnStart;
    private JButton _btnTimeline;
    private JList<String> _imgList;
    private JScrollPane _imgListSP;
    private JLabel _lblCreatedBy;
    private JLabel _lblHelp;
    private JLabel _lblHelpMenu;
    private JLabel _lblImgSelPrev;
    private JLabel _lblSelImg;
    private JLabel _lblSelImgPlease;
    private JLabel _lblSelMenu;
    private JLabel _lblSelPreview;
    private JLabel _lblSelSize;
    private JLabel _lblSelSizeMenu;
    private JRadioButton _lblShuffleBoard;
    private JLabel _lblSize;
    private JRadioButton _lblSize3;
    private JRadioButton _lblSize4;
    private JRadioButton _lblSize5;
    private JLabel _lblTimeline;
    private JRadioButton _lblUseCsv;
    private JLabel _lblWelcome;
    private JPanel _pnlBody;
    private JPanel _pnlHeader;
    private JPanel _pnlHelp;
    private JPanel _pnlImagePrev;
    private JPanel _pnlMenu;
    private JPanel _pnlPreview;
    private JPanel _pnlSelSize;
    private JPanel _pnlSelecedSize;
    private JPanel _pnlSelectedimg;
    private JPanel _pnlSelection;
    private JPanel _pnlSelimg;
    private JPanel _pnlStart;
    // End of variables declaration//GEN-END:variables

}
