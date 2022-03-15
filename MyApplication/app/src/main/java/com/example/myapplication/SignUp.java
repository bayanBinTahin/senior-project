package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class SignUp extends AppCompatActivity {
    TextInputLayout fName,lName, email, phone, password,cPassword;
    private Button next, dateButton;
    private DatePickerDialog datePickerDialog;
//    FirebaseDatabase fire;
//    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        next= findViewById(R.id.buttonNextToSignUp2);
//        fName=(EditText)findViewById(R.id.editTextFirstNameSignUp);
//        lName=(EditText)findViewById(R.id.editTextLastNameSignUp);
//        email=(EditText)findViewById(R.id.editTextEmailSignUp);
//        phone=(EditText)findViewById(R.id.editTextPhoneSignUp);
//        password=(EditText)findViewById(R.id.editTextPasswordSignUp);
//        cPassword=(EditText)findViewById(R.id.editTextConfirmPasswordSignUp);
        dateButton = findViewById(R.id.datePickerButton);
     //   signup();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Back");
        initDatePicker();
        dateButton.setText(getTodaysDate());
    }

    private Boolean validateFirstName(){
        String validateFirstName = fName.getEditText().getText().toString();
        String whiteSpace= "\\A\\w{4,10}\\z";
        if (validateFirstName.isEmpty()){
            fName.setError("First name can not be empty");
            return false;
        }else if (!validateFirstName.matches(whiteSpace)){
            fName.setError("White space not allowed");
            return false;
        } else{
            fName.setError(null);
            fName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateLastName(){
        String validateLastName = lName.getEditText().getText().toString();
        String whiteSpace= "\\A\\w{4,10}\\z";
        if (validateLastName.isEmpty()){
            lName.setError("Last name can not be empty");
            return false;
        }else if (!validateLastName.matches(whiteSpace)){
            fName.setError("White space not allowed");
            return false;
        }else {
            lName.setError(null);
            lName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail(){
        String validateEmail = email.getEditText().getText().toString();
        String emailPatters="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (validateEmail.isEmpty()){
            email.setError("Email can not be empty");
            return false;
        }else if (!validateEmail.matches(emailPatters)){
            email.setError("Invalid email");
            return false;
        } else{
            email.setError(null);
            return true;
        }
    }

    private Boolean validatePhoneNumber(){
        String validatePhoneNumber = phone.getEditText().getText().toString();
        if (validatePhoneNumber.isEmpty()){
            phone.setError("Phone number can not be empty");
            return false;
        }else {
            phone.setError(null);
            return true;
        }
    }

    private Boolean validatePassword(){
        String validatePassword = password.getEditText().getText().toString();
        String passwordPattern= "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[a-z])" +         //at least 1 lower case letter
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$";
        if (validatePassword.isEmpty()){
            password.setError("Password can not be empty");
            return false;
        }else if (!validatePassword.matches(passwordPattern)){
            password.setError("Password not match the rules ");
            return false;
        } else{
            password.setError(null);
            return true;
        }
    }

    public void registerUser(View view){
//        if(!validateFirstName() | !validateLastName()| !validateEmail() | !validatePhoneNumber() | !validatePassword()){
//            return;
//        }
//        String firstName = fName.getEditText().getText().toString();
//        String lastName = lName.getEditText().getText().toString();
//        String e_mail= email.getEditText().getText().toString();
//        String phoneNumber=phone.getEditText().getText().toString();
//        String pass=password.getEditText().getText().toString();
//       // UserHelperClass helperClass = new UserHelperClass(firstName, lastName, e_mail,phoneNumber,password);
//      //اخزنها في الداتا
//        // reference.child(اسم الجدول ).setValue(helperClass);
//        Intent intent = new Intent(this, SignUp2.class);
//        startActivity(intent);
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener()
        {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day)
            {
                month = month + 1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
            }
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());

    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        if(month == 1)
            return "JAN";
        if(month == 2)
            return "FEB";
        if(month == 3)
            return "MAR";
        if(month == 4)
            return "APR";
        if(month == 5)
            return "MAY";
        if(month == 6)
            return "JUN";
        if(month == 7)
            return "JUL";
        if(month == 8)
            return "AUG";
        if(month == 9)
            return "SEP";
        if(month == 10)
            return "OCT";
        if(month == 11)
            return "NOV";
        if(month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void openDatePicker(View view) {
        datePickerDialog.show();
    }

    private void signup() {
//        if (!fName.getText().toString().matches("[A-Z a-z]")) {
//            Toast.makeText(getApplicationContext(), "First name must be string ", Toast.LENGTH_LONG).show();
//        } else if (!lName.getText().toString().matches("[A-Z a-z]")) {
//            Toast.makeText(getApplicationContext(), "Last name must be string ", Toast.LENGTH_LONG).show();
//        } else if (!email.getText().toString().matches("^[a-zA-Z0-9_+&-]+(?:\\\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$")) {
//            Toast.makeText(getApplicationContext(), "Invalid email ", Toast.LENGTH_LONG).show();
//        } else if (!phone.getText().toString().matches("05\\\\d{8}")) {
//            Toast.makeText(getApplicationContext(), "Invalid phone number ", Toast.LENGTH_LONG).show();
//        } else if (!age.getText().toString().matches()) {
//
//        }
//        }else if (!password.getText().toString().matches("^(?=.[0-9])(?=.[a-z])(?=.[A-Z])(?=.[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")){
//            Toast.makeText(getApplicationContext(), "Invalid password ", Toast.LENGTH_LONG).show();
//        }else if(!cPassword.getText().toString().equals(password)){
//            Toast.makeText(getApplicationContext(), "Password and confirm password not match ", Toast.LENGTH_LONG).show();
//        }
    }

    public void openSignUp(){
        if(!validateFirstName() | !validateLastName()| !validateEmail() | !validatePhoneNumber() | !validatePassword()){
            return;
        }
        String firstName = fName.getEditText().getText().toString();
        String lastName = lName.getEditText().getText().toString();
        String e_mail= email.getEditText().getText().toString();
        String phoneNumber=phone.getEditText().getText().toString();
        String pass=password.getEditText().getText().toString();
        // UserHelperClass helperClass = new UserHelperClass(firstName, lastName, e_mail,phoneNumber,password);
        //اخزنها في الداتا
        // reference.child(اسم الجدول ).setValue(helperClass);
        Intent intent = new Intent(this, SignUp2.class);
        startActivity(intent);
    }
}