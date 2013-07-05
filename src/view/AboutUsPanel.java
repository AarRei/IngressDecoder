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

    JLabel aboutUs, version, versionnumber, weblink1, weblink2, weblink3, weblink4, weblink, contact, contact_mail,
            contact_g_XOP, noNianticGoogle;
    JTextArea aboutUsText;
    JButton   closeButton;
    Cursor hand = new Cursor(Cursor.HAND_CURSOR);

    public AboutUsPanel(Handler handler) {
        super();

        setLayout(new MigLayout("fill, ins 0, gap 0 "));
        setBackground(Color.black);

        Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();

        JPanel logoPanel = new JPanel(new MigLayout("fill"));
        JPanel contentPanel = new JPanel(new MigLayout("fill"));

        closeButton = new JButton("close");

        this.aboutUs = new JLabel(LangController.getString("AboutPanel.Label_AboutUs"));
        this.version = new JLabel(LangController.getString("AboutPanel.Label_Version"));
        this.versionnumber = new JLabel(GUI3.VERSION);
        this.weblink = new JLabel(LangController.getString("AboutPanel.Label_Weblink"));
        this.weblink1 = new JLabel(LangController.getString("AboutPanel.Label_OurWebsite"));
        this.weblink2 = new JLabel(LangController.getString("AboutPanel.Label_DeCodeCommunity"));
        this.weblink3 = new JLabel(LangController.getString("AboutPanel.Label_Niantic"));
        this.weblink4 = new JLabel(LangController.getString("AboutPanel.Label_IntelMap"));
        this.contact = new JLabel(LangController.getString("AboutPanel.Label_ContactUs"));
        this.contact_mail = new JLabel(LangController.getString("AboutPanel.Label_Mail"));
        this.contact_g_XOP = new JLabel(LangController.getString("AboutPanel.Label_G+XOP"));
        this.aboutUsText = new JTextArea(LangController.getString("AboutPanel.Label_Credit") + LangController
                                                                                                       .getString
                                                                                                                ("AboutPanel.Label_Description"));
        this.noNianticGoogle = new JLabel("This Software is not officially affiliated with Ingress or Niantic Labs " +
                                                  "at" + " Google.");

        aboutUs.setForeground(GUI3.LIME_GREEN);
        version.setForeground(GUI3.LIME_GREEN);
        versionnumber.setForeground(GUI3.LIME_GREEN);
        weblink.setForeground(GUI3.LIME_GREEN);
        weblink1.setForeground(GUI3.LIME_GREEN);
        weblink2.setForeground(GUI3.LIME_GREEN);
        weblink3.setForeground(GUI3.LIME_GREEN);
        weblink4.setForeground(GUI3.LIME_GREEN);
        contact.setForeground(GUI3.LIME_GREEN);
        contact_mail.setForeground(GUI3.LIME_GREEN);
        contact_g_XOP.setForeground(GUI3.LIME_GREEN);
        aboutUsText.setForeground(GUI3.LIME_GREEN);
        closeButton.setForeground(GUI3.LIME_GREEN);
        noNianticGoogle.setForeground(GUI3.LIME_GREEN);

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

        logoPanel.setBorder(new MatteBorder(2, 2, 2, 0, GUI3.LIME_GREEN));
        contentPanel.setBorder(new MatteBorder(2, 0, 2, 2, GUI3.LIME_GREEN));

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
