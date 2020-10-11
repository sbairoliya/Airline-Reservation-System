import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;


/**
 * @author Arjun Harbhajanka and Shivam Bairoliya
 * @version 11/28/30
 */


public class ReservationClient {

        public static String host;
    public static int port;
    public static Socket socket;
    public static ObjectOutputStream oos = null;

    private static boolean verifyInteger(String x) {
        try {
            int j = Integer.parseInt(x);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean verfifyName(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void clientRunner() {
        try {
            host = JOptionPane.showInputDialog(null, "What is the hostname " +
                    "you'd like to connect to?", "Hostname?", JOptionPane.INFORMATION_MESSAGE);
            if (host == null) {
                return;
            }
            String portString = JOptionPane.showInputDialog(null, "What is the port  " +
                    "you'd like to connect to?", "Port?", JOptionPane.INFORMATION_MESSAGE);
            if (portString == null) {
                return;
            }
            port = Integer.parseInt(portString);
            socket = new Socket(host, port);
            oos = new ObjectOutputStream(socket.getOutputStream());
            gui();

        } catch (IOException | NumberFormatException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Your host and port do not match",
                    "Server Connection Problem", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    public static void gui() throws IOException {

        String imagePath = "src/Purdue_pic.png";
        BufferedImage image = ImageIO.read(new File(imagePath));
        JFrame frame1 = new JFrame("Purdue University Flight Reservation System");
        JLabel label1 = new JLabel(new ImageIcon(image));
        JLabel label2 = new JLabel("<html><b><font size=6><centre>Welcome to the Purdue University " +
                "Flight<br/> Reservation System!</centre></b></font></html>");
        JPanel panel1 = new JPanel();
        JButton button1 = new JButton("Exit");
        JButton button2 = new JButton("Book a Flight");
        panel1.add(label2, BorderLayout.NORTH);
        panel1.add(label1, BorderLayout.CENTER);
        JPanel panelx = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelx.add(button1);
        panelx.add(button2);
        panel1.add(panelx);
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
        frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.setVisible(true);
        frame1.setResizable(true);
        frame1.setSize(700, 500);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank You for using the Purdue " +
                        "University Airline Management System!", "Thank You", JOptionPane.INFORMATION_MESSAGE);
                frame1.dispose();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * GUI 4 after image
                 */
                frame1.dispose();
                JFrame frame2 = new JFrame("Purdue University Flight Reservation System");
                frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel panel2 = new JPanel();

                JPanel panel3 = new JPanel();
                JLabel label3 = new JLabel("<html><b><font size=6><centre>Do you want to book a " +
                        "flight today?</b></font></centre></html>");
                JButton button3 = new JButton("Exit");
                JButton button4 = new JButton("Yes, I want to book a flight.");
                panel2.add(label3);
                panel3.add(button3);
                panel3.add(button4);
                frame2.add(panel2, BorderLayout.NORTH);
                frame2.add(panel3, BorderLayout.SOUTH);
                frame2.setVisible(true);
                frame2.setResizable(true);
                frame2.setSize(600, 400);
                button3.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,
                                "Thank You for using the Purdue University Airline Management System!",
                                "Thank You", JOptionPane.INFORMATION_MESSAGE);
                        frame1.dispose();
                        frame2.dispose();
                    }
                });
                button4.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame2.dispose();
                        JFrame frame3 = new JFrame("Purdue University Flight Management System");
                        frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        JPanel jPanel = new JPanel();
                        JPanel jPanel1 = new JPanel();
                        JPanel jPanel2 = new JPanel();
                        JLabel jLabel1 = new JLabel("<html><b>Choose a flight from the drop " +
                                "down menu.</b><br/></html>");
                        jPanel1.add(jLabel1, BorderLayout.NORTH);
                        String[] choices = {"Delta", "Southwest", "Alaska"};
                        JComboBox<String> jComboBox = new JComboBox<>(choices);
                        jPanel1.add(jComboBox, BorderLayout.AFTER_LINE_ENDS);
                        frame3.add(jPanel1, BorderLayout.NORTH);
                        frame3.add(jPanel2, BorderLayout.CENTER);
                        frame3.setVisible(true);
                        frame3.setSize(650, 500);
                        frame3.setResizable(false);
                        JButton button1 = new JButton("Exit");
                        JButton button2 = new JButton("Choose this flight");
                        button1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame1.dispose();
                                frame2.dispose();
                                frame3.dispose();
                            }
                        });
                        JPanel jPanel4 = new JPanel();
                        jPanel4.add(button1);
                        jPanel4.add(button2);
                        jPanel2.setFocusable(true);
                        jPanel2.requestFocusInWindow();
                        JFrame jFrame0 = new JFrame();
                        JFrame jFrame1 = new JFrame();
                        JFrame jFrame2 = new JFrame();
                        JFrame jFrame3 = new JFrame();
                        jPanel2.addKeyListener(new KeyListener() {
                            @Override
                            public void keyTyped(KeyEvent e) {

                            }


                            @Override
                            public void keyPressed(KeyEvent e) {
                                if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH && jComboBox.getSelectedIndex() == 0) {
                                    String[] x = Delta.displayPassengers().split("\n");
                                    //JFrame jFrame0 = new JFrame();
                                    jFrame0.setVisible(true);
                                    jFrame0.setSize(300, 300);
                                    JLabel jk = new JLabel("<html><b><font size=4>" +
                                            jComboBox.getSelectedItem().toString() + " Airlines " +
                                            Delta.getNoOfPassengers() + ":200</font></b>");
                                    JPanel jpanel = new JPanel();
                                    jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
                                    JList list = new JList(x);
                                    JScrollPane jScrollPane = new JScrollPane(list);
                                    jpanel.add(jk, BorderLayout.CENTER);
                                    jpanel.add(jScrollPane, BorderLayout.CENTER);
                                    JButton k = new JButton("Exit");
                                    k.addActionListener(e12 -> jFrame0.dispose());
                                    jpanel.add(k, BorderLayout.SOUTH);
                                    jFrame0.add(jpanel);
                                    jFrame0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                    jFrame0.setFocusable(true);
                                    jFrame0.requestFocusInWindow();
                                    jFrame0.addKeyListener(new KeyListener() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {

                                        }

                                        @Override
                                        public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                jFrame0.dispose();
                                            }

                                        }

                                        @Override
                                        public void keyReleased(KeyEvent e) {

                                        }
                                    });
                                }

                            }

                            @Override
                            public void keyReleased(KeyEvent e) {

                            }
                        });

                        frame3.add(jPanel4, BorderLayout.SOUTH);

                        JLabel jLabel = new JLabel("Delta Airlines is proud to be one of the" +
                                " five premier Airlines at Purdue University.");
                        JLabel jLabel2 = new JLabel("We offer exceptional services with free " +
                                "limited Wifi for all customers.");
                        JLabel jLabel3 = new JLabel("Passengers who use T-Mobile as a cell phone " +
                                "carrier get additional benefits.");
                        JLabel jLabel4 = new JLabel("We are also happy to offer power outlets in" +
                                " each seat for passenger use.");
                        JLabel jLabel5 = new JLabel("We hope you choose to fly Delta as your next airline.");
                        jPanel2.add(jLabel, BorderLayout.SOUTH);
                        jPanel2.add(jLabel2, BorderLayout.AFTER_LINE_ENDS);
                        jPanel2.add(jLabel3, BorderLayout.AFTER_LINE_ENDS);
                        jPanel2.add(jLabel4, BorderLayout.AFTER_LINE_ENDS);
                        jPanel2.add(jLabel5, BorderLayout.AFTER_LINE_ENDS);
                        jComboBox.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                if (jComboBox.getSelectedIndex() == 0) {

                                    jPanel2.removeAll();
                                    jPanel2.repaint();
                                    jPanel2.revalidate();
                                    JLabel jLabel = new JLabel("Delta Airlines is proud to be one of the" +
                                            " five premier Airlines at Purdue University.");
                                    JLabel jLabel2 = new JLabel("We offer exceptional services with free " +
                                            "limited Wifi for all customers.");
                                    JLabel jLabel3 = new JLabel("Passengers who use T-Mobile as a cell phone " +
                                            "carrier get additional benefits.");
                                    JLabel jLabel4 = new JLabel("We are also happy to offer power outlets in" +
                                            " each seat for passenger use.");
                                    JLabel jLabel5 = new JLabel("We hope you choose to fly Delta" +
                                            " as your next airline.");
                                    jPanel2.add(jLabel, BorderLayout.SOUTH);
                                    jPanel2.add(jLabel2, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel3, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel4, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel5, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.setFocusable(true);
                                    jPanel2.requestFocusInWindow();
                                    jPanel2.addKeyListener(new KeyListener() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {

                                        }

                                        @Override
                                        public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH &&
                                                    jComboBox.getSelectedIndex() == 0) {
                                                String[] j = Delta.displayPassengers().split("\n");
                                                //JFrame jFrame0 = new JFrame();
                                                jFrame0.dispose();
                                                jFrame1.setVisible(true);
                                                jFrame1.setSize(300, 300);
                                                JLabel jk = new JLabel("<html><b><font size=4>"
                                                        + jComboBox.getSelectedItem().toString() +
                                                        " Airlines " + Delta.getNoOfPassengers() + ":200</font></b>");
                                                JPanel jpanel = new JPanel();
                                                jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
                                                JList list = new JList(j);
                                                JScrollPane jScrollPane = new JScrollPane(list);
                                                jpanel.add(jk, BorderLayout.CENTER);
                                                jpanel.add(jScrollPane, BorderLayout.CENTER);
                                                jFrame1.add(jpanel);
                                                jFrame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                JButton k = new JButton("Exit");
                                                k.setAlignmentX(Component.CENTER_ALIGNMENT);
                                                jpanel.add(k, BorderLayout.SOUTH);
//                                                jpanel.setFocusable(true);
//                                                jpanel.requestFocusInWindow();
                                                k.addActionListener(e1 -> jFrame1.dispose());
                                                jFrame1.setFocusable(true);
                                                jFrame1.requestFocusInWindow();
                                                jFrame1.addKeyListener(new KeyListener() {
                                                    @Override
                                                    public void keyTyped(KeyEvent e) {
                                                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {

                                                        }

                                                    }

                                                    @Override
                                                    public void keyPressed(KeyEvent e) {
                                                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                            jFrame1.dispose();
                                                        }

                                                    }

                                                    @Override
                                                    public void keyReleased(KeyEvent e) {

                                                    }
                                                });

                                            }

                                        }

                                        @Override
                                        public void keyReleased(KeyEvent e) {

                                        }
                                    });

                                }
                                if (jComboBox.getSelectedIndex() == 1) {
                                    jPanel2.removeAll();
                                    jPanel2.repaint();
                                    jPanel2.revalidate();
                                    JLabel jLabel = new JLabel("Southwest Airlines is proud to " +
                                            "offer flights to " +
                                            "Purdue University.");
                                    JLabel jLabel2 = new JLabel("We are happy to offer free in flight Wifi, as " +
                                            "well as snacks.");
                                    JLabel jLabel3 = new JLabel("In addition, we offer flights for much cheaper" +
                                            " than other airlines, and offer two free checked bags.");
                                    JLabel jLabel4 = new JLabel("We hope you choose Southwest for your" +
                                            " next flight");
                                    jPanel2.add(jLabel, BorderLayout.SOUTH);
                                    jPanel2.add(jLabel2, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel3, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel4, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.setFocusable(true);
                                    jPanel2.requestFocusInWindow();
                                    jPanel2.addKeyListener(new KeyListener() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {

                                        }

                                        @Override
                                        public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
                                                if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH &&
                                                        jComboBox.getSelectedIndex() == 1) {
                                                    String[] j = Southwest.displayPassengers().split("\n");
                                                    //JFrame jFrame0 = new JFrame();
                                                    jFrame0.dispose();
                                                    jFrame2.setVisible(true);
                                                    jFrame2.setSize(300, 300);
                                                    JLabel jk = new JLabel("<html><b><font size=4>"
                                                            + jComboBox.getSelectedItem().toString()
                                                            + " Airlines " + Southwest.getNoOfPassengers()
                                                            + ":100</font></b>");
                                                    JPanel jpanel = new JPanel();
                                                    jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
                                                    JList list = new JList(j);
                                                    JScrollPane jScrollPane = new JScrollPane(list);
                                                    jpanel.add(jk, BorderLayout.CENTER);
                                                    jpanel.add(jScrollPane, BorderLayout.CENTER);
                                                    JButton k = new JButton("Exit");
                                                    jFrame2.setFocusable(true);
                                                    jFrame2.requestFocusInWindow();
                                                    jFrame2.addKeyListener(new KeyListener() {
                                                        @Override
                                                        public void keyTyped(KeyEvent e) {

                                                        }

                                                        @Override
                                                        public void keyPressed(KeyEvent e) {
                                                            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                                jFrame2.dispose();
                                                            }

                                                        }

                                                        @Override
                                                        public void keyReleased(KeyEvent e) {

                                                        }
                                                    });
                                                    k.setAlignmentX(Component.CENTER_ALIGNMENT);
                                                    jpanel.add(k, BorderLayout.SOUTH);
                                                    jFrame2.add(jpanel);
                                                    k.addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                            jFrame2.dispose();
                                                        }
                                                    });
                                                    jFrame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                }
                                            }

                                        }

                                        @Override
                                        public void keyReleased(KeyEvent e) {

                                        }
                                    });

                                }
                                if (jComboBox.getSelectedIndex() == 2) {
                                    jPanel2.removeAll();
                                    jPanel2.repaint();
                                    jPanel2.revalidate();
                                    JLabel jLabel = new JLabel("Alaska airlines is proud to serve " +
                                            "the strong and " +
                                            "knowledgeable Boilermakers from Purdue University.");
                                    JLabel jLabel2 = new JLabel("We primarily fly westward, and " +
                                            "often have stops " +
                                            "in Alaska and California.");
                                    JLabel jLabel3 = new JLabel("We have first class amenities, even " +
                                            "in coach class.");
                                    JLabel jLabel4 = new JLabel("We provide fun snacks, such as pretzels " +
                                            "and goldfish.");
                                    JLabel jLabel5 = new JLabel("We also have comfortable seats, and " +
                                            "free Wifi.");
                                    JLabel jLabel6 = new JLabel("We hope you choose Alaska Airlines for " +
                                            "your next itinerary.");
                                    jPanel2.add(jLabel, BorderLayout.SOUTH);
                                    jPanel2.add(jLabel2, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel3, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel4, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel5, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.add(jLabel6, BorderLayout.AFTER_LINE_ENDS);
                                    jPanel2.setFocusable(true);
                                    jPanel2.requestFocusInWindow();
                                    jPanel2.addKeyListener(new KeyListener() {
                                        @Override
                                        public void keyTyped(KeyEvent e) {

                                        }

                                        @Override
                                        public void keyPressed(KeyEvent e) {
                                            if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH &&
                                                    jComboBox.getSelectedIndex() == 2) {
                                                String[] j = Alaska.displayPassengers().split("\n");
                                                // JFrame jFrame0 = new JFrame();
                                                jFrame0.dispose();
                                                jFrame3.setVisible(true);
                                                jFrame3.setSize(300, 300);
                                                JLabel jk = new JLabel("<html><b><font size=4>" +
                                                        jComboBox.getSelectedItem().toString() +
                                                        " Airlines " + Alaska.getNoOfPassengers() + ":100</font></b>");
                                                JPanel jpanel = new JPanel();
                                                jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
                                                JList list = new JList(j);
                                                JScrollPane jScrollPane = new JScrollPane(list);
                                                jpanel.add(jk, BorderLayout.CENTER);
                                                jpanel.add(jScrollPane, BorderLayout.CENTER);
                                                JButton k = new JButton("Exit");
                                                k.setAlignmentX(Component.CENTER_ALIGNMENT);
                                                jpanel.add(k, BorderLayout.SOUTH);
                                                jFrame3.add(jpanel);
                                                k.addActionListener(new ActionListener() {
                                                    @Override
                                                    public void actionPerformed(ActionEvent e) {
                                                        jFrame3.dispose();
                                                    }
                                                });
                                                jFrame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                jFrame3.setFocusable(true);
                                                jFrame3.requestFocusInWindow();
                                                jFrame3.addKeyListener(new KeyListener() {
                                                    @Override
                                                    public void keyTyped(KeyEvent e) {

                                                    }

                                                    @Override
                                                    public void keyPressed(KeyEvent e) {
                                                        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                            jFrame3.dispose();
                                                        }

                                                    }

                                                    @Override
                                                    public void keyReleased(KeyEvent e) {

                                                    }
                                                });
                                            }

                                        }

                                        @Override
                                        public void keyReleased(KeyEvent e) {

                                        }
                                    });


                                }
                            }
                        });


                        /**
                         * GUI After Airline selection
                         */

                        button2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                frame3.dispose();
                                JFrame jFrame4 = new JFrame("Purdue University Flight Reservation System");
                                jFrame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                jFrame4.setVisible(true);
                                jFrame4.setSize(700, 400);
                                JLabel jLabel = new JLabel("<html><b>Are you sure that you want to" +
                                        " book a flight on " +
                                        Objects.requireNonNull(jComboBox.getSelectedItem()).toString() +
                                        " Airlines</b></html>");
                                JPanel jPanel = new JPanel();
                                jPanel.add(jLabel, BorderLayout.NORTH);
                                JButton button1 = new JButton("Exit");
                                JButton button2 = new JButton("No, I want a different flight");
                                // button 2 left for listener
                                button2.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        jFrame4.dispose();
                                        frame3.setVisible(true);
                                        frame3.setFocusable(true);
                                        frame3.requestFocusInWindow();
                                    }
                                });
                                JButton button3 = new JButton("Yes, I want this flight.");
                                JPanel jPanel2 = new JPanel();
                                jPanel2.add(button1, BorderLayout.SOUTH);
                                jPanel2.add(button2, BorderLayout.SOUTH);
                                jPanel2.add(button3, BorderLayout.SOUTH);
                                jFrame4.add(jPanel);
                                jFrame4.add(jPanel2, BorderLayout.SOUTH);
                                button1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        frame1.dispose();
                                        frame2.dispose();
                                        frame3.dispose();
                                        jFrame4.dispose();
                                    }
                                });
                                jFrame4.setFocusable(true);
                                jFrame4.requestFocusInWindow();
                                jFrame4.addKeyListener(new KeyListener() {
                                    @Override
                                    public void keyTyped(KeyEvent e) {

                                    }

                                    @Override
                                    public void keyPressed(KeyEvent e) {
                                        if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
                                            String[] j = {""};
                                            int am = 0;
                                            int max = 0;
                                            if (jComboBox.getSelectedItem().equals("Alaska")) {
                                                j = Alaska.displayPassengers().split("\n");
                                                am = Alaska.getNoOfPassengers();
                                                max = 100;
                                            }
                                            if (jComboBox.getSelectedItem().equals("Southwest")) {
                                                j = Southwest.displayPassengers().split("\n");
                                                am = Southwest.getNoOfPassengers();
                                                max = 100;
                                            }
                                            if (jComboBox.getSelectedItem().equals("Delta")) {
                                                j = Delta.displayPassengers().split("\n");
                                                am = Delta.getNoOfPassengers();
                                                max = 200;
                                            }
                                            JFrame jFrame5 = new JFrame();
                                            jFrame5.setVisible(true);
                                            jFrame5.setSize(300, 300);
                                            JLabel jk = new JLabel("<html><b><font size=4>" +
                                                    jComboBox.getSelectedItem().toString() +
                                                    " Airlines " + am + ":" + max + "</font></b>");
                                            JPanel jpanel = new JPanel();
                                            jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
                                            JList list = new JList(j);
                                            JScrollPane jScrollPane = new JScrollPane(list);
                                            jpanel.add(jk, BorderLayout.CENTER);
                                            jpanel.add(jScrollPane, BorderLayout.CENTER);
                                            JButton k = new JButton("Exit");
                                            k.setAlignmentX(Component.CENTER_ALIGNMENT);
                                            jpanel.add(k, BorderLayout.SOUTH);
                                            jFrame5.add(jpanel);
                                            k.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    jFrame5.dispose();
                                                }
                                            });
                                            jFrame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            jFrame5.setFocusable(true);
                                            jFrame5.requestFocusInWindow();
                                            jFrame5.addKeyListener(new KeyListener() {
                                                @Override
                                                public void keyTyped(KeyEvent e) {

                                                }

                                                @Override
                                                public void keyPressed(KeyEvent e) {
                                                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                        jFrame5.dispose();
                                                    }

                                                }

                                                @Override
                                                public void keyReleased(KeyEvent e) {

                                                }
                                            });
                                        }

                                    }

                                    @Override
                                    public void keyReleased(KeyEvent e) {

                                    }
                                });
                                button3.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        if (jComboBox.getSelectedItem().equals("Alaska") &&
                                                Alaska.MAX == Alaska.getNoOfPassengers()) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Flight is full.Please choose a different flight",
                                                    "Max capacity", JOptionPane.ERROR_MESSAGE);
                                        } else if (jComboBox.getSelectedItem().equals("Southwest") &&
                                                Southwest.MAX == Southwest.getNoOfPassengers()) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Flight is full.Please choose a different flight",
                                                    "Max capacity", JOptionPane.ERROR_MESSAGE);
                                        } else if (jComboBox.getSelectedItem().equals("Delta") &&
                                                Delta.MAX == Delta.getNoOfPassengers()) {
                                            JOptionPane.showMessageDialog(null,
                                                    "Flight is full.Please choose a different flight",
                                                    "Max capacity", JOptionPane.ERROR_MESSAGE);
                                        } else {
                                            jFrame4.dispose();
                                            JFrame jFrame5 = new JFrame("Purdue University Flight " +
                                                    "Reservation System");
                                            jFrame5.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                            jFrame5.setVisible(true);
                                            jFrame5.setSize(700, 500);
                                            JLabel jLabel = new JLabel("<html><b><font size=6> Please input your"
                                                    + " information below.</font></b></html>");
                                            jLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
                                            JLabel jLabel2 = new JLabel("What is your first name?");
                                            JLabel jLabel3 = new JLabel("What is your last name?");
                                            JLabel jLabel4 = new JLabel("What is your age?");
                                            JPanel jPanel = new JPanel();
                                            JPanel jPanel2 = new JPanel();
                                            //jPanel2.setLayout(new BoxLayout(jPanel2, BoxLayout.PAGE_AXIS));
                                            jPanel.add(jLabel, BorderLayout.NORTH);
                                            jPanel2.add(jLabel2);
                                            JTextArea area1 = new JTextArea(7, 50);
                                            JTextArea area2 = new JTextArea(7, 50);
                                            JTextArea area3 = new JTextArea(7, 50);
                                            jPanel2.add(area1);
                                            jPanel2.add(jLabel3);
                                            jPanel2.add(area2);
                                            jPanel2.add(jLabel4);
                                            jPanel2.add(area3);
                                            //jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
                                            jFrame5.add(jPanel, BorderLayout.NORTH);
                                            jFrame5.add(jPanel2, BorderLayout.CENTER);
                                            JButton button1 = new JButton("Exit");
                                            JButton button2 = new JButton("Next");
                                            JPanel jPanel3 = new JPanel();
                                            jPanel3.add(button1);
                                            jPanel3.add(button2);
                                            jFrame5.add(jPanel3, BorderLayout.SOUTH);
                                            jFrame5.setResizable(false);
                                            jFrame5.setFocusable(true);
                                            jFrame5.requestFocusInWindow();
                                            jFrame5.addKeyListener(new KeyListener() {
                                                @Override
                                                public void keyTyped(KeyEvent e) {

                                                }

                                                @Override
                                                public void keyPressed(KeyEvent e) {
                                                    if (e.getKeyCode() == KeyEvent.VK_BACK_SLASH) {
                                                        int am = 0;
                                                        int max = 0;
                                                        String[] j = {""};
                                                        if (jComboBox.getSelectedItem().equals("Alaska")) {
                                                            j = Alaska.displayPassengers().split("\n");
                                                            am = Alaska.getNoOfPassengers();
                                                            max = 100;
                                                        }
                                                        if (jComboBox.getSelectedItem().equals("Southwest")) {
                                                            j = Southwest.displayPassengers().split("\n");
                                                            max = 100;
                                                            am = Southwest.getNoOfPassengers();
                                                        }
                                                        if (jComboBox.getSelectedItem().equals("Delta")) {
                                                            j = Delta.displayPassengers().split("\n");
                                                            max = 200;
                                                            am = Delta.getNoOfPassengers();
                                                        }
                                                        JFrame jFrame9 = new JFrame();
                                                        jFrame9.setVisible(true);
                                                        jFrame9.setSize(300, 300);
                                                        JLabel jk = new JLabel("<html><b><font size=4>" +
                                                                jComboBox.getSelectedItem().toString() +
                                                                " Airlines" + am + ":" + max + "</font></b>");
                                                        JPanel jpanel = new JPanel();
                                                        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.PAGE_AXIS));
                                                        JList list = new JList(j);
                                                        JScrollPane jScrollPane = new JScrollPane(list);
                                                        jpanel.add(jk, BorderLayout.CENTER);
                                                        jpanel.add(jScrollPane, BorderLayout.CENTER);
                                                        JButton k = new JButton("Exit");
                                                        k.setAlignmentX(Component.CENTER_ALIGNMENT);
                                                        jpanel.add(k, BorderLayout.SOUTH);
                                                        jFrame9.add(jpanel);
                                                        k.addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                                jFrame9.dispose();
                                                            }
                                                        });
                                                        jFrame9.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                        jFrame9.setFocusable(true);
                                                        jFrame9.requestFocusInWindow();
                                                        jFrame9.addKeyListener(new KeyListener() {
                                                            @Override
                                                            public void keyTyped(KeyEvent e) {

                                                            }

                                                            @Override
                                                            public void keyPressed(KeyEvent e) {
                                                                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                                                                    jFrame9.dispose();
                                                                }

                                                            }

                                                            @Override
                                                            public void keyReleased(KeyEvent e) {

                                                            }
                                                        });
                                                    }


                                                }

                                                @Override
                                                public void keyReleased(KeyEvent e) {

                                                }
                                            });
                                            button1.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                    frame1.dispose();
                                                    frame2.dispose();
                                                    frame3.dispose();
                                                    jFrame4.dispose();
                                                    jFrame5.dispose();

                                                }
                                            });
                                            button2.addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {


                                                    if (area1.getText().equals("") || area2.getText().equals("")
                                                            || area3.getText().equals("")) {
                                                        JOptionPane.showMessageDialog(null,
                                                                "Some of the " +
                                                                        "Fields are empty", "Empty Field",
                                                                JOptionPane.ERROR_MESSAGE);
                                                    } else if (!verifyInteger(area3.getText())) {
                                                        JOptionPane.showMessageDialog(null,
                                                                "Enter a valid age  ", "Error ",
                                                                JOptionPane.ERROR_MESSAGE);

                                                    } else if (!verfifyName(area1.getText())) {
                                                        JOptionPane.showMessageDialog(null,
                                                                "Enter a valid first name  ", "Error ",
                                                                JOptionPane.ERROR_MESSAGE);

                                                    } else if (!verfifyName(area2.getText())) {
                                                        JOptionPane.showMessageDialog(null,
                                                                "Enter a valid last name ", "Error ",
                                                                JOptionPane.ERROR_MESSAGE);
                                                    } else {

                                                        int x = JOptionPane.showConfirmDialog(null,
                                                                "Are all" +
                                                                        " the details you entered correct?\n" +
                                                                        "The passenger's" +
                                                                        " name is "
                                                                        + area1.getText() + " " + area2.getText() +
                                                                        " and their " +
                                                                        "age is " + area3.getText() + ".\n" +
                                                                        "If all the " +
                                                                        "information " +
                                                                        "shown is correct," +
                                                                        " Select the Yes button,otherwise," +
                                                                        "select " +
                                                                        "the No button.", "Confirm Info",
                                                                JOptionPane.YES_NO_OPTION);
                                                        if (x == 0) {
                                                            jFrame5.dispose();
                                                            Passenger passenger = new Passenger(area1.getText(),
                                                                    area2.getText(), Integer.parseInt(area3.getText()));
                                                            String airline = (String) jComboBox.getSelectedItem();
                                                            try {
                                                                oos.writeObject(passenger);
                                                                oos.flush();
                                                                oos.writeObject(airline);
                                                                oos.flush();
                                                            } catch (IOException ex) {
                                                                ex.printStackTrace();
                                                            }
                                                            Gate gate;
                                                            String fun;
                                                            fun = (String) jComboBox.getSelectedItem();
                                                            if (jComboBox.getSelectedItem().equals("Delta")) {
                                                                gate = Delta.getGate();

                                                            } else if (fun.equals("Southwest")) {
                                                                gate = Southwest.getGate();
                                                            } else {
                                                                gate = Alaska.getGate();
                                                            }
                                                            JFrame jFrame6 = new JFrame("Purdue University " +
                                                                    "Flight Reservation System");
                                                            jFrame6.setSize(400, 500);
                                                            jFrame6.setVisible(true);
                                                            JPanel jPanel = new JPanel();
                                                            JLabel jLabel = new JLabel("<html><b>Flight data " +
                                                                    "displaying for " +
                                                                    jComboBox.getSelectedItem().toString() +
                                                                    ".<br/>Enjoy your"
                                                                    + " flight!<br/>Flight is now boarding at " +
                                                                    gate.toString() + "</b><br/></html>");
                                                            jPanel.add(jLabel, BorderLayout.NORTH);
                                                            JPanel jPanel2 = new JPanel();
                                                            jPanel2.setBorder(new TitledBorder(new EtchedBorder()));
                                                            JTextArea textArea = new JTextArea(10, 30);
                                                            textArea.setEditable(false);
                                                            if (airline.equals("Delta"))
                                                                textArea.setText(Delta.displayPassengers());

                                                            if (airline.equals("Alaska"))
                                                                textArea.setText(Alaska.displayPassengers());

                                                            if (airline.equals("Southwest"))
                                                                textArea.setText(Southwest.displayPassengers());
                                                            JScrollPane p = new JScrollPane(textArea);
                                                            int k = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
                                                            p.setVerticalScrollBarPolicy(k);
                                                            jPanel2.add(p);
                                                            JPanel jPanel3 = new JPanel();


                                                            JLabel jLabel4 = new JLabel(new BoardingPass(new
                                                                    Passenger(area1.getText(), area2.getText(),
                                                                    Integer.parseInt(area3.getText())), airline,
                                                                    gate).toString());
                                                            jPanel2.add(jLabel4, BorderLayout.SOUTH);
                                                            JButton jButton = new JButton("Exit");
                                                            JButton jButton2
                                                                    = new JButton("Refresh Flight Status");
                                                            jPanel3.add(jButton);
                                                            jPanel3.add(jButton2);
                                                            jFrame6.add(jPanel, BorderLayout.NORTH);
                                                            jFrame6.add(jPanel2, BorderLayout.CENTER);
                                                            jFrame6.add(jPanel3, BorderLayout.SOUTH);
                                                            jButton.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    JOptionPane.showMessageDialog(null,
                                                                            "Thank You for using the " +
                                                                                    "Purdue University Airline " +
                                                                                    "Management" +
                                                                                    " System!",
                                                                            "Thank You",
                                                                            JOptionPane.INFORMATION_MESSAGE);
                                                                    frame1.dispose();
                                                                    frame2.dispose();
                                                                    frame3.dispose();
                                                                    jFrame4.dispose();
                                                                    jFrame5.dispose();
                                                                    jFrame6.dispose();

                                                                }
                                                            });
                                                            jButton2.addActionListener(new ActionListener() {
                                                                @Override
                                                                public void actionPerformed(ActionEvent e) {
                                                                    if (airline.equals("Delta"))
                                                                        textArea.setText(Delta.displayPassengers());

                                                                    if (airline.equals("Alaska"))
                                                                        textArea.setText(Alaska.displayPassengers());

                                                                    if (airline.equals("Southwest"))
                                                                        textArea.setText(Southwest.displayPassengers());
                                                                    jFrame6.invalidate();
                                                                    jFrame6.revalidate();
                                                                    jFrame6.repaint();
                                                                    jFrame6.setVisible(false);
                                                                    jFrame6.setVisible(true);
                                                                }
                                                            });
                                                            jFrame6.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                                        }

                                                    }
                                                }
                                            });


                                        }
                                    }
                                });


                            }
                        });
                    }
                });


            }
        });
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        clientRunner();
    }
    /**
     * @author Arjun Harbhajanka and Shivam Bairoliya
     * @version 11/28/30
     */

    public static class ResponseListener implements Runnable {
        private Passenger passenger;
        private String airline;

        public ResponseListener(Passenger passenger, String airline) {
            this.passenger = passenger;
            this.airline = airline;
        }

        public void run() {
            try {
                if (airline.equals("Alaska"))
                    Alaska.addPassenger(passenger);
                if (airline.equals("Delta"))
                    Delta.addPassenger(passenger);
                if (airline.equals("Southwest"))
                    Southwest.addPassenger(passenger);
            } catch (NullPointerException v) {
                v.getMessage();
            }

        }
    }
}


