/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.thecell.textworker;

/**
 *
 * @author simon
 */
public class Textworker
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TextProcessor txtPrc = new TextProcessor("C:\\Users\\simon\\Desktop\\ImagesList.txt", "C:\\Users\\simon\\Desktop\\newImagesList.txt");
	txtPrc.cutXLinesEveryYRows(1, 2);
    }

}
