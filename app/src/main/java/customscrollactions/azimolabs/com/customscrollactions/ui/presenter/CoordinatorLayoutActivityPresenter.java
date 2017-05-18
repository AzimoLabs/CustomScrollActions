package customscrollactions.azimolabs.com.customscrollactions.ui.presenter;

import java.util.List;

import customscrollactions.azimolabs.com.customscrollactions.data.MockDataRepository;
import customscrollactions.azimolabs.com.customscrollactions.ui.CoordinatorLayoutActivity;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class CoordinatorLayoutActivityPresenter {

    private CoordinatorLayoutActivity view;
    private MockDataRepository dataRepository;

    public CoordinatorLayoutActivityPresenter(CoordinatorLayoutActivity view,
                                              MockDataRepository dataRepository) {
        this.view = view;
        this.dataRepository = dataRepository;
    }

    public void init() {
        fetchData();
    }

    public void fetchData() {
        dataRepository.fetchData(20);
    }

    public void fillView() {
        List<String> data = dataRepository.getData();

        view.updateTextView1(data.get(0));
        view.updateTextView2(data.get(1));
        view.updateTextView3(data.get(2));
        view.updateTextView4(data.get(3));
        view.updateTextView5(data.get(4));
        view.updateTextView6(data.get(5));
        view.updateTextView7(data.get(6));
        view.updateTextView8(data.get(7));
        view.updateTextView9(data.get(8));
        view.updateTextView10(data.get(9));
        view.updateTextView11(data.get(10));
        view.updateTextView12(data.get(11));
        view.updateTextView13(data.get(12));
        view.updateTextView14(data.get(13));
        view.updateTextView15(data.get(14));
        view.updateTextView16(data.get(15));
        view.updateTextView17(data.get(16));
        view.updateTextView18(data.get(17));
        view.updateTextView19(data.get(18));
        view.updateTextView20(data.get(19));
    }
}
