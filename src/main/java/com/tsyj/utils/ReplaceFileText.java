import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.List;

/**
 * guos
 */
public class ReplaceFileText extends JFrame {

    private static final long serialVersionUID = 8674569541853793419L;

    private JPanel contentPane;
    private JTextField fileField;
    private JTextField searchTextField;
    private JTextField replaceTextField;
    private File file;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReplaceFileText frame = new ReplaceFileText();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ReplaceFileText() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 501, 184);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(10, 91));
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{81, 0, 0, 66, 0};
        gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0,
                Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JButton button = new JButton("文件/目录：");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        GridBagConstraints gbc_button = new GridBagConstraints();
        gbc_button.anchor = GridBagConstraints.NORTHWEST;
        gbc_button.insets = new Insets(0, 0, 5, 5);
        gbc_button.gridx = 0;
        gbc_button.gridy = 0;
        panel.add(button, gbc_button);

        fileField = new JTextField();
        fileField.setEditable(false);
        GridBagConstraints gbc_fileField = new GridBagConstraints();
        gbc_fileField.gridwidth = 3;
        gbc_fileField.insets = new Insets(0, 0, 5, 0);
        gbc_fileField.fill = GridBagConstraints.HORIZONTAL;
        gbc_fileField.gridx = 1;
        gbc_fileField.gridy = 0;
        panel.add(fileField, gbc_fileField);
        fileField.setColumns(10);

        JLabel label = new JLabel("搜索内容：");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.anchor = GridBagConstraints.EAST;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 0;
        gbc_label.gridy = 1;
        panel.add(label, gbc_label);

        searchTextField = new JTextField();
        GridBagConstraints gbc_searchTextField = new GridBagConstraints();
        gbc_searchTextField.gridwidth = 3;
        gbc_searchTextField.insets = new Insets(0, 0, 5, 0);
        gbc_searchTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_searchTextField.gridx = 1;
        gbc_searchTextField.gridy = 1;
        panel.add(searchTextField, gbc_searchTextField);
        searchTextField.setColumns(10);

        JLabel label_1 = new JLabel("替换成为：");
        GridBagConstraints gbc_label_1 = new GridBagConstraints();
        gbc_label_1.anchor = GridBagConstraints.EAST;
        gbc_label_1.insets = new Insets(0, 0, 5, 5);
        gbc_label_1.gridx = 0;
        gbc_label_1.gridy = 2;
        panel.add(label_1, gbc_label_1);

        replaceTextField = new JTextField();
        GridBagConstraints gbc_replaceTextField = new GridBagConstraints();
        gbc_replaceTextField.gridwidth = 3;
        gbc_replaceTextField.insets = new Insets(0, 0, 5, 0);
        gbc_replaceTextField.fill = GridBagConstraints.HORIZONTAL;
        gbc_replaceTextField.gridx = 1;
        gbc_replaceTextField.gridy = 2;
        panel.add(replaceTextField, gbc_replaceTextField);
        replaceTextField.setColumns(10);

        JPanel panel_1 = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.gridwidth = 4;
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 0;
        gbc_panel_1.gridy = 3;
        panel.add(panel_1, gbc_panel_1);

        JButton replaceButton = new JButton("替换");
        replaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                do_replaceButton_actionPerformed(e);
            }
        });
        panel_1.add(replaceButton);
    }

    /**
     * 选择文件按钮事件处理方法
     *
     * @param e
     */
    protected void do_button_actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser("./");// 创建文件选择器
        // 设置文件扩展名过滤器
        chooser.setFileFilter(new FileNameExtensionFilter("文本文件", "txt",
                "java", "php", "html", "htm", "xml", "pom"));
        // 设置文件选择模式
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        // 显示文件打开对话框
        int option = chooser.showOpenDialog(this);
        // 确定用户按下打开按钮，而非取消按钮
        if (option != JFileChooser.APPROVE_OPTION)
            return;
        // 获取用户选择的文件对象
        file = chooser.getSelectedFile();
        // 显示文件信息到文本框
        fileField.setText(file.toString());
    }

    /**
     * 替换按钮的事件处理方法
     *
     * @param event
     */
    protected void do_replaceButton_actionPerformed(ActionEvent event) {
        String filePath = fileField.getText();
        if (Objects.isNull(file)) {
            JOptionPane.showMessageDialog(null, "请选择要替换的文件或目录！");
            return;
        }
        String searchText = searchTextField.getText();// 获取搜索文本
        if (Objects.isNull(searchText)) {
            JOptionPane.showMessageDialog(null, "替换内容不能为空！");
            return;
        }
        String replaceText = replaceTextField.getText();// 获取替换文本

        if (Objects.equals(searchText,replaceText)) {
            JOptionPane.showMessageDialog(null, "搜索与替换相同，无需替换！");
            return;
        }

        List<String> fileNames = ModifyFileUtils.replace(filePath, searchText, replaceText);
        StringBuffer message = new StringBuffer();
        if (fileNames == null || fileNames.size() == 0) {
            message.append("没有要替换的文件");
        } else {
            message.append("替换完成!\n修改文件列表:\n");
            fileNames.forEach(f -> {
                message.append(f + "\n");
            });
        }
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * 打开文件按钮的事件处理方法。
     *
     * @param e
     */
    protected void do_button_2_actionPerformed(ActionEvent e) {
        try {
            if (file == null)
                return;
            Desktop.getDesktop().edit(file);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}