package ru;

import java.util.Scanner;

public class ArabicRomainCalc {

    public static void main(String[] args) {

         try {
             Scanner in = new Scanner(System.in);
             System.out.print("Input: ");
             String text = in.nextLine();
             String[] numbers = text.split(" ",3);
             ExaminInput z1 = new ExaminInput();

             int z0 = z1.examinNumers(numbers[0]);
             int typeNum1 = z1.t;
             //System.out.println("Первое число: " + z0 + " Первый тип: " + typeNum1);

             int z2 = z1.examinNumers(numbers[2]);
             int typeNum2 = z1.t;
             //System.out.println("Второе число: " + z2 + " Второй тип: " + typeNum2);

             if (typeNum1 != typeNum2) {
                 System.out.println("Разные типы данных. \nПовторите ввод");
             }
             else if (typeNum1 == 0){
                 System.out.println("Output: " + z1.examinOperation(numbers[1], z0, z2));
             }
             else {
                 RomainOutput r = new RomainOutput();
                 r.defindRomain(z1.examinOperation(numbers[1], z0, z2));
             }
         }
         catch (NumberFormatException exc){
             System.out.println("Введенное значение не соответствует условию \nПопробуйте еще раз");
         }
         catch (ClassCastException exc){
             System.out.println("Введенная операция не соответствует условию \nПопробуйте еще раз");
         }
         catch (ArrayIndexOutOfBoundsException exc) {
             System.out.println("Введенное выражение не соответствует условию \nПопробуйте еще раз");
         }

    }
}


class ExaminInput{
    int z = 0; //Введенное число
    int t = 0; //Тип цифр 0 - арабские 1- римские
    int rez;
    public int examinNumers(String numbers){
        String[][] LegalNumbs; // 2-х мерный массив для хранения допустимых значений в строковом формате
        LegalNumbs = new String [][]{{"1","2","3","4","5","6","7","8","9","10"},{"I","II","III","IV","V","VI","VII","VIII","IX","X"}};
        var i = 0; //Счетчик столбцов
        var j = 0; //Счетчик строк (тип цифр)
        z = 0;
        for (j = 0; j < 2; j++) {
            for (i = 0; i < 10; i++) {
                if (LegalNumbs[j][i].equals(numbers)){
                    z = i + 1; //Определение введенного числа
                    t = j;   //Определение типа введенного числа 0 - арабские 1 - римские
                    //System.out.print("Your number: " + z);
                }
            }
        }
        if (z == 0) throw new NumberFormatException();
        return z;
    }
    public int examinOperation(String oper, int z0, int z2){
        switch (oper) {
            case "+" -> {
                rez = z0 + z2;
                return rez;
            }
            case "-" -> {
                rez = z0 - z2;
                return rez;
            }
            case "*" -> {
                rez = z0 * z2;
                return rez;
            }
            case "/" -> {
                rez = z0 / z2;
                return rez;
            }
        }
        throw new ClassCastException();
         //return rez;
    }
}

class RomainOutput {
    //Формирование строкового результата в формате римских чисел
    String desStr;
    String edStr;
    public void defindRomain(int rez){

        int des = rez / 10;
        int ed = rez % 10;
        switch (des) {
            case 1 -> desStr = "X";
            case 2 -> desStr = "XX";
            case 3 -> desStr = "XXX";
            case 4 -> desStr = "XL";
            case 5 -> desStr = "L";
            case 6 -> desStr = "LX";
            case 7 -> desStr = "LXX";
            case 8 -> desStr = "LXXX";
            case 9 -> desStr = "XC";
            case 10 -> desStr = "C";
        }
        switch (ed) {
            case 1 -> edStr = "I";
            case 2 -> edStr = "II";
            case 3 -> edStr = "III";
            case 4 -> edStr = "IV";
            case 5 -> edStr = "V";
            case 6 -> edStr = "VI";
            case 7 -> edStr = "VII";
            case 8 -> edStr = "VIII";
            case 9 -> edStr = "IX";
            case 0 -> edStr = "";
        }
        if (desStr == null) desStr = "";
        System.out.println("Output: " + desStr + edStr);
    }
}
