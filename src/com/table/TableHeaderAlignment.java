/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.table;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author MUHAMMAD NAZLAN R
 */
public class TableHeaderAlignment implements TableCellRenderer{
    private final TableCellRenderer oldHeadeCellRenderer;
    private final TableCellRenderer oldcellRenderer;
    
    public TableHeaderAlignment(JTable table){
        this.oldHeadeCellRenderer = table.getTableHeader().getDefaultRenderer();
        this.oldcellRenderer = table.getDefaultRenderer(Object.class);
 
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object o, boolean bln, boolean bln1, int row, int column) {
        JLabel label=(JLabel)oldHeadeCellRenderer.getTableCellRendererComponent(table, o, bln, bln1, row, column);
        label.setHorizontalAlignment(getAlignment(column));
        return label;
    }
    
    protected int getAlignment(int column){
        return SwingConstants.LEFT;
    }
    
    
}
