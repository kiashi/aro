/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.bot;

import bot.Bot;
import bot.Message;
import bot.Chat;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author LENOVO
 */
@Named(value = "botMB")
@RequestScoped
public class BotMB {

    private String textUser;

    private List<Message> discussion;

    /**
     * Creates a new instance of BotMB
     */
    public BotMB() {
    }

    public void send() {
        Bot bot = new Bot();
        try {
            discussion = bot.getDiscussion();
            // chat : motcle, action, params
            Chat chatAction = bot.getActionFromText(textUser);

            // le contenu à afficher
            List<Message> newMessages = bot.executeAction(chatAction);
            Message mesUser = new Message(1, textUser);
            mesUser.setContent(textUser);
            mesUser.setBoutons(new ArrayList<String>());
            mesUser.setActions(new ArrayList<String>());
            
            discussion.add(mesUser);
            for(Message m : newMessages){
                discussion.add(m);
            }

            bot.updateDiscussion(discussion);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendFromButton(String request, String param) {
        Bot bot = new Bot();
        try {
            System.out.println("okkkkkkkkkkkk");
            discussion = bot.getDiscussion();
            // chat : motcle, action, params
//            Chat chatAction = bot.getActionFromText(request);

            // le contenu à afficher
//            content = bot.executeAction(chatAction);

            discussion.add(new Message(1, request));
            discussion.add(new Message(0, param));

            bot.updateDiscussion(discussion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getTextUser() {
        return textUser;
    }

    public void setTextUser(String textUser) {
        this.textUser = textUser;
    }

    public List<Message> getDiscussion() {
        return discussion;
    }

    public void setDiscussion(List<Message> discussion) {
        this.discussion = discussion;
    }

}
