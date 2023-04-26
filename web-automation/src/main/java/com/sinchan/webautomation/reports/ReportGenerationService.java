package com.sinchan.webautomation.reports;


//src/main/resources/Reports


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.sinchan.webautomation.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Date;

@Service
public class ReportGenerationService {
    public static final String DEST = "/reports";
    @Autowired
    EmailSender emailSender;

    private boolean createDirectory() {
        System.out.println("creating directory");
        try {
            File dir = new File(DEST);
            if (dir.exists()) {
                System.out.println(dir.getAbsolutePath());
                return false;
            }
            System.out.println(dir.getAbsolutePath());
            return dir.mkdirs();
        } catch (SecurityException se) {
            se.printStackTrace();
        }
        return false;
    }

    public void generateReport() throws FileNotFoundException {

        boolean isDirCreated = createDirectory();
        if (isDirCreated) {
            System.out.println("Created Directory Successfully.");
        } else {
            System.out.println("Either directory exists or error has occurred.");
        }
        String fileName = "daily_health_report_" + emailSender.getCurrDateTime() + ".pdf";
        String finalPath = DEST + File.separatorChar + fileName;
        PdfDocument pdf = new PdfDocument(new PdfWriter(finalPath));
        Document doc = new Document(pdf);
        doc.add(new Paragraph("<h1>Daily Health Check Report</h1>"));
        doc.add(new Paragraph("--------------------------------------"));
        doc.add(new Paragraph("Dated" + new Date()));
        doc.close();
        System.out.println("Printing done");
    }

    public void generateTextReport() throws IOException, FileNotFoundException {
        boolean isDirCreated = createDirectory();
        if (isDirCreated) {
            System.out.println("Created Directory Successfully.");
        } else {
            System.out.println("Either directory exists or error has occurred.");
        }
        String fileName = "daily_health_check_report.txt";
        String path = DEST + File.separatorChar + fileName;
        File txtFile = new File(path);
        if (txtFile.exists()) {
            boolean isDeleted = txtFile.delete();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(txtFile));
        writer.write("Daily Health Check Report" + emailSender.getCurrDateTime());
        writer.newLine();
        writer.write("Automated Report");
        writer.close();
    }

}
