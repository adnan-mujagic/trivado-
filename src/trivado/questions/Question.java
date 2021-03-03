/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivado.questions;

/**
 *
 * @author Paprika
 */
public class Question {
    private String question;
    private String answer;
    public Question(String question, String answer){
        this.question=question;
        this.answer=answer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return this.question+"\n"+this.answer;
    }
    
    
}
