package com.company;

public class LoanP {

    private  String clientNo;
    private  String clientName;
    private double loanA;
    private int years;
    private  String typeLoan;

    public LoanP(String clientN, String name,double amount,int years, String type){
        this.clientNo=clientN;
        this.clientName=name;
        this.loanA=amount;
        this.years = years;
        this.typeLoan = type;
    }

    public String getClientNo() {
        return clientNo;
    }

    public void setClientNo(String clientNo) {
        this.clientNo = clientNo;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public double getLoanA() {
        return loanA;
    }

    public void setLoanA(double loanA) {
        this.loanA = loanA;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getTypeLoan() {
        return typeLoan;
    }

    public void setTypeLoan(String typeLoan) {
        this.typeLoan = typeLoan;
    }




}
