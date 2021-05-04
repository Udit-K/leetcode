package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/*
#    timestamp
#    type_of_error
#    error_code
#    platform
#
 */
public class Logs {

        String timeStamp;
        String typeOfError;
        String errorCode;
        String platform;

    @Override
    public String toString() {
        return  timeStamp +"  " + typeOfError + " " + errorCode + " " + platform;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getTypeOfError() {
        return typeOfError;
    }

    public void setTypeOfError(String typeOfError) {
        this.typeOfError = typeOfError;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }



    public HashMap<String, Integer> parseLogs(String[] logs) {
        List<Logs> logsList = new ArrayList<>();
        for (String eachLog: logs) {
            Logs logs1 = new Logs();
            List<String> dateArray = Arrays.asList(eachLog.split("-"));
            logs1.setTimeStamp(parseTimeStamp(dateArray.get(0)));
            logs1.setTypeOfError(parseErrorType(eachLog));
            logs1.setPlatform(parseAppType(eachLog));
            logs1.setErrorCode(parseStatusCode(eachLog));

            logsList.add(logs1);

        }
        if(!logsList.isEmpty()) {
            HashMap<String, Integer> resultMap = new HashMap<>();
            for(Logs log: logsList) {
                int count = 1;
                resultMap.put(log.toString(), count +1);
            }
            return resultMap;
        }

        return null;
    }

    private String parseTimeStamp(String time) {
        Date date1 = null;
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'");
        try {
             date1 = formatter.parse(time);
        }catch (Exception e) {
            //error parsing date
        }
        return date1.toGMTString();
    }

    private String parseErrorType(String error) {
        if(error.contains("INFO")) {
            return "INFO";
        }else if(error.contains("ERROR")) {
            return "ERROR";
        }
        return null;
    }

    private String parseAppType(String app) {

        if(app.contains("app")) {
            return "app";
        }else if ((app.contains("web"))) {
            return "web";
        }
        return null;
    }

    private String parseStatusCode(String statusCode) {
        Pattern pattern = Pattern.compile("\\:[0-9]{3}");
        Matcher matcher = pattern.matcher(statusCode);

        if(matcher.find()) {
           List app = Arrays.asList(matcher.group(0).split(":"));
           return (String) app.get(1);
        }
        return null;
    }


}
