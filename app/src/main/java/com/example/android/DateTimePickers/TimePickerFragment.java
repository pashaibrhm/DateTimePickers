
package com.example.android.DateTimePickers;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass for a time picker.
 * Sets the current time for the picker using Calendar.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    /**
     * Creates the time picker dialog with the current time from Calendar.
     * @param savedInstanceState    Saved instance
     * @return TimePickerDialog     The time picker dialog
     */
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);


        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    /**
     * Grabs the time and converts it to a string to pass
     * to the Main Activity in order to show it with processTimePickerResult().
     * @param view          The time picker view
     * @param hourOfDay     The hour chosen
     * @param minute        The minute chosen
     */
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        MainActivity activity = (MainActivity) getActivity();

        activity.processTimePickerResult(hourOfDay, minute);
    }
}
