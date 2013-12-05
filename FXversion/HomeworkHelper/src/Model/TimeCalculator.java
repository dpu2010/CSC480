/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author kylehodgkinson
 */
public class TimeCalculator {

    Category cat;

    public TimeCalculator(Category cat) {
        this.cat = cat;
    }

    public String calculateTime() {
        String result;

        Double timeAverage = averageTimes();
        Double scoreAverage = averageScores();
        
        double timeNext = computeTime(timeAverage, scoreAverage);
        Integer hours = (int) timeNext / 60;
        Integer minutes = (int) timeNext % 60; 
        
        result = new String(hours.toString() + " hour(s) and " + minutes.toString() + " minutes");
        
        return result;
    }
    
    public double computeTime(Double times, Double scores) {
        double algo = ((cat.getGoal() - scores) / 100) * times + times;
        return algo;
    }

    public Double averageTimes() {
        Double totalTime = new Double(0.0);
        int i;
        for (i = 0; i < cat.getCatTasks().size(); i++) {
            totalTime += cat.getCatTasks().get(i).getTimeSpent();
        }
        return totalTime / (i);
    }

    public Double averageScores() {
        Double totalScore = new Double(0.0);
        int i;
        for (i = 0; i < cat.getCatTasks().size(); i++) {
            totalScore += cat.getCatTasks().get(i).getScore();
        }
        return totalScore / (i);
    }

}
