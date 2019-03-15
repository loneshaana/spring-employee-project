package employee.example.data.model;

public enum Status {
    ACTIVE,INACTIVE;

    public static Boolean isValid(Status type){
        if(type == Status.ACTIVE || type == Status.INACTIVE){
            return true;
        }
//        try{
//            Status.valueOf(type);
//        }catch (IllegalArgumentException ex){
//            ex.printStackTrace();
//            return false;
//        }
        return  false;
    }
}
