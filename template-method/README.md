# template method pattern (模板方法模式)
## 模式定义
> 定义一个操作中的算法的框架，而将一些步骤延迟到子类中。 使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。

## 代码示例
### 示例1
#### 抽象模版
```
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
```

#### 具体模版
1.导出HTML格式报表
```
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
```

2.导出PDF格式报表
```
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
```

报表导出服务
```
public class TableExportService {

    public Table export(Exporter exporter){
        return exporter.export();
    }
}
```

client call:
```
    TableExportService service = new TableExportService();

    service.export(new HtmlExporter("101"));

    service.export(new PdfExporter("101"));

```



