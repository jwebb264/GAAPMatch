//TODO: create variable array list to hold students and hosts from database(if necessary)
//TODO: rerun program with next student/host to find match
//TODO: rank matches based on scores

public class Main {
    public static void main(String[] args){
        String login = "Student";
        GAPP n = new GAPP();

        if (login.startsWith("E") || login.startsWith("S")){
            ExchangeStudent student = new ExchangeStudent();
            student.studentResponses.put(1, 'N');
            student.studentResponses.put(2, 'Y');
            student.studentResponses.put(3, 'Y');
            student.studentResponses.put(4, 'Y');
            student.studentResponses.put(5, 'Y');
            student.studentResponses.put(6, 'Y');
            student.studentResponses.put(7, 'N');
            student.studentResponses.put(8, 'N');
            student.studentResponses.put(9, 'Y');
            student.studentResponses.put(10, 'Y');

            if (student.studentResponses.get(2)=='Y') {
                System.out.println("Student has allergies");
            }else System.out.println("No allergies");
        }else if(login.startsWith("H")){
            HostFamily host = new HostFamily();
                host.hostResponses.put(1, 'Y');
                host.hostResponses.put(2, 'N');
                host.hostResponses.put(3, 'Y');
                host.hostResponses.put(4, 'Y');
                host.hostResponses.put(5, 'Y');
                host.hostResponses.put(6, 'N');
                host.hostResponses.put(7, 'N');
                host.hostResponses.put(8, 'Y');
                host.hostResponses.put(9, 'N');
                host.hostResponses.put(10, 'Y');

                System.out.println(host.hostResponses.get(3));

        }





    }
}//end of program
