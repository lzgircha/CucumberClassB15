package Utils;

import org.apache.log4j.Logger;

public class Log {

    public static Logger log =Logger.getLogger(Log.class.getName());

    // when the test starts I should print the logs
    // when my tests stops, I should print the log
    // If I want to print any message in between, I should print the logs
    // log is not necessary only if the clint or manager requested to implement it!!!

    public static void startTestCase(String testCaseName){
        log.info("*****************************");
        log.info("*****************************");
        log.info("*********"+testCaseName+"************");
    }

    public static void  endTestCase(String testCaseName){
        log.info("##############################");
        log.info("###############################");
        log.info("########"+testCaseName+"################");
    }

    public static void info(String message){
        log.info(message);
    }

    public static void warning(String warning){
        log.info(warning);
    }


                      //========================MAVEN LIFECYCLE=====================

    //MAVEN LIFECYCLE: this consists of several phases:

    //* CLEAN: Removes all the files generated by the previous build
    //* VALIDATE: Checks the project is correct and all the necessary information is available
    //* COMPILE: Compiles the source code of the project
    //* TEST: Runs the tests for the project
    //* PACKAGE: Packages the compiled code into a distributable format, such as JAR or WAR files
    //* VERIFY: Runs and checks on results of integration tests to ensure quality criteria is met
    //* INSTALL: Installs the packages into the local repository (.m2 folder)
    //* SITE: Generates documentation  for the project
    //* DEPLOY: Copies the final package to remove repository for sharing with other developers and projects
}
