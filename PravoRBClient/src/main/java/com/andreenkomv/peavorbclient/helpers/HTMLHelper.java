/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andreenkomv.peavorbclient.helpers;

import com.andreenkomv.ws.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Admin
 */
public class HTMLHelper {

//HEADERS
    public static List<String> getUsersListHeader() {
        List<String> headers = new ArrayList<>();
        headers.add("ИД");
        headers.add("Логин");
        headers.add("Информация");
        headers.add("Права доступа");
        headers.add("Удалить");
        return headers;
    }

    public static List<String> getPartsListHeader(String name) {
        List<String> headers = new ArrayList<>();
        headers.add(name);
        return headers;
    }
    
//VALUES
    public static List<List<String>> getUsersListValues(List<Users> users, String host) {
        List<List<String>> values = new ArrayList<>();
        for (Users user : users) {
            List<String> row = new ArrayList<>();

            row.add(user.getId().toString());

            row.add(user.getLogin() + " (" + user.getFirstname() + " " + user.getLastname() + ")");

            row.add(getInfoLink(host, "user", user.getId()));

            row.add(
                    HTMLHelper.getHrefSetGroup(user, host, "А", 1)
                    + "&nbsp;/&nbsp;"
                    + HTMLHelper.getHrefSetGroup(user, host, "М", 2)
                    + "&nbsp;/&nbsp;"
                    + HTMLHelper.getHrefSetGroup(user, host, "П", 3)
            );

            row.add(getDeleteLink(host, "user", user.getId()));

            values.add(row);
        }
        return values;
    }

    public static List<List<String>> getPartsListValues(List<Parts> parts, String host, int access) {
        List<List<String>> values = new ArrayList<>();
        for (Parts part : parts) {
            List<String> row = new ArrayList<>();

            String td = getListLink(host, "part", part.getId(), part.getName());
            if (access < 3) {
                td += " (" + getEditLink(host, "part", part.getId()) + " | " + getDeleteLink(host, "part", part.getId()) + ")";
            }
            row.add(td);

            values.add(row);
        }
        return values;
    }
    
    public static List<List<String>> getActsListValues(List<History> histories, String host, int access) {
        List<List<String>> values = new ArrayList<>();
        for (History history : histories) {
            List<String> row = new ArrayList<>();

            Map<String, String> showMap = new HashMap<>();
            showMap.put("action", "show");
            showMap.put("history", history.getId().toString());
            String td ="<b>"+ getCustomHref(host, "act", showMap, history.getTexts().getName())+"</b>";
            
            Map<String, String> historyMap = new HashMap<>();
            historyMap.put("action", "list");
            historyMap.put("act", history.getActs().getId().toString());
            td += " ["+getCustomHref(host, "history", historyMap, "История")+"]";
            
            if (access < 3) {
                td += " (";                
                Map<String, String> editMap = new HashMap<>();
                editMap.put("action", "addedition");
                editMap.put("act", history.getActs().getId().toString());
                editMap.put("oldtext", history.getTexts().getId().toString());
                td += getCustomHref(host, "text", editMap, "Редактировать");                
                td += " | ";
                td += getDeleteLink(host, "act", history.getActs().getId());
                td +=")";
            }
            row.add(td);

            values.add(row);
        }
        return values;
    }
//HREFS    

    public static String getInfoLink(String host, String servlet, Integer id) {
        return getActionLink(host, servlet, "info", "Информация", id);
    }
    
    public static String getShowLink(String host, String servlet, Integer id, String value) {
        return getActionLink(host, servlet, "show", value, id);
    }

    public static String getListLink(String host, String servlet, Integer id, String value) {
        return getActionLink(host, servlet, "list", value, id);
    }

    public static String getEditLink(String host, String servlet, Integer id) {
        return getActionLink(host, servlet, "edit", "Редактировать", id);
    }

    public static String getDeleteLink(String host, String servlet, Integer id) {
        return getActionLink(host, servlet, "delete", "Удалить", id);
    }

    public static String getActionLink(String host, String servlet, String action, String value, Integer id) {
        Map<String, String> actionMap = new HashMap<>();
        actionMap.put("action", action);
        actionMap.put(servlet, id.toString());
        return HTMLHelper.getCustomHref(host, servlet, actionMap, value);
    }

    public static String getHrefSetGroup(Users user, String host, String value, int group) {
        return HTMLHelper.getHref((user.getGroups().getId() != group), host + "/user?action=setgroup&user=" + user.getId() + "&group=" + group, value);
    }

    public static String getCustomHref(String host, String servlet, Map<String, String> params, String value) {
        String url = host + "/" + servlet + "?";
        if (params.size() > 0) {
            TreeMap<String, String> treeMap = new TreeMap<>(params);
            for (Map.Entry<String, String> entry : treeMap.entrySet()) {
                String key = entry.getKey();
                String val = entry.getValue();
                url += key + "=" + val + "&";
            }
            url = url.substring(0, url.length() - 1);
        }
        return HTMLHelper.getHref(true, url, value);
    }

    public static String getHref(boolean active, String href, String value) {
        String res = "";
        if (active) {
            res += "<a href='" + href + "'>" + value + "</a>";
        } else {
            res += value;
        }
        return res;
    }
//SELECTS

    public static String getSelect(String name, Map<Integer, String> options, int def) {
        return getSelect(name, options, def, -1);
    }

    public static String getSelect(String name, Map<Integer, String> options, int def, int exclude) {
        String res = "<select name='" + name + "' id='" + name + "'>";
        options = sortByValue(options);
        for (Map.Entry<Integer, String> option : options.entrySet()) {
            Integer key = option.getKey();
            String val = option.getValue();
            String selected = "";
            if (key == def) {
                selected = "selected";
            }
            if (key!=exclude) {
                res+="<option "+selected+" value='"+key+"'>"+val+"</option>";
            }
        }
        res += "</select>";
        return res;
    }

    public static Map<Integer, String> getMapParts(List<Parts> parts) {
        Map<Integer, String> resmap = new HashMap<>();
        resmap.put(0, "Корневая категория");
        for (Parts part : parts) {
            resmap.put(part.getId(), part.getName());
        }
        return resmap;
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
            sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list
                = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
