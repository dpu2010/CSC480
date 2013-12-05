/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Course;
import Model.Student;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 *
 * @author kylehodgkinson
 */
public class mainUI extends TabPane implements Observer {

    Student student;

    public mainUI(final Student student) {

        this.student = student;
        student.addObserver(this);
        buildTabs();
        plusTab(this);

    }

    @Override
    public void update(Observable o, Object arg) {
        this.getTabs().remove(0, this.getTabs().size());
        buildTabs();
        plusTab(this);
    }

    public void plusTab(final TabPane pane) {
        pane.getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Tab>() {
                    @Override
                    public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
                        try {
                            if (newTab.getText().equals("+")) {
                                pane.getSelectionModel().select(oldTab);
                                Stage stage = new Stage();
                                CourseDialog newCourse = new CourseDialog(stage, student);
                                newCourse.buildCourseDialog();
                                stage.show();
                            }
                        } catch (NullPointerException e) {

                        }
                    }
                });
    }

    public void buildTabs() {

        ArrayList<Course> courseList = student.getCourseDataBase().getCourseList();
        ArrayList<Tab> tabs = new ArrayList<>();
        for (int i = 0; i < courseList.size(); i++) {
            tabs.add(new Tab(courseList.get(i).getName()));
            tabs.get(i).setContent(new TaskTable(courseList.get(i), student));
            this.getTabs().add(tabs.get(i));
        }
        this.getTabs().add(new Tab("+"));
        this.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
    }
}
