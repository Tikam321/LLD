package BehaviouralPattern;

import javax.management.MBeanAttributeInfo;

enum LoggerEnum {
    INFO,
    ERROR,
    DEBUG
}

abstract class AbstractLogger {
    private AbstractLogger abstractLogger;

    public AbstractLogger(AbstractLogger abstractLogger) {
        this.abstractLogger = abstractLogger;
    }

    public void log(LoggerEnum log, String message) {
        if (abstractLogger != null) {
            abstractLogger.log(log, message);
        }
    }
}

class InfoLogger extends AbstractLogger {

    public InfoLogger(AbstractLogger abstractLogger) {
        super(abstractLogger);
    }
    public void log(LoggerEnum log, String message) {
        System.out.println("the log object is passing through info logger");
        if (log.equals(LoggerEnum.INFO)) {
            System.out.println(LoggerEnum.INFO + " "  +message);
        } else {
            super.log(log, message);
        }
    }

}

class DebugLogger extends AbstractLogger {

    public DebugLogger(AbstractLogger abstractLogger) {
        super(abstractLogger);
    }
    public void log(LoggerEnum log, String message) {
        System.out.println("the log object is passing through debug logger");

        if (log.equals(LoggerEnum.DEBUG)) {
            System.out.println(LoggerEnum.DEBUG + " "  +message);
        } else {
            super.log(log, message);
        }
    }

}

class ErrorLogger extends AbstractLogger {

    public ErrorLogger(AbstractLogger abstractLogger) {
        super(abstractLogger);
    }
    public void log(LoggerEnum log, String message) {
        System.out.println("the log object is passing through error logger");
        if (log.equals(LoggerEnum.ERROR)) {
            System.out.println(LoggerEnum.ERROR + " "  +message);
        } else {
            super.log(log, message);
        }
    }
}



public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        AbstractLogger abstractLogger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));

        abstractLogger.log(LoggerEnum.ERROR, "error found on login");
        abstractLogger.log(LoggerEnum.INFO, "the user successfully logged-in");
        }
}