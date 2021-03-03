/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivado.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTextField;
import trivado.questions.Question;

/**
 *
 * @author Paprika
 */
public class CheckAnswer implements ActionListener{
    private JLabel answerLabel;
    private JLabel warningLabel;
    private JTextField answerField;
    private Question question;
    public CheckAnswer(JLabel answerLabel, JLabel warningLabel, JTextField answerField, Question question){
        this.answerField=answerField;
        this.answerLabel = answerLabel;
        this.question = question;
        this.warningLabel = warningLabel;
    }
    
    public void actionPerformed(ActionEvent ae){
        String userAnswer = answerField.getText();
        if(userAnswer.equals("")){
            warningLabel.setText("Please write an answer in the answer field!");
        }
        else{
            if(userAnswer.toLowerCase().equals(question.getAnswer().toLowerCase())){
                warningLabel.setText("That is correct!!!");
                answerLabel.setText(question.getAnswer());
                
            }
            else{
                warningLabel.setText(userAnswer+" isn't quite the answer! Try again!");
                
            }
            
            answerField.setText("");
            
        }
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
    
    
}
