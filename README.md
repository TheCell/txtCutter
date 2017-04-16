# txtCutter
cuts x lines after every y lines written

This was written for handling big txt files and cut Lines out of it.

## instructions
The Jar is used in the following way:

`java -jar Textworker.jar -source "pathToFile\list.txt" -target "pathToFile\texttest.txt" -skipafter 1 -skipamount 2`

`-source`: The Path to the sourcefile including the name of the File  
`-target`: The Path to the save File including the name of the File (Does not need to exist beforehand)  
`-skipafter` # // How many lines should be written before jump command  
`-skipamount` # // How many lines should be jumped before writing again
