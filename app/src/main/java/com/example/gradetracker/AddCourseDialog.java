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

public class AddCourseDialog extends AppCompatDialogFragment {

    private EditText courseName;
    private EditText category1, category2, category3, category4, category5, category6, category7, category8;
    private EditText weight1, weight2, weight3, weight4, weight5, weight6, weight7, weight8;
    private EditText assessments1, assessments2, assessments3, assessments4, assessments5, assessments6, assessments7, assessments8;

    private AddCourseListener listener;

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
                        String name = courseName.getText().toString();

                        String c1 = category1.getText().toString();
                        String w1 = weight1.getText().toString();
                        String a1 = assessments1.getText().toString();

                        String c2 = category1.getText().toString();
                        String w2 = weight1.getText().toString();
                        String a2 = assessments1.getText().toString();

                        String c3 = category1.getText().toString();
                        String w3 = weight1.getText().toString();
                        String a3 = assessments1.getText().toString();

                        String c4 = category1.getText().toString();
                        String w4 = weight1.getText().toString();
                        String a4 = assessments1.getText().toString();

                        String c5 = category1.getText().toString();
                        String w5 = weight1.getText().toString();
                        String a5 = assessments1.getText().toString();

                        String c6 = category1.getText().toString();
                        String w6 = weight1.getText().toString();
                        String a6 = assessments1.getText().toString();

                        String c7 = category1.getText().toString();
                        String w7 = weight1.getText().toString();
                        String a7 = assessments1.getText().toString();

                        String c8 = category1.getText().toString();
                        String w8 = weight1.getText().toString();
                        String a8 = assessments1.getText().toString();

                        listener.applyTexts(name, c1, w1, a1, c2, w2, a2, c3,  w3, a3, c4, w4, a4, c5, w5, a5, c6, w6, a6, c7, w7, a7, c8, w8, a8);
                    }
                });

        courseName = view.findViewById(R.id.course_name);

        category1 = view.findViewById(R.id.catagory1);
        weight1 = view.findViewById(R.id.weight1);
        assessments1 = view.findViewById(R.id.assessments1);

        category2 = view.findViewById(R.id.catagory2);
        weight2 = view.findViewById(R.id.weight2);
        assessments2 = view.findViewById(R.id.assessments2);

        category3 = view.findViewById(R.id.catagory3);
        weight3 = view.findViewById(R.id.weight3);
        assessments3 = view.findViewById(R.id.assessments3);

        category4 = view.findViewById(R.id.catagory4);
        weight4 = view.findViewById(R.id.weight4);
        assessments4 = view.findViewById(R.id.assessments4);

        category5 = view.findViewById(R.id.catagory5);
        weight5 = view.findViewById(R.id.weight5);
        assessments5 = view.findViewById(R.id.assessments5);

        category6 = view.findViewById(R.id.catagory6);
        weight6 = view.findViewById(R.id.weight6);
        assessments6 = view.findViewById(R.id.assessments6);

        category7 = view.findViewById(R.id.catagory7);
        weight7 = view.findViewById(R.id.weight7);
        assessments7 = view.findViewById(R.id.assessments7);

        category8 = view.findViewById(R.id.catagory8);
        weight8 = view.findViewById(R.id.weight8);
        assessments8 = view.findViewById(R.id.assessments8);

        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        listener = (AddCourseListener) context;
    }

    public interface AddCourseListener {
        void applyTexts(String name, String c1, String w1, String a1,
                        String c2, String w2, String a2,
                        String c3, String w3, String a3,
                        String c4, String w4, String a4,
                        String c5, String w5, String a5,
                        String c6, String w6, String a6,
                        String c7, String w7, String a7,
                        String c8, String w8, String a8);
    }

}


