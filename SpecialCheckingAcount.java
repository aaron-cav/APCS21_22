public class SpecialCheckingAcount extends CheckingAccount{
    private double minbalance;
    private double annualIR;

    public SpecialCheckingAcount(int idNum, double startBal, double chg, double minbal, double ir) {
        super(idNum, startBal, chg);
        minbalance = minbal;
        annualIR = ir;
    }

    public void clearCheck(double amount) {
        if(currentBalance() > minbalance)   {
            decreaseBalance(amount);
        }
        else
            clearCheck(amount);
    }

    public double monthlyInterest() {
        if (currentBalance() > minbalance) {
            return (super.currentBalance() + annualIR) / 12;
        } else
            return super.monthlyInterest();
    }
}
