/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Course;
import Model.Student;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author kylehodgkinson
 */
public class HomeworkHelper extends Application {

    Student student;
    AddCourse addBar;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Heavy Leather Inc.");

        student = new Student();
        
        Course softDev = new Course("307");
        student.getCourseDataBase().addCourse(softDev);
        /*Course artInt = new Course("480");
        Course intro = new Course("101");
        
        student.getCourseDataBase().addCourse(softDev);
        student.getCourseDataBase().addCourse(artInt);
        student.getCourseDataBase().addCourse(intro);
        
        Category programs307 = new Category("Programs", 95.0, softDev.getTaskDatabase());
        Category labs307 = new Category("Labs", 80.0, softDev.getTaskDatabase());
        Category midterms307 = new Category("Midterms", 90.0, softDev.getTaskDatabase());
        
        softDev.getCategoryDatabase().addCategory(midterms307);
        softDev.getCategoryDatabase().addCategory(programs307);
        softDev.getCategoryDatabase().addCategory(labs307);
                
        Task program1 = new Task("Program 1", programs307);
        Task program2 = new Task("Program 2", programs307);
        Task lab1 = new Task("Lab 1", labs307);
        Task lab2 = new Task("Lab 2", labs307);
        Task midterm = new Task("Midterm", midterms307);
        
        programs307.addTask(program1);
        programs307.addTask(program2);
        labs307.addTask(lab1);
        labs307.addTask(lab2);
        midterms307.addTask(midterm);*/
                
        //Setup Table
        BorderPane root = new BorderPane();
        root.setCenter(new mainUI(student));

        Scene scene = new Scene(root, 898, 510);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    

}
