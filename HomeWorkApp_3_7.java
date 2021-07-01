package ru.gb.GB_repo;

public class HomeWorkApp_3_7 {
    public static void main(String[] args) {

        CalculatorTest calc = new CalculatorTest();
        Tester tester = new Tester();
        try {
            tester.start(CalculatorTest.class.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}