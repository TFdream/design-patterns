package com.mindflow.pattern.template.ch1.exporter;

import com.mindflow.pattern.template.ch1.Table;

/**
 * ${DESCRIPTION}
 *
 * @author Ricky Fung
 * @date 2017-02-18 17:16
 */
public abstract class Exporter {
    protected Table table;
    protected String id;
    public Exporter(String id){
        this.id = id;
        this.table = new Table();
    }

    public Table export(){
        //定义导出报表的三个步骤
        exportHeader(id);
        exportBody(id);
        exportFooter(id);
        return table;
    }

    protected abstract void exportHeader(String id);

    protected abstract void exportBody(String id);

    protected abstract void exportFooter(String id);
}
