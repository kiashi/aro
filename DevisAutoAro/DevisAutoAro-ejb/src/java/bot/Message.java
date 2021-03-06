/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Message {

    private int user;
    private String content;
    private String page;
    private List<Bouton> boutons;
    private String classStyle;

    public Message() {
    }

    public Message(int user, String content) {
        this.content = content;
        this.user = user;
    }

    public String getClassStyle() {
        if (user == 1) {
            classStyle = "me";
        } else {
            classStyle = "him";
        }
        return classStyle;
    }

    public void setClassStyle(String classStyle) {
        this.classStyle = classStyle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<Bouton> getBoutons() {
        return boutons;
    }

    public void setBoutons(List<Bouton> boutons) {
        this.boutons = boutons;
    }

}
