package com.andreenkomv.pravorbclient.tags;

import com.andreenkomv.ws.*;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class UsersList extends TagSupport {

    private List<Users> users;

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public int doStartTag() {
        try {
            pageContext.getOut().write("<table class='table'><tr>");
            pageContext.getOut().write("<th>ИД</th>");
            pageContext.getOut().write("<th>Логин</th>");
            pageContext.getOut().write("<th>Информация</th>");
            pageContext.getOut().write("<th>Права доступа</th>");
            pageContext.getOut().write("<th>Удалить</th>");
            pageContext.getOut().write("</tr>");
            
            for (Users user: users) {
                String host = pageContext.getServletContext().getContextPath();
                pageContext.getOut().write("<tr>");
                pageContext.getOut().write("<td>"+user.getId()+"</td>");
                pageContext.getOut().write("<td>"+user.getLogin()+" ("+user.getFirstname()+" "+user.getLastname()+")</td>");
                pageContext.getOut().write("<td><a href='"+host+"/user?action=info&user="+user.getId()+"'>Информация</a></td>");
                pageContext.getOut().write("<td>");
                    pageContext.getOut().write(this.getHrefSetGroup(user, "A", 1));
                    pageContext.getOut().write("&nbsp;/&nbsp;");
                    pageContext.getOut().write(this.getHrefSetGroup(user, "М", 2));
                    pageContext.getOut().write("&nbsp;/&nbsp;");
                    pageContext.getOut().write(this.getHrefSetGroup(user, "П", 3));
                pageContext.getOut().write("</td>");
                pageContext.getOut().write("<td><a href='"+host+"/user?action=delete&user="+user.getId()+"'>Удалить</a></td>");
                pageContext.getOut().write("</tr>");
            }
            
            pageContext.getOut().write("</table>");
        } catch (IOException e) {
        }
        return SKIP_BODY;
    }
    
    private String getHref(boolean active, String href, String value) {
        String res = "";
        if (active) {
            res+="<a href='"+href+"'>"+value+"</a>";
        } else {
            res+=value;
        }
        return res;
    }
    
    private String getHrefSetGroup(Users user, String value, int group) {
        String host = pageContext.getServletContext().getContextPath();
        return this.getHref((user.getGroups().getId()!=group), host+"/user?action=setgroup&user="+user.getId()+"&group="+group, value);
    }
}
