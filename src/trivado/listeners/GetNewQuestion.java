/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivado.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import trivado.questions.Question;

/**
 *
 * @author Paprika
 */
public class GetNewQuestion implements ActionListener{
    private Question question;
    private JLabel questionLabel;
    private JLabel answerLabel;
    private JLabel warningLabel;
    private ArrayList<Question> questions;
    private JButton checkButton;
    private JTextField answerField;
    private Random rand = new Random();
    private CheckAnswer checkListener;
    public GetNewQuestion(Question questionAsked, JLabel questionLabel, JLabel answerLabel, JLabel warningLabel, ArrayList<Question> questions, JTextField textField, CheckAnswer checkListener){
        question = questionAsked;
        this.questions = questions;
        this.questionLabel = questionLabel;
        this.answerLabel = answerLabel;
        this.warningLabel = warningLabel;
        
        answerField = textField;
        this.checkListener=checkListener;
        
    }
    
    public void actionPerformed(ActionEvent ae){
        question = questions.get(rand.nextInt(questions.size()));
        
        questionLabel.setText(question.getQuestion());
        answerLabel.setText(makeHint(question.getAnswer()));
        warningLabel.setText("");
        this.checkListener.setQuestion(question);
        
        
    }
    
    public String makeHint(String answer){
        int lettersRevealed = getAmountOfLetters(answer);
        Set<Integer> indexesRevealed = getIndexesRevealed(lettersRevealed, answer);
        String hintWord="";
        for(int i=0;i<answer.length();i++){
            if(indexesRevealed.contains(i)){
                hintWord = hintWord + answer.charAt(i)+" ";
            }
            else if(answer.charAt(i)==' '){
                hintWord = hintWord +"    ";
            }
            else{
                hintWord = hintWord + "_ ";
            }
        }
        return hintWord;
    }
    
    public int getAmountOfLetters(String answer){
        if(answer.length()<4){
            return 1;
        }
        else{
            return answer.length()/4+1;
        }
    }
    
    public Set<Integer> getIndexesRevealed(int letters, String answer){
        Set<Integer> indexes = new HashSet<Integer>();
        int amountOfIndexes = 0;
        while(amountOfIndexes<letters){
           int newIndex = rand.nextInt(answer.length());
           if(indexes.contains(newIndex)){
               continue;
           }
           else{
               indexes.add(newIndex);
               amountOfIndexes++;
           }
        }
        
        return indexes;
        
    }
            
}
