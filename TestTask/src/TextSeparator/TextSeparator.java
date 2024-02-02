package TextSeparator;

import java.util.LinkedList;

import TextSeparator.Statistics.*;
import TextSeparator.Types.*;

import java.io.*;

public class TextSeparator {
    private LinkedList<String> inputFiles = new LinkedList<String>();
    private String path = "";
    private String prefix = "";
    private boolean append = false;
    
    private boolean shortStatFlag = false;
    private boolean fullStatFlag = false;
    private StatisticsOfStrings strStat = null;
    private StatisticsOfNumbers intStat = null;
    private StatisticsOfNumbers floatStat = null;

    private BufferedWriter writeToFile(BufferedWriter file, InnerStatistics statistics, TextString line) {
        try {
            if (file == null) {
                file = new BufferedWriter(new FileWriter(path + prefix + line.getFileName(), append));
            }
            file.write(line + "\n");
            if (statistics != null) {
                statistics.add(line.toString());
            }
        } catch (IOException ex) {
            System.out.printf("Couldn't write the value: %s;\n", line);
        }
        return file;
    }

    public TextSeparator(String[] args) {
        for (int i = 0; i < args.length; ++i) {
            if (args[i].compareTo("-p") == 0 && i + 1 < args.length) {
                prefix = args[++i];
            } else if (args[i].compareTo("-o") == 0 && i + 1 < args.length) {
                path = args[++i];
            } else if (args[i].compareTo("-a") == 0) {
                append = true;
            } else if (args[i].compareTo("-s") == 0) {
                shortStatFlag = true;
            } else if (args[i].compareTo("-p") == 0) {
                fullStatFlag = true;
            } else if (args[i].indexOf(".txt") == args[i].length() - 4) {
                inputFiles.addLast(args[i]);
            }
        }
        if (fullStatFlag || shortStatFlag) {
            strStat = new StatisticsOfStrings();
            intStat = new StatisticsOfNumbers();
            floatStat = new StatisticsOfNumbers();
        }
    }

    public void startSeporate() {
        File checkPath = new File(path);
        if (!checkPath.exists()) {
            path = "";
        } else {
            path += "/";
        }

        BufferedWriter strFile = null;
        BufferedWriter intFile = null;
        BufferedWriter floatFile = null;

        for (String nameInputFile: inputFiles) {
            File inFile = new File(nameInputFile);
            if (!inFile.exists()) {
                continue;
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(nameInputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (IntegerString.isType(line)) {
                        intFile = writeToFile(intFile, intStat, new IntegerString(line));
                    } else if (FloatString.isType(line)) {
                        floatFile = writeToFile(floatFile, floatStat, new FloatString(line));
                    } else {
                        strFile = writeToFile(strFile, strStat, new TextString(line));
                    }
                }
            } catch (IOException ex) {
                System.out.printf("Couldn't open %s to read;\n", nameInputFile);
            }
        }
        try {
            if (strFile != null) {
                strFile.close();
            }
            if (intFile != null) {
                intFile.close();
            }
            if (floatFile != null) {
                floatFile.close();
            }
        } catch (IOException ex) {
            System.out.println("Couldn't close the file;\n");
        }
    }

    public void printInfo()  {
        
    }
}
