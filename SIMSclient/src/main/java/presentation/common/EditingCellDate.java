package presentation.common;

import java.time.LocalDate;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;

/**
 * 可编辑的Table中的DatePicker
 * 
 * @author 潘星宇 2017-12-16
 * @param <T>
 */
public class EditingCellDate<T> extends TableCell<T, LocalDate> {

	private DatePicker datePicker;

	public EditingCellDate() {
	}

	@Override
	public void startEdit() {
		if (!isEmpty()) {
			super.startEdit();
			createLocalDate();
			setText(null);
			setGraphic(datePicker);
		}
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();
		setText(String.valueOf((LocalDate) getItem()));
		setGraphic(null);
	}

	@Override
	public void updateItem(LocalDate item, boolean empty) {
		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (datePicker != null) {
					datePicker.setValue(getLocalDate());
				}
				setText(null);
				setGraphic(datePicker);
			} else {
				setText(String.valueOf(getLocalDate()));
				setGraphic(null);
			}
		}
	}

	private void createLocalDate() {
		datePicker = new DatePicker(getLocalDate());
		datePicker.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
		datePicker.focusedProperty()
				.addListener((ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) -> {
					if (!arg2) {
						commitEdit(datePicker.getValue());
					}
				});
	}

	private LocalDate getLocalDate() {
		return getItem() == null ? LocalDate.of(2000, 01, 01) : getItem();
	}

}
