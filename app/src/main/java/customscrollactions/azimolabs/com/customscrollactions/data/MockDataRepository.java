package customscrollactions.azimolabs.com.customscrollactions.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by F1sherKK on 16/05/2017.
 */

public class MockDataRepository {

    private List<String> data = new ArrayList<>();

    public void fetchData(int numItems) {
        data.addAll(Arrays.asList(generateData(numItems)));
    }

    private String[] generateData(int numItems) {
        String[] outputArray = new String[numItems];
        for (int i = 0; i < numItems; i++) {
            String itemString = "Item " + i;
            outputArray[i] = itemString;
        }
        return outputArray;
    }

    public List<String> getData() {
        return data;
    }
}
