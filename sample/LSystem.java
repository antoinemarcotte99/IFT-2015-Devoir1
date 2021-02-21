package sample;

import org.json.*;
import java.lang;

public class LSystem {
    private String sym;
    private String str;
    private String ax;
    private String expansion;
    private String action;
    public LSystem(){
    }
    public static void readJSONFile(String file, LSystem S, Turtle T) throws java.io.IoException{
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file))); // lecture de fichier JSON avec JSONTokener
        JSONArray alphabet = input.getJSONArray("alphabet");
        String axiom = input.getString("axiom");
        S.setAxiom(axiom);
        for (int i=0; i<alphabet.length(); i++){
            String letter = alphabet.getString(i);
            Symbol sym = S(letter.charAt(0));
    }
    public Symbol addSymbol(char sym){
        alphabet[alphabet.length()+1]=sym;
        return sym;
    }
    public void addRule(Symbol sym, String expansion){
            JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file)));
            JSONArray rules = input.getJSONArray("rules");
            rules[rules.length()+1]=expansion;
    }
    public void setAction(Symbol sym, String action){
          this.sym="sym";
          JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file)));
          JSONArray actions = input.getString("actions");
          JSONArray x = actions.getString("sym");
          actions[x]=action;
    }
    public void setAxiom(String str){
        this.str = ax;
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file)));
        JSONArray axiom = input.getJSONArray("axiom");
        axiom[]=ax;
    }
    public Symbol.Seq rewrite(Symbol sym){
        this.sym="sym";
        JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file)));
        JSONArray rules = input.getJSONArray("rules");
        if(JSONArray x = rules.getJSONArray("sym")= null){return null}
        else return rewrite(rules[Math.floor(Math.random()*rules.length())]);//retourne un entier du tableau rule
    }
    public void tell(Turtle turtle, Symbol sym){

    }
    public Symbol.Seq getAxiom(){
            JSONObject input = new JSONObject(new JSONTokener(new java.io.FileReader(file)));
            JSONArray axiom = input.getJSONArray("axiom);
            return axiom;
    }
}
