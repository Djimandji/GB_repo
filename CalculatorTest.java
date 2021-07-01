package ru.gb.GB_repo;

class CalculatorTest {

    Calculator calc = new Calculator();

    @BeforeSuite
    void setUp() {
        System.out.println("Setup");
    }

    @AfterSuite
    void End() {
        System.out.println("=========================================");
        System.out.println("End");
    }

    @Test (priority = 1)
    void add() {
        System.out.println("=========================================");
        System.out.println("Add test  ---> priority 1");
        System.out.println(4 == calc.add(2, 1));
    }

    @Test (priority = 3)
    void sub() {
        System.out.println("=========================================");
        System.out.println("Sub test  ---> priority 3");
        System.out.println(4 == calc.sub(8, 2));
    }

    @Test (priority = 2)
    void mul() {
        System.out.println("=========================================");
        System.out.println("Mul test  ---> priority 2");
        System.out.println(4 == calc.mul(2, 2));
    }

    @Test (priority = 4)
    void div() {
        System.out.println("=========================================");
        System.out.println("Div test  ---> priority 4");
        System.out.println(4 == calc.sub(8, 2));
    }
}