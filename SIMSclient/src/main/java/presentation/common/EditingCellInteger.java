package presentation.common;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableCell;
import javafx.scene.control.TextField;

/**
 * ¿É±à¼­µÄTextField for Integer
 * 
 * @author ÅËÐÇÓî 2017-12-12
 * @param <T>
 */
public class EditingCellInteger<T> extends TableCell<T, Integer> {

	private TextField textField;

	public EditingCellInteger() {
	}

	@Override
	public void startEdit() {
		if (!isEmpty()) {
			super.startEdit();
			createTextField();
			setText(null);
			setGraphic(textField);
			textField.selectAll();
		}
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();
		setText(String.valueOf((Integer) getItem()));
		setGraphic(null);
	}

	@Override
	public void updateItem(Integer item, boolean empty) {
		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (textField != null) {
					textField.setText(getString());
				}
				setText(null);
				setGraphic(textField);
			} else {
				setText(getString());
				setGraphic(null);
			}
		}
	}

	private void createTextField() {
		textField = new TextField(getString());
		textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
		textField.focusedProperty()
				.addListener((ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) -> {
					if (!arg2) {
						commitEdit(Integer.parseInt(textField.getText()));
					}
				});
	}

	private String getString() {
		return getItem() == null ? "" : getItem().toString();
	}

}
