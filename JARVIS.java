package main.java.goxr3plus.sphinx5mavenexample.application;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.Microphone;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.recognizer.Recognizer;
import edu.cmu.sphinx.result.Result;
import edu.cmu.sphinx.util.props.PropertyException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Desktop;
import java.io.IOException;
import java.util.Locale;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.speech.AudioException;
import javax.speech.Central;
import javax.speech.EngineException;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author harik
 */

class TextToSpeech {
    Thread t;
    public TextToSpeech(String s){
        t = new Thread(new Runnable(){
           public void run(){
               voice(s);
           } 
        });
        t.start();
        
    }
    public void voice(String s) {
        try {
            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us" + ".cmu_us_kal.KevinVoiceDirectory");
            Central.registerEngineCentral("com.sun.speech.freetts" + ".jsapi.FreeTTSEngineCentral");
            Synthesizer synthesizer = Central.createSynthesizer(new SynthesizerModeDesc(Locale.US));
            synthesizer.allocate();
            synthesizer.resume();
            synthesizer.speakPlainText(s, null);
            synthesizer.waitEngineState(Synthesizer.QUEUE_EMPTY);
           
            t.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public class JARVIS extends javax.swing.JFrame implements KeyListener {

    /**
     * Creates new form FrontEndSwing
     */
    JFrame frame = this;
    Statement statement;
    Connection con;
    Thread voiceCMD;

    public JARVIS() throws ClassNotFoundException, SQLException {
        this.setResizable(false);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // perform some action before the window is closed
                //System.out.println("Window is closing");
                System.exit(0);
            }
        });
        initComponents();
        setTitle("JARVIS");
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12610475";
        String username = "sql12610475";
        String password = "Nm4fNt1upl";
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        statement = con.createStatement();
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);

    }
    
    
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jTextField1.addKeyListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                 

                jTextField1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new Font("Arial", Font.PLAIN, 20)); // change font size to 20
        jScrollPane1.setViewportView(jTextArea1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Mic.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setText("Go");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        jMenuBar1.setMaximumSize(new java.awt.Dimension(25, 29));

        jMenu2.setText("...");

        jMenuItem1.setText("Commands");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        String conversation = jTextField1.getText();

    }                                           

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (evt.getActionCommand().equals("Commands")) {
            JFrame newWindow = new JFrame();
            newWindow.setTitle("Commands");
            newWindow.setSize(800, 400);

            String[] columnNames = {"Operational Commands"};
            Object[][] data = {
                {"open chrome"},
                {"open word"},
                {"open powerpoint"},
                {"open excel"},
                {"open calculator"},
                {"open control panel "},
                {"open command prompt"},
                {"open notepad"},
                {"open paint"},
                {"open task manager"},
                {"open windows explorer"},
                {"open word pad"},
                {"open magnifier"},
                {"open edge"},
                {"open on screen keyboard"},
                {"open powershell"},
                {"open snipping tool"},
                {"open settings"},
                {"open photos"},
                {"open whatsapp"},
                {"open calendar"},
                {"open camera"},
                {"open alarms"},
                {"open clock"},
                {"open store"},
                {"open onedrive"},
                {"open visual studio code"},
                {"open vs code"},
                {"open youtube"},
                {"open gmail"},
                {"open google calender"},
                {"open google maps"},
                {"open notepad plus plus"},
                {"open spotify"},
                {"open visual studio"},
                {"what is todays date "},
                {"what is the date today "},
                {"can you tell me todays date "},
                {"whats the date today "},
                {"play music "},
                {"play song "},
                {"open brave "},
                {"lock the screen "},
                {"go to sleep "},
                {"screen off "},
                {"close chrome"},
                {"close Word"},
                {"close powerpoint"},
                {"close excel"},
                {"close control Panel"},
                {"close calculator"},
                {"close command prompt"},
                {"close notepad"},
                {"close paint"},
                {"close windows explorer"},
                {"close word pad"},
                {"close magnifier"},
                {"close edge"},
                {"close On Screen keyboard"},
                {"close PowerShell"},
                {"close snipping tool"},
                {"close whatsapp"},
                {"close camera"},
                {"close Notepad plus plus"},
                {"close one drive"},
                {"close spotify"},
                {"close vs code"},
                {"close visual studio"},
                {"close gmail"},
                {"close youtube"},
                {"close gmail"},
                {"close google calender"}
            };

            DefaultTableModel tableModel1 = new DefaultTableModel(data, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable table1 = new JTable(tableModel1);
            JTableHeader header = table1.getTableHeader();
            header.setFont(new Font("Serif", Font.ITALIC, 25));

            JScrollPane scrollPane1 = new JScrollPane(table1);
            table1.setFont(new Font("Serif", Font.PLAIN, 20));
            table1.setRowHeight(30);

            String[] columnNames2 = {"Interactive Commands"};
            Object[][] data2 = {
                {"hello"},
                {"hi jarvis"},
                {"hi"},
                {"hello jarvis"},
                {"hello"},
                {"good morning"},
                {"good morning jarvis"},
                {"good afternoon"},
                {"good afternoon jarvis"},
                {"good evening"},
                {"good evening jarvis"},
                {"good night"},
                {"good night jarvis"},
                {"hi how are you"},
                {"I am doing great"},
                {"how are you"},
                {"whats up"},
                {"thank you"},
                {"thank you jarvis"},
                {"what is todays date"},
                {"what is your name"}
            };

            DefaultTableModel tableModel2 = new DefaultTableModel(data2, columnNames2) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            JTable table2 = new JTable(tableModel2);
            JTableHeader header1 = table2.getTableHeader();
            header1.setFont(new Font("Serif", Font.ITALIC, 25));
            JScrollPane scrollPane2 = new JScrollPane(table2);
            table2.setFont(new Font("Serif", Font.PLAIN, 20));
            table2.setRowHeight(30);

            // Add the tables to the content pane of the NewWindow
            Container contentPane = newWindow.getContentPane();
            contentPane.setLayout(new GridLayout(1, 2));
            contentPane.add(scrollPane1);
            contentPane.add(scrollPane2);

            // Display the window
            newWindow.setVisible(true);
        }


    }                                          

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        if (evt.getActionCommand().equals("About")) {
            JFrame frame = new JFrame("ABOUT PAGE");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            JTextArea textArea = new JTextArea("JARVIS is a voice assisting tool that is completely built using Java.\n");
            textArea.append("Developers of this assistant are:\n 1.Vijay D\n 2. HARIKESAN D J\n 3.VISHNU\n 4. KP\n\n");
            textArea.append("We have used Java Swings GUI as Frontend and MySQL Database as backend!!");

            textArea.setEditable(false);
            textArea.setFont(new Font("Arial", Font.PLAIN, 16));

            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);

            // Add the text area to the frame
            frame.add(textArea);
            // add the panel to the center of the frame

        }
    }                                          

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // Create a Sphinx4 configuration object
//         ImageIcon r = new javax.swing.ImageIcon(getClass().getResource("/Mic.png"));
        if (evt.getSource() == jButton3) {
            ImageIcon newIcon = new ImageIcon(getClass().getResource("/Mic.png"));
            jButton3.setIcon(newIcon);
            voiceCMD = new Thread(new Runnable() {
                public void run() {
                    try {
                        Configuration config = new Configuration();

                        config.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
                        config.setDictionaryPath("src\\main\\resources\\5057.dic");
                        config.setLanguageModelPath("src\\main\\resources\\5057.lm");

                        try {
                            LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
                            speech.startRecognition(true);
                            jTextArea1.append("listening... \n");
                            SpeechResult speechResult = null;

                            while ((speechResult = speech.getResult()) != null) {
                                String voiceCommand = speechResult.getHypothesis();
                                //System.out.println("Voice Command is " + voiceCommand);

                                String vc = voiceCommand.toLowerCase();
                                jTextArea1.append("You: " + voiceCommand + "\n");// append the conversation to jTextArea1

                                ResultSet resultSet = statement.executeQuery("select command from commands where String = '" + vc + "'");

                                while (resultSet.next()) {
                                    //System.out.println(resultSet.getString(1));
                                    new TextToSpeech("Yes Master");
                                     jTextArea1.append("Jarvis : Yes Master\n");
                                    Runtime.getRuntime().exec(resultSet.getString(1));
                                }
                                
                                resultSet = statement.executeQuery("select Commands from interactivecommands where String = '" + vc + "'");
                               

                                while (resultSet.next()) {
                                    //System.out.println(resultSet.getString(1));
                                    new TextToSpeech(resultSet.getString(1));
                                     jTextArea1.append("Jarvis : "+resultSet.getString(1)+"\n");
                                    
                                    
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        con.close();
                    } catch (Exception e) {
                        //System.out.println(e);
                    }
                }
            });
            voiceCMD.start();
        }
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        //System.out.println("Enterd");
        String conversation = jTextField1.getText();
        //System.out.println(conversation);
        jTextArea1.append("You: " + conversation + "\n");

        String vc = conversation.toLowerCase();
        //System.out.println(conversation);
        jTextField1.setText("");// append the conversation to jTextArea1

        ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("select command from commands where String = '" + vc + "'");

            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                new TextToSpeech("Yes Master"); 
                jTextArea1.append("Jarvis : Yes Master\n");
                Runtime.getRuntime().exec(resultSet.getString(1));
                
            
            }
            resultSet = statement.executeQuery("select Commands from interactivecommands where String = '" + vc + "'");

             while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                new TextToSpeech(resultSet.getString(1));
                 jTextArea1.append("Jarvis : "+resultSet.getString(1)+"\n");
                
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(JARVIS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JARVIS.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField1.setText("");         // TODO add your handling code here:
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JARVIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JARVIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JARVIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JARVIS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new JARVIS().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JARVIS.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(JARVIS.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            UIManager.put("control", new Color(128, 128, 128));
            UIManager.put("nimbusBase", new Color(18, 30, 49));
            UIManager.put("nimbusBlueGrey", new Color(128, 128, 128));
            UIManager.put("nimbusFocus", new Color(51, 153, 255));
            UIManager.put("nimbusLightBackground", new Color(18, 30, 49));
            UIManager.put("nimbusSelectedText", new Color(255, 255, 255));
            UIManager.put("text", new Color(230, 230, 230));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            String text = jTextField1.getText();
            jTextArea1.append("You: "+text+"\n");
              String vc = text.toLowerCase();
            ResultSet resultSet;
        try {
            resultSet = statement.executeQuery("select command from commands where String = '" + vc + "'");

            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                new TextToSpeech("Yes Master");
                jTextArea1.append("Jarvis : Yes Master\n");
                Runtime.getRuntime().exec(resultSet.getString(1));
                
            
            }
            resultSet = statement.executeQuery("select Commands from interactivecommands where String = '" + vc + "'");

             while (resultSet.next()) {
                //System.out.println(resultSet.getString(1));
                new TextToSpeech(resultSet.getString(1));
                 jTextArea1.append("Jarvis : "+resultSet.getString(1)+"\n");
                
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(JARVIS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JARVIS.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextField1.setText("");
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
