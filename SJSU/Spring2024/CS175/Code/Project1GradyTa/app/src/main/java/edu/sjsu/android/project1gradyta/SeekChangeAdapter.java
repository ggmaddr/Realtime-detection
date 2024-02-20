package edu.sjsu.android.project1gradyta;
import android.widget.SeekBar;
public interface SeekChangeAdapter extends SeekBar.OnSeekBarChangeListener{
    @Override
    default void onStartTrackingTouch(SeekBar seekBar) {
    }
    @Override
    default void onStopTrackingTouch(SeekBar seekBar) {
    }


}
