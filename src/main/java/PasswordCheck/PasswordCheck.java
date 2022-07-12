package PasswordCheck;

public class PasswordCheck {
    private char[] input;
    public PasswordCheck(char[] passwordValue) throws Exception {
        this.input = passwordValue;

        //setting up restrictions for the password

        final int MIN_UPPERCASE = 1;
        final int MIN_LOWERCASE = 1;
        final int NUM_DIGITS = 1;
        final int SPECIAL = 1;
        final int NUM_SYMBOLS = 8;
        int upperCaseCounter = 0;
        int lowerCaseCounter = 0;
        int digitsCounter = 0;
        int specialCounter = 0;
        int symbolsCounter = 0;

        //counting requirements
        for (int i = 0; i <input.length; i++){
            char c = input[i];
            if(Character.isUpperCase(c)){
                upperCaseCounter++;
            }
            if(Character.isLowerCase(c)){
                lowerCaseCounter++;
            }
            if(Character.isDigit(c)){
                digitsCounter++;
            }
            if(c>=33&&c<=46||c==64){
                specialCounter++;
            }
            symbolsCounter++;
        }
        //Throwing exceptions for pop-up messages

        if(symbolsCounter<1) {
            throw new Exception("Password must not be empty");
        } else if(symbolsCounter<NUM_SYMBOLS){
                throw new Exception("Password must contain at least 8 characters");
            } else if(specialCounter<SPECIAL){
                throw new Exception("Password must contain special characters like " +
                        "(~! @#$%^&*_-+=`|\\(){}[]:;\"'<>,.?/)");
            } else if(digitsCounter<NUM_DIGITS) {
                throw new Exception("Password must contain at least 1 digit");
            } else if(lowerCaseCounter<MIN_LOWERCASE){
                throw new Exception("Password must contain at least 1 lowercase letter");
            } else if(upperCaseCounter<MIN_UPPERCASE){
                throw new Exception("Password must contain at least 1 uppercase letter");
            }
        }
    }
