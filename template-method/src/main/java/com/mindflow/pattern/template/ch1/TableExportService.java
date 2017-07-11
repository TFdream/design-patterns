package com.mindflow.pattern.template.ch1;

import com.mindflow.pattern.template.ch1.exporter.Exporter;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 17:13
 */
public class TableExportService {

    public Table export(Exporter exporter){
        return exporter.export();
    }
}
