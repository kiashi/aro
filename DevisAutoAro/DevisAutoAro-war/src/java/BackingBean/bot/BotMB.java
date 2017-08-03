/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackingBean.bot;

import bot.Actions;
import bot.Bot;
import bot.Bouton;
import bot.Message;
import bot.Chat;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author LENOVO
 */
@Named(value = "botMB")
@SessionScoped
public class BotMB implements Serializable {

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
            mesUser.setBoutons(new ArrayList<Bouton>());
            discussion.add(mesUser);
            for (Message m : newMessages) {
                discussion.add(m);
            }

            bot.updateDiscussion(discussion);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendFromButton(String actionString) {
        System.out.println("huhu123");
        Bot bot = new Bot();
        try {
            String[] actionParam = actionString.split("-");
            discussion = bot.getDiscussion();
            // chat : motcle, action, params
            Chat chatAction = new Chat();
            chatAction.setAction(actionParam[0]);
            if (actionParam.length > 1) {
                chatAction.setParam(actionParam[1]);
                chatAction.setTypesparams(actionParam[2]);
            } else {
                chatAction.setTypesparams("null");
                chatAction.setParam("null");
            }

            // le contenu à afficher
            List<Message> newMessages = bot.executeAction(chatAction);
            Message mesUser = new Message(1, textUser);
            mesUser.setBoutons(new ArrayList<Bouton>());

            discussion.add(mesUser);
            for (Message m : newMessages) {
                discussion.add(m);
            }

            bot.updateDiscussion(discussion);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void sendInfoProduit(String request, String param) {
        Bot bot = new Bot();
        Actions actions = new Actions();
        try {
            discussion = bot.getDiscussion();
            // le contenu à afficher
            List<Message> newMessages = actions.infoProduit(new Integer(param));
            Message mesUser = new Message(1, request);
            mesUser.setContent(request);
            mesUser.setBoutons(new ArrayList<Bouton>());

            discussion.add(mesUser);
            for (Message m : newMessages) {
                discussion.add(m);
            }

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
        if (discussion == null) {
            Bot bot = new Bot();
            try {
                discussion = bot.getDiscussion();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return discussion;
    }

    public void setDiscussion(List<Message> discussion) {
        this.discussion = discussion;
    }

}
