package com.WindThunderStudio.Printing;

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
        Font font3 = new Font("Courier New", Font.PLAIN, 9);
        HelloWorldPrinter printer = new PrintingTest1().new HelloWorldPrinter();
        printer.setFont1(font1);
        printer.setFont2(font2);
        printer.setFont3(font3);
        
        printer.setTitle1("Title 1: Main title");
        printer.setTitle2line1("Title 2 line 1: top");
        printer.setTitle2line2("Title 2 line 2: bot");
        printer.setHeaderline1("HeaderLine1: top");
        printer.setHeaderline2("HeaderLine2: bot");
        
        String[][] rows = new String[85][2];
        for (int i=0; i<rows.length; i++) {
            rows[i] = new String[] {"row " + i + ", line 1", "      row " + i + ", line 2"};
        }
        printer.setRows(rows.length);
        printer.setRowsData(rows);
        
        PrinterJob job = PrinterJob.getPrinterJob();

        Paper papel = new Paper();
//        papel.setImageableArea(72, 72, 450, 697);
        papel.setImageableArea(0, 0, 705, 506);
        papel.setSize(841, 595);
        PageFormat pf = job.getPageFormat(attributes)
        pf.setOrientation(PageFormat.LANDSCAPE);
        pf.setPaper(papel);
//        PageFormat pageFormat = job.pageDialog(job.defaultPage());
//        pageFormat.setPaper(papel);
//        pageFormat.setOrientation(PageFormat.PORTRAIT);
//        pageFormat.setOrientation(PageFormat.LANDSCAPE);
        Book book = new Book();
        book.append(printer, pf);
        book.append(printer, pf);
        
//        job.setPageable(book);
//        job.setPrintable(printer);
        //this is not needed.
//        PrintRequestAttributeSet aset = new HashPrintRequestAttributeSet();
        //disable duplex (double cara) printing
//        aset.remove(Sides.DUPLEX);
        
        PrintRequestAttributeSet pset = new HashPrintRequestAttributeSet();
        pset.add(Sides.ONE_SIDED);
        DocAttributeSet dset = new HashDocAttributeSet();
//        PageFormat pf = job.getPageFormat(aset);
//        pf.setOrientation(PageFormat.LANDSCAPE);
//        job.setPrintable(printer, pf);
        //cross-platform print dialog, java l&f
//        boolean doPrint = job.printDialog(aset);
//        if (doPrint) {
//            try {
//                job.print(aset);
//            } catch (PrinterException e) {
//                System.out.println("Cancelled. ");
//            }
//        }
        
        //system print dialog
//        boolean doPrint = job.printDialog();
//        if (doPrint) {
//            try {
////                job.print(aset);
//                job.print(); //to read the horizontal orientation, must use print(). No set needed.
//            } catch (PrinterException e) {
//                System.out.println("Cancelled. ");
//            }
//        }
    }
    
    /**
     * @author 99GU6879
     *
     */
    class HelloWorldPrinter implements Printable {
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
        private int linesOnPage0;
        private int linesPerPage;
        
        /**
         * The array index of row data when every new pages starts to print.
         */
        private int newStartIndex;
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

        public HelloWorldPrinter() {
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
            
            //title 1, title 2 (2 lines), header (2 lines)
            linesDataOnPage0 = (int)((pageHeight - lineHeight1 - lineHeight2*2 - lineHeight3*2) / lineHeight3);
            linesOnPage0 = linesDataOnPage0 + 5;
            
            linesPerPage = (int)pageHeight / lineHeight3;
            
            int pageLimit0 = 0;
            if (dataLines <= linesDataOnPage0) {
                pageLimit0 = 1; //all data can be printed on the first page.
            } else {
                int lastPageLines = (dataLines - linesDataOnPage0) % linesPerPage;
                pageLimit0 = (dataLines - linesDataOnPage0 - lastPageLines) / linesPerPage + 2;
            }
            
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
                
                if (pageIndex == 0) {
                    // 1. print the title 1
                    g2d.setFont(font1);
                    g2d.drawString(title1, 10, y);
                    y += lineHeight1;
                    
                    // 2. print title 2
                    g2d.setFont(font2);
                    g2d.drawString(title2line1, 10, y);
                    y += lineHeight2;
                    g2d.drawString(title2line2, 10, y);
                    y += lineHeight2;
                    
                    // 3. print header
                    g2d.setFont(font3);
                    g2d.drawString(headerline1, 10, y);
                    y += lineHeight3;
                    g2d.drawString(headerline2, 10, y);
                    y += lineHeight3;
                    
                    // 4. print data
                    for (int i=0; i< (int)(linesDataOnPage0 / 2); i++) {
                        g2d.drawString(rowsData[i][0], 10, y);
                        y += lineHeight3;
                        g2d.drawString(rowsData[i][1], 10, y);
                        y += lineHeight3;
                    }
                    
                    y = 0;
                    newStartIndex = (int)(linesDataOnPage0 / 2);
                    return PAGE_EXISTS;
                } else {
                    int end;
                    if (newStartIndex + (int)(linesPerPage / 2)  > rowsData.length) {
                        end = rowsData.length;
                    } else {
                        end = newStartIndex + (int)(linesPerPage / 2);
                    }
                    g2d.setFont(font3);
                    for (int i=newStartIndex; i< end; i++) {
                        g2d.drawString(rowsData[i][0], 10, y);
                        y += lineHeight3;
                        g2d.drawString(rowsData[i][1], 10, y);
                        y += lineHeight3;
                    }
                    
                    y = 0;
                    newStartIndex +=(int)(linesPerPage / 2);
                    return PAGE_EXISTS;
                }
            } else {
                return NO_SUCH_PAGE;
            }
        }
        
    }
}
