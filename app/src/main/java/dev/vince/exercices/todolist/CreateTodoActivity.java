package dev.vince.exercices.todolist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.LinkedList;

public class CreateTodoActivity extends Activity implements View.OnClickListener {


    private EditText nameView;
    private Spinner priorityView;
    private Button saveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);

        nameView = (EditText) findViewById(R.id.nameView);
        priorityView = (Spinner) findViewById(R.id.priorityView);
        saveView = (Button) findViewById(R.id.saveView);

        LinkedList<String> priorityValues = new LinkedList<>();
        for (PriorityEnum priorityEnum : PriorityEnum.values()){
            priorityValues.add(priorityEnum.toString());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_dropdown_item, priorityValues
        );

        priorityView.setAdapter(adapter);

        saveView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        Bundle extras = new Bundle();
        extras.putString("name", nameView.getText().toString());
        extras.putString("priority", priorityView.getSelectedItem().toString());
        intent.putExtras(extras);
        setResult(RESULT_OK, intent);

        finish();
    }
}
