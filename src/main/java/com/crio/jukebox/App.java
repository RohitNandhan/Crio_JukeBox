package com.crio.jukebox;

import com.crio.jukebox.commands.CommandInvoker;
import com.crio.jukebox.config.ApplicationConfig;
import com.crio.jukebox.exceptions.NoSuchCommandException;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class App {
    // To run the application  ./gradlew run --args="INPUT_FILE=jukebox-input.txt"
	public static void main(String[] args) {

		List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        commandLineArgs.add("INPUT-FILE=jukebox-input.txt");
        String expectedSequence = "INPUT-FILE";
        String actualSequence = commandLineArgs.stream()
                .map(a -> a.split("=")[0])
                .collect(Collectors.joining(","));
        if(expectedSequence.equals(actualSequence)){
            run(commandLineArgs);
        }
	}

    public static void run(List<String> commandLineArgs) {
    // Complete the final logic to run the complete program.
        ApplicationConfig applicationConfig=new ApplicationConfig();
        CommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
        BufferedReader bufferedReader;
        String inputFile=commandLineArgs.get(0).split("=")[1];
        commandLineArgs.remove(0);
        try{
            bufferedReader=new BufferedReader(new FileReader(inputFile));
            String line= bufferedReader.readLine();
            while(line!=null){
                List<String> tokens=Arrays.asList(line.split(" "));
               commandInvoker.executeCommand(tokens.get(0),tokens);
                System.out.println();
                line= bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException  | NoSuchCommandException e) {
            e.printStackTrace();
        }
    }
//    public static void run(List<String> commandLineArgs) {
//        // Complete the final logic to run the complete program.
//        ApplicationConfig applicationConfig=new ApplicationConfig();
//        CommandInvoker commandInvoker=applicationConfig.getCommandInvoker();
//        BufferedReader bufferedReader;
//          String inputFile=commandLineArgs.get(0).split("=")[1];
//        commandLineArgs.remove(0);
//        try{
//            bufferedReader=new BufferedReader(new FileReader(inputFile));
//            String line= bufferedReader.readLine();
//            while(line!=null){
//                List<String> tokens=Arrays.asList(line.split(" "));
//                commandInvoker.executeCommand(tokens.get(0),tokens);
//                System.out.println();
//                line= bufferedReader.readLine();
//            }
//            bufferedReader.close();
//        } catch (IOException  | NoSuchCommandException e) {
//            e.printStackTrace();
//        }
//    }
}
