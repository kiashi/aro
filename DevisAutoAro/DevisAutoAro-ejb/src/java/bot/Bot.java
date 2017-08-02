/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import util.FileUtil;

/**
 *
 * @author LENOVO
 */
public class Bot {

    public static final int BOT = 0;
    public static final int CLIENT = 1;
    public static String tagFile = "C://Users//LENOVO//Documents//GitHub//aro//DevisAutoAro//DevisAutoAro-ejb//ressources//tags.json";
    public static String discussionFile = "C://Users//LENOVO//Documents//GitHub//aro//DevisAutoAro//DevisAutoAro-ejb//ressources//discussion.json";

    /**
     * Execute la méthode spécifiée *action, depuis la classe Actions Retourne
     * un string contenant l'affichage avec les données
     *
     * @param action
     * @throws Exception
     */
    public List<Message> executeAction(Chat chat) throws Exception {
        Actions act = new Actions();
        if (chat.getTypesparams().compareToIgnoreCase("null") == 0) {
            Method method = act.getClass().getMethod(chat.getAction(), null);
            return (List<Message>) method.invoke(act, null);
        }
        else if (chat.getTypesparams().compareToIgnoreCase("java.lang.Integer") == 0) {
            Method method = act.getClass().getMethod(chat.getAction(), java.lang.Integer.class);
            return (List<Message>) method.invoke(act, new Integer(chat.getParam()));
        }
        else if (chat.getTypesparams().compareToIgnoreCase("java.lang.String") == 0) {
            Method method = act.getClass().getMethod(chat.getAction(), java.lang.String.class);
            return (List<Message>) method.invoke(act, chat.getParam().toString());
        }
        return null;
    }

    /**
     *
     * retourne la liste des messages du bot et de l'utilisateur stockés dans le
     * fichier JSON *discussionFile
     *
     * @return
     * @throws Exception
     */
    public List<Message> getDiscussion() throws Exception {
        String jsonData = FileUtil.getContentFile(discussionFile);
        List<Message> messages = new ArrayList<Message>();
        JSONArray jsonarray = new JSONArray(jsonData);
        for (int i = 0; i < jsonarray.length(); i++) {
            JSONObject jobject = jsonarray.getJSONObject(i);
            Message m = new Message(jobject.getInt("user"), jobject.getString("content"));
            JSONArray jsonBoutons = jobject.getJSONArray("boutons");
            List<Bouton> boutons = new ArrayList<Bouton>();
            
            for (int j = 0; j < jsonBoutons.length(); j++) {
                JSONObject jsonobjectb = jsonBoutons.getJSONObject(j);
                boutons.add(new Bouton(jsonobjectb.getString("label"), jsonobjectb.getString("action")));
                
            }
            m.setBoutons(boutons);
            messages.add(m);
        }
        return messages;
    }

    /**
     * Met à jour le fichier de discussion à partir de la liste des messages
     *
     * @param messages
     * @throws IOException
     */
    public void updateDiscussion(List<Message> messages) throws IOException {
        Gson gson = new Gson();
        String messagesJson = gson.toJson(messages);
        FileUtil.writeInFile(messagesJson, discussionFile);
    }

    /**
     *
     * @param text
     * @return
     * @throws Exception
     */
    public Chat getActionFromText(String text) throws Exception {
        String[] motsSepares = text.split(" ");
        try {
            String jsonData = FileUtil.getContentFile(tagFile);
            List<Chat> motsCle = new ArrayList<Chat>();
            JSONArray jsonarray = new JSONArray(jsonData);
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                Chat motcle = new Chat();
                motcle.setLibelle(jsonobject.getString("libelle"));
                motcle.setAction(jsonobject.getString("action"));
                motcle.setTypesparams(jsonobject.getString("typesparams"));
                motcle.setParam(jsonobject.getString("param"));

                JSONArray jsonTags = jsonobject.getJSONArray("motscles");
                List<String> tags = new ArrayList<String>();
                for (int j = 0; j < jsonTags.length(); j++) {
                    JSONObject jsonobjectMc = jsonTags.getJSONObject(j);
                    tags.add(jsonobjectMc.getString("mot"));
                }
                motcle.setMotscles(tags);
                motsCle.add(motcle);
            }
            int nbEqualMax = 0;
            int indice = 0;
            int ind = 0;
            for (Chat m : motsCle) {
                int currentNbEquals = getNbEquals(motsSepares, m.getMotscles());
                if (currentNbEquals > nbEqualMax) {
                    nbEqualMax = currentNbEquals;
                    indice = ind;
                }
                ind++;
            }
            return motsCle.get(indice);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public int getNbEquals(String[] param1, List<String> param2) {
        int res = 0;
        for (int i = 0; i < param1.length; i++) {
            for (String p2 : param2) {
                if (p2.toLowerCase().contains(param1[i].toLowerCase())) {
                    res++;
                }
            }
        }
        return res;
    }
}
