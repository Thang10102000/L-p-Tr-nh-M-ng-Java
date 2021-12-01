/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi.client;

public class ClientRun {

    public static void main(String[] args) {
        RMILoginClientView view = new RMILoginClientView();
        RMILoginClientControl control = new RMILoginClientControl(view);
        view.setVisible(true);
    }
}
