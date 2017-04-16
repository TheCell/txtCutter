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
    public static void main(String[] args)
    {
	int skipAfterX = 1;
	int amountOfLinesToSkip = 0;
	String source = "";
	String target = "";

	for(int i = 0; i < args.length; i++)
	{
	    if("-source".equals(args[i]))
	    {
		if(!"".equals(args[i+1]))
		{
		    source = args[i+1];
		}
	    }
	    if("-target".equals(args[i]))
	    {
		if(!"".equals(args[i+1]))
		{
		    target = args[i+1];
		}
	    }
	    if("-skipafter".equals(args[i].toLowerCase()))
	    {
		skipAfterX = Integer.parseUnsignedInt(args[i+1]);
	    }
	    if("-skipamount".equals(args[i].toLowerCase()))
	    {
		amountOfLinesToSkip = Integer.parseUnsignedInt(args[i+1]);
	    }
	}

        TextProcessor txtPrc = new TextProcessor(source, target);
	txtPrc.cutXLinesEveryYRows(skipAfterX, amountOfLinesToSkip);
    }

}
