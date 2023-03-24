import View.MainUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static int posX=0,posY=0;
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setUndecorated(true);
        MainUI content = new MainUI();
        mainFrame.setContentPane(content.getPanel());
        mainFrame.setVisible(true);
        mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#9E9E9E")));

        content.getPanel().addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                posX=e.getX();
                posY=e.getY();
            }
        });

        content.getPanel().addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent evt)
            {
                mainFrame.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
            }
        });

        content.getMinimize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setExtendedState(mainFrame.getExtendedState() | mainFrame.ICONIFIED);
            }
        });

    }
}
