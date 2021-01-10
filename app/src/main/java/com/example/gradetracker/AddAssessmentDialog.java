package com.example.gradetracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddAssessmentDialog extends AppCompatDialogFragment {

    private EditText assessmentName;
    private EditText grade;
    private EditText breakdownEntry;

    private AddAssessmentDialog.AddAssessmentListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_assessment_dialog, null);

        builder.setView(view)
                .setTitle("Add Assessment")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String a = assessmentName.getText().toString();
                        String g = grade.getText().toString();
                        String be = breakdownEntry.getText().toString();

                        listener.applyTexts2(a, g, be);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener = (AddAssessmentDialog.AddAssessmentListener) context;
    }

    public interface AddAssessmentListener {
        void applyTexts2(String a, String g, String be);
    }

}
