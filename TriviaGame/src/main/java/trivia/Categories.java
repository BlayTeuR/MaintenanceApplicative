package trivia;

enum Categories {
    POP("Pop", "./Questions/Pop.questions"),
    SCIENCE("Pop", "./Questions/Pop.questions"),
    SPORTS("Pop", "./Questions/Pop.questions"),
    ROCK("Pop", "./Questions/Pop.questions"),
    ;

    private final String stringValue;
    private final String fileNameValue;

    Categories(final String string, final String file){
        stringValue = new String(string);
        fileNameValue = new String(file);
    }

    public String toString(){
        return stringValue;
    }

    public String getFileNameValue() {
        return fileNameValue;
    }

    public String getStringValue(){
        return stringValue;
    }
}

