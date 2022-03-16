public class SavingsAccount extends Account{
    private double interesrRate;

    public SavingsAccount(int idNum, double startBal, double IntristRate2) {
        super(idNum, startBal);
        interesrRate = IntristRate2;
    }

    public double monthlyInterest() {
        return (super.currentBalance()+interesrRate)/12;
    }
}
