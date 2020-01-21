package com.alertpro.megadialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;

/**
 * Created by Alireza saeedi.
 * Date: 2019-12-31
 * Time: 6:17 PM
 */
public class Megadialog extends android.app.Dialog {

    private static Boolean Cancelable = true;
    private static Boolean CanceledOnTouchOutside = true;
    public static final int NORMAL_TYPE = 0;
    public static final int ERROR_TYPE = 1;
    public static final int SUCCESS_TYPE = 2;
    public static final int WARNING_TYPE = 3;
    public static final int CUSTOM_IMAGE_TYPE = 4;
    public static final int PROGRESS_TYPE = 5;
    public static int AlertType = 0;
    private LottieAnimationView animview;
    private ImageView customImgView;
    private TextView description;
    private TextView title;
    private RelativeLayout title_rel;
    private Context context;

    private Button posBtn;
    private Button negBtn;

    public Megadialog(@NonNull Context context) {
        super(context);
        this.context = context;
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(Cancelable);
        setCanceledOnTouchOutside(CanceledOnTouchOutside);
        setContentView(R.layout.megadialog);

        LinearLayout rootview = findViewById(R.id.rootview);
        description = findViewById(R.id.description);
        title = findViewById(R.id.title);
        title_rel = findViewById(R.id.title_rel);
        posBtn = findViewById(R.id.posBtn);
        posBtn.setVisibility(View.GONE);
        negBtn = findViewById(R.id.negBtn);
        negBtn.setVisibility(View.GONE);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        Metrics.width = displayMetrics.widthPixels;
        Metrics.height = displayMetrics.heightPixels;

        ViewGroup.LayoutParams params = rootview.getLayoutParams();
        params.width = (int) (Metrics.width / (1000 / 750f));
        rootview.setLayoutParams(params);

        animview = findViewById(R.id.animview);
        customImgView = findViewById(R.id.customImgView);
        customImgView.setVisibility(View.GONE);
    }

    public Boolean getCancelableDialog() {
        return Cancelable;
    }

    public Megadialog setCancelableDialog(Boolean cancelable) {
        Cancelable = cancelable;
        setCancelable(Cancelable);
        return this;
    }

    public Boolean getCanceledOnTouchOutsideDialog() {
        return CanceledOnTouchOutside;
    }

    public Megadialog setCanceledOnTouchOutsideDialog(Boolean canceledOnTouchOutside) {
        CanceledOnTouchOutside = canceledOnTouchOutside;
        setCanceledOnTouchOutside(CanceledOnTouchOutside);
        return this;
    }

    public int getAlertType() {
        return AlertType;
    }

    public Megadialog setAlertType(int alertType, Boolean AnimationLoop) {
        AlertType = alertType;

        if (alertType == ERROR_TYPE) {
            animview.setAnimation(R.raw.unapproved_cross);
            animview.playAnimation();
            animview.loop(AnimationLoop);
        } else if (alertType == SUCCESS_TYPE) {
            animview.setAnimation(R.raw.success);
            animview.playAnimation();
            animview.loop(AnimationLoop);
        } else if (alertType == PROGRESS_TYPE) {
            animview.setAnimation(R.raw.custom_loader);
            animview.playAnimation();
            animview.loop(AnimationLoop);
        } else if (alertType == CUSTOM_IMAGE_TYPE) {
            animview.setVisibility(View.GONE);
            customImgView.setVisibility(View.VISIBLE);
        }
        return this;
    }

    public Megadialog setImage(@DrawableRes int id) {
        customImgView.setImageDrawable(ContextCompat.getDrawable(context, id));
        return this;
    }

    public Megadialog setTextGravity(int TitleGravity, int DescriptionGravity) {
        title.setGravity(TitleGravity);
        description.setGravity(DescriptionGravity);
        return this;
    }

    public Megadialog setText(String titleText, String descriptionText) {
        if (titleText == null)
            title_rel.setVisibility(View.INVISIBLE);
        else {
            title_rel.setVisibility(View.VISIBLE);
            title.setText(titleText);
        }
        if (descriptionText == null)
            description.setVisibility(View.INVISIBLE);
        else {
            description.setVisibility(View.VISIBLE);
            description.setText(descriptionText);
        }

        return this;
    }

    public Megadialog setDecriptionTextSize(int size) {
        this.description.setTextSize(size);
        return this;
    }

    public Megadialog setTitieTextSize(int size) {
        this.title.setTextSize(size);
        return this;
    }

    public Megadialog setButtonsTextSize(int size) {
        this.negBtn.setTextSize(size);
        this.posBtn.setTextSize(size);
        return this;
    }


    public Megadialog setCancelButton(String text, View.OnClickListener listener) {
        this.negBtn.setText(text);
        this.negBtn.setOnClickListener(listener);
        this.negBtn.setVisibility(View.VISIBLE);
        return this;
    }

    public Megadialog setConfirmButton(String text, View.OnClickListener listener) {
        this.posBtn.setText(text);
        this.posBtn.setOnClickListener(listener);
        this.posBtn.setVisibility(View.VISIBLE);
        return this;
    }


    public Megadialog ShowDialog() {

      /*  if (this.negBtn.getVisibility() == View.VISIBLE && this.posBtn.getVisibility() == View.VISIBLE) {

            this.negBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            this.posBtn.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
        } else if (this.negBtn.getVisibility() == View.VISIBLE) {

        } else if (this.posBtn.getVisibility() == View.VISIBLE) {

        }*/
        show();
        return this;
    }

    public static class Metrics {
        public static int width;
        public static int height;
    }
}
