package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controller.Handler;

public class GUI3 {

    private boolean menuHidden, alwaysOnTop;
    private final JFrame      mainFrame;
    private final JPanel      mainPanel;
    private       JPanel      decoderPanel;
    private final JPanel      codePanel;
    private final JPanel      titlePanel;
    private final JScrollPane scrollPanel;
    private final MenuPanel   menuPanel;
    private final int random, menuPanelWidth = 250;

    //static stuff
    public static Font INGRESS_FONT;
    public static final Color  LIME_GREEN = new Color(0, 205, 106);
    public static final String VERSION    = "2.0.01";


    public GUI3() {
        Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
        try {
            INGRESS_FONT = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream("Coda.ttf"));
        } catch(Exception e) {
            INGRESS_FONT = new Font("Courier New", Font.PLAIN, 15);
        }
        this.random = new Random().nextInt(3);
        mainFrame = new JFrame();
        mainPanel = new JPanel(new MigLayout("gap 0, insets 0, fill"));
        mainPanel.setBackground(Color.BLACK);

        Handler handler = new Handler(this);

        menuPanel = new MenuPanel(handler);

        mainPanel.add(titlePanel = new TitlePanel(handler), "dock north");
        mainPanel.add(getMenuPanel(), "dock west, width " + menuPanelWidth + "!");

        decoderPanel = new DecoderPanel(mainPanel.getWidth(), random);
        scrollPanel = new JScrollPane(getDecoderPanel());

        scrollPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        scrollPanel.getVerticalScrollBar().setUnitIncrement(16);

        mainPanel.add(codePanel = new CodePanel(handler), "growx,wrap");
        mainPanel.add(scrollPanel, "grow, push");
        mainFrame.add(mainPanel);
        mainFrame.setMinimumSize(new Dimension(600, 400));
        mainFrame.pack();

        mainFrame.addComponentListener(new ComponentListener() {

            @Override
            public void componentResized(ComponentEvent e) {
                updateDecoderPanel();
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {
                mainPanel.revalidate();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                mainPanel.invalidate();
            }
        });

        mainFrame.setSize((int) screenSize.getWidth() / 2, (int) screenSize.getHeight() / 2);
        mainFrame.setLocation((int) screenSize.getWidth() / 4, (int) screenSize.getHeight() / 4);
        mainFrame.setTitle("Ingress Cipher Tool");
        mainFrame.setIconImage(makeImageIcon("/images/Ingress_Dual_middle.png").getImage());
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setVisible(true);
    }

    public void updateDecoderPanel() {
        decoderPanel = new DecoderPanel(scrollPanel.getWidth(), random);
        scrollPanel.setViewportView(getDecoderPanel());
        scrollPanel.revalidate();
    }

    public void toggleSidebar() {
        this.menuHidden = !menuHidden;
        if(menuHidden) mainPanel.remove(getMenuPanel());
        else {
            mainPanel.add(getMenuPanel(), "dock west, width " + menuPanelWidth + "!");
        }
        getCodePanel().changeHideIcon(menuHidden);
        mainPanel.revalidate();
        updateDecoderPanel();
    }

    public void executeCiphers() {
        getDecoderPanel().executeActiveCiphers(getCodePanel().getCode());
    }

    public void executeCipher(int methodID) {
        getDecoderPanel().executeSingleCipher(methodID, getCodePanel().getCode());

    }

    ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }

    public void addCodeToHistory() {
        getCodePanel().addCodeToHistory();
    }

    public CodePanel getCodePanel() {
        return (CodePanel) codePanel;
    }

    public TitlePanel getTitlePanel() {
        return (TitlePanel) titlePanel;
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }

    public void toggleAlwaysOnTop() {
        alwaysOnTop = !alwaysOnTop;
        mainFrame.setAlwaysOnTop(alwaysOnTop);
    }

    DecoderPanel getDecoderPanel() {
        return (DecoderPanel) decoderPanel;
    }

    public boolean isAlwaysOnTop() {
        return mainFrame.isAlwaysOnTop();
    }
}
