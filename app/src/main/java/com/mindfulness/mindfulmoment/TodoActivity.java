package com.mindfulness.mindfulmoment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TodoActivity extends AppCompatActivity {

    EditText edName,edCourse,edMarks,edUpdate;
    Button btnInsert,btnViewAll,btnUpdate,btnDelete;

    DatabaseHelper2 databaseHelper2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        databaseHelper2 = new DatabaseHelper2(this);


        edName = (EditText)findViewById(R.id.edEnterName);
        edCourse =(EditText) findViewById(R.id.edCourse);
        edMarks = (EditText) findViewById(R.id.edMarks);
        edUpdate =(EditText) findViewById(R.id.edIdToEdit);

        btnInsert =(Button)findViewById(R.id.btnInsert);
        btnViewAll =(Button)findViewById(R.id.btnViewAll);
        btnUpdate =(Button)findViewById(R.id.btnUpdate);
        btnDelete =(Button) findViewById(R.id.btnDelete);

        insertData();
        viewAllData();
        updateData();
        deleteData();
    }

    public void insertData(){
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String course = edCourse.getText().toString();
                String marks = edMarks.getText().toString();

                boolean isInserted = databaseHelper2.insertData(name,course,marks);
                if(isInserted){
                    Toast.makeText(TodoActivity.this, "Insert successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(TodoActivity.this, "Insert fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public void viewAllData(){
        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor data = databaseHelper2.getAllData();
                if(data.getCount() == 0){
                    showMessage("Error","No data in database");
                    return;
                }else{
                    StringBuffer buffer = new StringBuffer();
                    while(data.moveToNext()){
                        buffer.append("ID :"+ data.getString(0)+ "\n");
                        buffer.append("TASK :"+ data.getString(1)+ "\n");
                        buffer.append("DATE :"+ data.getString(2)+ "\n");
                        buffer.append("TIME :"+ data.getString(3)+ "\n\n");
                    }
                    showMessage("Data in database",buffer.toString());
                }
            }
        });
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setCancelable(true);
        builder.show();
    }

    public  void updateData(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edUpdate.getText().toString();
                String name = edName.getText().toString();
                String course = edCourse.getText().toString();
                String marks = edMarks.getText().toString();

                boolean isUpdated = databaseHelper2.updateData(id,name,course,marks);
                if(isUpdated){
                    Toast.makeText(TodoActivity.this, "Update successfully", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(TodoActivity.this, "Update fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteData(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edUpdate.getText().toString();
                int deletedRow = databaseHelper2.deleteData(id);

                if(deletedRow > 0){
                    Toast.makeText(TodoActivity.this, "Delete successfully", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(TodoActivity.this, "Delete fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}