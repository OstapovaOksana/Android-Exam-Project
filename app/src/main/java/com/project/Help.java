package com.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Help extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        textView = (TextView) findViewById(R.id.textView);


        Intent intent = getIntent();
        String action = intent.getAction();
        if(action.equals("Main")){
            textView.append("● У лабораторній роботі 1 обчислюється заданий вираз. Один з аргументів повинен вводити користувач.\n");
            textView.append("● У лабораторній роботі 2 обчислюються табульовані значення функції та записуються у файл, а також є можливість прочитати цей файл і відобразити його вміст на екрані.\n");
            textView.append("● У лабораторній роботі 3 користувач вводить значення кінців проміжку [x1; x2] та крок табуляції. Програма відображає список пар значень (x; y) та графік функції.\n");
            textView.append("● У лабораторній роботі 4 відображається робота з базою даних. Програма має можливість:\n" +
                    "- переглядати наявну базу (всі записи)\n" +
                    "- додавати один запис\n" +
                    "- модифікувати обраний запис\n" +
                    "- видаляти запис\n" +
                    "- здійснювати вибірку відповідно до варіанту \n" +
                    "- обчислювати величину відповідно до варіанту.\n");
            textView.append("● У лабораторній роботі 5 відображається інформація з адресної книги мого смартфону.\n");
            textView.append("● У лабораторній роботі 6 визначаються GPS-координати, адресу та відстань.\n");
        }
        else if(action.equals("Lab1")){
            textView.append("Введіть параметр для обчислення заданого виразу.\nПісля натискання кнопки ОБЧИСЛИТИ відбудеться обчислення та виведеться результат.");
        }
        else if(action.equals("Lab2")){
            textView.append("Введіть кінці проміжку та крок табуляції для обчислення заданого виразу.\nПісля натискання кнопки ЗАПИСАТИ У ФАЙЛ відбудеться обчислення виразу та результат запишеться у файл.\nПісля натискання кнопки ПРОЧИТАТИ ФАЙЛ відкриється створений нами файл.");
        }
        else if(action.equals("Lab3")){
            textView.append("Введіть кінці проміжку та крок табуляції для обчислення заданого виразу.\nПісля натискання кнопки ВІДКРИТИ ФАЙЛ відбудеться обчислення та відкриється файл з обчисленими значеннями х,у.\nПісля натискання кнопки ВІДКРИТИ ГРАФІК побудується графік за заданими точками з файлу");
        }
        else if(action.equals("Lab4")){
            textView.append("Програма має можливість:\n" +
                    "- переглядати наявну базу (всі записи)\n" +
                    "- додавати один запис\n" +
                    "- модифікувати обраний запис\n" +
                    "- видаляти запис\n" +
                    "- здійснювати вибірку відповідно до варіанту \n" +
                    "- обчислювати величину відповідно до варіанту.\n");
        }
        else if(action.equals("Lab5")){
            textView.append("Програма має можливість:\n" +
                    "- переглядати вміст адресної книги мого смартфону\n" +
                    "- переглядати контакти, вибранні за певним критерієм");
        }
        else if(action.equals("Lab6")){
            textView.append("Програма має можливість:\n" +
                    "- визначати GPS-координати\n" +
                    "- показати місцезнаходження на карті\n" +
                    "- визначати адресу місця, де знаходиться користувач\n" +
                    "- визначити адресу, за вказаними координатами\n" +
                    "- визначити відстань між цими двома точками");
        }

    }

    public void Back(View v){
        Intent intent = getIntent();
        String action = intent.getAction();
        if(action.equals("Main")){
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        }
        else if(action.equals("Lab1")){
            intent = new Intent(this, Lab1.class);
            startActivity(intent);
        }
        else if(action.equals("Lab2")){
            intent = new Intent(this, Lab2.class);
            startActivity(intent);
        }
        else if(action.equals("Lab3")){
            intent = new Intent(this, Lab3.class);
            startActivity(intent);
        }
        else if(action.equals("Lab4")){
            intent = new Intent(this, Lab4.class);
            startActivity(intent);
        }
        else if(action.equals("Lab5")){
            intent = new Intent(this, Lab5.class);
            startActivity(intent);
        }
        else if(action.equals("Lab6")){
            intent = new Intent(this, Lab6.class);
            startActivity(intent);
        }
    }
}
