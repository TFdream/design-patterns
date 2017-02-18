package com.bytebeats.pattern.template.ch1.exporter;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 17:24
 */
public class PdfExporter extends Exporter {

    public PdfExporter(String id) {
        super(id);
    }

    @Override
    protected void exportHeader(String id) {
        System.out.println("export PDF format header");
    }

    @Override
    protected void exportBody(String id) {
        System.out.println("export PDF format body");
    }

    @Override
    protected void exportFooter(String id) {
        System.out.println("export PDF format footer");
    }
}
