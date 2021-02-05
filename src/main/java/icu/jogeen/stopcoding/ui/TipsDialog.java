package icu.jogeen.stopcoding.ui;

import icu.jogeen.stopcoding.data.DataCenter;
import icu.jogeen.stopcoding.service.TimerService;
import icu.jogeen.stopcoding.task.RestTask;
import icu.jogeen.stopcoding.task.WorkTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;

public class TipsDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel tipsJL;

    public TipsDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("StopCoding");
        setLocation(400, 200);//距离屏幕左上角的其实位置
        setSize(500, 200);//对话框的长宽

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        DataCenter.reskTimer = new Timer();
        DataCenter.reskTimer.schedule(new RestTask(this), new Date(), 1000);
    }

    private void onOK() {
        handle();
    }

    private void onCancel() {
        handle();
    }

    private void handle() {
        //do nothing!
        JOptionPane.showMessageDialog(null, "Go to have a rest. When the time comes, I'll turn it off automatically.", "tips",JOptionPane.INFORMATION_MESSAGE);
    }

    public void setDesc(String desc) {
        tipsJL.setText(desc);
    }
}
