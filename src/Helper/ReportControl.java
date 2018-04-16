/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.awt.HeadlessException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Bang Gosir
 */
public class ReportControl {
    String path = AbsolutePath.getPathSaveReport();

    //report preview
    public void previewReport(JasperPrint jp, String report) {
        try {
            JasperViewer.viewReport(jp, false);
        } catch (Exception e) {
            MyHelper.pesan(null, e.getMessage(), 0);
        }
    }

    public void xlsExporter(JasperPrint jp, String fileName) {
        try {
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,path + fileName + ".xls");
            exporter.exportReport();
            MyHelper.pesan(null, "Data berhasil diexport", 1);
        } catch (JRException | HeadlessException e) {
            MyHelper.pesan(null, e.getMessage(), 0);
        }
    }

    //expoerter to xls
    public void rtfExporter(JasperPrint jp, String fileName) {
        try {
            JRRtfExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, path + fileName + ".rtf");
            exporter.exportReport();
            MyHelper.pesan(null, "Data berhasil diexport", 1);
        } catch (JRException | HeadlessException e) {
            MyHelper.pesan(null, e.getMessage(), 0);
        }
    }

    //exporter to pdf
    public void pdfExporter(JasperPrint jp, String fileName) {
        try {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, path + fileName + ".pdf");
            exporter.exportReport();
            Object[] obj = {"Buka file", "Tutup"};
            int cc = MyHelper.pesanKonfirmasi(null, obj, "Data berhasil diexport", 1);
            if (cc == 0)
            {
                MyHelper.callPdf(fileName+".pdf");
            }
        } catch (HeadlessException | JRException e) {
            MyHelper.pesan(null, e.getMessage(), 0);
        }
    }    
}
