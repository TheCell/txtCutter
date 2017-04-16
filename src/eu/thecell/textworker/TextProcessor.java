/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eu.thecell.textworker;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author simon
 */
public class TextProcessor
{
    private String inputFileName;
    private String outputFileName;

    public TextProcessor(String inputFileName)
    {
	this(inputFileName, "");
    }

    public TextProcessor(String inputFileName, String outputFileName)
    {
	this.inputFileName = inputFileName;
	this.outputFileName = outputFileName;
    }

    public void cutXLinesEveryYRows(int skipAfterX, int amountOfLinesToSkip)
    {
	int currentCount = 0;
	skipAfterX --;

	if(this.outputFileName.equals(""))
	{
	    try (Stream<String> stream = Files.lines(Paths.get(this.inputFileName)))
	    {
		Iterator<String> iterator = stream.iterator();
		String line = "";

		while(iterator.hasNext())
		{
		    line = iterator.next();

		    if(currentCount <= skipAfterX)
		    {
			System.out.println(line);
		    }

		    if(currentCount >= skipAfterX + amountOfLinesToSkip)
		    {
			currentCount = -1;
		    }

		    currentCount++;
		}
	    } catch (IOException ex)
	    {
		Logger.getLogger(TextProcessor.class.getName()).log(Level.SEVERE, null, ex);
		System.out.println("File could not be found.");
	    }
	}
	else
	{
	    try (Stream<String> stream = Files.lines(Paths.get(this.inputFileName)); PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(this.outputFileName))))
	    {
		Iterator<String> iterator = stream.iterator();
		String line = "";

		while(iterator.hasNext())
		{
		    line = iterator.next();

		    if(currentCount <= skipAfterX)
		    {
			pw.append(line + System.lineSeparator());
		    }

		    if(currentCount >= skipAfterX + amountOfLinesToSkip)
		    {
			currentCount = -1;
		    }

		    currentCount++;
		}
	    } catch (IOException ex)
	    {
		Logger.getLogger(TextProcessor.class.getName()).log(Level.SEVERE, null, ex);
		System.out.println("File could not be found.");
	    }
	}

	System.out.println("File Processed.");

    }
}
