public class GAPP {
    protected boolean medicalIssues;
    protected char gender;
    //protected char genderPreference;
    protected boolean smokes;
    protected boolean okWithSmoking;
    protected boolean environmentalAllergies;
    protected boolean foodAllergies;
    protected boolean seperateRoom;
    protected String religious;
    protected boolean canAccomodate;

    public GAPP(){

    }
/**
    public int medicalIssues(){
        if (ExchangeStudent.medicalIssues && Host.canAccomodate || !ExchangeStudent.medicalIssues){
            return 1;
        } else if (ExchangeStudent.medicalIssues && !Host.canAccomodate){
            return -1;
        } else return 0;
    }

    public int environmentalAllergies(){
        if(ExchangeStudent.environmentalAllergies && !Host.hasPets || ExchangeStudent.environmentalAllergies && ExchangeStudent.canAccomodate){
            return 1;
        }else if (!ExchangeStudent.environmentalAllergies){
            return 1;
        } else return -1;
    }

    public int foodAllergies(){
        if(!ExchangeStudent.foodAllergies){
            return 1;
        }else if (ExchangeStudent.foodAllergies && Host.canAccomodate){
            return 1;
        }else return -1;
    }

    public int dietaryRestrictions(){
        if(!ExchangeStudent.dietaryRestrictions){
            return 1;
        }
        if(ExchangeStudent.dietaryRestrictions && Host.canAccomodate){
            return 1;
        } else return -1;
    }

    public int StudentSmoker(){

    }

    public int HostSmoker(){

    }

    public int Gender(){

    }
*/

}
