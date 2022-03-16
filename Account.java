import java.text.DecimalFormat;

public abstract class Account{
    private int idNumber;
    private double balance;

    public Account(int idNum, double startBal) {
        int idnum = 123456789;
        startBal = 250.0;
    }
    /** @return the identity number for this account */
    public int idNumber() {
        return idNumber;
    }

    /** @return the current balance for this account */
    public double currentBalance() {
        return balance;
    }
    /** precondition: amount >= 0.0
     * postcondition: the current balance of this account has been increased
     * by amount */
    public void deposit(double amount) {
        balance += amount;
    }
    /** precondition: 0.0 <= amount <= balance
     * postcondition: the current balance of this account has been decreased
     * by amount and return true; return false if amount > balance */
    public boolean decreaseBalance(double amount) {
        if(amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
    /** @return the monthly interest due for this account */
    public abstract double monthlyInterest();



    public String toString()    {
        DecimalFormat df = new DecimalFormat("$.00");
        return getClass().toString().substring(6) + " " + idNumber + ": " + df.format(balance);
    }
}
