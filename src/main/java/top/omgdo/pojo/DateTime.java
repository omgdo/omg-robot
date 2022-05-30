package top.omgdo.pojo;

public enum DateTime {

    DATE("yyyy-MM-dd"),TIME("hh:mm:ss"),DATE_TIME("yyyy-MM-dd hh:mm:ss");
    private String patten;
    DateTime(String patten){
        this.patten=patten;
    }
    public String getPatten(){
        return patten;
    }

}
