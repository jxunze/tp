package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.model.person.PayrollWrapper;

public class PayrollListPanel extends UiPart<Region> {
    private static final String FXML = "PayrollListPanel.fxml";

    @FXML
    private ListView<PayrollWrapper> payrollListView;

    public PayrollListPanel(ObservableList<PayrollWrapper> payrollList) {
        super(FXML);
        payrollListView.setItems(payrollList);
        payrollListView.setCellFactory(listView -> new PayrollListViewCell());
    }

    class PayrollListViewCell extends ListCell<PayrollWrapper> {
        @Override
        protected void updateItem(PayrollWrapper payroll, boolean empty) {
            super.updateItem(payroll, empty);

            if (empty || payroll == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PayrollCard(payroll, getIndex() + 1).getRoot());
            }
        }
    }
}
