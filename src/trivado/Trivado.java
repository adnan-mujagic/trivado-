/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trivado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import trivado.questions.Question;
import trivado.ui.UserInterface;

/**
 *
 * @author Paprika
 */
public class Trivado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("What is my full name?","Adnan Mujagic"));
        questions.add(new Question("What does the International System of Quantities refer 1024 bytes as?","Kibibyte"));
        questions.add(new Question("Name of the most mentioned esports organization?","FaZe Clan"));
        questions.add(new Question("The captial of Finland","Helsinki"));
        questions.add(new Question("The sport where the goal is to score more goals","Soccer"));
        questions.add(new Question("The material that glasses are usually made of?","Glass"));
        questions.add(new Question("This element is abreviated as N in the periodic table", "Nitrogen"));
        questions.add(new Question("The genre of music", "kpop"));
        questions.add(new Question("The genre of music", "rap"));
        questions.add(new Question("The genre of music", "rock"));
        questions.add(new Question("The genre of music", "jazz"));
        questions.add(new Question("The genre of music", "metal"));
        questions.add(new Question("A music instrument with keys", "Piano"));
        questions.add(new Question("Used to measure temperature", "Thermometer"));
        questions.add(new Question("A famous US helicopter named after a tribe", "Apache"));
        questions.add(new Question("City in Illinois", "Chicago"));
        questions.add(new Question("Pentagon is in this city", "Washington"));
        questions.add(new Question("Capital of Australia", "Canberra"));
        questions.add(new Question("Name of the main character in Home Alone", "Kevin"));
        questions.add(new Question("Empire State building is in this city","New York"));
        questions.add(new Question("A singer whose lastname is often confused for eyelash", "Billie Eilish"));
        questions.add(new Question("The author of Crime and Punishment", "Fyodor Dostoevsky"));
        questions.add(new Question("Tyrion belongs to this family in Game of Thrones", "Lannister"));
        questions.add(new Question("The state in which Los Angeles is located", "California"));
        questions.add(new Question("RM is the leader of this K-pop group","BTS"));
        questions.add(new Question("The highest mountain in the world", "Mount Everest"));
        questions.add(new Question("Capital of Japan", "Tokyo"));
        questions.add(new Question("In show Money Heist, every robber has a name of a city except...", "the professor"));
        questions.add(new Question("Viral 'rapper' who got famous with a hit 'Old Town Road'", "Lil Nas X"));
        
        
        UserInterface ui = new UserInterface(questions);
        SwingUtilities.invokeLater(ui);
    }
    
}
