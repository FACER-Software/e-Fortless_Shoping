package mx.ipn.e_fortlessshoping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.app.Dialog;
import android.widget.DatePicker;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    EditText fecha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        fecha = (EditText) findViewById(R.id.FecNac);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.FecNac:
                        showDatePickerDialog();
                        break;
                }
            }
        });
    }

    private String twoDigits(int n) {
        return (n<=9) ? ("0"+n) : String.valueOf(n);
    }

    private void showDatePickerDialog(){
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = twoDigits(day) + " / " + twoDigits(month+1) + " / " + year;
                fecha.setText(selectedDate);
            }
        });
        newFragment.show(getSupportFragmentManager(),"datePicker");
    }
}
