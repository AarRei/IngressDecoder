package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.Handler;
import controller.LangController;

public class AboutUsPanel extends JDialog {

    public AboutUsPanel(Handler handler) {
        super();

        setLayout(new MigLayout("fill, ins 0, gap 0 "));
        setBackground(Color.black);

        Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();

        JPanel logoPanel = new JPanel(new MigLayout("fill"));
        JPanel contentPanel = new JPanel(new MigLayout("fill"));

        JButton closeButton = new JButton("close");

        JLabel aboutUs = new JLabel(LangController.getString("AboutPanel.Label_AboutUs"));
        JLabel version = new JLabel(LangController.getString("AboutPanel.Label_Version"));
        JLabel versionnumber = new JLabel(GUI3.VERSION);
        JLabel weblink = new JLabel(LangController.getString("AboutPanel.Label_Weblink"));
        JLabel weblink1 = new JLabel(LangController.getString("AboutPanel.Label_OurWebsite"));
        JLabel weblink2 = new JLabel(LangController.getString("AboutPanel.Label_DeCodeCommunity"));
        JLabel weblink3 = new JLabel(LangController.getString("AboutPanel.Label_Niantic"));
        JLabel weblink4 = new JLabel(LangController.getString("AboutPanel.Label_IntelMap"));
        JLabel contact = new JLabel(LangController.getString("AboutPanel.Label_ContactUs"));
        JLabel contact_mail = new JLabel(LangController.getString("AboutPanel.Label_Mail"));
        JLabel contact_g_XOP = new JLabel(LangController.getString("AboutPanel.Label_G+XOP"));
        JTextArea aboutUsText = new JTextArea(LangController.getString("AboutPanel.Label_Credit") + LangController
                                                                                                            .getString("AboutPanel.Label_Description"));

        JLabel noNianticGoogle = new JLabel("This Software is not officially affiliated with Ingress or Niantic Labs " +
                                                    "at" + " Google.");

        aboutUs.setForeground(GUI3.guiColor);
        version.setForeground(GUI3.guiColor);
        versionnumber.setForeground(GUI3.guiColor);
        weblink.setForeground(GUI3.guiColor);
        weblink1.setForeground(GUI3.guiColor);
        weblink2.setForeground(GUI3.guiColor);
        weblink3.setForeground(GUI3.guiColor);
        weblink4.setForeground(GUI3.guiColor);
        contact.setForeground(GUI3.guiColor);
        contact_mail.setForeground(GUI3.guiColor);
        contact_g_XOP.setForeground(GUI3.guiColor);
        aboutUsText.setForeground(GUI3.guiColor);
        closeButton.setForeground(GUI3.guiColor);
        noNianticGoogle.setForeground(GUI3.guiColor);

        aboutUs.setFont(GUI3.INGRESS_FONT);
        version.setFont(GUI3.INGRESS_FONT);
        versionnumber.setFont(GUI3.INGRESS_FONT);
        weblink.setFont(GUI3.INGRESS_FONT);
        weblink1.setFont(GUI3.INGRESS_FONT);
        weblink2.setFont(GUI3.INGRESS_FONT);
        weblink3.setFont(GUI3.INGRESS_FONT);
        weblink4.setFont(GUI3.INGRESS_FONT);
        contact.setFont(GUI3.INGRESS_FONT);
        contact_mail.setFont(GUI3.INGRESS_FONT);
        contact_g_XOP.setFont(GUI3.INGRESS_FONT);
        aboutUsText.setFont(GUI3.INGRESS_FONT);
        closeButton.setFont(GUI3.INGRESS_FONT);
        noNianticGoogle.setFont(GUI3.INGRESS_FONT.deriveFont(9f));

        weblink1.setName("weblink1");
        weblink2.setName("weblink2");
        weblink3.setName("weblink3");
        weblink4.setName("weblink4");
        contact_mail.setName("contactMail");
        contact_g_XOP.setName("GPlusXOP");

        Cursor hand = new Cursor(Cursor.HAND_CURSOR);
        weblink1.setCursor(hand);
        weblink2.setCursor(hand);
        weblink3.setCursor(hand);
        weblink4.setCursor(hand);
        contact_mail.setCursor(hand);
        contact_g_XOP.setCursor(hand);

        weblink1.addMouseListener(handler);
        weblink2.addMouseListener(handler);
        weblink3.addMouseListener(handler);
        weblink4.addMouseListener(handler);
        contact_mail.addMouseListener(handler);
        contact_g_XOP.addMouseListener(handler);

        logoPanel.setBackground(Color.black);
        contentPanel.setBackground(Color.black);
        aboutUsText.setBackground(Color.black);
        closeButton.setBackground(Color.black);
        noNianticGoogle.setBackground(Color.black);
        noNianticGoogle.setOpaque(true);

        aboutUsText.setEditable(false);
        aboutUsText.setBorder(new EmptyBorder(0, 0, 0, 0));
        aboutUsText.setLineWrap(true);
        aboutUsText.setWrapStyleWord(true);

        logoPanel.add(new JLabel(makeImageIcon("/images/enlightened_big.png")), "growy, push");

        contentPanel.add(aboutUs, "wrap");
        contentPanel.add(aboutUsText, "gapbefore 50px,growx, wrap");
        contentPanel.add(version, "wrap");
        contentPanel.add(versionnumber, "gapbefore 50px,wrap");
        contentPanel.add(weblink, "wrap");
        contentPanel.add(weblink1, "gapbefore 50px,wrap");
        contentPanel.add(weblink2, "gapbefore 50px,wrap");
        contentPanel.add(weblink3, "gapbefore 50px,wrap");
        contentPanel.add(weblink4, "gapbefore 50px,wrap");
        contentPanel.add(contact, "wrap");
        contentPanel.add(contact_mail, "gapbefore 50px,wrap");
        contentPanel.add(contact_g_XOP, "gapbefore 50px,wrap");
        contentPanel.add(closeButton, "al right,wrap");

        closeButton.setActionCommand("closeDialog");
        closeButton.addActionListener(handler);

        logoPanel.setBorder(new MatteBorder(2, 2, 2, 0, GUI3.guiColor));
        contentPanel.setBorder(new MatteBorder(2, 0, 2, 2, GUI3.guiColor));

        add(logoPanel, "growy");
        add(contentPanel, "grow, push,wrap");
        add(noNianticGoogle, "span 4");

        setUndecorated(true);
        getContentPane().setBackground(Color.black);
        setBackground(Color.black);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocation((int) screenSize.getWidth() / 4, (int) screenSize.getHeight() / 4);
        setMinimumSize(new Dimension(700, 450));
        setResizable(false);
        setModal(true);
    }

    private ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }
}
