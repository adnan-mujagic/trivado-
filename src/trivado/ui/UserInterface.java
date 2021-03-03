/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivado.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import trivado.listeners.CheckAnswer;
import trivado.listeners.GetNewQuestion;
import trivado.questions.Question;

/**
 *
 * @author Paprika
 */
public class UserInterface implements Runnable{
    private ArrayList<Question> questions;
    private JFrame j;
    private Container wrapper;
    private Random rand = new Random();
    private Question questionAsked;
    public UserInterface(ArrayList<Question> questions){
        this.questions = questions;
    }
    
    public void run(){
        j = new JFrame("Trivado");
        j.setPreferredSize(new Dimension(500,400));
        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createContents(j.getContentPane());
        j.setVisible(true);
        j.pack();
        
    }
    
    public void createContents(Container cont){
        GridLayout grid = new GridLayout(6,2);
        cont.setLayout(grid);
        
        questionAsked = questions.get(rand.nextInt(questions.size()));
        
        
        //here we will make the question label
        JLabel questionLabel = new JLabel(questionAsked.getQuestion());
        //answer label
        JLabel answerLabel = new JLabel(makeHint(questionAsked.getAnswer()));
        //textfield for userinput
        JTextField answerField = new JTextField();
        //button to check answer
        JButton checkButton = new JButton("Check");
        
        //button to generate new question
        JButton newQuestion = new JButton("Get New Question");
        //The warning label below everythign
        JLabel warningLabel = new JLabel("I'm here!");
        cont.add(questionLabel);
        cont.add(answerLabel);
        cont.add(answerField);
        cont.add(checkButton);
        cont.add(newQuestion);
        cont.add(warningLabel);
        
        //add an event listener to the checkbutton
        CheckAnswer ca = new CheckAnswer(answerLabel, warningLabel, answerField, questionAsked);
        checkButton.addActionListener(ca);
        
        //add an event listener to get new question
        GetNewQuestion gnc = new GetNewQuestion(questionAsked, questionLabel, answerLabel, warningLabel, questions, answerField, ca);
        newQuestion.addActionListener(gnc);
        
        
        
        
        
        
        


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
