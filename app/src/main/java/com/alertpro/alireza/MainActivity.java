package com.alertpro.alireza;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import com.alertpro.megadialog.Megadialog;

public class MainActivity extends AppCompatActivity {

    Megadialog megadialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        megadialog = new Megadialog(this)
                .setAlertType(Megadialog.PROGRESS_TYPE, true)
                .setCancelableDialog(true)
                .setCanceledOnTouchOutsideDialog(true)
                .setText(null, "صبر کنید ...")
                .setTextGravity(Gravity.RIGHT, Gravity.CENTER)
                .setDecriptionTextSize(15)
                .ShowDialog();
    }
}
