package com.bytebeats.pattern.template.ch1.exporter;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 17:24
 */
public class HtmlExporter extends Exporter {

    public HtmlExporter(String id) {
        super(id);
    }

    @Override
    protected void exportHeader(String id) {
        System.out.println("export HTML format header");
    }

    @Override
    protected void exportBody(String id) {
        System.out.println("export HTML format body");
    }

    @Override
    protected void exportFooter(String id) {
        System.out.println("export HTML format footer");
    }
}
