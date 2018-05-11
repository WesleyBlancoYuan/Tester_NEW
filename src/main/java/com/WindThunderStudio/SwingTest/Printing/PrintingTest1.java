package com.WindThunderStudio.SwingTest.Printing;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.JobAttributes;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.DocAttributeSet;
import javax.print.attribute.HashDocAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Sides;

public class PrintingTest1 {
    /**
     * @param args
     */
    public static void main(String[] args) {

        
        Font font1 = new Font("Courier New", Font.PLAIN, 12);
        Font font2 = new Font("Courier New", Font.PLAIN, 10);
        Font font3 = new Font("Courier New", Font.PLAIN, 8);
        CELPrinter printer = new PrintingTest1().new CELPrinter();
        printer.setFont1(font1);
        printer.setFont2(font2);
        printer.setFont3(font3);
        
        printer.setTitle1("Title 1: Main title");
        printer.setTitle2line1("Title 2 line 1: top");
        printer.setTitle2line2("Title 2 line 2: bot");
        printer.setHeaderline1("HeaderLine1: top");
        printer.setHeaderline2("HeaderLine2: bot");
        
        String[][] rows = new String[86][2];
        rows[0] = new String[] {"----10----" + "----20----"+ "----30----"+ "----40----"+ "----50----"
        + "----60----"+ "----70----"+ "----80----"+ "----90----"+ "---100----"
                + "---110----"+ "---120----"+ "---130----"+ "---140----"+ "---150----"+ "---160----"+ "---170----"+ "---180----"+ "---190----"+ "---200----", 
                "qwertyuiop[]ASDFGHJKL;'\\ZXCvbnm,./1234567890/*-+"};
        for (int i=1; i<rows.length; i++) {
            rows[i] = new String[] {"row " + i + ", line 1", "      row " + i + ", line 2"};
        }
        printer.setRows(rows.length);
        printer.setRowsData(rows);
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        PageFormat pf0 = job.getPageFormat(null);
        Paper paper0 = pf0.getPaper();
        paper0.setImageableArea(10, 10, paper0.getWidth(), paper0.getHeight());
        pf0.setPaper(paper0);
        pf0.setOrientation(PageFormat.LANDSCAPE);
        
        PageFormat pf = job.validatePage(pf0);
//        Paper papel = new Paper();
//        papel.setSize(841, 595);
//        papel.setImageableArea(37, 30, 506, 705);
        job.setPrintable(printer, pf);
        
        //system print dialog
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
//                job.print(); //to read the horizontal orientation, must use print(). No set needed.
            } catch (PrinterException e) {
                System.out.println("Cancelled. ");
            }
        }
    }
    
    /**
     * @author 99GU6879
     *
     */
    class CELPrinter implements Printable {
        private Font font1;
        private Font font2;
        private Font font3;
        
        private int lineHeight1;
        private int lineHeight2;
        private int lineHeight3;
        
        private String title1;
        private String title2line1;
        private String title2line2;
        private String headerline1;
        private String headerline2;
        
        private String[][] rowsData;
        
        /** 
         * Number of rows in the table
         */
        private int rows;
        
        /**
         * Number of lines of data to print. 2*rows.
         */
        private int dataLines;
        
        private int pageLimit;
        private int linesDataOnPage0;
        private int linesPerPage;
        
        /**
         * The array index of row data when every new pages starts to print.
         */
        private int[] newStartIndex;
        public void setRows(int rows) {
            this.rows = rows;
        }

        public void setFont1(Font font1) {
            this.font1 = font1;
        }

        public void setFont2(Font font2) {
            this.font2 = font2;
        }

        public void setFont3(Font font3) {
            this.font3 = font3;
        }
        

        public void setTitle1(String title1) {
            this.title1 = title1;
        }

        public void setTitle2line1(String title2line1) {
            this.title2line1 = title2line1;
        }

        public void setTitle2line2(String title2line2) {
            this.title2line2 = title2line2;
        }

        public void setHeaderline1(String headerline1) {
            this.headerline1 = headerline1;
        }

        public void setHeaderline2(String headerline2) {
            this.headerline2 = headerline2;
        }

        public void setRowsData(String[][] rowsData) {
            this.rowsData = rowsData;
        }

        public CELPrinter() {
            // TODO Auto-generated constructor stub
        }
        
        
        private int calculatePageLimit(int dataLines, Graphics g, PageFormat pf) {
            FontMetrics metrics1 = g.getFontMetrics(font1);
            FontMetrics metrics2 = g.getFontMetrics(font2);
            FontMetrics metrics3 = g.getFontMetrics(font3);
            lineHeight1 = metrics1.getHeight();
            lineHeight2 = metrics2.getHeight();
            lineHeight3 = metrics3.getHeight();
            
            double pageHeight = pf.getImageableHeight();
            
            //title 1, title 2 (2 lines), header (2 lines), footer/pagination (4 lines)
            linesDataOnPage0 = (int)((pageHeight - lineHeight1 - lineHeight2*2 - lineHeight3*2 - lineHeight3*4) / lineHeight3);
            
            linesPerPage = (int)pageHeight / lineHeight3 - 4; // pagination (4 lines)
            
            int pageLimit0 = 0;
            if (dataLines <= linesDataOnPage0) {
                pageLimit0 = 1; //all data can be printed on the first page.
            } else {
                int lastPageLines = (dataLines - linesDataOnPage0) % linesPerPage;
                pageLimit0 = (dataLines - linesDataOnPage0 - lastPageLines) / linesPerPage + 2;
            }
            
            newStartIndex = new int[pageLimit0 + 1];
            newStartIndex[0] = 0;
            return pageLimit0;
        }
        @Override
        public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
            
            if (pageLimit == 0) { //not calculated yet.
                this.dataLines = rows * 2;
                pageLimit = calculatePageLimit(dataLines, graphics, pageFormat);
            }
            
            Graphics2D g2d = (Graphics2D)graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            
            if (pageIndex < pageLimit) {
                int y = 36;
                // 1. print the title 1
                g2d.setFont(font1);
                g2d.drawString(title1, 20, y);
                y += lineHeight1;
                
                // 2. print title 2
                g2d.setFont(font2);
                g2d.drawString(title2line1, 20, y);
                y += lineHeight2;
                g2d.drawString(title2line2, 20, y);
                y += lineHeight2;
                
                // 3. print header
                g2d.setFont(font3);
                g2d.drawString(headerline1, 20, y);
                y += lineHeight3;
                g2d.drawString(headerline2, 20, y);
                y += lineHeight3;
                
                // 4.calculate the new page break line number (where to stop this time).
                // if all records are printed, stop too.
                int end = Math.min(rowsData.length, newStartIndex[pageIndex] + (int)(linesDataOnPage0 / 2));
                
                
                for (int i=newStartIndex[pageIndex]; i< end; i++) {
                    g2d.drawString(rowsData[i][0], 20, y);
                    y += lineHeight3;
                    g2d.drawString(rowsData[i][1], 20, y);
                    y += lineHeight3;
                }
                g2d.drawString("pág. " + (pageIndex + 1), (int)pageFormat.getImageableWidth() / 2, (int)pageFormat.getImageableHeight() - 15);
                y = 0;
                newStartIndex[pageIndex + 1] = end;
                return PAGE_EXISTS;
            } else {
                return NO_SUCH_PAGE;
            }
        }
        
    }
}
