package com.example.gradetracker;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class AddCourseDialog extends AppCompatDialogFragment {

    private EditText catagory1, catagory2, catagory3, catagory4, catagory5, catagory6, catagory7, catagory8;
    private EditText weight1, weight2, weight3, weight4, weight5, weight6, weight7, weight8;
    private EditText assessments1, assessments2, assessments3, assessments4, assessments5, assessments6, assessments7, assessments8;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_course_dialog, null);

        builder.setView(view)
                .setTitle("Add Course")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        catagory1 = view.findViewById(R.id.catagory1);
        weight1 = view.findViewById(R.id.weight1);
        assessments1 = view.findViewById(R.id.assessments1);

        catagory2 = view.findViewById(R.id.catagory2);
        weight2 = view.findViewById(R.id.weight2);
        assessments2 = view.findViewById(R.id.assessments2);

        catagory3 = view.findViewById(R.id.catagory3);
        weight3 = view.findViewById(R.id.weight3);
        assessments3 = view.findViewById(R.id.assessments3);

        catagory4 = view.findViewById(R.id.catagory4);
        weight4 = view.findViewById(R.id.weight4);
        assessments4 = view.findViewById(R.id.assessments4);

        catagory5 = view.findViewById(R.id.catagory5);
        weight5 = view.findViewById(R.id.weight5);
        assessments5 = view.findViewById(R.id.assessments5);

        catagory6 = view.findViewById(R.id.catagory6);
        weight6 = view.findViewById(R.id.weight6);
        assessments6 = view.findViewById(R.id.assessments6);

        catagory7 = view.findViewById(R.id.catagory7);
        weight7 = view.findViewById(R.id.weight7);
        assessments7 = view.findViewById(R.id.assessments7);

        catagory8 = view.findViewById(R.id.catagory8);
        weight8 = view.findViewById(R.id.weight8);
        assessments8 = view.findViewById(R.id.assessments8);

        return builder.create();
    }

}
