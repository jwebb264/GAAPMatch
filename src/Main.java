public class Main {
    public static void main(String[] args){
        String login = "Host";
        if (login.startsWith("E")){
            ExchangeStudent student = new ExchangeStudent();
        }else if(login.startsWith("H")){
            Host host = new Host();
        }


    }
}//end of program
