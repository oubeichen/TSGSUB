/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tsgsub;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author oubeichen
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null); 
        SubTable.setEnabled(false);
        SubTable.setDropTarget(new DropTarget() {
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
                // handle drop inside current table
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable t = dtde.getTransferable();
                List fileList;
                try {
                    fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                    file = (File) fileList.get(0);
                    openFile();
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        jScrollPane1.setDropTarget(new DropTarget() {
            @Override
            public synchronized void drop(DropTargetDropEvent dtde) {
                // handle drop outside current table (e.g. add row)
                dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                Transferable t = dtde.getTransferable();
                List fileList;
                try {
                    fileList = (List) t.getTransferData(DataFlavor.javaFileListFlavor);
                    file = (File) fileList.get(0);
                    openFile();
                } catch (UnsupportedFlavorException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                openFile();
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SubTable = new javax.swing.JTable();
        SingleLanButton = new javax.swing.JButton();
        MultiLanButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        showFontsButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        FileOpenMenu = new javax.swing.JMenuItem();
        FileSaveMenu = new javax.swing.JMenuItem();
        ExitMenu = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        SingLan = new javax.swing.JMenuItem();
        MultiLan = new javax.swing.JMenuItem();
        showFonts = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("三角字幕查错工具0.22");

        SubTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "开始时间", "结束时间", "样式", "内容"
            }
        ));
        jScrollPane1.setViewportView(SubTable);
        SubTable.getColumnModel().getColumn(0).setPreferredWidth(3);
        SubTable.getColumnModel().getColumn(1).setPreferredWidth(3);
        SubTable.getColumnModel().getColumn(2).setPreferredWidth(5);

        SingleLanButton.setText("单语查错");
        SingleLanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SingleLanButtonActionPerformed(evt);
            }
        });

        MultiLanButton.setText("双语查错");
        MultiLanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiLanButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("已经能识别几种编码，打开还是失败的使用记事本->另存为，下面选择UTF-8");

        jLabel2.setText("拖拽文件到下面的表格中可直接打开，BUG比较多，有问题请反馈给oubeichen，谢谢啦!");

        showFontsButton.setText("查看字体");
        showFontsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFontsButtonActionPerformed(evt);
            }
        });

        jMenu1.setText("文件");

        FileOpenMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        FileOpenMenu.setText("打开");
        FileOpenMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileOpenMenuActionPerformed(evt);
            }
        });
        jMenu1.add(FileOpenMenu);

        FileSaveMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        FileSaveMenu.setText("保存");
        jMenu1.add(FileSaveMenu);

        ExitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        ExitMenu.setText("退出");
        ExitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(ExitMenu);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("编辑");

        SingLan.setText("单语查错");
        SingLan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SingLanActionPerformed(evt);
            }
        });
        jMenu2.add(SingLan);

        MultiLan.setText("双语查错");
        MultiLan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiLanActionPerformed(evt);
            }
        });
        jMenu2.add(MultiLan);

        showFonts.setText("查看字体");
        showFonts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showFontsActionPerformed(evt);
            }
        });
        jMenu2.add(showFonts);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SingleLanButton)
                            .addComponent(MultiLanButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(showFontsButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(SingleLanButton)
                        .addGap(67, 67, 67)
                        .addComponent(MultiLanButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(showFontsButton)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FileOpenMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FileOpenMenuActionPerformed
        // TODO add your handling code here:
        if (dlg == null) {
            dlg = new JFileChooser();
        }
        FileFilter filter1 = new ExtensionFileFilter("ASS File", new String[]{"ASS"});
        dlg.setFileFilter(filter1);
        dlg.setDialogTitle("Open ASS file");
        int result = dlg.showOpenDialog(this);  // 打开"打开文件"对话框
        // int result = dlg.showSaveDialog(this);  // 打"开保存文件"对话框
        if (result == JFileChooser.CANCEL_OPTION) {
            return;
        }
        file = dlg.getSelectedFile();
        openFile();
    }//GEN-LAST:event_FileOpenMenuActionPerformed

    private void SingLanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SingLanActionPerformed
        // TODO add your handling code here:
        SingleLanButtonActionPerformed(evt);
    }//GEN-LAST:event_SingLanActionPerformed

    private void ExitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitMenuActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_ExitMenuActionPerformed

    private void MultiLanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiLanActionPerformed
        // TODO add your handling code here:
        MultiLanButtonActionPerformed(evt);
    }//GEN-LAST:event_MultiLanActionPerformed

    private void SingleLanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SingleLanButtonActionPerformed
        // TODO add your handling code here:
        if (file == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "还没有打开一个文件！", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (sldlg != null) {
            sldlg.dispose();
        }
        sldlg = new SingLanDialog(this, false);
        sldlg.setVisible(true);
    }//GEN-LAST:event_SingleLanButtonActionPerformed

    private void MultiLanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiLanButtonActionPerformed
        // TODO add your handling code here:
        if (file == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "还没有打开一个文件！", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (mudlg != null) {
            mudlg.dispose();
        }
        mudlg = new MultiLanDialog(this, false);
        mudlg.setVisible(true);
    }//GEN-LAST:event_MultiLanButtonActionPerformed

    private void showFontsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFontsButtonActionPerformed
        // TODO add your handling code here:
        if (file == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "还没有打开一个文件！", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
       if (sfdlg != null) {
            sfdlg.dispose();
        }
        sfdlg = new ShowFontsDialog(this, false);
        sfdlg.setVisible(true);
    }//GEN-LAST:event_showFontsButtonActionPerformed

    private void showFontsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showFontsActionPerformed
        // TODO add your handling code here:
        showFontsButtonActionPerformed(evt);
    }//GEN-LAST:event_showFontsActionPerformed
    private void openFile() {

        BufferedReader reader = null;
        try {
            /*用于判断编码的代码开始*/
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bin = new BufferedInputStream(fis);
            int p = (bin.read() << 8) + bin.read();
            String code;
            switch (p) {
                case 0xefbb:
                    code = "UTF-8";
                    break;
                case 0xfffe:
                    code = "Unicode";
                    break;
                case 0xfeff:
                    code = "UTF-16BE";
                    break;
                default:
                    code = "GBK";
            }
            /*用于判断编码的代码结束*/
            // 按照对应编码方式将字节流转化为字符流
            InputStreamReader isr;
            try {
                fis.close();
                fis = new FileInputStream(file);
                isr = new InputStreamReader(fis, code);
                if(reader != null)
                {
                    reader.close();
                }
                reader = new BufferedReader(isr);
            } catch (UnsupportedEncodingException ex) {
                javax.swing.JOptionPane.showMessageDialog(this, "字幕文件编码有问题，请仔细检查", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                return;
            }

        } catch (FileNotFoundException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "打开的文件不存在，请仔细检查", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "字幕文件编码有问题，请仔细检查", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        String tempString;
        Subline.clear();
        //int line = 1;
        try {
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                //System.out.println("line " + line + ": " + tempString);
                Subline.add(tempString);
                //line++;
            }
            reader.close();
        } catch (IOException ex) {
            javax.swing.JOptionPane.showMessageDialog(this, "字幕文件格式有问题，请仔细检查", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
        parseASS(file.getName());
    }

    private void parseASS(String filename) {
        Allstyle.clear();
        Starttime.clear();
        Endtime.clear();
        Style.clear();
        Content.clear();
        StyleFonts.clear();
        int totallines = Subline.size(), i;
        String tempstring, ststr;
        boolean v4style = false;//判断是否在[V4+ Styles]片段内
        //parsestyles
        for (i = 0; i < totallines; i++) {
            tempstring = Subline.get(i).toString();
            if (v4style) {
                if (tempstring.contains("Style:")) {
                    ststr = tempstring.split(",", 2)[0];
                    ststr = ststr.substring(tempstring.indexOf("Style:") + 6);
                    if (ststr.startsWith(" ")) {
                        ststr = ststr.substring(1);
                    }//去除空格
                    Allstyle.add(ststr);
                    ststr = tempstring.split(",", 3)[1];
                    StyleFonts.add(ststr);
                } else {
                    if (tempstring.contains("[Events]")) {
                        break;
                    }
                    /*else//events和v4+styles中的异常行
                     {
                     }*/
                }
            } else if (tempstring.contains("[V4+ Styles]")) {
                v4style = true;
            }
        }
        if (i == totallines || Allstyle.isEmpty())//字幕文件没有字幕主体或者没有一个样式
        {
            javax.swing.JOptionPane.showMessageDialog(this, "字幕文件内容格式有误，请仔细检查格式", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        //parseevents
        for (; i < totallines; i++) {
            tempstring = Subline.get(i).toString();
            if (tempstring.contains("Dialogue:")) {
                if (substart == -1) {
                    substart = i - 1;
                }
                String[] nowline = tempstring.split(",", 10);
                if (nowline.length < 10)//这行字幕逗号数不够
                {
                    Subline.remove(i);
                    i--;
                    totallines--;
                    continue;
                }
                Starttime.add(nowline[1]);
                Endtime.add(nowline[2]);
                Style.add(nowline[3]);  
                Content.add(nowline[9]);
            } else if (substart != -1)//已经开始却不是字幕
            {
                Subline.remove(i);
                i--;
                totallines--;
            }
        }
        if (substart == -1) {
            javax.swing.JOptionPane.showMessageDialog(this, "一行字幕也没有", "文件错误", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        Subline.add("");//人工补上一个空行
        totallines++;
        //int events = Starttime.size();
        putintable();
        this.setTitle(filename);
    }

    private void putintable() {
        DefaultTableModel dtm = (DefaultTableModel) SubTable.getModel();
        dtm.setRowCount(0);
        dtm.setColumnCount(0);
        dtm.addColumn("开始时间", Starttime);
        dtm.addColumn("结束时间", Endtime);
        dtm.addColumn("样式", Style);
        dtm.addColumn("内容", Content);
        TableColumnModel tcm = SubTable.getColumnModel();
        tcm.getColumn(0).setMaxWidth(70);
        tcm.getColumn(1).setMaxWidth(70);
        tcm.getColumn(2).setPreferredWidth(70);
        tcm.getColumn(2).setWidth(70);
        tcm.getColumn(2).setMaxWidth(300);
        jScrollPane1.setRowHeaderView(new RowHeaderTable(SubTable, 40));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    public static Vector getStarttime() {
        return Starttime;
    }

    public static Vector getEndtime() {
        return Endtime;
    }

    public static Vector getStyle() {
        return Style;
    }

    public static Vector getContent() {
        return Content;
    }

    public static ArrayList getAllstyle() {
        return Allstyle;
    }

    public static ArrayList getStyleFonts() {
        return StyleFonts;
    }
    public static void setSelectedRow(int row) {
        row--;
        Rectangle rect = SubTable.getCellRect(row, 0, true);
        SubTable.scrollRectToVisible(rect);
        SubTable.setRowSelectionInterval(row, row);
        //jScrollPane1.getHorizontalScrollBar().setValue(row);
        //jScrollPane1.getHorizontalScrollBar().updateUI();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ExitMenu;
    private javax.swing.JMenuItem FileOpenMenu;
    private javax.swing.JMenuItem FileSaveMenu;
    private javax.swing.JMenuItem MultiLan;
    private javax.swing.JButton MultiLanButton;
    private javax.swing.JMenuItem SingLan;
    private javax.swing.JButton SingleLanButton;
    private static javax.swing.JTable SubTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem showFonts;
    private javax.swing.JButton showFontsButton;
    // End of variables declaration//GEN-END:variables
    SingLanDialog sldlg = null;
    MultiLanDialog mudlg = null;
    ShowFontsDialog sfdlg = null;
    private javax.swing.JFileChooser dlg = null;
    private ArrayList Subline = new ArrayList();
    private static ArrayList StyleFonts = new ArrayList();
    private static ArrayList Allstyle = new ArrayList();
    private static Vector Starttime = new Vector();
    private static Vector Endtime = new Vector();
    private static Vector Style = new Vector();
    private static Vector Content = new Vector();
    //private int stylestart = -1;
    private int substart = -1;//字幕主体开始的行数，便于定位
    private static File file = null;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");

    /**
     * 用于显示RowHeader的JTable，只需要将其加入JScrollPane的RowHeaderView即可为JTable生成行标题
     */
    class RowHeaderTable extends JTable {

        private JTable refTable;//需要添加rowHeader的JTable  

        /**
         * 为JTable添加RowHeader，
         *
         * @param refTable 需要添加rowHeader的JTable
         * @param columnWideth rowHeader的宽度
         */
        public RowHeaderTable(JTable refTable, int columnWidth) {
            super(new RowHeaderTableModel(refTable.getRowCount()));
            this.refTable = refTable;
            this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//不可以调整列宽  
            this.getColumnModel().getColumn(0).setPreferredWidth(columnWidth);
            this.setDefaultRenderer(Object.class, new RowHeaderRenderer(refTable, this));//设置渲染器  
            this.setPreferredScrollableViewportSize(new Dimension(columnWidth, 0));
        }
    }

    /**
     * 用于显示RowHeader的JTable的渲染器，可以实现动态增加，删除行，在Table中增加、删除行时RowHeader
     * 一起变化。当选择某行时，该行颜色会发生变化
     */
    class RowHeaderRenderer extends JLabel implements TableCellRenderer, ListSelectionListener {

        JTable reftable;//需要添加rowHeader的JTable  
        JTable tableShow;//用于显示rowHeader的JTable  

        public RowHeaderRenderer(JTable reftable, JTable tableShow) {
            this.reftable = reftable;
            this.tableShow = tableShow;
            //增加监听器，实现当在reftable中选择行时，RowHeader会发生颜色变化  
            ListSelectionModel listModel = reftable.getSelectionModel();
            listModel.addListSelectionListener(this);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object obj,
                boolean isSelected, boolean hasFocus, int row, int col) {
            ((RowHeaderTableModel) table.getModel()).setRowCount(reftable.getRowCount());
            JTableHeader header = reftable.getTableHeader();
            this.setOpaque(true);
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));//设置为TableHeader的边框类型  
            setHorizontalAlignment(CENTER);//让text居中显示  
            setBackground(header.getBackground());//设置背景色为TableHeader的背景色    
            if (isSelect(row)) //当选取单元格时,在row header上设置成选取颜色   
            {
                setForeground(Color.white);
                setBackground(Color.lightGray);
            } else {
                setForeground(header.getForeground());
            }
            setFont(header.getFont());
            setText(String.valueOf(row + 1));
            return this;
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            this.tableShow.repaint();
        }

        private boolean isSelect(int row) {
            int[] sel = reftable.getSelectedRows();
            for (int i = 0; i < sel.length; i++) {
                if (sel[i] == row) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 用于显示表头RowHeader的JTable的TableModel，不实际存储数据
     */
    class RowHeaderTableModel extends AbstractTableModel {

        private int rowCount;//当前JTable的行数，与需要加RowHeader的TableModel同步  

        public RowHeaderTableModel(int rowCount) {
            this.rowCount = rowCount;
        }

        public void setRowCount(int rowCount) {
            this.rowCount = rowCount;
        }

        @Override
        public int getRowCount() {
            return rowCount;
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int row, int column) {
            return row;
        }
    }
}
