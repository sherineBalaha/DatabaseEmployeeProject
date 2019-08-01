/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseemployeeproject;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.*;

/**
 *
 * @author 91030283
 */
public class ResultSetTableModel extends AbstractTableModel{
    
    public ArrayList arrData;
    public ResultSet employeeResultSet;
    public ResultSetMetaData metadataRS;
    EmployeeFrame frame;
    int columNum ;
    int rowCount=0;
    
    public ResultSetTableModel(ResultSet rs)
    {
        frame =new EmployeeFrame();
        try 
        {
            employeeResultSet= rs;
            metadataRS = employeeResultSet.getMetaData();
            //frame.exceptOptionPane.showMessageDialog(this, String.valueOf(tableModel.rowCount), "Messege", JOptionPane.INFORMATION_MESSAGE);
            arrData= new ArrayList();
            columNum = getColumnCount();
            
            
            while (employeeResultSet.next())
            {
                Object[] rowData = new Object[columNum];
                for (int i=0; i<rowData.length; i++)
                {
                    rowData[i] = employeeResultSet.getObject(i+1);
                }
                
                arrData.add(rowData);
                rowCount =getRowCount();
            }
            
                   
                    
            throw new SQLException();
        }
        catch (SQLException sqle)
        {
           
        }    
    }   
        public Object getValueAt(int rowData,int col)
        {
            if( rowData < arrData.size())
            {
                return ((Object[])arrData.get(rowData))[col];
            }
            else
            {
                return null;
            }
        }
        
        
        public  int getRowCount()
        {
            rowCount = arrData.size();
            return rowCount;
        }
   
        public  String getColumnName(int count)
        {
            try
            {
                return metadataRS.getColumnName(count++);
            }
            catch(SQLException sqle)
            {
                //frame.showExceptionOptionPane(sqle);
                return "";
            }
            
        }    
        
        
        
      public int getColumnCount()
        {
            try
            {
                return metadataRS.getColumnCount();
                
            }
            catch(SQLException sqle)
            {
                //frame.showExceptionOptionPane(sqle);
                return 0;
            }
            
        }    
                  
                
    }//ResultSetTableModel
    
    
    
    

