package com.company;

public class Business extends LoanP implements Generate{

    private double loanAmount;
    private double monthlyRate;
    private double termInMonths;


    public Business(String clientN, String name, double amount, int years, String type) {
        super(clientN, name, amount, years, type);
        this.loanAmount = super.getLoanA();
        this.monthlyRate = 0.09/12;
        this.termInMonths = this.loanAmount*12;
    }

    public void amortization() {
        double monthlyPayment= (loanAmount*monthlyRate)/(1-Math.pow(1+monthlyRate,-termInMonths));

    }




}
