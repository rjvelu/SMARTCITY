/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Directories;

import java.util.ArrayList;
import model.BuildingCoordinates;

/**
 *
 * @author Ruthvik Garlapati
 */
public class BuildingsDirectory {
    ArrayList<BuildingCoordinates> list;
    
     public BuildingsDirectory(){
      this.list = new ArrayList<>();
   }

    public ArrayList<BuildingCoordinates> getList() {
        return list;
    }

    public void setList(ArrayList<BuildingCoordinates> list) {
        this.list = list;
    }
     public BuildingCoordinates addNew(){
     BuildingCoordinates temp = new BuildingCoordinates();
     list.add(temp);
     return temp;
    }
}
     