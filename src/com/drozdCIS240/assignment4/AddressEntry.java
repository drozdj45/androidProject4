package com.drozdCIS240.assignment4;



import com.drozdCIS240.assignment4.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddressEntry extends Activity implements View.OnClickListener {
	Button cmdSave;
	Button cmdClear;
	Button cmdCancel;
	// EditText editName;
	// EditText editAddress;

	EditText editFName;
	EditText editLName;
	EditText editStreet;
	EditText editCity;
	EditText editState;
	EditText editZip;

	int result;
	AddressStrongTypeIntent stIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_address_entry);
		editFName = (EditText) findViewById(R.id.editFName);
		editLName = (EditText) findViewById(R.id.editLName);
		editStreet = (EditText) findViewById(R.id.editStreet);
		editCity = (EditText) findViewById(R.id.editCity);
		editState = (EditText) findViewById(R.id.editState);
		editZip = (EditText) findViewById(R.id.editZip);
		cmdSave = (Button) findViewById(R.id.cmdSave);
		cmdSave.setOnClickListener(this);
		cmdClear = (Button) findViewById(R.id.cmdClear);
		cmdClear.setOnClickListener(this);
		cmdCancel = (Button) findViewById(R.id.cmdCancel);
		cmdCancel.setOnClickListener(this);
		stIntent = new AddressStrongTypeIntent(getIntent());
		editFName.setText(stIntent.fname);
		editLName.setText(stIntent.lname);
		editStreet.setText(stIntent.street);
		editCity.setText(stIntent.city);
		editState.setText(stIntent.state);
		editZip.setText(stIntent.zip);

		// editName.setText(stIntent.name);
		// editAddress.setText(stIntent.address);
		if (stIntent.action == AddressStrongTypeIntent.ActionType.DELETE)
			cmdSave.setText(R.string.delete);
		editFName
				.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
		editLName
				.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
		editStreet
				.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
		editCity.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
		editState
				.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
		editZip.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
		cmdClear.setEnabled(stIntent.action != AddressStrongTypeIntent.ActionType.DELETE);
	}

	@Override
	public void finish() {
		stIntent.clearIntent();
		stIntent.fname = editFName.getText().toString();
		stIntent.lname = editLName.getText().toString();
		stIntent.street = editStreet.getText().toString();
		stIntent.city = editCity.getText().toString();
		stIntent.state = editState.getText().toString();
		stIntent.zip = editZip.getText().toString();
		setResult(result, stIntent.getIntent());
		super.finish();
	}

	public void onClick(View v) {
		if (cmdSave.getId() == v.getId()) {
			result = RESULT_OK;
			finish();

		}
		if (cmdClear.getId() == v.getId()) {
			editFName.setText("");
			editLName.setText("");
			editStreet.setText("");
			editCity.setText("");
			editState.setText("");
			editZip.setText("");
		}
		if (cmdCancel.getId() == v.getId()) {
			result = RESULT_CANCELED;
			finish();

		}
	}

}
