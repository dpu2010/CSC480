/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.ArrayList;

/**
 *
 * @author kylehodgkinson
 */
class CategoryDB {
    
    ArrayList<Category> categories;
    
    public CategoryDB() {
        
       categories = new ArrayList<Category>(); 
        
    }
    
    public ArrayList<Category> getCategories() {
        return categories;
    }
    
}