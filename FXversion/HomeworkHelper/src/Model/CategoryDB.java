/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author kylehodgkinson
 */
public class CategoryDB extends Observable implements Observer{
    
    ArrayList<Category> categories;
    
    public CategoryDB(TaskDB courseList) {
       categories = new ArrayList<Category>(); 
    }
    
    public ArrayList<Category> getCategories() {
        return categories;
    }
    
    public ObservableList<Category> getObsCatList() {
        return FXCollections.observableArrayList(this.categories);
    }
    
    public void addCategory(Category cat) {
        this.categories.add(cat);
        cat.addObserver(this);
        setChanged();
        notifyObservers();
    }

    @Override
    public void update(Observable o, Object arg) {
        setChanged();
        notifyObservers();
    }
    
}
