package com.mindflow.pattern.template.ch1;

import com.mindflow.pattern.template.ch1.exporter.HtmlExporter;
import com.mindflow.pattern.template.ch1.exporter.PdfExporter;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 17:28
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {

        TableExportService service = new TableExportService();

        service.export(new HtmlExporter("101"));

        service.export(new PdfExporter("101"));
    }
}
