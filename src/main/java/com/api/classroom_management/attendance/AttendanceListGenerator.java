package com.api.classroom_management.attendance;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AttendanceListGenerator {

    public static Document generatePdf() throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA,22, BaseColor.BLACK);
        Chunk chunk = new Chunk("olá, Mundo",font);
        document.add(chunk);
        document.close();
        return document;
    }

}
