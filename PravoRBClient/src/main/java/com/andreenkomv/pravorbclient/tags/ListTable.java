package com.andreenkomv.pravorbclient.tags;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class ListTable extends TagSupport {

    private List<List<String>> rows;
    private List<String> headers;

    public void setRows(List<List<String>> rows) {
        this.rows = rows;
    }

    public void setHeaders(List<String> headers) {
        this.headers = headers;
    }

    @Override
    public int doStartTag() {
        try {
            pageContext.getOut().write("<table class='table table-bordered table-hover'>");
            if (headers!=null) {
                pageContext.getOut().write("<tr>");
                for (String header: headers) {
                    pageContext.getOut().write("<th>"+header+"</th>");
                }
                pageContext.getOut().write("</tr>");
            }
            
            for (List<String> row: rows) {
                pageContext.getOut().write("<tr>");
                for (String td: row) {
                    pageContext.getOut().write("<td>"+td+"</td>");
                }
                pageContext.getOut().write("</tr>");
            }
            
            pageContext.getOut().write("</table>");
        } catch (IOException e) {
        }
        return SKIP_BODY;
    }
}
