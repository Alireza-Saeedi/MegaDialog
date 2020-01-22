package com.alertpro.alireza;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.alertpro.megadialog.Megadialog;

public class MainActivity extends AppCompatActivity {

    Megadialog megadialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        megadialog = new Megadialog(this);

        findViewById(R.id.Progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                megadialog.setAlertType(Megadialog.PROGRESS_TYPE, true)
                        .setCancelableDialog(true)
                        .setCanceledOnTouchOutsideDialog(true)
                        .setText("connecting...", "please wait...")
                        .setTextGravity(Gravity.LEFT, Gravity.CENTER)
                        .setDecriptionTextSize(14)
                        .setTitieTextSize(13)
                        .ShowDialog();
            }
        });


        findViewById(R.id.Success).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                megadialog.setAlertType(Megadialog.SUCCESS_TYPE, true)
                        .setCancelableDialog(true)
                        .setCanceledOnTouchOutsideDialog(true)
                        .setText(null, "Success")
                        .setTextGravity(Gravity.LEFT, Gravity.CENTER)
                        .setDecriptionTextSize(14)
                        .ShowDialog();
            }
        });


        findViewById(R.id.Error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                megadialog.setAlertType(Megadialog.ERROR_TYPE, true)
                        .setCancelableDialog(true)
                        .setCanceledOnTouchOutsideDialog(true)
                        .setText(null, "Error")
                        .setTextGravity(Gravity.LEFT, Gravity.CENTER)
                        .setDecriptionTextSize(14)
                        .ShowDialog();
            }
        });


        findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                megadialog.setAlertType(Megadialog.PROGRESS_TYPE, true)
                        .setCancelableDialog(true)
                        .setCanceledOnTouchOutsideDialog(true)
                        .setText(null, "do you want to exit?")
                        .setTextGravity(Gravity.LEFT, Gravity.CENTER)
                        .setImage(R.drawable.question_mark)
                        .setDecriptionTextSize(15)
                        .setButtonsTextSize(13)
                        .setCancelButton("Cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                                megadialog.dismiss();
                            }
                        })
                        .setConfirmButton("Exit", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Exit", Toast.LENGTH_SHORT).show();
                                megadialog.dismiss();
                            }
                        })
                        .ShowDialog();
            }
        });
    }
}
