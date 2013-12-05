/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Category;
import Model.Course;
import Model.Student;
import Model.Task;
import java.util.Observable;
import java.util.Observer;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author kylehodgkinson
 */
public class TaskTable extends VBox {

    Course course;
    Student student;
    TTable table;
    CatTable cTable;
    Button newTaskButton = new Button("Create New Task");
    Button newCategoryButton = new Button("Create New Category");

    public TaskTable(final Course course, final Student student) {
        this.course = course;
        this.student = student;

        table = new TTable(FXCollections.observableArrayList(
                course.getTaskDatabase().getTasks()));

        table.setItems(FXCollections.observableArrayList(
                course.getTaskDatabase().getTasks()));

        cTable = new CatTable(FXCollections.observableArrayList(
                course.getCategoryDatabase().getCategories()));

        cTable.setItems(FXCollections.observableArrayList(
                course.getCategoryDatabase().getCategories()));

        newCategoryButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = new Stage();
                CategoryDialog newCategory = new CategoryDialog(stage, course);
                newCategory.buildCategoryDialog();
                stage.show();
            }
        });

        newTaskButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final Stage stage = new Stage();
                TaskDialog newTask = new TaskDialog(stage, course);
                newTask.buildTaskDialog();
                stage.show();
            }
        });

        this.getChildren().addAll(table, newTaskButton, cTable, newCategoryButton);
    }

    private class CatTable extends TableView<Category> implements Observer {

        String name = "Name";
        String number = "Number of Tasks";
        String target = "Target Score";
        String average = "Current Score";

        TableColumn nameColumn = new TableColumn<>(name);
        TableColumn numberColumn = new TableColumn<>(number);
        TableColumn targetColumn = new TableColumn<>(target);
        TableColumn averageColumn = new TableColumn(average);

        CatTable(ObservableList List) {

            nameColumn.setCellValueFactory(
                    new PropertyValueFactory<Category, String>("name")
            );
            nameColumn.setMinWidth(name.length() * 35.0);

            numberColumn.setCellValueFactory(
                    new PropertyValueFactory<Category, Integer>("numTasks")
            );
            numberColumn.setMinWidth(number.length() * 10.0);

            targetColumn.setCellValueFactory(
                    new PropertyValueFactory<Category, Double>("goal")
            );
            targetColumn.setMinWidth(target.length() * 10.0);
            
            averageColumn.setMinWidth(average.length() * 10.0);
            averageColumn.setCellValueFactory(new AverageCellValueFactory());

            this.getColumns().addAll(nameColumn, numberColumn, targetColumn, averageColumn);
            this.setEditable(true);
            student.addObserver(this);
        }

        private class AverageCellValueFactory implements Callback<CellDataFeatures<Category, String>, ObservableValue<String>> {

            public AverageCellValueFactory() {
            }

            @Override
            public ObservableValue<String> call(CellDataFeatures<Category, String> p) {
                String result = "";
                Double average = p.getValue().getAverage();
                if (average >= 0.0) {
                    result = String.valueOf(round(average, 2));
                }
                ReadOnlyObjectWrapper<String> thing = new ReadOnlyObjectWrapper<String>(result);
                return thing;
            }
        }

        public double round(double value, int places) {
            if (places < 0) {
                throw new IllegalArgumentException();
            }
            long factor = (long) Math.pow(10, places);
            value = value * factor;
            long tmp = Math.round(value);
            return (double) tmp / factor;
        }

        @Override
        public void update(Observable o, Object arg) {
            this.setItems(FXCollections.observableArrayList(
                    course.getCategoryDatabase().getCategories()));
        }
    }

    private class TTable extends TableView<Task> implements Observer {

        String name = "Name";
        String category = "Category";
        String suggest = "Suggested Time for Task";
        String spent = "Time Spent on Task (minutes)";
        String score = "Score";

        TableColumn nameColumn = new TableColumn<>(name);
        TableColumn categoryColumn = new TableColumn<>(category);
        TableColumn suggestColumn = new TableColumn<>(suggest);
        TableColumn spentColumn = new TableColumn(spent);
        TableColumn scoreColumn = new TableColumn(score);

        TTable(ObservableList List) {

            nameColumn.setCellValueFactory(
                    new PropertyValueFactory<Task, String>("name")
            );
            nameColumn.setMinWidth(name.length() * 21.0);

            categoryColumn.setCellValueFactory(
                    new PropertyValueFactory<Task, String>("catName")
            );
            categoryColumn.setMinWidth(category.length() * 12.0);

            suggestColumn.setCellValueFactory(
                    new PropertyValueFactory<Task, String>("suggestedTime")
            );
            suggestColumn.setMinWidth(suggest.length() * 10.0);

            spentColumn.setMinWidth(spent.length() * 10.0);

            spentColumn.setCellValueFactory(new MySpentCellValueFactory());
            spentColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            spentColumn.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<Task, String> t) {
                            Task s = ((Task) t.getTableView().getItems().get(t.getTablePosition().getRow()));
                            String input = t.getNewValue();
                            try {
                                s.setTimeSpent(Double.valueOf(input));
                            } catch (NumberFormatException e) {
                                if (input.equals("")) {
                                } else {
                                    System.out.println("Please enter a NUMBER that is greater than or equal to 0.");
                                }
                            }
                        }
                    }
            );

            scoreColumn.setMinWidth(score.length() * 12.0);

            scoreColumn.setCellValueFactory(new MyScoreCellValueFactory());
            scoreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
            scoreColumn.setOnEditCommit(
                    new EventHandler<TableColumn.CellEditEvent<Task, String>>() {
                        @Override
                        public void handle(TableColumn.CellEditEvent<Task, String> t) {
                            Task s = ((Task) t.getTableView().getItems().get(t.getTablePosition().getRow()));
                            String input = t.getNewValue();
                            try {
                                s.setScore(Double.valueOf(input));
                            } catch (NumberFormatException e) {
                                if (input.equals("")) {
                                } else {
                                    System.out.println("Please enter a NUMBER that is greater than or equal to 0.");
                                }
                            }
                        }
                    }
            );

            this.getColumns().addAll(nameColumn, categoryColumn, suggestColumn, spentColumn, scoreColumn);
            this.setEditable(true);
            student.addObserver(this);
        }

        @Override
        public void update(Observable o, Object arg) {
            System.out.println("Hello I am here!");
            this.setItems(FXCollections.observableArrayList(
                    course.getTaskDatabase().getTasks()));
        }

        private class MyScoreCellValueFactory implements Callback<TableColumn.CellDataFeatures<Task, String>, ObservableValue<String>> {

            public MyScoreCellValueFactory() {
            }

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Task, String> p) {
                Double grade = p.getValue().getScore();
                if (grade == null) {
                    return new ReadOnlyObjectWrapper<String>("");
                }
                String result = String.valueOf(grade);
                ReadOnlyObjectWrapper<String> thing = new ReadOnlyObjectWrapper<String>(result);
                return thing;
            }
        }

        private class MySpentCellValueFactory implements Callback<TableColumn.CellDataFeatures<Task, String>, ObservableValue<String>> {

            public MySpentCellValueFactory() {
            }

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Task, String> p) {
                Double spent = p.getValue().getTimeSpent();
                if (spent == null) {
                    return new ReadOnlyObjectWrapper<String>("");
                }
                String result = String.valueOf(spent);
                ReadOnlyObjectWrapper<String> thing = new ReadOnlyObjectWrapper<String>(result);
                return thing;
            }
        }

    }

}
