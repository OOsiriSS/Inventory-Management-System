package presentation.common;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableCell;

/**
 * 可编辑的TableCell 中的 ChoiceBox
 * 
 * @author 潘星宇 2017-12-11
 * @param <T>
 */
public class EditingCellChoice<T> extends TableCell<T, String> {

	private ChoiceBox<String> choice;
	ObservableList<String> list;

	public EditingCellChoice(ObservableList<String> roleList) {
		this.list = roleList;
	}

	@Override
	public void startEdit() {
		if (!isEmpty()) {
			super.startEdit();
			createChoiceBox();
			setText(null);
			setGraphic(choice);

		}
	}

	@Override
	public void cancelEdit() {
		super.cancelEdit();
		setText((String) getItem());
		setGraphic(null);
	}

	@Override
	public void updateItem(String item, boolean empty) {
		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (isEditing()) {
				if (choice != null) {
					choice.setValue(getString());
				}
				setText(null);
				setGraphic(choice);
			} else {
				setText(getString());
				setGraphic(null);
			}
		}
	}

	private void createChoiceBox() {
		choice = new ChoiceBox<>();
		choice.setItems(FXCollections.observableArrayList(list));
		choice.setValue(getString());
		choice.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
		choice.focusedProperty().addListener((ObservableValue<? extends Boolean> arg0, Boolean arg1, Boolean arg2) -> {
			if (!arg2) {
				commitEdit(choice.getValue());
			}
		});
	}

	private String getString() {
		return getItem() == null ? "" : getItem().toString();
	}
}
